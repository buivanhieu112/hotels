package entity;

import java.sql.Timestamp;

public class HoaDon {
	private String maHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private Timestamp ngayLapHD;
	private double tongThanhTien;
	private boolean tinhTrang;
	
	
	
	
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public Timestamp getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Timestamp ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public double getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public HoaDon(String maHD, NhanVien nhanVien, KhachHang khachHang, Timestamp ngayLapHD, double tongThanhTien, boolean tinhTrang) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLapHD = ngayLapHD;
		this.tongThanhTien = tongThanhTien;
		this.tinhTrang = tinhTrang;
	}
	public HoaDon() {
		super();
	}
	
	
	
	
	public HoaDon(String maHD, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	public HoaDon(String maHD, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
	}
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	public HoaDon(String maHD, KhachHang khachHang, Timestamp ngayLapHD) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.ngayLapHD = ngayLapHD;
	}
	
	public HoaDon(String maHD, KhachHang khachHang, boolean tinhTrang) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.tinhTrang = tinhTrang;
	}
	public HoaDon(String maHD, NhanVien nhanVien, KhachHang khachHang, Timestamp ngayLapHD) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLapHD = ngayLapHD;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayLapHD="
				+ ngayLapHD + ", tongThanhTien=" + tongThanhTien + ", tinhTrang=" + tinhTrang
				+ "]";
	}
	
	
}
