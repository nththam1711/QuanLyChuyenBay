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
@Table(name = "Ve")
public class Ve {

    @Id
    private String MaVe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MaChuyen")
    private ChuyenBay chuyenBay;
    
    @Column(name="HangVe")
    private String HangVe;
    
    @Column(name="LoaiVe")
    private String LoaiVe;
    
    @Column(name="Soghe")
    private String SoGhe;
    
    @Column(name="Gia")
    private int Gia;
    
    @Column(name="ThoiGian")
    private String ThoiGian;
    
    @Column(name="TinhTrang")
    private String TinhTrang;
    


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MaKH")
    private KhachHang khachHang;

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Ve() {
    }

    public Ve(String MaVe, ChuyenBay chuyenBay, String HangVe, String LoaiVe, String SoGhe, int Gia, String ThoiGian, String TinhTrang, ChuyenBay chuyenbay, KhachHang khachHang) {
        this.MaVe = MaVe;
        this.chuyenBay = chuyenBay;
        this.HangVe = HangVe;
        this.LoaiVe = LoaiVe;
        this.SoGhe = SoGhe;
        this.Gia = Gia;
        this.ThoiGian = ThoiGian;
        this.TinhTrang = TinhTrang;
        this.khachHang = khachHang;
    }
    

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public void setChuyenBay(ChuyenBay chuyenBay) {
        this.chuyenBay = chuyenBay;
    }



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
