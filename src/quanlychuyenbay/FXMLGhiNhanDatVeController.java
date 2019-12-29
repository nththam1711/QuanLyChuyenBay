/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import quanlychuyenbay.pojo.ChuyenBay;
import quanlychuyenbay.pojo.KhachHang;
import quanlychuyenbay.pojo.Ve;

/**
 * FXML Controller class
 *
 * @author thamt
 */
public class FXMLGhiNhanDatVeController implements Initializable {
    @FXML TextField txtSanBayDi;
    @FXML TextField txtSanBayDen;
    @FXML TextField maHanhKhach;
    @FXML TextField txtNgayGio;
    @FXML ComboBox cbMaChuyen;
    @FXML ComboBox cbHangVe;
    @FXML TextField txtTenHanhKhach;
    @FXML TextField txtCMND;
    @FXML ComboBox cbLoaiVe;
    @FXML TextField txtSDT;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cbHangVe.getItems().add("A");
        this.cbHangVe.getItems().add("B");
        this.cbHangVe.getItems().add("C");
        this.cbLoaiVe.getItems().add("Mot Chieu");
        this.cbLoaiVe.getItems().add("Hai Chieu");
        List<ChuyenBay> list = this.getChuyenBay();

        list.forEach(item -> {
            this.cbMaChuyen.getItems().add(item.getMaChuyen());
        });
        maHanhKhach.setOnKeyPressed((javafx.scene.input.KeyEvent event) -> {
            if (event.getCode() == KeyCode.TAB || event.getCode() == KeyCode.ENTER) {
                // do stuff
                try {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    
//                    Criteria cr = session.createCriteria(KhachHang.class);
//                    Criterion mkh = Restrictions.eq("MaKH", maHanhKhach.getText());
//                    cr.add(mkh);
                    
                    KhachHang kh = (KhachHang) session.get(KhachHang.class, maHanhKhach.getText());
                    if(kh!=null){
                        txtTenHanhKhach.setText(kh.getTenKH());
                        txtSDT.setText(kh.getDiaChi());
                        txtCMND.setText(kh.getSoCMT());
                        txtSDT.setText(kh.getSDT());                        
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Ma khach hang khong ton tai");
                        alert.show();
                        maHanhKhach.setText("");
                        txtCMND.setText("");
                        txtSDT.setText("");
                        txtTenHanhKhach.setText("");
                    }
                    session.close();
                    
                } catch (HibernateException ex) {
                    Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);                  
                }
            }           
        });
    }
    
    @FXML private void cbMaChuyenSelected(ActionEvent e){
        if(this.cbMaChuyen.getSelectionModel().getSelectedItem() != null){
            String ajfa = this.cbMaChuyen.getSelectionModel().getSelectedItem().toString();
            ChuyenBay cb = this.getChuyenBay(this.cbMaChuyen.getSelectionModel().getSelectedItem().toString());
            if(cb != null){
                this.txtSanBayDen.setText(cb.getSanBayDen());
                this.txtSanBayDi.setText(cb.getSanBayDi());
                this.txtNgayGio.setText(cb.getKhoiHanh());
            }
        }      
    }
    private List<ChuyenBay> getChuyenBay() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria cr = session.createCriteria(ChuyenBay.class);            
            cr.addOrder(Order.desc("maChuyen"));
            List<ChuyenBay> chuyenBay = cr.list();
            session.close();
//            return FXCollections.observableArrayList(chuyenBay);
            return chuyenBay;
        } catch (HibernateException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);
        }
        return null;

    }
    
    private ChuyenBay getChuyenBay(String maChuyen) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
//            Criteria cr = session.createCriteria(ChuyenBay.class);
//            Criterion mc = Restrictions.eq("maChuyen", maChuyen);
//           // cr.addOrder(Order.desc("maChuyen"));
//           cr.add(mc);
            ChuyenBay chuyenBay = (ChuyenBay) session.get(ChuyenBay.class, maChuyen);
            session.close();
            return chuyenBay;
        } catch (HibernateException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);
        }
        return null;
    }
    
    @FXML private void taoMoiHandler(ActionEvent action){
        clearText();
    }
    
    private void clearText(){      
        txtSanBayDi.setText("");
        txtSanBayDen.setText("");
        maHanhKhach.setText("");
        txtNgayGio.setText("");
        cbMaChuyen.setValue("");
        cbHangVe.setValue("");
        txtTenHanhKhach.setText("");
        txtCMND.setText("");
        cbLoaiVe.setValue("");
        txtSDT.setText("");
    }
    
    @FXML
    private void luuHandler(ActionEvent event) {
        if (checkInformation()) {
            String maChuyen = cbMaChuyen.getValue().toString();
            String maKH = maHanhKhach.getText();
            String loaiVe = cbLoaiVe.getValue().toString();
            String hangVe = cbHangVe.getValue().toString();
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Criteria cr = session.createCriteria(Ve.class);
                Criterion mc = Restrictions.eq("chuyenBay.maChuyen", maChuyen);
                Criterion lv = Restrictions.eq("LoaiVe", loaiVe);
                Criterion hv = Restrictions.eq("HangVe", hangVe);
                Criterion tt = Restrictions.eq("TinhTrang", "Con");
                // cr.addOrder(Order.desc("maChuyen"));
                cr.add(mc);
                cr.add(lv);
                cr.add(hv);
                cr.add(tt);
                cr.setMaxResults(1);
                List<Ve> list = cr.list();
               
                if (list.size() > 0) {
                    String maVe = list.get(0).getMaVe();
                    Ve ve = (Ve) session.get(Ve.class, maVe);
                    KhachHang kh = (KhachHang) session.get(KhachHang.class, maKH);
                    ve.setKhachHang(kh);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                    Date date = new Date();  
                    ve.setThoiGian(formatter.format(date));
                    ve.setTinhTrang("Het");
                    Transaction trans = session.beginTransaction();
                    session.update(ve);
                    trans.commit();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Dat ve thanh cong!");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Ve da het");
                    alert.show();

                }
                session.close();

            } catch (HibernateException ex) {
                Logger.getAnonymousLogger().log(Level.SEVERE, "msg", ex);
            }

        }

    }
       
    private boolean checkInformation(){
        if(!cbMaChuyen.getValue().equals("") && !maHanhKhach.getText().isEmpty() && !cbHangVe.equals("") && !cbLoaiVe.equals("")){
            return true;
        }
        return false;
    }
    
    
    
}
