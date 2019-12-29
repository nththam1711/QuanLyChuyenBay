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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import quanlychuyenbay.pojo.Ve;

/**
 * FXML Controller class
 *
 * @author haichau
 */
public class FXMLTraCuuVeController implements Initializable {
    @FXML TextField txtMaChuyen;
    @FXML ComboBox cbLoaiVe;
    @FXML ComboBox cbHangVe;
    @FXML Button btnSearch;
    @FXML TableColumn colMaVe;
    @FXML TableColumn colHangVe;
    @FXML TableColumn colLoaiVe;
    @FXML TableColumn colSoGhe;
    @FXML TableColumn colGia;
    @FXML TableColumn colThoiGian;
    @FXML TableColumn colTinhTrang;
    @FXML TableView<Ve> tbVe;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbLoaiVe.getItems().add("Mot Chieu");
        cbLoaiVe.getItems().add("Hai Chieu");
        cbHangVe.getItems().add("A");
        cbHangVe.getItems().add("B");
        cbHangVe.getItems().add("C");
        this.colMaVe.setCellValueFactory(new PropertyValueFactory("MaVe"));
        this.colHangVe.setCellValueFactory(new PropertyValueFactory("HangVe"));
        this.colLoaiVe.setCellValueFactory(new PropertyValueFactory("LoaiVe"));
        this.colSoGhe.setCellValueFactory(new PropertyValueFactory("SoGhe"));
        this.colGia.setCellValueFactory(new PropertyValueFactory("Gia"));
        this.colThoiGian.setCellValueFactory(new PropertyValueFactory("ThoiGian"));
        this.colTinhTrang.setCellValueFactory(new PropertyValueFactory("TinhTrang"));
        this.tbVe.setItems(this.getVe());
    }
    
    @FXML
    private void onSearch(ActionEvent e) {
        this.tbVe.getItems().clear();
        String maChuyen = this.txtMaChuyen.getText();
        if (maChuyen.trim() != "") {
            String loaiVe = "";
            String hangVe = "";
            if (this.cbLoaiVe.getSelectionModel().getSelectedItem() != null) {
                loaiVe = this.cbLoaiVe.getSelectionModel().getSelectedItem().toString();
            }
            if (this.cbHangVe.getSelectionModel().getSelectedItem() != null) {
                hangVe = this.cbHangVe.getSelectionModel().getSelectedItem().toString();
            }
            if (!"".equals(loaiVe) && !"".equals(maChuyen) && !"".equals(hangVe)) {
                this.tbVe.setItems(this.getVe(maChuyen, loaiVe, hangVe));
            } else if (!"".equals(loaiVe) && !"".equals(maChuyen)) {
                this.tbVe.setItems(this.getVe(maChuyen, loaiVe, null));
            }else if(!"".equals(hangVe) && !"".equals(maChuyen)){
                this.tbVe.setItems(this.getVe(maChuyen, null, hangVe));
            }else
            {
                this.tbVe.setItems(this.getVe(maChuyen));
            }
        }
        else{
             this.tbVe.setItems(this.getVe());
        }

    }

    private ObservableList<Ve> getVe() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(Ve.class);
//        Criterion mc = Restrictions.eq("MaChuyen", txtMaChuyen.getText());
        List<Ve> list = cr.list();
        session.close();
        return FXCollections.observableArrayList(list) ;
        }
        catch(Exception e){
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", e);
        }
        return null;
    }
    
    private ObservableList<Ve> getVe(String maChuyen){
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
    
//    private ObservableList<Ve> getVe(String maChuyen, String loaiVe){
//        try{
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Criteria cr = session.createCriteria(Ve.class);
//        Criterion mc = Restrictions.eq("chuyenBay.maChuyen", maChuyen);
//        Criterion tt = Restrictions.eq("LoaiVe", loaiVe);
//        cr.add(mc);
//        cr.add(tt);
//        List<Ve> list = cr.list();
//        session.close();
//        return FXCollections.observableArrayList(list) ;
//        }
//        catch(Exception e){
//            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", e);
//        }
//        return null;
//    }
    
    private ObservableList<Ve> getVe(String maChuyen, String loaiVe, String hangVe){
        try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Ve.class);
        Criterion mc = Restrictions.eq("chuyenBay.maChuyen", maChuyen);
        cr.add(mc);
        if(loaiVe != null){
            Criterion lv = Restrictions.eq("LoaiVe", loaiVe);
            cr.add(lv);
        }
        if(hangVe != null){
            Criterion hv = Restrictions.eq("HangVe", hangVe);
             cr.add(hv);
        }       
        List<Ve> list = cr.list();
        session.close();
        return FXCollections.observableArrayList(list) ;
        }
        catch(Exception e){
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", e);
        }
        return null;
    }
    
    
}
