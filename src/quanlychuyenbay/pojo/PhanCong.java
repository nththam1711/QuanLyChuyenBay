/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay.pojo;
import javax.persistence.*;

/**
 *
 * @author thamt
 */
@Entity
@Table(name = "phancong")
public class PhanCong {
    
    @Id
    private String MaChuyen;
    
    @Column(name = "MaNV")
    private String MaNV;

    /**
     * @return the MaChuyen
     */
    public String getMaChuyen() {
        return MaChuyen;
    }

    /**
     * @param MaChuyen the MaChuyen to set
     */
    public void setMaChuyen(String MaChuyen) {
        this.MaChuyen = MaChuyen;
    }

    /**
     * @return the MaNV
     */
    public String getMaNV() {
        return MaNV;
    }

    /**
     * @param MaNV the MaNV to set
     */
    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
}
