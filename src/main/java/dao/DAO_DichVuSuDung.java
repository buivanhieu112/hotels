package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.Database;
import entity.DichVu;
import entity.DichVuSuDung;
import entity.DonVi;
import entity.LoaiDichVu;
import entity.PhieuThue;

public class DAO_DichVuSuDung {
	
	public static ArrayList<DichVuSuDung> getAllHDDV(int pt) {
		ArrayList<DichVuSuDung> dsHDDV = new ArrayList<DichVuSuDung>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
    	try {
    		String sql = "Select * from dichvusudung dvsd "
    				+ "join dichvu dv on dv.madv=dvsd.madv "
    				+ "join donvi on donvi.madonvi=dv.madonvi "
    				+ "join loaidichvu ldv on ldv.maldv=dv.maldv "
    				+ "join phieuthue pt on pt.mapt=dvsd.mapt "
    				+ "where pt.maPT = "+pt;
					
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				PhieuThue phieuThue = new PhieuThue(rs.getInt("maPT"));
//				DichVu dichVu = new DichVu(rs.getString("maDV"));
				String maDV = rs.getString("maDV");
				DonVi donVi = new DonVi(rs.getString("maDonVi"));
				LoaiDichVu loaiDV = new LoaiDichVu(rs.getString("maLDV"));
//				Phong phong = new Phong(rs.getString("maPhong"));
//				int phieuThue1 = rs.getInt("maPT");
//				double tienDV = rs.getDouble("tienDV");
				int maHDDV = rs.getInt("maHDDV");
				int soLuong = rs.getInt("soLuong");
				Timestamp gioDatDV = rs.getTimestamp("gioDatDV");
				DichVu dichVu= new DichVu(maDV, loaiDV, donVi);
				DichVuSuDung hddv = new DichVuSuDung(maHDDV,phieuThue, dichVu, soLuong, gioDatDV);
				dsHDDV.add(hddv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHDDV;
	}
	
	public static ArrayList<DichVuSuDung> getAllDVSDDaThanhToan() {
		ArrayList<DichVuSuDung> dsHDDV = new ArrayList<DichVuSuDung>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
    	try {
    		String sql = "Select * from dichvusudung dvsd "
    				+ "join dichvu dv on dv.madv=dvsd.madv "
    				+ "join donvi on donvi.madonvi=dv.madonvi "
    				+ "join loaidichvu ldv on ldv.maldv=dv.maldv "
    				+ "join phieuthue pt on pt.mapt=dvsd.mapt "
    				+ "where pt.tinhTrang=N'Đã Thanh Toán'";
					
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				PhieuThue phieuThue = new PhieuThue(rs.getInt("maPT"));
//				DichVu dichVu = new DichVu(rs.getString("maDV"));
				String maDV = rs.getString("maDV");
				DonVi donVi = new DonVi(rs.getString("maDonVi"));
				LoaiDichVu loaiDV = new LoaiDichVu(rs.getString("maLDV"));
//				Phong phong = new Phong(rs.getString("maPhong"));
//				int phieuThue1 = rs.getInt("maPT");
//				double tienDV = rs.getDouble("tienDV");
				int maHDDV = rs.getInt("maHDDV");
				int soLuong = rs.getInt("soLuong");
				Timestamp gioDatDV = rs.getTimestamp("gioDatDV");
				DichVu dichVu= new DichVu(maDV, loaiDV, donVi);
				DichVuSuDung hddv = new DichVuSuDung(maHDDV,phieuThue, dichVu, soLuong, gioDatDV);
				dsHDDV.add(hddv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsHDDV;
	}
	
	public static boolean capNhatTienDV(DichVuSuDung hddv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update DichVuSuDung set tienDV = ?"
					+ " where maPT = ? and maDV = ? and gioDatDV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
//			pstm.setInt(1,hdp.getSoGio());
			pstm.setDouble(1,hddv.getTienDV());
			pstm.setInt(2,hddv.getPhieuThue().getMaPT());
			pstm.setString(3,hddv.getDichVu().getMaDV());
			pstm.setTimestamp(4, hddv.getGioDatDV());
			
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật tiền dịch vụ trong bảng dịch vụ thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatSoLuongDV(DichVuSuDung hddv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update DichVuSuDung set soLuong = ?"
					+ " where maHDDV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
//			Timestamp gioHienTai = new Timestamp(System.currentTimeMillis());
			pstm.setInt(1,hddv.getSoLuong());
			pstm.setInt(2, hddv.getMaHDDV());
//			pstm.setInt(2,hddv.getPhieuThue().getMaPT());
//			pstm.setString(3,hddv.getDichVu().getMaDV());
//			pstm.setTimestamp(4, gioHienTai);
			
			
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật số lượng dịch vụ thất bại!");
			return false;
		}
	}
	
	public static ArrayList<DichVuSuDung> getAllDichVuTheoPTvaDV(PhieuThue pt, DichVu dv) {
		ArrayList<DichVuSuDung> dsHDDV = new ArrayList<DichVuSuDung>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
    	try {
    		String sql = "Select * from DichVuSuDung where maDV= '"+dv.getMaDV()+"'and mapt = "+pt.getMaPT();
					
			s =con.prepareStatement(sql);
			ResultSet rs=s.executeQuery();
			while(rs.next()) {
				PhieuThue phieuThue = new PhieuThue(rs.getInt("maPT"));
				DichVu dichVu = new DichVu(rs.getString("maDV"));
				int soLuong = rs.getInt("soLuong");
				Timestamp gioDatDV = rs.getTimestamp("gioDatDV");
				
				DichVuSuDung hddv = new DichVuSuDung(phieuThue, dichVu, soLuong, gioDatDV);
				dsHDDV.add(hddv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return dsHDDV;
	}
	
	public static boolean themDVSD(DichVuSuDung hddv) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into DichVuSuDung values (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, hddv.getPhieuThue().getMaPT());
			pstm.setString(2, hddv.getDichVu().getMaDV());
			pstm.setInt(3,hddv.getSoLuong());
			pstm.setTimestamp(4, hddv.getGioDatDV());
			pstm.setDouble(5, 0);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println("Thêm phiếu đặt dịch vụ thất bại!");
			return false;
		}
	}
	
	public static boolean huyDatDV(DichVuSuDung hddv){		
		Database.getInstance().connect();
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="delete from Dichvusudung where mapt = ? and maDV = ? and giodatdv = ?";
        try {
           s=con.prepareStatement(sql);
            s.setInt(1, hddv.getPhieuThue().getMaPT());
            s.setString(2, hddv.getDichVu().getMaDV());
            s.setTimestamp(3, hddv.getGioDatDV());
            s.executeUpdate();
            return true;
        } catch (SQLException e) {
           e.printStackTrace();
           return false;
        }
	}

}
