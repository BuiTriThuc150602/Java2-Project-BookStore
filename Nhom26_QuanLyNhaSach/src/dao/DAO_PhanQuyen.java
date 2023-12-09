package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhanQuyen;

public class DAO_PhanQuyen {

	public ArrayList<PhanQuyen> getAllQuyen() {

		ArrayList<PhanQuyen> dsquyen = new ArrayList<PhanQuyen>();
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Quyen";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maQuyen = rs.getString("maPhanQuyen").trim();
				String tenQuyen = rs.getString("tenPhanQuyen").trim();
				PhanQuyen quyen = new PhanQuyen(maQuyen, tenQuyen);
				dsquyen.add(quyen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsquyen;
	}

	public PhanQuyen getQuyenTheoMaQuyen(String maPQ) {
		PhanQuyen quyen = null;
		
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhanQuyen where maPhanQuyen=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPQ);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maQuyen = rs.getString("maPhanQuyen").trim();
				String tenQuyen = rs.getString("tenPhanQuyen").trim();
				quyen = new PhanQuyen(maQuyen, tenQuyen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return quyen;
	}
	
	

}
