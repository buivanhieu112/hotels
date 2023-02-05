/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Database {
    public static Connection con = null;
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}

	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLKS2";
		String user = "sa";
		String password = "1234";
		try {
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if(con != null)
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		System.out.println("Kết nối thành công!");
		return con;
		
	}
}
