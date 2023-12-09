package entity;

public class SanPhamMuaTrenHoaDon {
	private String maSP;
	private String tenSP;
	private String donViTinh;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	
	public SanPhamMuaTrenHoaDon() {
		
	}
	
	
	public SanPhamMuaTrenHoaDon(String maSP, String tenSP, String donViTinh, int soLuong, double donGia,
			double thanhTien) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}


	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
	
	

}
