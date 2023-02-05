/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.Database;
import entity.LoaiDichVu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DAO_LoaiDichVu {
	public static ArrayList<LoaiDichVu> getAllLoaiDV() {
		ArrayList<LoaiDichVu> dslp = new ArrayList<LoaiDichVu>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from LoaiDichVu";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maDV= rs.getString("maLDV");
				String tenDV= rs.getString("tenLDV");
				
				dslp.add(new LoaiDichVu(maDV, tenDV ));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return dslp;
	}
	
	public static boolean themLoaiDV(LoaiDichVu lp) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into LoaiDichVu values(?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, lp.getMaLoaiDichVu());
			pstm.setString(2, lp.getTenLoaiDichVu());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	
	public static void xoaLoaiDV(String maLoaiDV){		
		Database.getInstance().connect();;
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="Delete From LoaiDichVu where maLDV = ?";
        try {
           s=con.prepareStatement(sql);
            s.setString(1, maLoaiDV);
            s.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
        	try {
				s.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
        }
	}
	
	public static boolean capNhatLoaiDV(LoaiDichVu lp) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update LoaiDichVu set tenLDV = ? where maLDV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, lp.getTenLoaiDichVu());
			pstm.setString(2, lp.getMaLoaiDichVu());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin loại dịch vụ thất bại!");
			return false;
		}
	}
	
	public static ArrayList<LoaiDichVu> timLoaiDV(String ten){
		ArrayList<LoaiDichVu> dsdv =new ArrayList<LoaiDichVu>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from LoaiDichVu where maLDV like N'%"+ten+"%' "
			            + "or tenLDV like N'%"+ten+"%' ";  
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maLDV= rs.getString("maLDV");
					String tenLDV= rs.getString("tenLDV");
					LoaiDichVu dv = new LoaiDichVu(maLDV, tenLDV);
					dsdv.add(dv);
				}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				s.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return dsdv;
	}
}
