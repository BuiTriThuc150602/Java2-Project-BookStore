package dao;

import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import connectDB.ConnectDB;
import entity.KhachHang;
import imageHepler.ImageIOHelper;

public class DAO_KhachHang {
	public ArrayList<KhachHang> getAllKhachHang() {
		PreparedStatement preparedStatement = null;
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenKhachHang = rs.getString("hoTen");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				int diemTichLuy = rs.getInt("diemTichLuy");
				byte[] data = rs.getBytes("hinhAnh");
				Image hinhAnh = ImageIOHelper.createImage(data, "jpg");
				KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, diaChi, soDienThoai, diemTichLuy, hinhAnh);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}

	public KhachHang getKhachHangTheoMa(String maKH) {
		KhachHang kh = null;
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where maKhachHang=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenKhachHang = rs.getString("hoTen");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				int diemTichLuy = rs.getInt("diemTichLuy");
				byte[] data = rs.getBytes("hinhAnh");
				Image hinhAnh = ImageIOHelper.createImage(data, "jpg");
				kh = new KhachHang(maKhachHang, tenKhachHang, diaChi, soDienThoai, diemTichLuy, hinhAnh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kh;
	}

	public boolean themKhachHang(KhachHang kh) throws IOException {

		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "INSERT INTO [dbo].[KhachHang]\r\n" + "           ([maKhachHang]\r\n"
					+ "           ,[hoTen]\r\n" + "           ,[soDienThoai]\r\n" + "           ,[diaChi]\r\n"
					+ "           ,[hinhAnh]\r\n" + "           ,[diemTichLuy])\r\n" + "     VALUES\r\n"
					+ "           (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, kh.getMaKhachHang());
			preparedStatement.setString(2, kh.getHoTen());
			preparedStatement.setString(3, kh.getSoDT());
			Image hinhAnh = kh.getHinhAnh();
			byte[] image = ImageIOHelper.toByteArray(hinhAnh, "jpg");
			preparedStatement.setBytes(5, image);
			preparedStatement.setString(4, kh.getDiaChi());
			preparedStatement.setInt(6, kh.getDiemTichLuy());

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean suaKhachHang(KhachHang kh) throws IOException {

		String sql = "UPDATE [dbo].[KhachHang]\r\n" + "   SET " + "      [hoTen] = ?\r\n"
				+ "      ,[soDienThoai] = ? \r\n" + "      ,[diaChi] = ?\r\n" + "      ,[hinhAnh] = ?\r\n"
				+ "      ,[diemTichLuy] = ?\r\n" + " WHERE maKhachHang = ? ";
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, kh.getHoTen());
			preparedStatement.setString(2, kh.getSoDT());
			preparedStatement.setString(3, kh.getDiaChi());
			Image hinhAnh = kh.getHinhAnh();
			byte[] image = ImageIOHelper.toByteArray(hinhAnh, "jpg");
			preparedStatement.setBytes(4, image);
			preparedStatement.setInt(5, kh.getDiemTichLuy());
			preparedStatement.setString(6, kh.getMaKhachHang());
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean xoaKhachHang(String maKH) {
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "delete from KhachHang where maKhachHang=?";
			String sql2 = "update HoaDon set maKhachHang= null where maKhachHang=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
			preparedStatement.setString(1, maKH);
			preparedStatement2.setString(1, maKH);

			n = preparedStatement2.executeUpdate();
			n = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatDiemTichLuy(String maKH, int diem) {
		String sql = "update KhachHang set diemTichLuy = diemTichLuy + ? where maKhachHang=?";
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, diem);
			preparedStatement.setString(2, maKH);

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {

			}
		}

		return n > 0;
	}


	public ArrayList<KhachHang> search(String keySearch) {
		ArrayList<KhachHang> listKH = new ArrayList<>();
		String SQL = "select * from KhachHang where " + "hoTen like N'%" + keySearch + "%' " + "or soDienThoai like '%"
				+ keySearch + "%' ";
		try {
			ConnectDB.getInstance().connect();
			Connection connection = ConnectDB.getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			while (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String tenKhachHang = rs.getString("hoTen");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				int diemTichLuy = rs.getInt("diemTichLuy");
				byte[] data = rs.getBytes("hinhAnh");
				Image hinhAnh = ImageIOHelper.createImage(data, "jpg");
				KhachHang khachHang = new KhachHang(maKhachHang, tenKhachHang, diaChi, soDienThoai, diemTichLuy, hinhAnh);
				listKH.add(khachHang);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listKH;

	}
}
