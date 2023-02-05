/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.Database;
import entity.LoaiPhong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DAO_LoaiPhong {
    public static ArrayList<LoaiPhong> getAllLoaiPhong() {
		ArrayList<LoaiPhong> dslp = new ArrayList<LoaiPhong>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from LoaiPhong";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maLP= rs.getString("maLP");
				String tenLP= rs.getString("tenLP");
				Double giaLP= rs.getDouble("giaLP");
				
				dslp.add(new LoaiPhong(maLP, tenLP, giaLP));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return dslp;
	}
	
	public static boolean themLP(LoaiPhong lp) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into LoaiPhong values(?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, lp.getMaLP());
			pstm.setString(2, lp.getTenLP());
			pstm.setDouble(3, lp.getGiaLP());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	
	public static void xoaLP(String maLP){		
		Database.getInstance().connect();;
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="Delete From LoaiPhong where maLP = ?";
        try {
           s=con.prepareStatement(sql);
            s.setString(1, maLP);
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
	
	public static boolean capNhatLP(LoaiPhong lp) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update LoaiPhong set tenLP = ?, giaLP = ? where maLP = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, lp.getTenLP());
			pstm.setDouble(2, lp.getGiaLP());
			pstm.setString(3, lp.getMaLP());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin loại phòng thất bại!");
			return false;
		}
	}
	
	public static ArrayList<LoaiPhong> timLP(String ten){
		ArrayList<LoaiPhong> dslp=new ArrayList<LoaiPhong>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from LoaiPhong where maLP like N'%"+ten+"%' "
			            + "or tenLP like N'%"+ten+"%'"
			            + "or giaLP like N'%"+ten+"%'";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maLP= rs.getString("maLP");
					String tenLP= rs.getString("tenLP");
					Double giaLP= rs.getDouble("giaLP");
					LoaiPhong lp=new LoaiPhong(maLP, tenLP, giaLP);
					dslp.add(lp);
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
		return dslp;
	}
}
