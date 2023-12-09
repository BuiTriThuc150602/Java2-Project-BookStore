package dao;

import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Loai;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.SanPham;
import entity.TacGia;
import entity.TheLoai;
import imageHepler.ImageIOHelper;

public class DAO_SanPham {
	private DAO_Loai daoLoai = new DAO_Loai();
	private DAO_NhaXuatBan daoNXB = new DAO_NhaXuatBan();
	private DAO_NhaCungCap daoNCC = new DAO_NhaCungCap();
	private DAO_TacGia daoTG = new DAO_TacGia();
	private DAO_TheLoai daoTL = new DAO_TheLoai();

	public ArrayList<SanPham> getALLSanPham() {
		ArrayList<SanPham> dssp = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				SanPham sanPham = onCreate(rs);
				dssp.add(sanPham);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}

	public ArrayList<SanPham> getTop10SanPham() {
		ArrayList<SanPham> dssp = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select top 10 * from SanPham";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				SanPham sanPham = onCreate(rs);
				dssp.add(sanPham);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}

	public SanPham getSanPhamTheoMa(String maSP) {
		SanPham sp = null;
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where maSP=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maSP);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				sp = onCreate(rs);
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
		return sp;
	}

	public SanPham getSanPhamTheoTen(String ten) {
		SanPham sp = null;
		try {
			ConnectDB.getInstance().connect();
			PreparedStatement statement = null;
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where tenSP=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				sp = onCreate(rs);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sp;
	}

	public boolean themSanPham(SanPham sp) {

		String sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
			;
			Connection con = ConnectDB.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, sp.getMaSanPham());
			preparedStatement.setString(2, sp.getTenSanPham());
			preparedStatement.setInt(3, sp.getSoLuong());
			preparedStatement.setFloat(4, sp.getDonGia());
			Image hinhAnh = sp.getHinhAnh();
			byte[] image = ImageIOHelper.toByteArray(hinhAnh, "jpg");
			preparedStatement.setBytes(5, image);
			preparedStatement.setInt(6, sp.getSoTrang());
			preparedStatement.setString(7, sp.getNhaXuatBan().getMaNhaXuatBan());
			preparedStatement.setString(8, sp.getTacGia().getMaTacGia());
			preparedStatement.setString(8, sp.getTheLoai().getMaTheLoai());
			preparedStatement.setString(10, sp.getKichThuoc());
			Date ngayXuatBan = new Date(sp.getNgayXuatBan().getTime());
			preparedStatement.setDate(11, ngayXuatBan);
			preparedStatement.setString(12, sp.getLoaiBia());
			preparedStatement.setString(13, sp.getLoai().getMaLoai());
			preparedStatement.setString(14, sp.getNhaCungCap().getMaNhaCungCap());
			preparedStatement.setString(15, sp.getXuatXu());
			preparedStatement.setString(16, sp.getThuongHieu());
			preparedStatement.setString(17, sp.getChatLieu());

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean suaSanPham(SanPham sp) {
		String sql = "update SanPham set tenSP=?, soLuong=?, donGia=?, hinhAnh=?, soTrang=?, maXuatBan=?, "
				+ "maTacGia=?, maTheLoai=?, kichThuoc=?, ngayXuatBan=?, loaiBia=?, maLoai=?, maNhaCungCap=?, "
				+ "xuatXu=?, thuongHieu=?, chatLieu=? where maSP=?";
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();

			Connection con = ConnectDB.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sp.getTenSanPham());
			preparedStatement.setInt(2, sp.getSoLuong());
			preparedStatement.setFloat(3, sp.getDonGia());
			Image hinhAnh = sp.getHinhAnh();
			byte[] image = ImageIOHelper.toByteArray(hinhAnh, "jpg");
			preparedStatement.setBytes(4, image);
			preparedStatement.setInt(5, sp.getSoTrang());
			preparedStatement.setString(6, sp.getNhaXuatBan().getMaNhaXuatBan());
			preparedStatement.setString(7, sp.getTacGia().getMaTacGia());
			preparedStatement.setString(8, sp.getTheLoai().getMaTheLoai());
			preparedStatement.setString(9, sp.getKichThuoc());
			Date ngayXuatBan = new Date(sp.getNgayXuatBan().getTime());
			preparedStatement.setDate(10, ngayXuatBan);
			preparedStatement.setString(11, sp.getLoaiBia());
			preparedStatement.setString(12, sp.getLoai().getMaLoai());
			preparedStatement.setString(13, sp.getNhaCungCap().getMaNhaCungCap());
			preparedStatement.setString(14, sp.getXuatXu());
			preparedStatement.setString(15, sp.getThuongHieu());
			preparedStatement.setString(16, sp.getChatLieu());
			preparedStatement.setString(17, sp.getMaSanPham());

			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
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

	public boolean xoaSanPham(String maSP) {
		int n = 0;
		try {
			ConnectDB.getInstance().connect();

			Connection con = ConnectDB.getConnection();
			String sql = "delete from SanPham where maSP=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maSP);
			n = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}

	public ArrayList<SanPham> search(String key) {
		ArrayList<SanPham> rsSearch = new ArrayList<>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from SanPham where " + "tenSP like N'%" + key + "%' " + "or maSP like N'%" + key
					+ "%' " + "or maLoai like '%" + key + "%' ";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				SanPham sanPham = onCreate(rs);
				rsSearch.add(sanPham);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rsSearch;

	}

	public boolean capNhatSoLuongTon(String maSP, int slBan) {
		String sql = "update SanPham set soLuong = soLuong - ? where maSP=?";
		int n = 0;
		PreparedStatement preparedStatement = null;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, slBan);
			preparedStatement.setString(2, maSP);

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

	private SanPham onCreate(ResultSet rs) throws SQLException, IOException {
		String maSanPham = rs.getString("maSP");
		String tenSanPham = rs.getString("tenSP");
		int soLuong = rs.getInt("soLuong");
		float donGia = rs.getFloat("donGia");
		byte[] data = rs.getBytes("hinhAnh");
		Image hinhAnh = ImageIOHelper.createImage(data, "jpg");
		int soTrang = rs.getInt("soTrang");
		NhaXuatBan NhaXuatBan = daoNXB.getNhaXuatBanTheoMa(rs.getString("maXuatBan"));
		TacGia TacGia = daoTG.getTacGiaTheoMa(rs.getString("maTacGia"));
		TheLoai TheLoai = daoTL.layTheLoaiTheoMa(rs.getString("maTheLoai"));
		String kichThuoc = rs.getString("kichThuoc");
		Date ngayXuatBan = rs.getDate("ngayXuatBan");
		String loaiBia = rs.getString("loaiBia");
		Loai loai = daoLoai.getLoaiTheoMa(rs.getString("maLoai"));
		NhaCungCap NhaCungCap = daoNCC.getNhaCungCapTheoMa(rs.getString("maNhaCungCap"));
		String xuatXu = rs.getString("xuatXu");
		String thuongHieu = rs.getString("thuongHieu");
		String chatLieu = rs.getString("chatLieu");
		String donViTinh = rs.getString("donViTinh");
		SanPham sanPham = new SanPham(maSanPham, tenSanPham, soLuong, donGia, donViTinh, hinhAnh, soTrang, kichThuoc,
				ngayXuatBan, loaiBia, xuatXu, thuongHieu, chatLieu, TacGia, NhaXuatBan, loai, TheLoai, NhaCungCap);

		return sanPham;
	}

}
