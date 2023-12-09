package entity;

import java.awt.Image;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private String diaChi;
	private Date ngaySinh;
	private Date ngayVaoLam;
	private float heSoLuong;
	private int luongCoBan;
	private LoaiNhanVien loai;
	private TaiKhoan taiKhoan;
	private Image hinhAnh;
	public NhanVien() {
		
	}
	public NhanVien(String maNhanVien, String hoTen, String diaChi, Date ngaySinh, Date ngayVaoLam, float heSoLuong,
			int luongCoBan, LoaiNhanVien loai, TaiKhoan taiKhoan, Image hinhAnh) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
		this.heSoLuong = heSoLuong;
		this.luongCoBan = luongCoBan;
		this.loai = loai;
		this.taiKhoan = taiKhoan;
		this.hinhAnh = hinhAnh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
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
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public int getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(int luongCoBan) {
		this.luongCoBan = luongCoBan;
	}
	public LoaiNhanVien getLoai() {
		return loai;
	}
	public void setLoai(LoaiNhanVien loai) {
		this.loai = loai;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public Image getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(Image hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", ngaySinh="
				+ ngaySinh + ", ngayVaoLam=" + ngayVaoLam + ", heSoLuong=" + heSoLuong + ", luongCoBan=" + luongCoBan
				+ ", loai=" + loai + ", taiKhoan=" + taiKhoan + ", hinhAnh=" + hinhAnh + "]";
	}

	
}
