package entity;

import java.sql.Timestamp;

public class HoaDonDichVu {
	private String maHDDV;
	private HoaDon hoaDon;
	private DichVu dichVu;
	private Phong phong;
	private int soLuong;
	private Timestamp gioDatDV;
	private double tienDV;
	public String getMaHDDV() {
		return maHDDV;
	}
	public void setMaHDDV(String maHDDV) {
		this.maHDDV = maHDDV;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
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
	
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	public HoaDonDichVu(HoaDon hoaDon, DichVu dichVu, Phong phong, int soLuong, Timestamp gioDatDV) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.phong = phong;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
	}
	
	
	public HoaDonDichVu(HoaDon hoaDon, DichVu dichVu, Phong phong, int soLuong, Timestamp gioDatDV, double tienDV) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.phong = phong;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
		this.tienDV = tienDV;
	}
	public HoaDonDichVu(String maHDDV, HoaDon hoaDon, DichVu dichVu, Phong phong, int soLuong, Timestamp gioDatDV,
			double tienDV) {
		super();
		this.maHDDV = maHDDV;
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.phong = phong;
		this.soLuong = soLuong;
		this.gioDatDV = gioDatDV;
		this.tienDV = tienDV;
	}
	
	
	public HoaDonDichVu(HoaDon hoaDon, DichVu dichVu, Phong phong) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "HoaDonDichVu [maHDDV=" + maHDDV + ", dichVu=" + dichVu + ", phong=" + phong + ", soLuong=" + soLuong
				+ ", gioDatDV=" + gioDatDV + ", tienDV=" + tienDV + "]";
	}
	
	
}
