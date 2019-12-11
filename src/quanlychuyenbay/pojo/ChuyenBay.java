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
@Table(name = "chuyenbay")
public class ChuyenBay {

    @Id
    private String MaChuyen;
    @Column(name = "MaMB", length = 5, nullable = false)
    private String MaMB;
    
    @Column(name = "SanBayDi")
    private String SanBayDi;
    
    @Column(name = "SanBayDen")
    private String SanBayDen;
    
    @Column(name = "Khoihanh")
    private String KhoiHanh;
    
    @Column(name = "ThoiGianDuKien")
    private String ThoiGianDuKien;
    
    @Column(name = "SoGheBanDau")
    private int SoGheBanDau;
    
    @Column(name = "SoGheTrong")
    private int SoGheTrong;

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
     * @return the SanBayDi
     */
    public String getSanBayDi() {
        return SanBayDi;
    }

    /**
     * @param SanBayDi the SanBayDi to set
     */
    public void setSanBayDi(String SanBayDi) {
        this.SanBayDi = SanBayDi;
    }

    /**
     * @return the SanBayDen
     */
    public String getSanBayDen() {
        return SanBayDen;
    }

    /**
     * @param SanBayDen the SanBayDen to set
     */
    public void setSanBayDen(String SanBayDen) {
        this.SanBayDen = SanBayDen;
    }

    /**
     * @return the KhoiHanh
     */
    public String getKhoiHanh() {
        return KhoiHanh;
    }

    /**
     * @param KhoiHanh the KhoiHanh to set
     */
    public void setKhoiHanh(String KhoiHanh) {
        this.KhoiHanh = KhoiHanh;
    }

    /**
     * @return the ThoiGianDuKien
     */
    public String getThoiGianDuKien() {
        return ThoiGianDuKien;
    }

    /**
     * @param ThoiGianDuKien the ThoiGianDuKien to set
     */
    public void setThoiGianDuKien(String ThoiGianDuKien) {
        this.ThoiGianDuKien = ThoiGianDuKien;
    }

    /**
     * @return the SoGheBanDau
     */
    public int getSoGheBanDau() {
        return SoGheBanDau;
    }

    /**
     * @param SoGheBanDau the SoGheBanDau to set
     */
    public void setSoGheBanDau(int SoGheBanDau) {
        this.SoGheBanDau = SoGheBanDau;
    }

    /**
     * @return the SoGheTrong
     */
    public int getSoGheTrong() {
        return SoGheTrong;
    }

    /**
     * @param SoGheTrong the SoGheTrong to set
     */
    public void setSoGheTrong(int SoGheTrong) {
        this.SoGheTrong = SoGheTrong;
    }
}
