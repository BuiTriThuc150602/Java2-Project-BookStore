package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CTHoaDon;
import entity.HoaDon;
import entity.SanPham;

public class DAO_CTHoaDon {
	private DAO_HoaDon daoHD;
	private DAO_SanPham daoSP;

	public ArrayList<CTHoaDon> getAllCTHoaDon() throws IOException {
		ArrayList<CTHoaDon> dsctHdD = new ArrayList<CTHoaDon>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				CTHoaDon ctHoaDon = onCreate(rs);
				dsctHdD.add(ctHoaDon);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dsctHdD;
	}
	public ArrayList<CTHoaDon> getCTHoaDonTheoMaHoaDon(String maHD) {
		ArrayList<CTHoaDon> dsctHdD = new ArrayList<CTHoaDon>();
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietHoaDon where maHD = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHD);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CTHoaDon ctHoaDon = onCreate(rs);
				dsctHdD.add(ctHoaDon);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dsctHdD;
	}
	
	public boolean themCTHD(CTHoaDon ctHoaDon) {
		String sql = "insert into ChiTietHoaDon values (?,?,?)";
		int n = 0;
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, ctHoaDon.getHoaDon().getMaHoaDon());
			preparedStatement.setString(2, ctHoaDon.getSanPham().getMaSanPham());
			preparedStatement.setInt(3, ctHoaDon.getSoLuong());
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			 e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean xoaCTHD(String maHD) {
		String sql = "delete from ChiTietHoaDon where maHD=?";
		int n = 0;
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHD);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			 e.printStackTrace();
		}
		return n > 0;
	}

	private CTHoaDon onCreate(ResultSet rs) throws SQLException, IOException {
		daoHD = new DAO_HoaDon();
		HoaDon hoaDon = daoHD.getHoaDonTheoMa(rs.getString("maHD"));
		daoSP = new DAO_SanPham();
		SanPham sanPham = daoSP.getSanPhamTheoMa(rs.getString("maSP"));
		int soLuong = rs.getInt("soLuong");
		CTHoaDon ctHD = new CTHoaDon(hoaDon, sanPham, soLuong);
		return ctHD;
	}
}
