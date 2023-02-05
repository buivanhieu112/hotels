package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.Database;
import entity.DichVu;
import entity.DonVi;
import entity.LoaiDichVu;

public class DAO_DichVu {
	public static ArrayList<DichVu> getAllDichVu() {
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from DichVu";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maDV= rs.getString("maDV");
				String tenDV= rs.getString("TenDV");
				double giaDV= rs.getDouble("donGia");
				int soLuongTon = rs.getInt("soLuongTon");
				LoaiDichVu loaiDV = new LoaiDichVu(rs.getString("maLDV"));
				DonVi donVi = new DonVi(rs.getString("maDonVi"));

				dsdv.add(new DichVu(maDV, tenDV, giaDV, soLuongTon, loaiDV, donVi));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return dsdv;
	}
	
	public static boolean themDV(DichVu dv) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into DichVu values(?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, dv.getMaDV());
			pstm.setString(2, dv.getLoaiDichVu().getMaLoaiDichVu());
			pstm.setString(3, dv.getDonVi().getMaDonVi());
			pstm.setString(4, dv.getTenDV());
			pstm.setInt(5, dv.getSoLuongTon());
			pstm.setDouble(6, dv.getGiaDV());
			
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	
	public static void xoaDV(String maDV){		
		Database.getInstance().connect();
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="Delete From DichVu where maDV = ?";
        try {
           s=con.prepareStatement(sql);
            s.setString(1, maDV);
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
	
	public static boolean capNhatDV(DichVu dv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update DichVu set tenDV = ?, donGia = ?, soLuongTon = ?, maLDV = ?, maDonVi = ? where maDV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, dv.getTenDV());
			pstm.setDouble(2, dv.getGiaDV());
			pstm.setInt(3, dv.getSoLuongTon());
			pstm.setString(4, dv.getLoaiDichVu().getMaLoaiDichVu());
			pstm.setString(5, dv.getDonVi().getMaDonVi());
			pstm.setString(6, dv.getMaDV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin dịch vụ thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatSoLuongTon(String ma, int slt) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update DichVu set soLuongTon = ? where maDV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(2, ma);
			pstm.setInt(1, slt);
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật số lượng tồn của dịch vụ "+ma+" thất bại!");
			return false;
		}
	}
	
	public static ArrayList<DichVu> timDV(String ten){
		ArrayList<DichVu> dsdv=new ArrayList<DichVu>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from DichVu dv join LoaiDichVu ldv on ldv.maLDV = dv.maLDV " 
						+ "join DonVi dvi on dvi.maDonVi = dv.maDonVi "
						+ "where maDV like N'%"+ten+"%' "
			            + "or tenDV like N'%"+ten+"%' "
			            + "or tenLDV like N'%"+ten+"%' "
			            + "or tenDonVi like N'%"+ten+"%' "
			            + "or donGia like N'%"+ten+"%' ";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV= rs.getString("maDV");
					String tenDV= rs.getString("tenDV");
					double giaDV= rs.getDouble("donGia");
					int soLuongTon = rs.getInt("soLuongTon");
					LoaiDichVu loaiDV= new LoaiDichVu(rs.getString("maLDV"));
					DonVi donVi = new DonVi(rs.getString("maDonVi"));
					DichVu dv=new DichVu(maDV, tenDV, giaDV, soLuongTon, loaiDV, donVi);
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
	
	public static ArrayList<DichVu> timDVTrongTableThemDV(String ten){
		ArrayList<DichVu> dsdv=new ArrayList<DichVu>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from DichVu dv join loaidichvu ldv on ldv.maldv=dv.maldv join donvi on donvi.madonvi=dv.madonvi where madv like N'%"+ten+"%' "
			            + "or tenDV like N'%"+ten+"%'"
			            + "or donvi.tendonvi like N'%"+ten+"%'"
			            + "or ldv.tenldv like N'%"+ten+"%'"
			            + "or donGia like N'%"+ten+"%'";
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDV= rs.getString("maDV");
					String tenDV= rs.getString("tenDV");
					double giaDV= rs.getDouble("donGia");
					int soLuongTon = rs.getInt("soLuongTon");
					LoaiDichVu loaiDV= new LoaiDichVu(rs.getString("maLDV"));
					DonVi donVi = new DonVi(rs.getString("maDonVi"));
					DichVu dv=new DichVu(maDV, tenDV, giaDV, soLuongTon, loaiDV, donVi);
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
