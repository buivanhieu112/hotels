/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class DichVu {
    private String maDV;
    private String tenDV;
    private double giaDV;
    private int soLuongTon;
    LoaiDichVu loaiDichVu;
    DonVi donVi;

    public DichVu(String maDV, String tenDV, double giaDV, int soLuongTon, LoaiDichVu loaiDichVu, DonVi donVi) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
        this.soLuongTon = soLuongTon;
        this.loaiDichVu = loaiDichVu;
        this.donVi = donVi;
    }
   
	public DichVu(String maDV, LoaiDichVu loaiDichVu, DonVi donVi) {
		super();
		this.maDV = maDV;
		this.loaiDichVu = loaiDichVu;
		this.donVi = donVi;
	}
	
	public DichVu(String maDV) {
		super();
		this.maDV = maDV;
	}


	public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(double giaDV) {
        this.giaDV = giaDV;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public DonVi getDonVi() {
        return donVi;
    }

    public void setDonVi(DonVi donVi) {
        this.donVi = donVi;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDV=" + maDV + ", tenDV=" + tenDV + ", giaDV=" + giaDV + ", soLuongTon=" + soLuongTon + ", loaiDichVu=" + loaiDichVu + ", donVi=" + donVi + '}';
    }
    
    
        
}
