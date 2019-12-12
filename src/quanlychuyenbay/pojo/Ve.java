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
@Table(name = "ve")
public class Ve {

    @Id
    private String MaVe;
    
    
    private String MaChuyen;
    private String MaKH;
    private String HangVe;
    private String LoaiVe;
    private String SoGhe;
    private int Gia;
    private String ThoiGian;
    private String TinhTrang;

    /**
     * @return the MaVe
     */
    public String getMaVe() {
        return MaVe;
    }

    /**
     * @param MaVe the MaVe to set
     */
    public void setMaVe(String MaVe) {
        this.MaVe = MaVe;
    }

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
     * @return the MaKH
     */
    public String getMaKH() {
        return MaKH;
    }

    /**
     * @param MaKH the MaKH to set
     */
    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    /**
     * @return the HangVe
     */
    public String getHangVe() {
        return HangVe;
    }

    /**
     * @param HangVe the HangVe to set
     */
    public void setHangVe(String HangVe) {
        this.HangVe = HangVe;
    }

    /**
     * @return the LoaiVe
     */
    public String getLoaiVe() {
        return LoaiVe;
    }

    /**
     * @param LoaiVe the LoaiVe to set
     */
    public void setLoaiVe(String LoaiVe) {
        this.LoaiVe = LoaiVe;
    }

    /**
     * @return the SoGhe
     */
    public String getSoGhe() {
        return SoGhe;
    }

    /**
     * @param SoGhe the SoGhe to set
     */
    public void setSoGhe(String SoGhe) {
        this.SoGhe = SoGhe;
    }

    /**
     * @return the Gia
     */
    public int getGia() {
        return Gia;
    }

    /**
     * @param Gia the Gia to set
     */
    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    /**
     * @return the ThoiGian
     */
    public String getThoiGian() {
        return ThoiGian;
    }

    /**
     * @param ThoiGian the ThoiGian to set
     */
    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    /**
     * @return the TinhTrang
     */
    public String getTinhTrang() {
        return TinhTrang;
    }

    /**
     * @param TinhTrang the TinhTrang to set
     */
    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

}
