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

public class DAO_ThongKe {
	public static ArrayList<HoaDon> timHDDaThanhToanCuaNV(String maNV){
		ArrayList<HoaDon> dshd=new ArrayList<HoaDon>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "Select hd.maHD, hd.maNV, hd.maKH, kh.soDT, ngayLapHD, tongTien, thueVAT, hd.tinhTrang "
					+ "from HoaDon hd join KhachHang kh "
					+ "on hd.maKH = kh.maKH join NhanVien nv "
					+ "on hd.maNV = nv.maNV "
					+ "where hd.maNV = '"+maNV+"' "
		            + "and hd.tinhTrang = 1 "
		            + "group by hd.maHD, hd.maNV, hd.maKH, kh.soDT, ngayLapHD, tongTien, thueVAT, hd.tinhTrang";   
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
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongThanhTien");
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
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongThanhTien");
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
		            + "and hd.tinhTrang = 1 and nv.tinhTrang = 1";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maHD = rs.getString("maHD");
				NhanVien nhanVien = new NhanVien(rs.getString("maNV"));
				KhachHang khachHang = new KhachHang(rs.getString("maKH"));
				Timestamp ngayLapHD = rs.getTimestamp("ngayLapHD");
				double tongThanhTien = rs.getDouble("tongThanhTien");
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
	
	//===============================================================================
//	public static ArrayList<String[]> thongKeDTTheoGio(int gio, int ngay, int thang, int nam){
//		ArrayList<String[]> thongKeGio = new ArrayList<String[]>();
//		Database.getInstance().connect();
//    	Connection con= Database.getConnection();
//    	PreparedStatement s=null;
//		try {	
//				String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
//						+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
//						+ " SUM(soGio) as soGio,"
//						+ " tongThanhTien"
//						+ " from HoaDon hd join HoaDonPhong hdp "
//						+ "on hd.maHD = hdp.maHD join Phong p "
//						+ "on hdp.maPhong = p.maPhong "
//						+ "where hd.tinhTrang = 1 "
//						+ "and DATEPART(HOUR, ngayLapHD) = "+gio+" "
//						+ "and YEAR(ngayLapHD) = '"+nam+"' "
//						+ "and MONTH(ngayLapHD) = '"+thang+"' "
//						+ "and DAY(ngayLapHD) = '"+ngay+"'"
//						+ "group by DATEPART(HOUR, ngayLapHD), hd.maHD, tongThanhTien";   
//				s =con.prepareStatement(sql);
//				ResultSet rs=s.executeQuery();
//				while(rs.next()) {
//					double tienPhongVIP = rs.getDouble("tienPhongVIP");
//					double tienPhongThuong = rs.getDouble("tienPhongThuong");
//					int soGio = rs.getInt("soGio");
//					double tongThanhTien = rs.getDouble("tongThanhTien");
//					String[] arr = new String [4];
//					arr[0] = tienPhongVIP+"";
//					arr[1] = tienPhongThuong+"";
//					arr[2] = soGio+"";
//					arr[3] = tongThanhTien+"";
//					thongKeGio.add(arr);
//				}
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			try {
//				s.close();
//			}catch(SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//		return thongKeGio;
//	}
	
//	public static ArrayList<String[]> thongKeDTTheoNgay(int ngay, int thang, int nam){
//		ArrayList<String[]> thongKeNgay = new ArrayList<String[]>();
//		Database.getInstance().connect();
//    	Connection con= Database.getConnection();
//    	PreparedStatement s=null;
//		try {	
//				String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
//						+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
//						+ " SUM(soGio) as soGio,"
//						+ " tongThanhTien"
//						+ " from HoaDon hd join HoaDonPhong hdp "
//						+ "on hd.maHD = hdp.maHD join Phong p "
//						+ "on hdp.maPhong = p.maPhong "
//						+ "where hd.tinhTrang = 1 "
//						+ "and DATEPART(DAY, ngayLapHD) = "+ngay+" "
//						+ "and YEAR(ngayLapHD) = '"+nam+"' "
//						+ "and MONTH(ngayLapHD) = '"+thang+"' "
//						+ "group by DATEPART(DAY, ngayLapHD), hd.maHD, tongThanhTien";   
//				s =con.prepareStatement(sql);
//				ResultSet rs=s.executeQuery();
//				while(rs.next()) {
//					double tienPhongVIP = rs.getDouble("tienPhongVIP");
//					double tienPhongThuong = rs.getDouble("tienPhongThuong");
//					int soGio = rs.getInt("soGio");
//					double tongThanhTien = rs.getDouble("tongThanhTien");
//					String[] arr = new String [4];
//					arr[0] = tienPhongVIP+"";
//					arr[1] = tienPhongThuong+"";
//					arr[2] = soGio+"";
//					arr[3] = tongThanhTien+"";
//					thongKeNgay.add(arr);
//				}
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			try {
//				s.close();
//			}catch(SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//		return thongKeNgay;
//	}
	
//	public static ArrayList<String[]> thongKeDTTheoThang(int thang, int nam){
//		ArrayList<String[]> thongKeThang = new ArrayList<String[]>();
//		Database.getInstance().connect();
//    	Connection con= Database.getConnection();
//    	PreparedStatement s=null;
//		try {	
//			String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
//					+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
//					+ " SUM(soGio) as soGio,"
//					+ " tongThanhTien"
//					+ " from HoaDon hd join HoaDonPhong hdp "
//					+ "on hd.maHD = hdp.maHD join Phong p "
//					+ "on hdp.maPhong = p.maPhong "
//					+ "where hd.tinhTrang = 1 "
//					+ "and DATEPART(MONTH, ngayLapHD) = "+thang+" "
//					+ "and YEAR(ngayLapHD) = '"+nam+"' "
//					+ "group by DATEPART(MONTH, ngayLapHD), hd.maHD, tongThanhTien";   
//			s =con.prepareStatement(sql);
//			ResultSet rs=s.executeQuery();
//			while(rs.next()) {
//				double tienPhongVIP = rs.getDouble("tienPhongVIP");
//				double tienPhongThuong = rs.getDouble("tienPhongThuong");
//				int soGio = rs.getInt("soGio");
//				double tongThanhTien = rs.getDouble("tongThanhTien");
//				String[] arr = new String [4];
//				arr[0] = tienPhongVIP+"";
//				arr[1] = tienPhongThuong+"";
//				arr[2] = soGio+"";
//				arr[3] = tongThanhTien+"";
//				thongKeThang.add(arr);
//			}
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}finally {
//			try {
//				s.close();
//			}catch(SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//		return thongKeThang;
//	}
	
	//===============================================================================
	public static ArrayList<String[]> thongKeDTTheoGioCuaNV(String maNV, int gio, int ngay, int thang, int nam){
		ArrayList<String[]> thongKeGio = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
						+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
						+ " SUM(soGio) as soGio,"
						+ " tongThanhTien"
						+ " from HoaDon hd join HoaDonPhong hdp "
						+ "on hd.maHD = hdp.maHD join Phong p "
						+ "on hdp.maPhong = p.maPhong "
						+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
						+ "and DATEPART(HOUR, ngayLapHD) = "+gio+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "and DAY(ngayLapHD) = '"+ngay+"'"
						+ "group by DATEPART(HOUR, ngayLapHD), hd.maHD, tongThanhTien";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					double tienPhongVIP = rs.getDouble("tienPhongVIP");
					double tienPhongThuong = rs.getDouble("tienPhongThuong");
					int soGio = rs.getInt("soGio");
					double tongThanhTien = rs.getDouble("tongThanhTien");
					String[] arr = new String [4];
					arr[0] = tienPhongVIP+"";
					arr[1] = tienPhongThuong+"";
					arr[2] = soGio+"";
					arr[3] = tongThanhTien+"";
					thongKeGio.add(arr);
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
		return thongKeGio;
	}
	
	public static ArrayList<String[]> thongKeDTTheoNgayCuaNV(String maNV, int ngay, int thang, int nam){
		ArrayList<String[]> thongKeNgay = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
						+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
						+ " SUM(soGio) as soGio,"
						+ " tongThanhTien"
						+ " from HoaDon hd join HoaDonPhong hdp "
						+ "on hd.maHD = hdp.maHD join Phong p "
						+ "on hdp.maPhong = p.maPhong "
						+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
						+ "and DATEPART(DAY, ngayLapHD) = "+ngay+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "group by DATEPART(DAY, ngayLapHD), hd.maHD, tongThanhTien";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					double tienPhongVIP = rs.getDouble("tienPhongVIP");
					double tienPhongThuong = rs.getDouble("tienPhongThuong");
					int soGio = rs.getInt("soGio");
					double tongThanhTien = rs.getDouble("tongThanhTien");
					String[] arr = new String [4];
					arr[0] = tienPhongVIP+"";
					arr[1] = tienPhongThuong+"";
					arr[2] = soGio+"";
					arr[3] = tongThanhTien+"";
					thongKeNgay.add(arr);
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
		return thongKeNgay;
	}
	
	public static ArrayList<String[]> thongKeDTTheoThangCuaNV(String maNV, int thang, int nam){
		ArrayList<String[]> thongKeThang = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
					+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
					+ " SUM(soGio) as soGio,"
					+ " tongThanhTien"
					+ " from HoaDon hd join HoaDonPhong hdp "
					+ "on hd.maHD = hdp.maHD join Phong p "
					+ "on hdp.maPhong = p.maPhong "
					+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
					+ "and DATEPART(MONTH, ngayLapHD) = "+thang+" "
					+ "and YEAR(ngayLapHD) = '"+nam+"' "
					+ "group by DATEPART(MONTH, ngayLapHD), hd.maHD, tongThanhTien";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				double tienPhongVIP = rs.getDouble("tienPhongVIP");
				double tienPhongThuong = rs.getDouble("tienPhongThuong");
				int soGio = rs.getInt("soGio");
				double tongThanhTien = rs.getDouble("tongThanhTien");
				String[] arr = new String [4];
				arr[0] = tienPhongVIP+"";
				arr[1] = tienPhongThuong+"";
				arr[2] = soGio+"";
				arr[3] = tongThanhTien+"";
				thongKeThang.add(arr);
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
		return thongKeThang;
	}
	
	//===============================================================================
	public static ArrayList<String[]> thongKeDVTheoGioCuaNV(String maNV, int gio, int ngay, int thang, int nam){
		ArrayList<String[]> thongKeGio = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select maDV, SUM(tienDV) as tongTienDV,"
						+ " SUM(soLuong) as soLuong "
						+"from HoaDon hd join HoaDonDichVu hddv "
						+"on hd.maHD = hddv.maHD "
						+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
						+ "and DATEPART(HOUR, ngayLapHD) = "+gio+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "and DAY(ngayLapHD) = '"+ngay+"'"
						+ "group by DATEPART(HOUR, ngayLapHD), maDV "
						+ "order by soLuong DESC";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV = rs.getString("maDV");
					int soLuong = rs.getInt("soLuong");
					double tongTienDV = rs.getDouble("tongTienDV");
					String[] arr = new String [3];
					arr[0] = maDV;
					arr[1] = soLuong+"";
					arr[2] = tongTienDV+"";
					thongKeGio.add(arr);
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
		return thongKeGio;
	}
	
	public static ArrayList<String[]> thongKeDVTheoNgayCuaNV(String maNV, int ngay, int thang, int nam){
		ArrayList<String[]> thongKeNgay = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select maDV, SUM(tienDV) as tongTienDV,"
						+ " SUM(soLuong) as soLuong "
						+"from HoaDon hd join HoaDonDichVu hddv "
						+"on hd.maHD = hddv.maHD "
						+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
						+ "and DATEPART(DAY, ngayLapHD) = "+ngay+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "group by DATEPART(DAY, ngayLapHD), maDV "
						+ "order by soLuong DESC";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV = rs.getString("maDV");
					int soLuong = rs.getInt("soLuong");
					double tongTienDV = rs.getDouble("tongTienDV");
					String[] arr = new String [3];
					arr[0] = maDV;
					arr[1] = soLuong+"";
					arr[2] = tongTienDV+"";
					thongKeNgay.add(arr);
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
		return thongKeNgay;
	}
	
	public static ArrayList<String[]> thongKeDVTheoThangCuaNV(String maNV, int thang, int nam){
		ArrayList<String[]> thongKeThang = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select maDV, SUM(tienDV) as tongTienDV,"
					+ " SUM(soLuong) as soLuong "
					+"from HoaDon hd join HoaDonDichVu hddv "
					+"on hd.maHD = hddv.maHD "
					+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
					+ "and DATEPART(MONTH, ngayLapHD) = "+thang+" "
					+ "and YEAR(ngayLapHD) = '"+nam+"' "
					+ "group by DATEPART(MONTH, ngayLapHD), maDV "
					+ "order by soLuong DESC";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString("maDV");
				int soLuong = rs.getInt("soLuong");
				double tongTienDV = rs.getDouble("tongTienDV");
				String[] arr = new String [3];
				arr[0] = maDV;
				arr[1] = soLuong+"";
				arr[2] = tongTienDV+"";
				thongKeThang.add(arr);
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
		return thongKeThang;
	}
	
	public static ArrayList<String[]> thongKeDVTheoNamCuaNV(String maNV, int nam){
		ArrayList<String[]> thongKeNam = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select maDV, SUM(tienDV) as tongTienDV,"
					+ " SUM(soLuong) as soLuong "
					+"from HoaDon hd join HoaDonDichVu hddv "
					+"on hd.maHD = hddv.maHD "
					+ "where hd.tinhTrang = 1 and hd.maNV = '"+maNV+"' "
					+ "and YEAR(ngayLapHD) = '"+nam+"' "
					+ "group by DATEPART(YEAR, ngayLapHD), maDV "
					+ "order by soLuong DESC";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString("maDV");
				int soLuong = rs.getInt("soLuong");
				double tongTienDV = rs.getDouble("tongTienDV");
				String[] arr = new String [3];
				arr[0] = maDV;
				arr[1] = soLuong+"";
				arr[2] = tongTienDV+"";
				thongKeNam.add(arr);
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
		return thongKeNam;
	}
	
	//===============================================================================
	public static ArrayList<String[]> thongKeDVTheoGio(int gio, int ngay, int thang, int nam){
		ArrayList<String[]> thongKeGio = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select dv.maDV, Sum(soLuong*donGia) as tongTienDV, Sum(soLuong) as soLuong"
//						+ " SUM(soLuong) as soLuong "
						+"from PhieuThue pt join DichVuSuDung dvsd on pt.maPT=dvsd.maPT "
						+"join DichVu dv on dv.maDV=dvsd.maDV "
						+ "where pt.tinhTrang = N'Đã Thanh Toán' "
						+ "and DATEPART(HOUR, ngayLapHD) = "+gio+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "and DAY(ngayLapHD) = '"+ngay+"'"
						+ "group by DATEPART(HOUR, ngayLapHD), dv.maDV "
						+ "order by soLuong DESC";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV = rs.getString("maDV");
					int soLuong = rs.getInt("soLuong");
					double tongTienDV = rs.getDouble("tongTienDV");
					String[] arr = new String [3];
					arr[0] = maDV;
					arr[1] = soLuong+"";
					arr[2] = tongTienDV+"";
					thongKeGio.add(arr);
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
		return thongKeGio;
	}
	
	public static ArrayList<String[]> thongKeDVTheoNgay(int ngay, int thang, int nam){
		ArrayList<String[]> thongKeNgay = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select dv.maDV, Sum(soLuong*donGia) as tongTienDV, Sum(soLuong) as soLuong "
						+ " from PhieuThue pt join DichVuSuDung dvsd on pt.maPT=dvsd.maPT "
//						+"join HoaDon hd on hd.mahd=pt.mahd "
						+"join DichVu dv on dv.maDV=dvsd.maDV "
						+ "where pt.tinhTrang =N'Đã Thanh Toán' "
						+ "and DATEPART(DAY, gioDatDV) = "+ngay+" "
						+ "and YEAR(gioDatDV) = '"+nam+"' "
						+ "and MONTH(gioDatDV) = '"+thang+"' "
						+ "group by DATEPART(DAY, gioDatDV), dv.maDV "
						+ "order by soLuong DESC";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV = rs.getString("maDV");
					int soLuong = rs.getInt("soLuong");
					double tongTienDV = rs.getDouble("tongTienDV");
					String[] arr = new String [3];
					arr[0] = maDV;
					arr[1] = soLuong+"";
					arr[2] = tongTienDV+"";
					thongKeNgay.add(arr);
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
		return thongKeNgay;
	}
	
	public static ArrayList<String[]> thongKeDVTheoThang(int thang, int nam){
		ArrayList<String[]> thongKeThang = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select dv.maDV, Sum(soLuong*donGia) as tongTienDV, Sum(soLuong) as soLuong "
					+ " from PhieuThue pt join DichVuSuDung dvsd on pt.maPT=dvsd.maPT "
//					+"join HoaDon hd on hd.mahd=pt.mahd "
					+"join DichVu dv on dv.maDV=dvsd.maDV "
					+ "where pt.tinhTrang =N'Đã Thanh Toán' "
					+ "and DATEPART(MONTH, gioDatDV) = "+thang+" "
					+ "and YEAR(gioDatDV) = '"+nam+"' "
					+ "group by DATEPART(MONTH, gioDatDV), dv.maDV "
					+ "order by soLuong DESC";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString("maDV");
				int soLuong = rs.getInt("soLuong");
				double tongTienDV = rs.getDouble("tongTienDV");
				String[] arr = new String [3];
				arr[0] = maDV;
				arr[1] = soLuong+"";
				arr[2] = tongTienDV+"";
				thongKeThang.add(arr);
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
		return thongKeThang;
	}
	
	public static ArrayList<String[]> thongKeDVTheoNam(int nam){
		ArrayList<String[]> thongKeNam = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select dv.maDV, Sum(soLuong*donGia) as tongTienDV, Sum(soLuong) as soLuong "
					+ " from PhieuThue pt join DichVuSuDung dvsd on pt.maPT=dvsd.maPT "
//					+"join HoaDon hd on hd.mahd=pt.mahd "
					+"join DichVu dv on dv.maDV=dvsd.maDV "
					+ "where pt.tinhTrang =N'Đã Thanh Toán' "
					+ "and YEAR(gioDatDV) = '"+nam+"' "
					+ "group by DATEPART(YEAR, gioDatDV), dv.maDV "
					+ "order by soLuong DESC";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString("maDV");
				int soLuong = rs.getInt("soLuong");
				double tongTienDV = rs.getDouble("tongTienDV");
				String[] arr = new String [3];
				arr[0] = maDV;
				arr[1] = soLuong+"";
				arr[2] = tongTienDV+"";
				thongKeNam.add(arr);
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
		return thongKeNam;
	}
	//==============================================================================================================================
	public static ArrayList<String[]> thongKeDTTheoNam(int nam){
		ArrayList<String[]> thongKeNam = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select maHD, sum(tongTien) as tongThanhTien "
					+ " from HoaDon "
//					+"join HoaDon hd on hd.mahd=pt.mahd "
//					+"join DichVu dv on dv.maDV=dvsd.maDV "
					+ "where tinhTrang = 1 "
					+ "and YEAR(ngayLapHD) = '"+nam+"' "
					+ "group by DATEPART(YEAR, ngayLapHD), maHD "
					+ "order by tongThanhTien DESC";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString("maHD");
//				int soLuong = rs.getInt("soLuong");
				double tongTienDV = rs.getDouble("tongThanhTien");
				String[] arr = new String [2];
				arr[0] = maDV;
//				arr[1] = soLuong+"";
				arr[1] = tongTienDV+"";
				thongKeNam.add(arr);
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
		return thongKeNam;
	}
	
	public static ArrayList<String[]> thongKeDTTheoThang(int thang, int nam){
		ArrayList<String[]> thongKeThang = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
			String sql = "select maHD, sum(tongTien) as tongThanhTien "
					+ " from HoaDon "
//					+"join HoaDon hd on hd.mahd=pt.mahd "
//					+"join DichVu dv on dv.maDV=dvsd.maDV "
					+ "where tinhTrang = 1 "
					+ "and DATEPART(MONTH, ngayLapHD) = "+thang+" "
					+ "and YEAR(ngayLapHD) = '"+nam+"' "
					+ "group by DATEPART(MONTH, ngayLapHD), maHD "
					+ "order by tongThanhTien DESC";   
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				String maDV = rs.getString("maHD");
//				int soLuong = rs.getInt("soLuong");
				double tongTienDV = rs.getDouble("tongThanhTien");
				String[] arr = new String [2];
				arr[0] = maDV;
//				arr[1] = soLuong+"";
				arr[1] = tongTienDV+"";
				thongKeThang.add(arr);
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
		return thongKeThang;
	}
	
	public static ArrayList<String[]> thongKeDTTheoNgay(int ngay, int thang, int nam){
		ArrayList<String[]> thongKeNgay = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select maHD, sum(tongTien) as tongThanhTien "
						+ " from HoaDon "
//						+"join HoaDon hd on hd.mahd=pt.mahd "
//						+"join DichVu dv on dv.maDV=dvsd.maDV "
						+ "where tinhTrang = 1 "
						+ "and DATEPART(DAY, ngayLapHD) = "+ngay+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "group by DATEPART(DAY, ngayLapHD), maHD "
						+ "order by tongThanhTien DESC";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV = rs.getString("maHD");
//					int soLuong = rs.getInt("soLuong");
					double tongTienDV = rs.getDouble("tongThanhTien");
					String[] arr = new String [2];
					arr[0] = maDV;
//					arr[1] = soLuong+"";
					arr[1] = tongTienDV+"";
					thongKeNgay.add(arr);
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
		return thongKeNgay;
	}
	
	public static ArrayList<String[]> thongKeDTTheoGio(int gio, int ngay, int thang, int nam){
		ArrayList<String[]> thongKeGio = new ArrayList<String[]>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "select SUM(case when maLP = 'LP001' and tienPhong is not null then tienPhong else 0 end) as tienPhongVIP,"
						+ " SUM(case when maLP = 'LP002' and tienPhong is not null then tienPhong else 0 end) as tienPhongThuong,"
						+ " SUM(soGio) as soGio,"
						+ " tongThanhTien"
						+ " from HoaDon hd join HoaDonPhong hdp "
						+ "on hd.maHD = hdp.maHD join Phong p "
						+ "on hdp.maPhong = p.maPhong "
						+ "where hd.tinhTrang = 1 "
						+ "and DATEPART(HOUR, ngayLapHD) = "+gio+" "
						+ "and YEAR(ngayLapHD) = '"+nam+"' "
						+ "and MONTH(ngayLapHD) = '"+thang+"' "
						+ "and DAY(ngayLapHD) = '"+ngay+"'"
						+ "group by DATEPART(HOUR, ngayLapHD), hd.maHD, tongThanhTien";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					double tienPhongVIP = rs.getDouble("tienPhongVIP");
					double tienPhongThuong = rs.getDouble("tienPhongThuong");
					int soGio = rs.getInt("soGio");
					double tongThanhTien = rs.getDouble("tongThanhTien");
					String[] arr = new String [4];
					arr[0] = tienPhongVIP+"";
					arr[1] = tienPhongThuong+"";
					arr[2] = soGio+"";
					arr[3] = tongThanhTien+"";
					thongKeGio.add(arr);
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
		return thongKeGio;
	}
	
}
