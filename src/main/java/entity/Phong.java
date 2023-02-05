/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


/**
 *
 * @author admin
 */
public class Phong {
	private String maPhong;
	private String tenPhong;
	private LoaiPhong loaiPhong;
	private String tinhTrang;
	
	
	public Phong(String maPhong, String tenPhong, LoaiPhong loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong + ", tinhTrang="
				+ tinhTrang + "]";
	}
	public Phong(String maPhong, String tenPhong, LoaiPhong loaiPhong, String tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.tinhTrang = tinhTrang;
	}
	public Phong() {
		super();
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	
	
   
    
    
}
