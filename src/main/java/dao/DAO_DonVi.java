/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.Database;
import entity.DonVi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DAO_DonVi {
    public static ArrayList<DonVi> getAllDonVi() {
		ArrayList<DonVi> dslp = new ArrayList<DonVi>();
		
		try {
			Database.getInstance().connect();
			Connection conn= Database.getConnection();
			String sql= "select * from DonVi";
			
			PreparedStatement pstm= conn.prepareStatement(sql);
			
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
				String maDV= rs.getString("maDonVi");
				String tenDV= rs.getString("tenDonVi");
				
				dslp.add(new DonVi(maDV, tenDV ));
			}
			Database.getInstance().disconnect();;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return dslp;
	}
	
	public static boolean themDonVi(DonVi lp) {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "insert into DonVi values(?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, lp.getMaDonVi());
			pstm.setString(2, lp.getTenDonVi());
			pstm.executeUpdate();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1);
			return false;
		}
	}
	
	public static void xoaDonVi(String maDV){		
		Database.getInstance().connect();;
    	Connection con = Database.getConnection();
    	PreparedStatement s=null;
    	String sql="Delete From DonVi where maDonVi = ?";
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
	
	public static boolean capNhatDonVi(DonVi lp) throws Exception  {
		try {
			Database.getInstance().connect();
			Connection conn = Database.getConnection();
			String sql = "update DonVi set tenDonVi = ? where maDonVi = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, lp.getTenDonVi());
			pstm.setString(2, lp.getMaDonVi());
			pstm.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("Cập nhật thông tin loại phòng thất bại!");
			return false;
		}
	}
	
	public static ArrayList<DonVi> timDonVi(String ten){
		ArrayList<DonVi> dsdv =new ArrayList<DonVi>();
		Database.getInstance().connect();
    	Connection con= Database.getConnection();
    	PreparedStatement s=null;
		try {	
				String sql = "Select * from DonVi where maDonVi like N'%"+ten+"%' "
			            + "or tenDonVi like N'%"+ten+"%'";  
				s =con.prepareStatement(sql);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
					String maDonVi= rs.getString("maDonVi");
					String tenDonVi= rs.getString("tenDonVi");
					DonVi dv = new DonVi(maDonVi, tenDonVi);
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
