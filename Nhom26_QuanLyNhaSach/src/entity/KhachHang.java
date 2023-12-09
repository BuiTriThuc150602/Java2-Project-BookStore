package entity;

import java.awt.Image;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String hoTen;
	private String diaChi;
	private String soDT;
	private int diemTichLuy;
	private Image hinhAnh;
	public KhachHang() {

	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", soDT=" + soDT
				+ ", diemTichLuy=" + diemTichLuy + ", hinhAnh=" + hinhAnh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	public Image getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(Image hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public KhachHang(String maKhachHang, String hoTen, String diaChi, String soDT, int diemTichLuy, Image hinhAnh) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.diemTichLuy = diemTichLuy;
		this.hinhAnh = hinhAnh;
	}

	

}
