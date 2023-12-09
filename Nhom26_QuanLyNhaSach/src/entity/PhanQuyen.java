package entity;

import java.util.Objects;

public class PhanQuyen {
	private String maPhanQuyen;
	private String tenPhanQuyen;

	public PhanQuyen(String maPhanQuyen, String tenPhanQuyen) {
		this.maPhanQuyen = maPhanQuyen;
		this.tenPhanQuyen = tenPhanQuyen;
	}

	public PhanQuyen() {
		this("", "");
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhanQuyen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanQuyen other = (PhanQuyen) obj;
		return Objects.equals(maPhanQuyen, other.maPhanQuyen);
	}

	public String getTenPhanQuyen() {
		return tenPhanQuyen;
	}

	public void setTenPhanQuyen(String tenPhanQuyen) {
		this.tenPhanQuyen = tenPhanQuyen;
	}

	public String getMaPhanQuyen() {
		return maPhanQuyen;
	}

	@Override
	public String toString() {
		return "PhanQuyen [maPhanQuyen=" + maPhanQuyen + ", tenPhanQuyen=" + tenPhanQuyen + ", hashCode()=" + hashCode()
				+ ", getTenPhanQuyen()=" + getMaPhanQuyen() + ", getMaPhanQuyen()=" + getMaPhanQuyen()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
