package entity;

import java.awt.Image;
import java.util.Date;
import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private int soLuong;
	private float donGia;
	private Image hinhAnh;
	private int soTrang;
	private String kichThuoc;
	private Date ngayXuatBan;
	private String loaiBia;
	private String xuatXu;
	private String thuongHieu;
	private String chatLieu;
	private String donViTinh;
	private TacGia tacGia;
	private NhaXuatBan nhaXuatBan;
	private Loai loai;
	private TheLoai theLoai;
	private NhaCungCap nhaCungCap;

	public SanPham() {

	}

	public SanPham(String maSanPham, String tenSanPham, int soLuong, float donGia,String donViTinh, Image hinhAnh, int soTrang,
			String kichThuoc, Date ngayXuatBan, String loaiBia, String xuatXu, String thuongHieu, String chatLieu,
			TacGia tacGia, NhaXuatBan nhaXuatBan, Loai loai, TheLoai theLoai, NhaCungCap nhaCungCap) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.hinhAnh = hinhAnh;
		this.soTrang = soTrang;
		this.kichThuoc = kichThuoc;
		this.ngayXuatBan = ngayXuatBan;
		this.loaiBia = loaiBia;
		this.xuatXu = xuatXu;
		this.thuongHieu = thuongHieu;
		this.chatLieu = chatLieu;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.loai = loai;
		this.theLoai = theLoai;
		this.nhaCungCap = nhaCungCap;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
	

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public Image getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Image hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public Date getNgayXuatBan() {
		return ngayXuatBan;
	}

	public void setNgayXuatBan(Date ngayXuatBan) {
		this.ngayXuatBan = ngayXuatBan;
	}

	public String getLoaiBia() {
		return loaiBia;
	}

	public void setLoaiBia(String loaiBia) {
		this.loaiBia = loaiBia;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public Loai getLoai() {
		return loai;
	}

	public void setLoai(Loai loai) {
		this.loai = loai;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", donGia="
				+ donGia + ", hinhAnh=" + hinhAnh + ", soTrang=" + soTrang + ", kichThuoc=" + kichThuoc
				+ ", ngayXuatBan=" + ngayXuatBan + ", loaiBia=" + loaiBia + ", xuatXu=" + xuatXu + ", thuongHieu="
				+ thuongHieu + ", chatLieu=" + chatLieu + ", donViTinh=" + donViTinh + ", tacGia=" + tacGia
				+ ", nhaXuatBan=" + nhaXuatBan + ", loai=" + loai + ", theLoai=" + theLoai + ", nhaCungCap="
				+ nhaCungCap + "]";
	}



}
