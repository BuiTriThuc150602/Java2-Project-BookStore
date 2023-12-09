package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_HoaDon {
	private DAO_KhachHang daoKH;
	private DAO_NhanVien daoNV;

	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				HoaDon hoaDon = onCreate(rs);
				dshd.add(hoaDon);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}

	public ArrayList<HoaDon> getHoaDonTheoNgay(java.util.Date date) {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HoaDon where ngayLap=? ";
			statement = con.prepareStatement(sql);
			statement.setDate(1, new Date(date.getTime()));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = onCreate(rs);
				dshd.add(hoaDon);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}

	public ArrayList<HoaDon> getHoaDonTheoThang(java.util.Date date) {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HoaDon where MONTH(ngayLap)=? ";
			statement = con.prepareStatement(sql);
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int month = localDate.getMonthValue();
			statement.setInt(1, month);
			;
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = onCreate(rs);
				dshd.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	public ArrayList<HoaDon> getHoaDonTheoNhanVien(String maNV) {
		ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HoaDon where maNhanVien=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDon hoaDon = onCreate(rs);
				dshd.add(hoaDon);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshd;
	}

	public HoaDon getHoaDonTheoMa(String maHD) {
		HoaDon hd = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from HoaDon where maHD=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				hd = onCreate(rs);
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
		return hd;
	}

	public boolean themHoaDon(HoaDon hd) {
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "insert into HoaDon values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, hd.getMaHoaDon());
			preparedStatement.setString(2, hd.getNhanVien().getMaNhanVien());
			preparedStatement.setString(3, hd.getKhachHang().getMaKhachHang());
			preparedStatement.setDate(4, new Date(hd.getNgayLap().getTime()));
			preparedStatement.setString(5, hd.getGiamGia());
			preparedStatement.setFloat(6, hd.getTongTien());

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean suaHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		daoNV = new DAO_NhanVien();
		daoKH = new DAO_KhachHang();
		String sql = "update HoaDon set maNhanVien=?, maKhachHang=?, ngayLap=?, giamGia=?, tongTien = ? where maHD=?";
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, hd.getMaHoaDon());
			preparedStatement.setString(2, hd.getNhanVien().getMaNhanVien());
			preparedStatement.setString(3, hd.getKhachHang().getMaKhachHang());
			preparedStatement.setDate(4, new Date(hd.getNgayLap().getTime()));
			preparedStatement.setString(5, hd.getGiamGia());
			preparedStatement.setFloat(6, (float) hd.getTongTien());

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (Exception e) {

			}
		}
		return n > 0;
	}

	public boolean xoaHoaDon(String maHD) {
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "delete from HoaDon where maHD=?";
			DAO_CTHoaDon dao_CTHoaDon = new DAO_CTHoaDon();
			dao_CTHoaDon.xoaCTHD(maHD);
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHD);

			n = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public String getMaHDCuoiCung() {
		String maHD = "";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select top 1 maHD from HoaDon order by maHD desc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				maHD = rs.getString("maHD");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maHD;
	}

	private HoaDon onCreate(ResultSet rs) {
		String maHD;
		HoaDon hoaDon = null;
		try {
			maHD = rs.getString("maHD");
			daoNV = new DAO_NhanVien();
			NhanVien nhanVien = daoNV.getNhanVienTheoMa(rs.getString("maNhanVien"));
			daoKH = new DAO_KhachHang();
			KhachHang khachHang = daoKH.getKhachHangTheoMa(rs.getString("maKhachHang"));
			Date ngayLap = rs.getDate("ngayLap");
			String giamGia = rs.getString("giamGia");
			float tongTien = rs.getFloat("tongTien");
			hoaDon = new HoaDon(maHD, ngayLap, giamGia, nhanVien, khachHang, tongTien);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hoaDon;

	}
}
