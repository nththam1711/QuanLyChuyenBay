/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DateTimeStringConverter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import quanlychuyenbay.pojo.ChuyenBay;
import quanlychuyenbay.pojo.MayBay;

/**
 * FXML Controller class
 *
 * @author thamt
 */
public class FXMLThemChuyenBayController implements Initializable {

    @FXML
    private TextField txtMaChuyenBay;
    @FXML
    private ComboBox<MayBay> cbxMaMB;
    @FXML
    private TextField txtSanBayDen;
    @FXML
    private TextField txtSanBayDi;
    @FXML
    private DatePicker dtpKhoiHanh;
    @FXML
    private TextField txtDuKien;
    @FXML
    private TextField txtSoGheBanDau;
    @FXML
    private TextField txtSoGheTrong;
    @FXML
    private Button btnXacNhan;

    private ObservableList<ChuyenBay> data;

    public void setMayBayData(ObservableList<ChuyenBay> data) {
        this.data = data;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbxMaMB.setItems(this.getMayBayData());
        this.cbxMaMB.getSelectionModel().select(0);

        Callback<DatePicker, DateCell> dayCellFactory = this.getDayCellFactory();
        dtpKhoiHanh.setDayCellFactory(dayCellFactory);

        this.setTxtDuKienFormat();

    }

    @FXML
    private void handleAcceptButton(ActionEvent event) {
        this.addChuyenBay();
    }

    private void closeStage() {

        Stage stage = (Stage) btnXacNhan.getScene().getWindow();
        stage.close();

    }

    private void setTxtDuKienFormat() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date current = new Date();
        try {
            // TODO
            txtDuKien.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse(format.format(current).toString())));

        } catch (ParseException ex) {
            Logger.getLogger(FXMLThemChuyenBayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ObservableList<MayBay> getMayBayData() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            Criteria cr = session.createCriteria(MayBay.class);

            List<MayBay> mayBay = cr.list();
            session.close();
            return FXCollections.observableArrayList(mayBay);

        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);

        }
        return null;
    }

    private boolean validate() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        boolean isShowAlert = false;

        int soGheBanDau = Integer.parseInt(txtSoGheBanDau.getText());
        int soGheTrong = Integer.parseInt(txtSoGheTrong.getText());

        if (soGheTrong <= 0 || soGheBanDau <= 0) {
            alert.setContentText("Số Ghế Trống và Số Ghế Ban Đầu không được bé hơn 0.");
            isShowAlert = true;
        }
        if (soGheTrong > soGheBanDau) {
            alert.setContentText("Số Ghế Trống không được lớn hơn Số Ghế Ban Đầu.");
            isShowAlert = true;
        }

        if (isShowAlert == true) {
            alert.show();
            return false;
        } else {
            return true;
        }

    }

    private void addChuyenBay() {
        if (this.validate() == true) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            ChuyenBay chuyenbay;
            chuyenbay = new ChuyenBay(
                    txtMaChuyenBay.getText(), cbxMaMB.getSelectionModel().getSelectedItem(),
                    txtSanBayDi.getText(), txtSanBayDen.getText(), dtpKhoiHanh.getValue().toString(), txtDuKien.getText(),
                    Integer.parseInt(txtSoGheBanDau.getText()), Integer.parseInt(txtSoGheTrong.getText()));

            Transaction trans = null;
            try {
                trans = session.beginTransaction();
                session.save(chuyenbay);
                trans.commit();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Thêm chuyến bay thành công.");
                alert.show();
                data.add(0, chuyenbay);
                this.closeStage();

            } catch (Exception ex) {
                if (trans != null) {
                    trans.rollback();
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Thêm thất bại");
                alert.show();
                Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);

            } finally {
                session.close();
            }
        }
    }

    private Callback<DatePicker, DateCell> getDayCellFactory() {

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {

            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        // Vô hiệu hóa thứ 2, 3, 4
//                        if (item.getDayOfWeek() == DayOfWeek.MONDAY //
//                                || item.getDayOfWeek() == DayOfWeek.TUESDAY //
//                                || item.getDayOfWeek() == DayOfWeek.WEDNESDAY)
                        Date today = new Date();
                        LocalDate localToday = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        if (item.isBefore(localToday) == true) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        return dayCellFactory;
    }

}
