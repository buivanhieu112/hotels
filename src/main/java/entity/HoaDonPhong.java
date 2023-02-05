package entity;

import java.sql.Timestamp;
import java.text.NumberFormat;

public class HoaDonPhong {
	private HoaDon hoaDon;
	private Phong phong;
	private Timestamp gioDatPhong;
	private Timestamp gioTraPhong;
	private double tienPhong;
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	
	
	public HoaDonPhong(HoaDon hoaDon) {
		super();
		this.hoaDon = hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Timestamp getGioDatPhong() {
		return gioDatPhong;
	}
	public void setGioDatPhong(Timestamp gioDatPhong) {
		this.gioDatPhong = gioDatPhong;
	}
	public Timestamp getGioTraPhong() {
		return gioTraPhong;
	}
	public void setGioTraPhong(Timestamp gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}
	public double getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}
	@Override
	public String toString() {
		return "HoaDonPhong [hoaDon=" + hoaDon + ", phong=" + phong + ", gioDatPhong=" + gioDatPhong + ", gioTraPhong="
				+ gioTraPhong + ", tienPhong=" + tienPhong + "]";
	}
	public HoaDonPhong(HoaDon hoaDon, Phong phong, Timestamp gioDatPhong, Timestamp gioTraPhong, double tienPhong) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.gioDatPhong = gioDatPhong;
		this.gioTraPhong = gioTraPhong;
		this.tienPhong = tienPhong;
	}
	public HoaDonPhong(HoaDon hoaDon, Phong phong, Timestamp gioDatPhong) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.gioDatPhong = gioDatPhong;
	}
	public HoaDonPhong() {
		super();
	}
	public HoaDonPhong(HoaDon hoaDon, Phong phong, Timestamp gioDatPhong, Timestamp gioTraPhong) {
		super();
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.gioDatPhong = gioDatPhong;
		this.gioTraPhong = gioTraPhong;
	}
	
	
	public int tinhNgay() {
		NumberFormat numf = NumberFormat.getNumberInstance();
		numf.setMaximumFractionDigits(1);
		double s = (double)(gioTraPhong.getTime() - gioDatPhong.getTime())/(3600*1000);
		int soNgay = (int) (s/24);
		if (soNgay<s)
			soNgay+=1;
		return soNgay;
	}
	
}
