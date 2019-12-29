/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlychuyenbay.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author thamt
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    private String MaKH;

    @Column(name = "TenKH")
    private String TenKH;

    @Column(name = "QuocTich")
    private String QuocTich;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "SDT")
    private String SDT;

    @Column(name = "SoCMT")
    private String SoCMT;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "khachHang", cascade=CascadeType.ALL)
//    @JoinColumn(name = "MaKH")
    private Set<Ve> ve= new HashSet<Ve>();

    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String QuocTich, String DiaChi, String SDT, String SoCMT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.QuocTich = QuocTich;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.SoCMT = SoCMT;
    }
    

    public Set<Ve> getVe() {
        return ve;
    }

    public void setVe(Set<Ve> ve) {
        this.ve = ve;
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
     * @return the TenKH
     */
    public String getTenKH() {
        return TenKH;
    }

    /**
     * @param TenKH the TenKH to set
     */
    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    /**
     * @return the QuocTich
     */
    public String getQuocTich() {
        return QuocTich;
    }

    /**
     * @param QuocTich the QuocTich to set
     */
    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
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
     * @return the SoCMT
     */
    public String getSoCMT() {
        return SoCMT;
    }

    /**
     * @param SoCMT the SoCMT to set
     */
    public void setSoCMT(String SoCMT) {
        this.SoCMT = SoCMT;
    }

}
