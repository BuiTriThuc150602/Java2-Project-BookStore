package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaCungCap;

public class DAO_NhaCungCap {
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhaCungCap";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString("maNCC");
				String tenNhaCungCap = rs.getString("tenNCC");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, soDienThoai, diaChi);
				dsNCC.add(ncc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNCC;
	}

	public NhaCungCap getNhaCungCapTheoMa(String maNCC) {
		NhaCungCap ncc = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from NhaCungCap where maNCC=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNCC);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maNhaCungCap = rs.getString("maNCC");
				String tenNhaCungCap = rs.getString("tenNCC");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, soDienThoai, diaChi);
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
		return ncc;
	}

	public boolean themNhaCungCap(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into NhaCungCap value(?,?,?,?)";
		int n = 0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, ncc.getMaNhaCungCap());
			preparedStatement.setString(2, ncc.getTenNhaCungCap());
			preparedStatement.setString(3, ncc.getSoDT());
			preparedStatement.setString(4, ncc.getDiaChi());

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
		return n > 0;
	}

	public boolean suaNhaCungCap(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "update NhaCungCap set tenNCC=?, soDienThoai=?, diaChi=? where maNCC=?";
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, ncc.getMaNhaCungCap());
			preparedStatement.setString(2, ncc.getTenNhaCungCap());
			preparedStatement.setString(3, ncc.getSoDT());
			preparedStatement.setString(4, ncc.getDiaChi());

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean xoaNhaCungCap(String maNCC) {
		int n = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from NhaCungCap where maNCC=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNCC);
			n = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}
}
