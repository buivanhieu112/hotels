/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class LoaiPhong {
    private String maLP;
	private String tenLP;
	private double giaLP;
	
	public String getMaLP() {
		return maLP;
	}
	public void setMaLP(String maLP) {
		this.maLP = maLP;
	}
	public String getTenLP() {
		return tenLP;
	}
	public void setTenLP(String tenLP) {
		this.tenLP = tenLP;
	}
	public double getGiaLP() {
		return giaLP;
	}
	public void setGiaLP(double giaLP) {
		this.giaLP = giaLP;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maLP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLP, other.maLP);
	}
	
	public LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoaiPhong(String maLP) {
		super();
		this.maLP = maLP;
	}
	
	public LoaiPhong(String maLP, String tenLP, double giaLP) {
		super();
		this.maLP = maLP;
		this.tenLP = tenLP;
		this.giaLP = giaLP;
	}
	
	@Override
	public String toString() {
		return "LoaiPhong [maLP=" + maLP + ", tenLP=" + tenLP + ", giaLP=" + giaLP + "]";
	}
    
    
}
