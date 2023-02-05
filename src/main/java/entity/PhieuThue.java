package entity;

import java.sql.Timestamp;
import java.text.NumberFormat;

public class PhieuThue {
	private int maPT;
	private Phong phong;
	private HoaDon hoaDon;
	private String tinhTrang;
	private Timestamp ngayDatPhong;
	private Timestamp ngayTraPhong;
	private double tienPhong;
	private double tienCoc;

	public PhieuThue(int maPT) {
		super();
		this.maPT = maPT;
	}
	
	public PhieuThue(int maPT, Phong phong, HoaDon hoaDon, String tinhTrang, Timestamp ngayDatPhong,
			Timestamp ngayTraPhong, double tienPhong, double tienCoc) {
		super();
		this.maPT = maPT;
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.tinhTrang = tinhTrang;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienPhong = tienPhong;
		this.tienCoc = tienCoc;
	}



	public PhieuThue(int maPT, Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong, Timestamp ngayTraPhong,
			double tienPhong, double tienCoc) {
		super();
		this.maPT = maPT;
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienPhong = tienPhong;
		this.tienCoc = tienCoc;
	}

	public PhieuThue(Phong phong, HoaDon hoaDon, String tinhTrang, Timestamp ngayDatPhong, Timestamp ngayTraPhong,
			double tienPhong, double tienCoc) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.tinhTrang = tinhTrang;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienPhong = tienPhong;
		this.tienCoc = tienCoc;
	}

	

	public PhieuThue(Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong, Timestamp ngayTraPhong, double tienCoc) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienCoc = tienCoc;
	}
	
	public PhieuThue(Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong, double tienCoc) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.tienCoc = tienCoc;
	}
	public PhieuThue(Phong phong, HoaDon hoaDon, String tinhTrang, Timestamp ngayDatPhong) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.tinhTrang = tinhTrang;
		this.ngayDatPhong = ngayDatPhong;
	}
	public int getMaPT() {
		return maPT;
	}
	public void setMaPT(int maPT) {
		this.maPT = maPT;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Timestamp getNgayDatPhong() {
		return ngayDatPhong;
	}
	public void setNgayDatPhong(Timestamp ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}
	public Timestamp getNgayTraPhong() {
		return ngayTraPhong;
	}
	public void setNgayTraPhong(Timestamp ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}
	public double getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}
	public double getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}
	
	
	



	public PhieuThue(int maPT, Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong, Timestamp ngayTraPhong,
			double tienCoc) {
		super();
		this.maPT = maPT;
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tienCoc = tienCoc;
	}



	public PhieuThue(int maPT, Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong, Timestamp ngayTraPhong) {
		super();
		this.maPT = maPT;
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
	}



	public PhieuThue(int maPT, Phong phong, HoaDon hoaDon) {
		super();
		this.maPT = maPT;
		this.phong = phong;
		this.hoaDon = hoaDon;
	}



	public PhieuThue(Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
	}
	
	
	
	public PhieuThue(Phong phong, HoaDon hoaDon, Timestamp ngayDatPhong, Timestamp ngayTraPhong) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayTraPhong = ngayTraPhong;
	}



	@Override
	public String toString() {
		return "PhieuThue [maPT=" + maPT + ", phong=" + phong + ", hoaDon=" + hoaDon + ", tinhTrang=" + tinhTrang
				+ ", ngayDatPhong=" + ngayDatPhong + ", ngayTraPhong=" + ngayTraPhong + ", tienPhong=" + tienPhong
				+ ", tienCoc=" + tienCoc + "]";
	}
	public int tinhNgay() {
		NumberFormat numf = NumberFormat.getNumberInstance();
		numf.setMaximumFractionDigits(1);
		double s = (double)(ngayTraPhong.getTime() - ngayDatPhong.getTime())/(3600*1000);
		int soNgay = (int) Math.ceil(s/24);
		if (soNgay<s)
			soNgay+=1;
		return soNgay;
	}
	
}
