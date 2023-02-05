/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class LoaiDichVu {
    private String maLoaiDichVu;
    private String tenLoaiDichVu;

    public String getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    @Override
    public String toString() {
        return "LoaiDichVu{" + "maLoaiDichVu=" + maLoaiDichVu + ", tenLoaiDichVu=" + tenLoaiDichVu + '}';
    }

    public LoaiDichVu(String maLoaiDichVu, String tenLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public LoaiDichVu(String maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public LoaiDichVu() {
    }
    
    
}
