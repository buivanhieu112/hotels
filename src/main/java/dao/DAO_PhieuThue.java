package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.Database;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.PhieuThue;
import entity.Phong;

public class DAO_PhieuThue {

	public static boolean themPhieuThue(PhieuThue pt) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into PhieuThue values(?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, pt.getPhong().getMaPhong());
			pstm.setString(2, pt.getHoaDon().getMaHD());
			pstm.setString(3, "Đang sử dụng");
			pstm.setTimestamp(4, pt.getNgayDatPhong());			
			pstm.setTimestamp(5, pt.getNgayTraPhong());
			pstm.setDouble(6, 0);
			pstm.setDouble(7, pt.getTienCoc());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println("Thêm phiếu thuê thất bại!");
			return false;
		}
	}
	
	public static ArrayList<PhieuThue> getAllHoaDonPhongChuaThanhToan(){ 
		ArrayList<PhieuThue> dspt = new ArrayList<PhieuThue>();
		
		Database.getInstance().connect();
    	Connection conn= Database.getConnection();
    	PreparedStatement pstm=null;
		try {
			String sql = "select * from phieuthue pt join phong p on p.maphong=pt.maphong join hoadon hd on hd.maHD=pt.maHD join KhachHang kh on kh.maKH=hd.maKH where pt.tinhTrang=N'Đang sử dụng'";
			pstm= conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				
//				Phong phong = new Phong(rs.getString("maPhong"));
				String maPhong= rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLP"));
				
				int maPT = rs.getInt("maPT");
				Timestamp ngayDatPhong = rs.getTimestamp("ngayDatPhong");
				Timestamp ngayTraPhong = rs.getTimestamp("ngayTraPhong");
//				Double tienPhong = rs.getDouble("tienPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				
				HoaDon hoaDon = new HoaDon(maHD, khachHang);
				Phong phong = new Phong(maPhong, tenPhong, loaiPhong);
				PhieuThue pt = new PhieuThue(maPT, phong, hoaDon, ngayDatPhong, ngayTraPhong, tienCoc);
				dspt.add(pt);
			}
	    	
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return dspt;
	}
	
	
	
	
	public static ArrayList<PhieuThue> getAllPhieuThueChuaThanhToanTheoMaPT(int ma){
		ArrayList<PhieuThue> dspt=new ArrayList<PhieuThue>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from PhieuThue pt join Phong p "
						+ "on pt.maPhong = p.maPhong join hoadon hd on hd.maHD=pt.maHD "
						+ "where pt.mapt = "+ma;   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
//					String maHD = rs.getString("maHD");
//					KhachHang khachHang = new KhachHang(rs.getString("maKH"));
					HoaDon hoaDon = new HoaDon(rs.getString("maHD"));
//					Phong phong = new Phong(rs.getString("maPhong"));
					String maPhong= rs.getString("maPhong");
					String tenPhong = rs.getString("tenPhong");
					LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLP"));
					
					int maPT = rs.getInt("maPT");
					Timestamp ngayDatPhong = rs.getTimestamp("ngayDatPhong");
					Timestamp ngayTraPhong = rs.getTimestamp("ngayTraPhong");
					Double tienPhong = rs.getDouble("tienPhong");
					Double tienCoc = rs.getDouble("tienCoc");
					
//					HoaDon hoaDon = new HoaDon(maHD);
					Phong phong = new Phong(maPhong, tenPhong, loaiPhong);
					PhieuThue pt=new PhieuThue(maPT, phong, hoaDon, ngayDatPhong, ngayTraPhong, tienPhong, tienCoc);
					dspt.add(pt);
				}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return dspt;
	}
	
	public static boolean capNhatNgayTraPhong(PhieuThue pt) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update PhieuThue set ngayTraPhong = ?"
					+ " where maPhong = ? and maHD = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			Timestamp gioHienTai = new Timestamp(System.currentTimeMillis());
			pstm.setTimestamp(1,gioHienTai);
			pstm.setString(2,pt.getPhong().getMaPhong());
			pstm.setString(3,pt.getHoaDon().getMaHD());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật ngày trả phòng trong hóa đơn phòng thất bại!");
			return false;
		}
	}
	public static ArrayList<PhieuThue> getAllPhieuThueTheoMaHD(String ma){
		ArrayList<PhieuThue> dshdp=new ArrayList<PhieuThue>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from PhieuThue pt join Phong p "
						+ "on pt.maPhong = p.maPhong where pt.maHD = '"+ma+"'";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					HoaDon hoaDon= new HoaDon(rs.getString("maHD"));
					String maPhong= rs.getString("maPhong");
					String tenPhong = rs.getString("tenPhong");
					int mapt = rs.getInt("maPT");
					LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLP"));
					Timestamp ngayDatPhong = rs.getTimestamp("ngayDatPhong");
					Timestamp ngayTraPhong = rs.getTimestamp("ngayTraPhong");
					Double tienPhong = rs.getDouble("tienPhong");
					Double tienCoc = rs.getDouble("tienCoc");
					
					Phong phong = new Phong(maPhong, tenPhong, loaiPhong);
					PhieuThue hdp=new PhieuThue(mapt,phong, hoaDon, ngayDatPhong, ngayTraPhong, tienPhong, tienCoc);
					dshdp.add(hdp);
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
		return dshdp;
	}
	
	public static boolean capNhatPhieuThue(PhieuThue hdp) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update PhieuThue set tienPhong = ?,tinhTrang = ?"
					+ " where maPhong = ? and maHD = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
//			pstm.setInt(1,hdp.getSoGio());
			pstm.setDouble(1,hdp.getTienPhong());
			pstm.setString(2, "Đã Thanh Toán");
			pstm.setString(3,hdp.getPhong().getMaPhong());
			pstm.setString(4,hdp.getHoaDon().getMaHD());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin tiền thuê phòng trong phiếu thuê phòng thất bại!");
			return false;
		}
	}
	
//	public static ArrayList<PhieuThue> getAllPhieuThueDaThanhToan() {
//		ArrayList<PhieuThue> dspt = new ArrayList<PhieuThue>();
//		
//		try {
//			Database.getInstance().connect();
//			Connection conn= Database.getConnection();
//			String sql= "select * from PhieuThue where tinhTrang = N'Đã Thanh Toán'"
//					+ " order by ngayTraPhong";
//			
//			PreparedStatement pstm= conn.prepareStatement(sql);
//			
//			ResultSet rs= pstm.executeQuery();
//			while(rs.next()) {
//				String maPT= rs.getString("maPT");
//				NhanVien nhanVien= new NhanVien(rs.getString("maNV"));
//				KhachHang khachHang= new KhachHang(rs.getString("maKH"));
//				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
//				Double tongThanhTien = rs.getDouble("tongTien");
//				Boolean tinhTrang = rs.getBoolean("tinhTrang");
//				
//				
//				
//				
//				
//				dshd.add(new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhTrang));
//			}
//			Database.getInstance().disconnect();;
//		} catch (SQLException e) {
//			System.out.println("Lấy danh sách hóa đơn thất bại!");
//		};
//		return dspt;
//	}
	
	public static ArrayList<PhieuThue> timPT(String ten) {
		ArrayList<PhieuThue> dspt= new ArrayList<PhieuThue>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			
			String sql = "select * "
					+ "from phieuthue pt join phong p on pt.maPhong=p.maPhong "
					+ "join LoaiPhong lp on lp.maLP = p.maLP "
					+ "join hoadon hd on hd.maHD=pt.maHD "
					+ "join KhachHang kh on kh.maKH=hd.maKH "
					+ "where pt.tinhTrang =N'Đang sử dụng' "
					+ " and (pt.maPT like N'%"+ten+"%' "
					+ " or giaLP like N'%"+ten+"%' "
					+ " or tenLP like N'%"+ten+"%' "
					+ " or tenPhong like N'%"+ten+"%' "
					+ " or ngayDatPhong like N'%"+ten+"%' "
					+ " or tenKH like N'%"+ten+"%') ";
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				
//				Phong phong = new Phong(rs.getString("maPhong"));
				String maPhong= rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLP"));
				
				int maPT = rs.getInt("maPT");
				Timestamp ngayDatPhong = rs.getTimestamp("ngayDatPhong");
				Timestamp ngayTraPhong = rs.getTimestamp("ngayTraPhong");
//				Double tienPhong = rs.getDouble("tienPhong");
				Double tienCoc = rs.getDouble("tienCoc");
				
				HoaDon hoaDon = new HoaDon(maHD, khachHang);
				Phong phong = new Phong(maPhong, tenPhong, loaiPhong);
				PhieuThue pt=new PhieuThue(maPT, phong, hoaDon, ngayDatPhong, ngayTraPhong, tienCoc);
				dspt.add(pt);
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		
		return dspt;
	}
	
	
	
	
	
	
	
}
