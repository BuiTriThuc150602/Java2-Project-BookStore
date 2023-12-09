package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TacGia;

public class DAO_TacGia {
	public ArrayList<TacGia> getAllTacGia() {
		ArrayList<TacGia> dstg = new ArrayList<TacGia>();
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TacGia";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String tenTacGia = rs.getString("tenTacGia");
				TacGia tg = new TacGia(maTacGia, tenTacGia);
				dstg.add(tg);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstg;
	}

	public TacGia getTacGiaTheoMa(String maTG) {
		TacGia tg = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from TacGia where maTacGia=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTG);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String tenTacGia = rs.getString("tenTacGia");
				tg = new TacGia(maTacGia, tenTacGia);
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
		return tg;
	}
}
