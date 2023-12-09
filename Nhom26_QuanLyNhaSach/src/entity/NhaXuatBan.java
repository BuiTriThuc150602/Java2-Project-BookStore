package entity;

import java.util.Objects;

public class NhaXuatBan {
	private String maNhaXuatBan;
	private String tenNhaXuatBan;
	private String diaChi;
	private String soDT;

	public NhaXuatBan() {

	}

	public NhaXuatBan(String maNhaXuatBan, String tenNhaXuatBan, String diaChi, String soDT) {
		super();
		this.maNhaXuatBan = maNhaXuatBan;
		this.tenNhaXuatBan = tenNhaXuatBan;
		this.diaChi = diaChi;
		this.soDT = soDT;
	}

	public String getMaNhaXuatBan() {
		return maNhaXuatBan;
	}

	public void setMaNhaXuatBan(String maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
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

	@Override
	public int hashCode() {
		return Objects.hash(maNhaXuatBan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaXuatBan other = (NhaXuatBan) obj;
		return Objects.equals(maNhaXuatBan, other.maNhaXuatBan);
	}

	@Override
	public String toString() {
		return "NhaXuatBan [maNhaXuatBan=" + maNhaXuatBan + ", tenNhaXuatBan=" + tenNhaXuatBan + ", diaChi=" + diaChi
				+ ", soDT=" + soDT + "]";
	}

}
