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
public class ChucVu {
    private String maCV;
	private String tenCV;
	
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getTenCV() {
		return tenCV;
	}
	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maCV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChucVu other = (ChucVu) obj;
		return Objects.equals(maCV, other.maCV);
	}
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChucVu(String maCV) {
		super();
		this.maCV = maCV;
	}
	
	public ChucVu(String maCV, String tenCV) {
		super();
		this.maCV = maCV;
		this.tenCV = tenCV;
	}
	
	@Override
	public String toString() {
		return "ChucVu [maCV=" + maCV + ", tenCV=" + tenCV + "]";
	}
}
