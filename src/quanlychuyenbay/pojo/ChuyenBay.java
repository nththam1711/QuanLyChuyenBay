/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author thamt
 */
@Entity 
@Table(name = "chuyenbay")
public class ChuyenBay implements Serializable {

    @Id
    private String maChuyen;
    
    @Column(name = "MaMB", length = 5, nullable = false, insertable = false, updatable = false)
    private String maMB;
    
    @Column(name = "SanBayDi")
    private String sanBayDi;
    
    @Column(name = "SanBayDen")
    private String sanBayDen;
    
    @Column(name = "Khoihanh")
    private String khoiHanh;
    
    @Column(name = "ThoiGianDuKien")
    private String thoiGianDuKien;
    
    @Column(name = "SoGheBanDau")
    private Integer soGheBanDau;
    
    @Column(name = "SoGheTrong")
    private Integer soGheTrong;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaMB")
    private MayBay mayBay;

    
    public ChuyenBay() {
    
    }
    
    public ChuyenBay (String maChuyen, String maMB, String sanBayDi, String sanBayDen, String khoiHanh,
            String thoiGianDuKien, Integer soGheBanDau, Integer soGheTrong) {
        
        this.maChuyen = maChuyen;
        this.maMB = maMB;
        this.sanBayDi = sanBayDi;
        this.sanBayDen = sanBayDen;
        this.khoiHanh = khoiHanh;
        this.thoiGianDuKien = thoiGianDuKien;
        this.soGheBanDau = soGheBanDau;
        this.soGheTrong = soGheTrong;
    }

    /**
     * @return the maChuyen
     */
    public String getMaChuyen() {
        return maChuyen;
    }

    /**
     * @param maChuyen the maChuyen to set
     */
    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    /**
     * @return the maMB
     */
    public String getMaMB() {
        return maMB;
    }

    /**
     * @param maMB the maMB to set
     */
    public void setMaMB(String maMB) {
        this.maMB = maMB;
    }

    /**
     * @return the sanBayDi
     */
    public String getSanBayDi() {
        return sanBayDi;
    }

    /**
     * @param sanBayDi the sanBayDi to set
     */
    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    /**
     * @return the sanBayDen
     */
    public String getSanBayDen() {
        return sanBayDen;
    }

    /**
     * @param sanBayDen the sanBayDen to set
     */
    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

    /**
     * @return the khoiHanh
     */
    public String getKhoiHanh() {
        return khoiHanh;
    }

    /**
     * @param khoiHanh the khoiHanh to set
     */
    public void setKhoiHanh(String khoiHanh) {
        this.khoiHanh = khoiHanh;
    }

    /**
     * @return the thoiGianDuKien
     */
    public String getThoiGianDuKien() {
        return thoiGianDuKien;
    }

    /**
     * @param thoiGianDuKien the thoiGianDuKien to set
     */
    public void setThoiGianDuKien(String thoiGianDuKien) {
        this.thoiGianDuKien = thoiGianDuKien;
    }

    /**
     * @return the soGheBanDau
     */
    public Integer getSoGheBanDau() {
        return soGheBanDau;
    }

    /**
     * @param soGheBanDau the soGheBanDau to set
     */
    public void setSoGheBanDau(Integer soGheBanDau) {
        this.soGheBanDau = soGheBanDau;
    }

    /**
     * @return the soGheTrong
     */
    public Integer getSoGheTrong() {
        return soGheTrong;
    }

    /**
     * @param soGheTrong the soGheTrong to set
     */
    public void setSoGheTrong(Integer soGheTrong) {
        this.soGheTrong = soGheTrong;
    }

    /**
     * @return the mayBay
     */
    public MayBay getMayBay() {
        return mayBay;
    }

    /**
     * @param mayBay the mayBay to set
     */
    public void setMayBay(MayBay mayBay) {
        this.mayBay = mayBay;
    }


    
   
}
