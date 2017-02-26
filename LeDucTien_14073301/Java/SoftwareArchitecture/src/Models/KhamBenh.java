package Models;

public class KhamBenh {
	private String msbn;
	private String msbacsy;
	private String ngaykham;
	private String ghichu;
	public KhamBenh() {
		// TODO Auto-generated constructor stub
	}
	public KhamBenh(String msbn, String msbacsy, String ngaykham, String ghichu) {
		super();
		this.msbn = msbn;
		this.msbacsy = msbacsy;
		this.ngaykham = ngaykham;
		this.ghichu = ghichu;
	}
	public String getMsbn() {
		return msbn;
	}
	public void setMsbn(String msbn) {
		this.msbn = msbn;
	}
	public String getMsbacsy() {
		return msbacsy;
	}
	public void setMsbacsy(String msbacsy) {
		this.msbacsy = msbacsy;
	}
	public String getNgaykham() {
		return ngaykham;
	}
	public void setNgaykham(String ngaykham) {
		this.ngaykham = ngaykham;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
}
