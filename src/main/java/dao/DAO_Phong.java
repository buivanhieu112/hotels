/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.Database;
import entity.LoaiPhong;
import entity.Phong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DAO_Phong {
    public static ArrayList<Phong> getAllPhong() {
		ArrayList<Phong> dsp = new ArrayList<Phong>();
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from Phong";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhong= rs.getString("maPhong");
				String tenPhong= rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLP"));
				String tinhTrang = rs.getString("tinhTrang");
				
				dsp.add(new Phong(maPhong, tenPhong, loaiPhong, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return dsp;
	}
    
    public static ArrayList<Phong> getALLPhongTrong() {
		ArrayList<Phong> list= new ArrayList<Phong>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "select * from Phong where tinhTrang = N'Còn Trống'";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhong= rs.getString("maPhong");
				String tenPhong= rs.getString("tenPhong");
				LoaiPhong loaiPhong= new LoaiPhong(rs.getString("maLP"));
				String tinhTrang= rs.getString("tinhTrang");
				
				list.add(new Phong(maPhong, tenPhong, loaiPhong, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}

	public static boolean themPhong(Phong p) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into Phong values(?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, p.getMaPhong());
			pstm.setString(2, p.getLoaiPhong().getMaLP());
			pstm.setString(3, p.getTenPhong());
			pstm.setString(4, "Còn Trống");
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	
	public static void xoaPhong(String maPhong){		
		Database.getInstance().connect();
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="Delete From Phong where maPhong = ?";
        try {
           s=con.prepareStatement(sql);
            s.setString(1, maPhong);
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
	
	public static boolean capNhatPhong(Phong p) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update Phong set maPhong = ?, maLP = ?, tenPhong = ? where maPhong = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, p.getMaPhong());
			pstm.setString(2, p.getLoaiPhong().getMaLP());
			pstm.setString(3, p.getTenPhong());
			pstm.setString(4, p.getMaPhong());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static ArrayList<Phong> timPhong(String ten) {
		ArrayList<Phong> list= new ArrayList<Phong>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "select * from Phong p join LoaiPhong lp "
					+ "on p.maLP = lp.maLP "
					+ "where maPhong like N'%"+ten+"%' "
					+ "or tenPhong like N'%"+ten+"%' "
					+ "or p.maLP like N'%"+ten+"%' "
					+ "or tenLP like N'%"+ten+"%' "
					+ "or giaLP like N'%"+ten+"%' ";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhong= rs.getString("maPhong");
				String tenPhong= rs.getString("tenPhong");
				LoaiPhong loaiPhong= new LoaiPhong(rs.getString("maLP"));
				String tinhTrang= rs.getString("tinhTrang");
				
				list.add(new Phong(maPhong, tenPhong, loaiPhong, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	public static ArrayList<Phong> timPhongTrongDSP(String ten) {
		ArrayList<Phong> list= new ArrayList<Phong>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "select * from Phong p join LoaiPhong lp "
					+ "on p.maLP = lp.maLP "
					+ "where tinhTrang = N'Còn trống' and (tenPhong like N'%"+ten+"%' "
					+ "or tenLP like N'%"+ten+"%' "
					+ "or giaLP like N'%"+ten+"%') ";

			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhong= rs.getString("maPhong");
				String tenPhong= rs.getString("tenPhong");
				LoaiPhong loaiPhong= new LoaiPhong(rs.getString("maLP"));
				String tinhTrang= rs.getString("tinhTrang");
				
				list.add(new Phong(maPhong, tenPhong, loaiPhong, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	public static ArrayList<Phong> timPhongTrong(String ten) {
		ArrayList<Phong> list= new ArrayList<Phong>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "select * from Phong p join LoaiPhong lp "
					+ "on p.maLP = lp.maLP "
					+ "where (maPhong like N'%"+ten+"%' "
					+ "or tenPhong like N'%"+ten+"%' "
					+ "or p.maLP like N'%"+ten+"%' "
					+ "or tenLP like N'%"+ten+"%' "
					+ "or giaLP like N'%"+ten+"%') "
					+ "and tinhTrang = 0";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhong= rs.getString("maPhong");
				String tenPhong= rs.getString("tenPhong");
				LoaiPhong loaiPhong= new LoaiPhong(rs.getString("maLP"));
//				String ghiChu= rs.getString("ghiChu");
				String tinhTrang= rs.getString("tinhTrang");
				
				list.add(new Phong(maPhong, tenPhong, loaiPhong, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	
	public static ArrayList<Phong> getALLPhongDat() {
		ArrayList<Phong> list= new ArrayList<Phong>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "Select * from Phong where tinhTrang = N'Đang Sử Dụng'";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maPhong= rs.getString("maPhong");
				String tenPhong= rs.getString("tenPhong");
				LoaiPhong loaiPhong= new LoaiPhong(rs.getString("maLP"));
				String tinhTrang= rs.getString("tinhTrang");
				
				list.add(new Phong(maPhong, tenPhong, loaiPhong, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	

	
//	public static ArrayList<Phong> getALLPhongTrongTheoLoaiPhong() {
//		ArrayList<Phong> list= new ArrayList<Phong>();
//		
//		try {
//			Database.getInstance().connect();
//			Connection conn= Database.getConnection();
//			Phong p = new Phong();
//			String sql = "select * from Phong where malp=? and tinhTrang = N'Còn Trống'";
//			
//			PreparedStatement pstm= conn.prepareStatement(sql);
//			pstm.setString(1, p.getLoaiPhong().getMaLP());
//			
//			ResultSet rs= pstm.executeQuery();
//			while(rs.next()) {
//				LoaiPhong loaiPhong= new LoaiPhong(rs.getString("maLP"));
//			}
//			Database.getInstance().disconnect();;
//		} catch (SQLException e) {
//			System.out.println(e);
//		};
//		
//		return list;
//		
//	}
	
	public static boolean capNhatTinhTrangPhongDat(Phong p) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update Phong set tinhTrang = ? where maPhong = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,"Đang sử dụng");
			pstm.setString(2, p.getMaPhong());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật tình trạng phòng thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatTinhTrangPhongTrong(Phong p) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update Phong set tinhTrang = ? where maPhong = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,"Còn Trống");
			pstm.setString(2, p.getMaPhong());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật tình trạng nhân viên thất bại!");
			return false;
		}
	}
}
