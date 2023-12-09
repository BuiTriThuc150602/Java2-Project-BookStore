package entity;

import java.util.Date;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private Date ngayLap;
	private String giamGia;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private float tongTien;

	public HoaDon() {

	}

	public HoaDon(String maHoaDon, Date ngayLap, String giamGia, NhanVien nhanVien, KhachHang khachHang,float tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.giamGia = giamGia;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tongTien = tongTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(String giamGia) {
		this.giamGia = giamGia;
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
	
	

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", giamGia=" + giamGia + ", nhanVien="
				+ nhanVien + ", khachHang=" + khachHang + ", tongTien=" + tongTien + "]";
	}

	

}
