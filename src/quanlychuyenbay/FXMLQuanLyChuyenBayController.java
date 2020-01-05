/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import quanlychuyenbay.pojo.ChuyenBay;
import quanlychuyenbay.pojo.NhanVien;
import quanlychuyenbay.pojo.Ve;

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
    @FXML private Button btnDel;

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
        
        btnDel.disableProperty().bind(Bindings.isEmpty(tbvChuyenBay.getSelectionModel().getSelectedItems()));
        
    }

    @FXML
    private void handleThemButton(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLThemChuyenBay.fxml"));
        try {
            Parent root = fxmlLoader.load();

            FXMLThemChuyenBayController controller = fxmlLoader.getController();
            controller.setMayBayData(tbvChuyenBay.getItems());

            Stage stage = new Stage();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Thêm Chuyến Bay");
            stage.setScene(new Scene(root));
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
            stage.setOnCloseRequest((WindowEvent we) -> {
                this.reloadTable();
            });
        } catch (Exception e) {
            System.out.println("Can't load new windown");
        }
    }
    private List<Ve> getVe(String maChuyen){
        try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Ve.class);
        Criterion mc = Restrictions.eq("chuyenBay.maChuyen", maChuyen);
        cr.add(mc);
        List<Ve> list = cr.list();
        session.close();
        return FXCollections.observableArrayList(list) ;
        }
        catch(Exception e){
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", e);
        }
        return null;
    }
    
    
    @FXML
    private void handleXoa(ActionEvent event) {
        ChuyenBay cb = tbvChuyenBay.getSelectionModel().getSelectedItem();
        List list = this.getVe(cb.getMaChuyen());
        if (list.size() == 0) {
        
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction trans = session.beginTransaction();
                session.delete(cb);
                trans.commit();
                session.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Xoa thanh cong");
                    alert.show();
                this.reloadTable();
                

            } catch (HibernateException ex) {
                Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Xoa khong thanh cong");
                    alert.show();
            }

        }
        else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Khong duoc xoa");
                    alert.show();
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
