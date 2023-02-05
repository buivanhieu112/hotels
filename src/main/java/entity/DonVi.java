/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class DonVi {
    private String maDonVi,tenDonVi;

    public DonVi(String maDonVi, String tenDonVi) {
        this.maDonVi = maDonVi;
        this.tenDonVi = tenDonVi;
    }

    public DonVi() {
    }

    public DonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    @Override
    public String toString() {
        return "DonVi{" + "maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + '}';
    }
    
}
