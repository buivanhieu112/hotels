package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.KhachHang;

public class DAO_KhachHang {
	
	public static ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from KhachHang";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maKH= rs.getString("maKH");
				String tenKH= rs.getString("tenKH");
				String gioiTinh = rs.getString("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String soCMND= rs.getString("soCMND");
				String soDT= rs.getString("soDT");
				
				list.add(new KhachHang(maKH, tenKH,gioiTinh,diaChi, soCMND, soDT));
			}
			Database.getInstance().disconnect();
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}
	
	public static ArrayList<KhachHang> timKH(String ten) {
		ArrayList<KhachHang> list= new ArrayList<KhachHang>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "Select * from KhachHang where tenKH like N'%"+ten+"%' "
					+ "or maKH like N'%"+ten+"%' "
					+ "or diaChi like N'%"+ten+"%' "
					+ "or gioiTinh like N'%"+ten+"%' "
		            + "or soCMND like N'%"+ten+"%' "
		            + "or soDT like N'%"+ten+"%' ";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maKH= rs.getString("maKH");
				String tenKH= rs.getString("tenKH");
				String gioiTinh = rs.getString("gioiTinh");
				String diaChi = rs.getString("diaChi");
				String soCMND= rs.getString("soCMND");
				String soDT= rs.getString("soDT");
				
				list.add(new KhachHang(maKH, tenKH,gioiTinh,diaChi, soCMND, soDT));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return list;
		
	}

	public static boolean themKH(KhachHang kh) {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into KhachHang values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, kh.getMaKH());
			pstm.setString(2, kh.getTenKH());
			pstm.setString(3, kh.getGioiTinh());
			pstm.setString(4, kh.getDiaChi());
			pstm.setString(5, kh.getSoCMND());
			pstm.setString(6, kh.getSoDT());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println("Thêm khách hàng không thành công!");
			return false;
		}
	}
	
	public static boolean capNhatKH(KhachHang kh) throws Exception  {
		
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update KhachHang set tenKH = ?, gioiTinh=?, diaChi=?, soCMND = ?, soDT = ?  where maKH = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,kh.getTenKH());
			pstm.setString(2,kh.getGioiTinh());
			pstm.setString(3,kh.getDiaChi());
			pstm.setString(4,kh.getSoCMND());
			pstm.setString(5,kh.getSoDT());
			pstm.setString(6,kh.getMaKH());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
//	
}
