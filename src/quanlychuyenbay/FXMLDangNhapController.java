/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import quanlychuyenbay.pojo.TaiKhoan;

/**
 * FXML Controller class
 *
 * @author thamt
 */
public class FXMLDangNhapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtTenDangNhap;
    @FXML
    private PasswordField txtMatKhau;
    @FXML
    private Button btnDangNhap;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean validate() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if (txtTenDangNhap.getText().equals("")) {
            alert.setContentText("Chưa nhập tên đăng nhập.");
            alert.show();
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            alert.setContentText("Chưa nhập mật khẩu.");
            alert.show();
            return false;
        }
        return true;
    }

    @FXML
    private void handleDangNhapButton(ActionEvent event) throws SQLException, IOException {

        if (validate()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            try {
                String username = txtTenDangNhap.getText();
                String password = txtMatKhau.getText();

                Session session = HibernateUtil.getSessionFactory().openSession();

                TaiKhoan taikhoan = (TaiKhoan) session.get(TaiKhoan.class, username);

                Logger.getAnonymousLogger().log(Level.SEVERE, taikhoan.toString());
                if(taikhoan == null){
                    alert.setContentText("Tên đăng nhập không đúng.");
                                    alert.show();
                }
                else if (password.equals(taikhoan.getPassword())) {
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Trang Chủ");
                    stage.show();

                    Stage login = (Stage) btnDangNhap.getScene().getWindow();
                    login.close();
                } else {
                    alert.setContentText("Mật khẩu không đúng.");
                    alert.show();
                }
            } catch (Exception e) {
                alert.setContentText("err" + e.toString());
                alert.show();
            }

        }

//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
//            Parent root = fxmlLoader.load();
//            Scene scene = new Scene（root);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            
//        } catch (Exception e) {
//            System.out.println("Can't load new windown");
//        }
    }

}
