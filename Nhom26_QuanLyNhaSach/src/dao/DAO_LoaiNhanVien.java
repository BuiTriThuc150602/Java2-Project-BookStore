package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiNhanVien;

public class DAO_LoaiNhanVien {
	public ArrayList<LoaiNhanVien> getAllLoaiNhanVien() {

		ArrayList<LoaiNhanVien> dsLoaiTaiKhoan = new ArrayList<LoaiNhanVien>();
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiNhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoai = rs.getString("maLoai").trim();
				String tenLoai = rs.getString("tenLoai").trim();
				String mota = rs.getString("moTa").trim();

				LoaiNhanVien loai = new LoaiNhanVien(maLoai, tenLoai, mota);
				dsLoaiTaiKhoan.add(loai);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiTaiKhoan;
	}

	public LoaiNhanVien getLoaiNhanVienTheoMa(String ma) {
		LoaiNhanVien loai = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from LoaiNhanVien where maLoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maLoai = rs.getString("maLoai").trim();
				String tenLoai = rs.getString("tenLoai").trim();
				String mota = rs.getString("moTa").trim();
				loai = new LoaiNhanVien(maLoai, tenLoai, mota);
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
		return loai;
	}
	
	public LoaiNhanVien getLoaiNhanVienTheoTen(String ten) {
		LoaiNhanVien loai = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from LoaiNhanVien where tenLoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maLoai = rs.getString("maLoai").trim();
				String tenLoai = rs.getString("tenLoai").trim();
				String mota = rs.getString("moTa").trim();
				loai = new LoaiNhanVien(maLoai, tenLoai, mota);
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
		return loai;
	}

}
