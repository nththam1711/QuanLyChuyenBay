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
@Table(name = "thongke")
public class ThongKe {
    
    @Id
    private String MaTuyen;
    
    @Column(name = "ThoiGian")
    private int ThoiGian;
    
    @Column(name  = "SoChuyenBay")
    private int SoChuyenBay;
    
    @Column(name = "LuongKhachMax")
    private String LuongKhachMax;
    
    @Column(name = "LuongKhachMin")
    private String LuongKhachMin;

    /**
     * @return the MaTuyen
     */
    public String getMaTuyen() {
        return MaTuyen;
    }

    /**
     * @param MaTuyen the MaTuyen to set
     */
    public void setMaTuyen(String MaTuyen) {
        this.MaTuyen = MaTuyen;
    }

    /**
     * @return the ThoiGian
     */
    public int getThoiGian() {
        return ThoiGian;
    }

    /**
     * @param ThoiGian the ThoiGian to set
     */
    public void setThoiGian(int ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    /**
     * @return the SoChuyenBay
     */
    public int getSoChuyenBay() {
        return SoChuyenBay;
    }

    /**
     * @param SoChuyenBay the SoChuyenBay to set
     */
    public void setSoChuyenBay(int SoChuyenBay) {
        this.SoChuyenBay = SoChuyenBay;
    }

    /**
     * @return the LuongKhachMax
     */
    public String getLuongKhachMax() {
        return LuongKhachMax;
    }

    /**
     * @param LuongKhachMax the LuongKhachMax to set
     */
    public void setLuongKhachMax(String LuongKhachMax) {
        this.LuongKhachMax = LuongKhachMax;
    }

    /**
     * @return the LuongKhachMin
     */
    public String getLuongKhachMin() {
        return LuongKhachMin;
    }

    /**
     * @param LuongKhachMin the LuongKhachMin to set
     */
    public void setLuongKhachMin(String LuongKhachMin) {
        this.LuongKhachMin = LuongKhachMin;
    }
}
