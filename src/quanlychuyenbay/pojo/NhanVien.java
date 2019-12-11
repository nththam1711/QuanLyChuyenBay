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
@Table(name = "nhanvien")
public class NhanVien {

    @Id
    private String MaNV;

    @Column(name = "TenNhanVien")
    private String TenNhanVien;
    
    @Column(name = "DiaChi")
    private String DiaChi;
    
    @Column(name = "SDT")
    private String SDT;
    
    @Column(name = "Luong")
    private double Luong;

    @Column(name = "MaLoai")
    private String MaLoai;

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

    /**
     * @return the TenNhanVien
     */
    public String getTenNhanVien() {
        return TenNhanVien;
    }

    /**
     * @param TenNhanVien the TenNhanVien to set
     */
    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    /**
     * @return the DiaChi
     */
    public String getDiaChi() {
        return DiaChi;
    }

    /**
     * @param DiaChi the DiaChi to set
     */
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    /**
     * @return the SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * @param SDT the SDT to set
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * @return the Luong
     */
    public double getLuong() {
        return Luong;
    }

    /**
     * @param Luong the Luong to set
     */
    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    /**
     * @return the MaLoai
     */
    public String getMaLoai() {
        return MaLoai;
    }

    /**
     * @param MaLoai the MaLoai to set
     */
    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

}
