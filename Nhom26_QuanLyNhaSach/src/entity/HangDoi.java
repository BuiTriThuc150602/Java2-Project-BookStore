package entity;

import java.util.ArrayList;

public class HangDoi {
	private String maHD;
	private String ngayLap;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private ArrayList<SanPhamMuaTrenHoaDon> dsSanPhamMua;
	public HangDoi(String maHD, String ngayLap, NhanVien nhanVien, KhachHang khachHang,
			ArrayList<SanPhamMuaTrenHoaDon> dsSanPhamMua) {
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.dsSanPhamMua = dsSanPhamMua;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public ArrayList<SanPhamMuaTrenHoaDon> getDsSanPhamMua() {
		return dsSanPhamMua;
	}
	public void setDsSanPhamMua(ArrayList<SanPhamMuaTrenHoaDon> dsSanPhamMua) {
		this.dsSanPhamMua = dsSanPhamMua;
	}
	
	
	
	

}
