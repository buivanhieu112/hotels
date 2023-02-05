package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.ChucVu;

public class DAO_ChucVu {
	public static ArrayList<ChucVu> getAllChucVu() {
		ArrayList<ChucVu> dscv = new ArrayList<ChucVu>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from chucvu";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maCV= rs.getString("maCV");
				String tenCV= rs.getString("tenCV");
				
				dscv.add(new ChucVu(maCV, tenCV));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return dscv;
	}
	
	public static boolean themCV(ChucVu cv) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into ChucVu values(?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cv.getMaCV());
			pstm.setString(2, cv.getTenCV());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	
	public static void xoaCV(String maCV){		
		Database.getInstance().connect();
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="Delete From ChucVu where maCV = ?";
        try {
           s=con.prepareStatement(sql);
            s.setString(1, maCV);
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
	
	public static boolean capNhatCV(ChucVu cv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update ChucVu set tenCV = ? where maCV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cv.getTenCV());
			pstm.setString(2, cv.getMaCV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin chức vụ thất bại!");
			return false;
		}
	}
	
	public static ArrayList<ChucVu> timCV(String ten){
		ArrayList<ChucVu> dscv=new ArrayList<ChucVu>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from ChucVu where maCV like N'%"+ten+"%' "
			            + "or tenCV like N'%"+ten+"%'";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maCV= rs.getString("maCV");
					String tenCV= rs.getString("tenCV");
					ChucVu cv=new ChucVu(maCV, tenCV);
					dscv.add(cv);
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
		return dscv;
	}
}
