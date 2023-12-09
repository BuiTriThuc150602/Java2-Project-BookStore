package entity;

import java.util.Objects;

public class TheLoai {
	private String maTheLoai;
	private String tenLoai;

	public TheLoai() {

	}

	public TheLoai(String maTheLoai, String tenLoai) {
		super();
		this.maTheLoai = maTheLoai;
		this.tenLoai = tenLoai;
	}

	public String getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTheLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoai other = (TheLoai) obj;
		return Objects.equals(maTheLoai, other.maTheLoai);
	}

	@Override
	public String toString() {
		return "TheLoai [maTheLoai=" + maTheLoai + ", tenLoai=" + tenLoai + "]";
	}

}
