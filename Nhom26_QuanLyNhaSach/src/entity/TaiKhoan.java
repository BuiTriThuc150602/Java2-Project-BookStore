package entity;

import java.util.Objects;

public class TaiKhoan {
	private String maTaiKhoan;
	private PhanQuyen phanQuyen;
	private String email;
	private String matKhau;
	private String tenDangnhap;

	public TaiKhoan() {
		this("", null, "", "", "");
	}

	public TaiKhoan(String maTaiKhoan, PhanQuyen phanQuyen, String email, String matKhau, String tenDangnhap) {
		this.maTaiKhoan = maTaiKhoan;
		this.phanQuyen = phanQuyen;
		this.email = email;
		this.matKhau = matKhau;
		this.tenDangnhap = tenDangnhap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTaiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(maTaiKhoan, other.maTaiKhoan);
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public PhanQuyen getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(PhanQuyen phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenDangnhap() {
		return tenDangnhap;
	}

	public void setTenDangnhap(String tenDangnhap) {
		this.tenDangnhap = tenDangnhap;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", phanQuyen=" + phanQuyen.getMaPhanQuyen() + ", email=" + email + ", matKhau="
				+ matKhau + ", tenDangnhap=" + tenDangnhap + "]";
	}

}
