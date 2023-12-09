package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaXuatBan;

public class DAO_NhaXuatBan {
	public ArrayList<NhaXuatBan> getAllNhaXuatBan() {
		ArrayList<NhaXuatBan> dsNXB = new ArrayList<NhaXuatBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhaXuatBan";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNhaXuatBan = rs.getString("maNXB");
				String tenNhaXuatBan = rs.getString("tenNXB");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				NhaXuatBan nxb = new NhaXuatBan(maNhaXuatBan, tenNhaXuatBan, diaChi, soDienThoai);
				dsNXB.add(nxb);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNXB;
	}

	public NhaXuatBan getNhaXuatBanTheoMa(String maNXB) {
		NhaXuatBan nxb = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from NhaXuatBan where maNXB=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNXB);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maNhaXuatBan = rs.getString("maNXB");
				String tenNhaXuatBan = rs.getString("tenNXB");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				nxb = new NhaXuatBan(maNhaXuatBan, tenNhaXuatBan, diaChi, soDienThoai);
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
		return nxb;
	}
}
