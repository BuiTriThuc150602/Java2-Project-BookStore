package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Loai;

public class DAO_Loai {
	public ArrayList<Loai> getAllLoai(){
		ArrayList<Loai> dsLoai = new ArrayList<Loai>();
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Loai";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLoai = rs.getString("maLoai");
				String tenLoai = rs.getString("tenLoai");
				Loai l = new Loai(maLoai, tenLoai);
				dsLoai.add(l);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoai;
	}
	
	public Loai getLoaiTheoMa(String maLoai) {
		Loai loai = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from Loai where maLoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoai);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				String maLoai1 = rs.getString("maLoai");
				String tenLoai = rs.getString("tenLoai");
				loai = new Loai(maLoai1, tenLoai);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return loai;
	}
	public Loai getLoaiTheoTen(String tenLoai) {
		Loai loai = null;		
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();;
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Loai where tenLoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenLoai);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				String maLoai = rs.getString("maLoai");
				String ten = rs.getString("tenLoai");
				loai = new Loai(maLoai, ten);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return loai;
	}
}
