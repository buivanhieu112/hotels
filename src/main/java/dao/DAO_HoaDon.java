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
import entity.NhanVien;

public class DAO_HoaDon {
	
	public static ArrayList<HoaDon> getAllHoaDonChuaThanhToan() {
		ArrayList<HoaDon> dshd= new ArrayList<HoaDon>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from HoaDon where tinhTrang = 0";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHD= rs.getString("maHD");
				KhachHang khachHang= new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				dshd.add(new HoaDon(maHD, null, khachHang, ngayLapHD, 0, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println("Lấy danh sách hóa đơn thất bại!");
		};
		return dshd;
	}
	
	
	
	
	
	public static ArrayList<HoaDon> getAllHoaDonDaThanhToan() {
		ArrayList<HoaDon> dshd= new ArrayList<HoaDon>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from HoaDon where tinhTrang = 1"
					+ " order by ngayLapHD";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHD= rs.getString("maHD");
				NhanVien nhanVien= new NhanVien(rs.getString("maNV"));
				KhachHang khachHang= new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				Double tongThanhTien = rs.getDouble("tongTien");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				dshd.add(new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println("Lấy danh sách hóa đơn thất bại!");
		};
		return dshd;
	}

	public static ArrayList<HoaDon> getAllHoaDonDaThanhToanTheoNV() {
		ArrayList<HoaDon> dshd= new ArrayList<HoaDon>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from HoaDon hd join NhanVien nv"
					+ " on hd.maNV = nv.maNV"
					+ " where nv.tinhTrang = 1"
					+ " and hd.tinhTrang = 1";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHD= rs.getString("maHD");
				NhanVien nhanVien= new NhanVien(rs.getString("maNV"));
				KhachHang khachHang= new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				Double tongThanhTien = rs.getDouble("tongTien");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				dshd.add(new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println("Lấy danh sách hóa đơn thất bại!");
		};
		return dshd;
	}
	
	public static ArrayList<HoaDon> getAllHoaDonDaThanhToanCuaNV(String ma) {
		ArrayList<HoaDon> dshd= new ArrayList<HoaDon>();		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from HoaDon hd join NhanVien nv"
					+ " on hd.maNV = nv.maNV"
					+ " where hd.maNV = '"+ma+"' "
					+ " and hd.tinhTrang = 1"
					+ " order by ngayLapHD";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHD= rs.getString("maHD");
				NhanVien nhanVien= new NhanVien(rs.getString("maNV"));
				KhachHang khachHang= new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				Double tongThanhTien = rs.getDouble("tongTien");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				dshd.add(new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println("Lấy danh sách hóa đơn thất bại!");
		};
		return dshd;
	}
	
	public static ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dshd= new ArrayList<HoaDon>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from HoaDon";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maHD= rs.getString("maHD");
				NhanVien nhanVien= new NhanVien(rs.getString("maNV"));
				KhachHang khachHang= new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				Double tongThanhTien = rs.getDouble("tongTien");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				dshd.add(new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println("Lấy danh sách hóa đơn thất bại!");
		};
		return dshd;
	}
	
	public static boolean themHD(HoaDon hd) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into HoaDon values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, hd.getMaHD());
			pstm.setString(2, null);
			pstm.setString(3, hd.getKhachHang().getMaKH());
			pstm.setTimestamp(4, null);
			pstm.setDouble(5, 0);
			pstm.setBoolean(6, false);
			
			pstm.executeUpdate();
			System.out.println("Thêm hóa đơn thành công!");
			return true;
		} catch (SQLException e1) {
			System.out.println("Thêm hóa đơn thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatHD(HoaDon hd) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update HoaDon set maNV = ?, ngayLapHD = ?, tinhtrang = ?, "
					+ " tongTien = ? where maHD = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,hd.getNhanVien().getMaNV());
			pstm.setTimestamp(2,hd.getNgayLapHD());
			pstm.setBoolean(3,true);
			pstm.setDouble(4,hd.getTongThanhTien());
			pstm.setString(5,hd.getMaHD());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin hóa đơn trong bảng hóa đơn thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatTinhTrangDaThanhToan(HoaDon hd) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update HoaDon set tinhTrang = ? where maNV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setBoolean(1,true);
			pstm.setString(2, hd.getMaHD());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật tình trạng hóa đơn thất bại!");
			return false;
		}
	}
	
	public static ArrayList<HoaDon> timHDChuaThanhToan(String ten){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select hd.maHD, hd.maKH, soDT, ngayLapHD from HoaDon hd join KhachHang kh "
						+ "on hd.maKH = kh.maKH join HoaDonPhong hdp "
						+ "on hd.maHD = hdp.maHD join Phong p "
						+ "on hdp.maPhong = p.maPhong "
						+ "where (hd.maHD like N'%"+ten+"%' "
						+ "or p.maPhong like N'%"+ten+"%' "
						+ "or tenPhong like N'%"+ten+"%' "
			            + "or tenKH like N'%"+ten+"%' "
			            + "or soDT like N'%"+ten+"%') "
			            + "and hd.tinhTrang = 0 "
			            + "group by hd.maHD, hd.maKH, soDT, ngayLapHD";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maHD= rs.getString("maHD");
					KhachHang khachHang= new KhachHang(rs.getString("maKH"));
					Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
					HoaDon hd = new HoaDon(maHD, null, khachHang, ngayLapHD, 0, false);
					dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanCuaNVTheoNgayHienTai(String ngayHT){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String ngay = ngayHT.substring(8);
			String thang = ngayHT.substring(5,7);
			String nam = ngayHT.substring(0,4);
			String sql = "Select * from HoaDon hd join NhanVien nv "
					+ "on hd.maNV = nv.maNV "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
					+ "and MONTH(ngayLapHD) = '"+thang+"' "
					+ "and DAY(ngayLapHD) = '"+ngay+"'"
			        + "and hd.tinhTrang = 1 and nv.tinhTrang = 1 ";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanCuaNV(String ten){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select hd.maHD, hd.maNV, hd.maKH, kh.soDT, ngayLapHD, tongThanhTien, thueVAT, hd.tinhTrang "
					+ "from HoaDon hd join KhachHang kh "
					+ "on hd.maKH = kh.maKH join NhanVien nv "
					+ "on hd.maNV = nv.maNV "
					+ "where (hd.maHD like N'%"+ten+"%' "
		            + "or tenKH like N'%"+ten+"%' "
		            + "or kh.soDT like N'%"+ten+"%') "
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1"
		            + "group by hd.maHD, hd.maNV, hd.maKH, kh.soDT, ngayLapHD, tongThanhTien, thueVAT, hd.tinhTrang";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanCuaNVTheoNam(int nam){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select * "
					+ "from HoaDon hd join NhanVien nv "
					+ "on hd.maNV = nv.maNV "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1 "
		            + "order by ngayLapHD";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanCuaNVTheoThang(int thang, int nam){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select * "
					+ "from HoaDon hd join NhanVien nv "
					+ "on hd.maNV = nv.maNV "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
					+ "and MONTH(ngayLapHD) = '"+thang+"' "
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1 "
		            + "order by ngayLapHD";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanCuaNVTheoNgay(int ngay, int thang, int nam){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select * "
					+ "from HoaDon hd join NhanVien nv "
					+ "on hd.maNV = nv.maNV "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
					+ "and MONTH(ngayLapHD) = '"+thang+"' "
					+ "and DAY(ngayLapHD) = '"+ngay+"' "
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1 "
		            + "order by ngayLapHD";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	//===========================================================================================================================
	public static ArrayList<HoaDon> timHDDaThanhToanTheoNam(int nam){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select * "
					+ "from HoaDon hd "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
		            + "and hd.tinhTrang = 1"
		            + "order by ngayLapHD";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
//				double thueVAT = rs.getDouble("thueVAT");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanTheoThang(int thang, int nam){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select * "
					+ "from HoaDon hd "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
					+ "and MONTH(ngayLapHD) = '"+thang+"' "
		            + "and hd.tinhTrang = 1"
		            + "order by ngayLapHD";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToanTheoNgay(int ngay, int thang, int nam){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select * "
					+ "from HoaDon hd "
					+ "where YEAR(ngayLapHD) = '"+nam+"' "
					+ "and MONTH(ngayLapHD) = '"+thang+"' "
					+ "and DAY(ngayLapHD) = '"+ngay+"' "
		            + "and hd.tinhTrang = 1"
		            + "order by ngayLapHD";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongTien");
				boolean tinhtrang = rs.getBoolean("tinhTrang");
				HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
				dshd.add(hd);
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
		return dshd;
	}
	
	public static ArrayList<HoaDon> timHDDaThanhToan(String ten){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select * from hoadon hd join khachhang kh on kh.maKH=hd.maKH join NhanVien nv on nv.maNV=hd.maNV "
						+ "where hd.tinhTrang = 1 and hd.mahd like N'%"+ten+"%' "
						+ "or tenKH like N'%"+ten+"%' "
						+ "or tenNV like N'%"+ten+"%' "
						+ "or ngayLapHD like N'%"+ten+"%' "
						+ "or tongTien like N'%"+ten+"%' ";
//						+ "group by ngayLapHD,hd.maHD,tenKH,tenNV,tongTien";
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maHD = rs.getString("maHD");
					NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
					KhachHang khachHang = new KhachHang(rs.getString("maKH"));
					Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
					double tongThanhTien = rs.getDouble("tongTien");
					boolean tinhtrang = rs.getBoolean("tinhTrang");
					HoaDon hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
					dshd.add(hd);
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
		return dshd;
	}
	
	public static HoaDon timHDTheoMa(String ma){
		HoaDon hd = new HoaDon();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from HoaDon "
						+ "where maHD = '"+ma+"' ";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maHD = rs.getString("maHD");
					NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
					KhachHang khachHang = new KhachHang(rs.getString("maKH"));
					Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
					double tongThanhTien = rs.getDouble("tongTien");
					boolean tinhtrang = rs.getBoolean("tinhTrang");
					hd = new HoaDon(maHD, nhanVien, khachHang, ngayLapHD, tongThanhTien, tinhtrang);
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
		return hd;
	}
	
	
}
