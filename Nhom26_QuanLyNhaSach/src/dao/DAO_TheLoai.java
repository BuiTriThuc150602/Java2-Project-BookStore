package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TheLoai;

public class DAO_TheLoai {
	public ArrayList<TheLoai> getAllTheLoai() {
		ArrayList<TheLoai> dsTL = new ArrayList<TheLoai>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TheLoai";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenLoai");
				TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
				dsTL.add(tl);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTL;
	}

	public TheLoai layTheLoaiTheoMa(String maTL) {
		TheLoai tl = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from TheLoai where maTheLoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTL);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenLoai");
				tl = new TheLoai(maTheLoai, tenTheLoai);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return tl;
	}
}
