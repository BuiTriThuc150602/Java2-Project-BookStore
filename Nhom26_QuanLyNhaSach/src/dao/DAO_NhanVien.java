package dao;

import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.TaiKhoan;
import imageHepler.ImageIOHelper;

public class DAO_NhanVien {
	private DAO_TaiKhoan dao_TaiKhoan = new DAO_TaiKhoan();

	public ArrayList<NhanVien> getAllNhanVien() {
		PreparedStatement preparedStatement = null;
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien";
			preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				Date ngaySinh = rs.getDate("ngaySinh");
				Date ngayVaoLam = rs.getDate("ngayVaoLam");
				byte[] data = rs.getBytes("hinhAnh");
				Image hinhAnh = ImageIOHelper.createImage(data, "jpg");
				float heSoLuong = rs.getFloat("heSoLuong");
				int luongCoBan = rs.getInt("luongCoBan");
				DAO_LoaiNhanVien dao_LoaiNhanVien = new DAO_LoaiNhanVien();
				DAO_TaiKhoan dao_TaiKhoan = new DAO_TaiKhoan();
				LoaiNhanVien loai = dao_LoaiNhanVien.getLoaiNhanVienTheoMa(rs.getString("maLoai"));
				TaiKhoan taiKhoan = dao_TaiKhoan.getTaiKhoanTheoMa(rs.getString("maTaiKhoan"));
				NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, diaChi, ngaySinh, ngayVaoLam, heSoLuong, luongCoBan,
						loai, taiKhoan, hinhAnh);
				dsnv.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}

	public NhanVien getNhanVienTheoTaiKhoan(String maTaiKhoan) {
		NhanVien nhanVien = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			PreparedStatement statement = null;
			String sql = "Select * from NhanVien where maTaiKhoan=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maTaiKhoan);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				nhanVien = onCreate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		ConnectDB.getInstance().disconnect();
		return nhanVien;
	}

	public NhanVien getNhanVienTheoMa(String maNV) {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from NhanVien where maNhanVien=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				nv = onCreate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return nv;
	}

	private NhanVien onCreate(ResultSet rs) throws SQLException, IOException {
		String maNhanVien = rs.getString("maNhanVien");
		String hoTen = rs.getString("hoTen");
		String diaChi = rs.getString("diaChi");
		Date ngaySinh = rs.getDate("ngaySinh");
		Date ngayVaoLam = rs.getDate("ngayVaoLam");
		byte[] data = rs.getBytes("hinhAnh");
		Image hinhAnh = ImageIOHelper.createImage(data, "jpg");
		float heSoLuong = rs.getFloat("heSoLuong");
		int luongCoBan = rs.getInt("luongCoBan");
		DAO_LoaiNhanVien dao_LoaiNhanVien = new DAO_LoaiNhanVien();
		DAO_TaiKhoan dao_TaiKhoan = new DAO_TaiKhoan();
		LoaiNhanVien loai = dao_LoaiNhanVien.getLoaiNhanVienTheoMa(rs.getString("maLoai"));
		TaiKhoan taiKhoan = dao_TaiKhoan.getTaiKhoanTheoMa(rs.getString("maTaiKhoan"));
		NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, diaChi, ngaySinh, ngayVaoLam, heSoLuong, luongCoBan, loai,
				taiKhoan, hinhAnh);
		return nhanVien;

	}

	public boolean themNhanVien(NhanVien nv) throws IOException {

		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into NhanVien (maNhanVien, hoTen, diaChi, ngaySinh,hinhAnh,ngayVaoLam,heSoLuong,luongCoBan, maLoai, maTaiKhoan) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, nv.getMaNhanVien());
			preparedStatement.setString(2, nv.getHoTen());
			preparedStatement.setString(3, nv.getDiaChi());
			java.sql.Date ngaySinh = new java.sql.Date(nv.getNgaySinh().getTime());
			java.sql.Date ngayVaoLam = new java.sql.Date(nv.getNgayVaoLam().getTime());
			preparedStatement.setDate(4, ngaySinh);
			Image hinhAnh = nv.getHinhAnh();
			byte[] image = ImageIOHelper.toByteArray(hinhAnh, "jpg");
			preparedStatement.setBytes(5, image);
			preparedStatement.setDate(6, ngayVaoLam);
			preparedStatement.setDouble(7, nv.getHeSoLuong());
			preparedStatement.setInt(8, nv.getLuongCoBan());
			preparedStatement.setString(9, nv.getLoai().getMaLoai());
			preparedStatement.setString(10, nv.getTaiKhoan().getMaTaiKhoan());
			System.out.println(nv.getTaiKhoan());

			n = preparedStatement.executeUpdate();
			dao_TaiKhoan.themTaiKhoan(nv.getTaiKhoan());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean suaNhanVien(NhanVien nv) throws IOException {
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "update NhanVien set hoTen= ?, diaChi= ?, ngaySinh=?, hinhAnh= ?, ngayVaoLam= ? , heSoLuong= ?, "
					+ "luongCoBan= ? , maLoai= ? , maTaiKhoan= ? where maNhanVien= ? ";
			preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(10, nv.getMaNhanVien());
			preparedStatement.setString(1, nv.getHoTen());
			preparedStatement.setString(2, nv.getDiaChi());
			java.sql.Date ngaySinh = new java.sql.Date(nv.getNgaySinh().getTime());
			java.sql.Date ngayVaoLam = new java.sql.Date(nv.getNgayVaoLam().getTime());
			preparedStatement.setDate(3, ngaySinh);
			Image hinhAnh = nv.getHinhAnh();
			byte[] image = ImageIOHelper.toByteArray(hinhAnh, "jpg");
			preparedStatement.setBytes(4, image);
			preparedStatement.setDate(5, ngayVaoLam);
			preparedStatement.setDouble(6, nv.getHeSoLuong());
			preparedStatement.setInt(7, nv.getLuongCoBan());
			preparedStatement.setString(8, nv.getLoai().getMaLoai());
			preparedStatement.setString(9, nv.getTaiKhoan().getMaTaiKhoan());
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {

			}
		}
		return n > 0;
	}

	public boolean xoaNhanVien(String ma) {
		int n = 0;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementHD = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from NhanVien where maNhanVien = ?";
			String sqlHD = "update HoaDon set maNhanVien = null where maNhanVien=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatementHD = con.prepareStatement(sqlHD);
			preparedStatement.setString(1, ma);
			preparedStatementHD.setString(1, ma);
			if (dao_TaiKhoan.xoaTaiKhoan(ma)) {
				preparedStatementHD.executeUpdate();
				n = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

}
