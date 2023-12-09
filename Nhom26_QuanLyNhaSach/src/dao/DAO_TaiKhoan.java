package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhanQuyen;
import entity.TaiKhoan;

public class DAO_TaiKhoan {

	private DAO_PhanQuyen dao_PhanQuyen = new DAO_PhanQuyen();
	public ArrayList<TaiKhoan> getAllTaiKhoan() {

		ArrayList<TaiKhoan> dstaikhoan = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTaiKhoan = rs.getString("maTaiKhoan");
				DAO_PhanQuyen dao_PhanQuyen = new DAO_PhanQuyen();
				PhanQuyen quyen = dao_PhanQuyen.getQuyenTheoMaQuyen(rs.getString("maPhanQuyen"));
				String email = rs.getString("email");
				String matKhau = rs.getString("matKhau");
				String tenDangNhap = rs.getString("tenDangNhap");

				TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, quyen, email, matKhau, tenDangNhap);
				dstaikhoan.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dstaikhoan;
	}

	public TaiKhoan getTaiKhoanTheoMa(String maTK) {
		TaiKhoan taiKhoan = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement statement = null;
			String sql = "Select * from PhanQuyen where maPhanQuyen=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTK);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maTaiKhoan = rs.getString("maTaiKhoan");
				DAO_PhanQuyen dao_PhanQuyen = new DAO_PhanQuyen();
				PhanQuyen quyen = dao_PhanQuyen.getQuyenTheoMaQuyen(rs.getString("maPhanQuyen"));
				String email = rs.getString("email");
				String matKhau = rs.getString("matKhau");
				String tenDangNhap = rs.getString("tenDangNhap");

				taiKhoan = new TaiKhoan(maTaiKhoan, quyen, email, matKhau, tenDangNhap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return taiKhoan;
	}
	
	public boolean themTaiKhoan(TaiKhoan tk) {
		int n = 0;
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			String sql = "insert into TaiKhoan values(?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, tk.getMaTaiKhoan());
			preparedStatement.setString(2, tk.getPhanQuyen().getMaPhanQuyen());
			preparedStatement.setString(3, tk.getEmail());
			preparedStatement.setString(4, tk.getMatKhau());
			preparedStatement.setString(5, tk.getTenDangnhap());		

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaTaiKhoan(String ma) {
		int n = 0;
		PreparedStatement preparedStatement = null;
			try {
				ConnectDB.getInstance().connect();
				Connection con = ConnectDB.getConnection();
				String sql = "delete from TaiKhoan where maTaiKhoan = ?";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, ma);	
				n = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return n>0;
	}
	
}
