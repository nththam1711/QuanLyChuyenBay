/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import quanlychuyenbay.pojo.ChuyenBay;

/**
 * FXML Controller class
 *
 * @author thamt
 */
public class FXMLQuanLyChuyenBayController implements Initializable {

    @FXML
    private TableView<ChuyenBay> tbvChuyenBay;
    @FXML
    private TableColumn colMaChuyen;
    @FXML
    private TableColumn colMaMB;
    @FXML
    private TableColumn colSanBayDi;
    @FXML
    private TableColumn colSanBayDen;
    @FXML
    private TableColumn colKhoiHanh;
    @FXML
    private TableColumn colThoiGianDuKien;
    @FXML
    private TableColumn colSoGheBanDau;
    @FXML
    private TableColumn colSoGheTrong;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        this.colMaChuyen.setCellValueFactory(new PropertyValueFactory("maChuyen"));
        this.colMaMB.setCellValueFactory(new PropertyValueFactory("mayBay"));
        this.colSanBayDi.setCellValueFactory(new PropertyValueFactory("sanBayDi"));
        this.colSanBayDen.setCellValueFactory(new PropertyValueFactory("sanBayDen"));
        this.colKhoiHanh.setCellValueFactory(new PropertyValueFactory("khoiHanh"));
        this.colThoiGianDuKien.setCellValueFactory(new PropertyValueFactory("thoiGianDuKien"));
        this.colSoGheBanDau.setCellValueFactory(new PropertyValueFactory("soGheBanDau"));
        this.colSoGheTrong.setCellValueFactory(new PropertyValueFactory("soGheTrong"));

        this.tbvChuyenBay.setItems(this.getChuyenBay());
    }

    @FXML
    private void handleThemButton() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLThemChuyenBay.fxml"));
        try {
            Parent root = fxmlLoader.load();

            FXMLThemChuyenBayController controller = fxmlLoader.getController();
            controller.setMayBayData(tbvChuyenBay.getItems());

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Thêm Chuyến Bay");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("Can't load new windown");
        }
    }

    @FXML
    private void handelCapNhatButton() {
        this.reloadTable();
    }

    private ObservableList<ChuyenBay> getChuyenBay() {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            Criteria cr = session.createCriteria(ChuyenBay.class);
            
            cr.addOrder(Order.desc("maChuyen"));
            List<ChuyenBay> chuyenBay = cr.list();
            session.close();
            return FXCollections.observableArrayList(chuyenBay);

        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);

        }
        return null;

    }

    public void reloadTable() {
        this.tbvChuyenBay.getItems().clear();
        this.tbvChuyenBay.setItems(this.getChuyenBay());
    }

}
