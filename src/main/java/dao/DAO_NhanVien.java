/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.Database;
import entity.ChucVu;
import entity.NhanVien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DAO_NhanVien {
	public static ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsnv= new ArrayList<NhanVien>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from NhanVien";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maNV= rs.getString("maNV");
				String tenNV= rs.getString("tenNV");
				String gioiTinh = rs.getString("gioiTinh");
				String soDT = rs.getString("soDT");
				String soCMND = rs.getString("soCMND");
				ChucVu chucVu = new ChucVu(rs.getString("maCV"));
				Date ngayVaoLam = rs.getDate("ngayVaoLam");
				String matKhau = rs.getString("matKhau");
				Boolean tinhTrang = rs.getBoolean("tinhTrang");
				
				dsnv.add(new NhanVien(maNV, tenNV, gioiTinh, soCMND, chucVu, soDT, ngayVaoLam, matKhau, tinhTrang));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println("Lấy danh sách nhân viên thất bại!");
		};
		
		return dsnv;
		
	}
    public NhanVien DSNhanVien(int index) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			Database.getInstance();
			Connection con = Database.getConnection();
			
			String sql = "Select * from NhanVien";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String maNV= rs.getString(1);
				String tenNV= rs.getString(2);
				String gioiTinh = rs.getString(3);
                                String soCMND = rs.getString(4);
                                ChucVu chucVu = new ChucVu(rs.getString(5));
				String soDT = rs.getString(6);
				Date ngayVaoLam = rs.getDate(6);
				String matKhau = rs.getString(7);
				Boolean tinhTrang = rs.getBoolean(8);
				
				dsnv.add(new NhanVien(maNV, tenNV, gioiTinh, soCMND,chucVu, soDT, ngayVaoLam, matKhau, tinhTrang) );

			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		if(index<0 || index>dsnv.size())
			return null;
		return dsnv.get(index);
	}
    
    public static boolean capNhatTinhTrangNVDN(NhanVien nv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update NhanVien set tinhTrang = ? where maNV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setBoolean(1,true);
			pstm.setString(2, nv.getMaNV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật tình trạng nhân viên thất bại!");
			return false;
		}
	}
    
    public static boolean themNV(NhanVien nv) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nv.getMaNV());
			pstm.setString(2, nv.getTenNV());
			pstm.setString(3, nv.getGioiTinh());
			pstm.setString(4, nv.getSoCMND());
                        pstm.setString(5, nv.getChucVu().getMaCV());
			pstm.setString(6, nv.getSoDT());
			pstm.setDate(7, nv.getNgayVaoLam());
			pstm.setString(8, nv.getMatKhau());
			pstm.setBoolean(9,false);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println("Thêm nhân viên thất bại!");
			return false;
		}

	}
    
    public static int count() {
		return getAllNhanVien().size();
	}
	
	public static NhanVien timKiemTheoMa(String ma) {
		NhanVien nv = new NhanVien();
		if(getAllNhanVien().contains(nv))
			return getAllNhanVien().get(getAllNhanVien().indexOf(nv));
	return null;
	}
	
	public static ArrayList<NhanVien> timNV(String ten){
		ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from NhanVien nv join ChucVu cv on nv.maCV = cv.maCV "
						+ "where maNv like N'%"+ten+ "%' "
						+ "or tenNV like N'%"+ten+"%' "
						+ "or tenCV like N'%"+ten+"%' "
			            + "or gioiTinh like N'%"+ten+"%' "
			            + "or soCMND like N'%"+ten+"%' "
			            + "or soDT like N'%"+ten+"%' "
						+ "or ngayVaoLam like N'%"+ten+"%' ";
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maNV= rs.getString("maNV");
					String tenNV= rs.getString("tenNV");
					String gioiTinh = rs.getString("gioiTinh");
					String soCMND = rs.getString("soCMND");
                                        ChucVu chucVu = new ChucVu(rs.getString("maCV"));
					String soDT = rs.getString("soDT");
					Date ngayVaoLam = rs.getDate("ngayVaoLam");
					String matKhau = rs.getString("matKhau");
					Boolean tinhTrang = rs.getBoolean("tinhTrang");
					NhanVien nv=new NhanVien(maNV, tenNV, gioiTinh, soCMND, chucVu, soDT, ngayVaoLam, matKhau, tinhTrang);
					dsnv.add(nv);
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
		return dsnv;
	}
	
	public static NhanVien timNVTheoMa(String ma){
		NhanVien nv = new NhanVien();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from NhanVien "
						+ "where maNV = '"+ma+"' ";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maNV= rs.getString("maNV");
					String tenNV= rs.getString("tenNV");
					String gioiTinh= rs.getString("gioiTinh");
					String soCMND= rs.getString("soCMND");
                                        ChucVu chucVu = new ChucVu(rs.getString("maCV"));
					String soDT= rs.getString("soDT");
					Date ngayVaoLam = rs.getDate("ngayVaoLam");
					String matKhau = rs.getString("matKhau");
					boolean tinhTrang = rs.getBoolean("tinhTrang");
					nv = new NhanVien(maNV, tenNV, gioiTinh, soCMND,chucVu, soDT, ngayVaoLam, matKhau, tinhTrang);
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
		return nv;
	}
	
	public static void xoaNV(String maNV){		
		Database.getInstance().connect();
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="delete from NhanVien where maNV = ?";
        try {
           s=con.prepareStatement(sql);
            s.setString(1, maNV);
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
	
	public static boolean capNhatNV(NhanVien nv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update NhanVien set tenNV = ?, gioiTinh = ?, "
					+ " soCMND = ?, maCV = ?, soDT = ?, matKhau = ? where maNV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,nv.getTenNV());
			pstm.setString(2,nv.getGioiTinh());
			pstm.setString(3,nv.getSoCMND());
			pstm.setString(4,nv.getChucVu().getMaCV());
			pstm.setString(5,nv.getSoDT());
			pstm.setString(6,nv.getMatKhau());
			pstm.setString(7,nv.getMaNV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin nhân viên thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatTT(NhanVien nv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update NhanVien set gioiTinh = ?, "
					+ " soCMND = ?, soDT = ? where maNV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,nv.getGioiTinh());
			pstm.setString(2,nv.getSoCMND());
			pstm.setString(3,nv.getSoDT());
			pstm.setString(4,nv.getMaNV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin nhân viên thất bại!");
			return false;
		}
	}
	
	public static boolean capNhatTinhTrangNVDX(NhanVien nv) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update NhanVien set tinhTrang = ? where maNV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setBoolean(1, false);
			pstm.setString(2, nv.getMaNV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật tình trạng nhân viên thất bại!");
			return false;
		}
	}
	
	public static NhanVien getNhanVienDangLogin(){
		NhanVien nv = new NhanVien();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from NhanVien "
						+ "where tinhTrang = '1'";   
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maNV= rs.getString("maNV");
					String tenNV= rs.getString("tenNV");
					String gioiTinh = rs.getString("gioiTinh");
					String soCMND = rs.getString("soCMND");
                    ChucVu chucVu = new ChucVu(rs.getString("maCV"));
					String soDT = rs.getString("soDT");
					Date ngayVaoLam = rs.getDate("ngayVaoLam");
					String matKhau = rs.getString("matKhau");
					Boolean tinhTrang = rs.getBoolean("tinhTrang");
					nv = new NhanVien(maNV, tenNV, gioiTinh, soCMND, chucVu, soDT, ngayVaoLam, matKhau, tinhTrang);
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
		return nv;
	}
	
	public static boolean capNhatPass(NhanVien nv,String matKhau) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update NhanVien set matKhau = ? where maNV = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,matKhau);
			pstm.setString(2,nv.getMaNV());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Lấy lại mật khẩu thất bại!");
			return false;
		}
	}
    
    
}
