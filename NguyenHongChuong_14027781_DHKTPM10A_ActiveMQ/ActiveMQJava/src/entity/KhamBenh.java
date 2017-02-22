package entity;

import java.util.Date;

public class KhamBenh {

	private Date ngayKham;
	private String ghiChu;
	public Date getNgayKham() {
		return ngayKham;
	}
	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public KhamBenh(Date ngayKham, String ghiChu) {
		super();
		this.ngayKham = ngayKham;
		this.ghiChu = ghiChu;
	}
	
}
