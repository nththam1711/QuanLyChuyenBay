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
@Table(name = "maybay")
public class MayBay {

    @Id
    private String MaMB;

    @Column(name = "TenMB")
    private String TenMB;
    
    @Column(name = "NamSX")
    private int NamSX;
    
    @Column(name = "SoGhe")
    private int SoGhe;

    /**
     * @return the MaMB
     */
    public String getMaMB() {
        return MaMB;
    }

    /**
     * @param MaMB the MaMB to set
     */
    public void setMaMB(String MaMB) {
        this.MaMB = MaMB;
    }

    /**
     * @return the tenMB
     */
    public String getTenMB() {
        return TenMB;
    }

    /**
     * @param tenMB the tenMB to set
     */
    public void setTenMB(String TenMB) {
        this.TenMB = TenMB;
    }

    /**
     * @return the NamSX
     */
    public int getNamSX() {
        return NamSX;
    }

    /**
     * @param NamSX the NamSX to set
     */
    public void setNamSX(int NamSX) {
        this.NamSX = NamSX;
    }

    /**
     * @return the SoGhe
     */
    public int getSoGhe() {
        return SoGhe;
    }

    /**
     * @param SoGhe the SoGhe to set
     */
    public void setSoGhe(int SoGhe) {
        this.SoGhe = SoGhe;
    }
}
