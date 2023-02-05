package entity;

import java.sql.Timestamp;

public class DichVuSuDung {
	private int maHDDV;
	private PhieuThue phieuThue;
	private DichVu dichVu;
	private int soLuong;
	private Timestamp gioDatDV;
	private double tienDV;
	public DichVuSuDung(int maHDDV, PhieuThue phieuThue, DichVu dichVu, int soLuong, Timestamp gioDatDV,
			double tienDV) {
		super();
		this.maHDDV = maHDDV;
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
		this.tienDV = tienDV;
	}
	
	

	public DichVuSuDung(int maHDDV, PhieuThue phieuThue, DichVu dichVu, int soLuong, Timestamp gioDatDV) {
		super();
		this.maHDDV = maHDDV;
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
	}



	public DichVuSuDung(PhieuThue phieuThue, DichVu dichVu, Timestamp gioDatDV) {
		super();
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.gioDatDV = gioDatDV;
	}



	public DichVuSuDung(PhieuThue phieuThue, DichVu dichVu) {
		super();
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
	}


	public DichVuSuDung(PhieuThue phieuThue, DichVu dichVu, int soLuong) {
		super();
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}


	public int getMaHDDV() {
		return maHDDV;
	}
	public void setMaHDDV(int maHDDV) {
		this.maHDDV = maHDDV;
	}
	public PhieuThue getPhieuThue() {
		return phieuThue;
	}
	public void setPhieuThue(PhieuThue phieuThue) {
		this.phieuThue = phieuThue;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Timestamp getGioDatDV() {
		return gioDatDV;
	}
	public void setGioDatDV(Timestamp gioDatDV) {
		this.gioDatDV = gioDatDV;
	}
	public double getTienDV() {
		return tienDV;
	}
	public void setTienDV(double tienDV) {
		this.tienDV = tienDV;
	}
	@Override
	public String toString() {
		return "DichVuSuDung [maHDDV=" + maHDDV + ", phieuThue=" + phieuThue + ", dichVu=" + dichVu + ", soLuong="
				+ soLuong + ", gioDatDV=" + gioDatDV + ", tienDV=" + tienDV + "]";
	}
	public DichVuSuDung(PhieuThue phieuThue, DichVu dichVu, int soLuong, Timestamp gioDatDV, double tienDV) {
		super();
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
		this.tienDV = tienDV;
	}
	public DichVuSuDung(PhieuThue phieuThue, DichVu dichVu, int soLuong, Timestamp gioDatDV) {
		super();
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
	}



	public DichVuSuDung(PhieuThue phieuThue, DichVu dichVu, double tienDV) {
		super();
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
		this.tienDV = tienDV;
	}
	
	
	

}
