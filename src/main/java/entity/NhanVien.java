/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class NhanVien {
    private String maNV,tenNV,gioiTinh,soCMND;
    private ChucVu chucVu;
    private String soDT;
    private Date ngayVaoLam;
    private String matKhau;
    private boolean tinhTrang;

    public NhanVien(String maNV, String tenNV, String gioiTinh, String soCMND, ChucVu chucVu, String soDT, Date ngayVaoLam, String matKhau, boolean tinhTrang) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.chucVu = chucVu;
        this.soDT = soDT;
        this.ngayVaoLam = ngayVaoLam;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
    }

    public NhanVien() {
    }
    

    public NhanVien(String maNV, String tenNV, String gioiTinh, String soCMND, ChucVu chucVu, String soDT,
			Date ngayVaoLam, String matKhau) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.chucVu = chucVu;
		this.soDT = soDT;
		this.ngayVaoLam = ngayVaoLam;
		this.matKhau = matKhau;
	}


	public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", soCMND=" + soCMND + ", chucVu=" + chucVu + ", soDT=" + soDT + ", ngayVaoLam=" + ngayVaoLam + ", matKhau=" + matKhau + ", tinhTrang=" + tinhTrang + '}';
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    

    
}
