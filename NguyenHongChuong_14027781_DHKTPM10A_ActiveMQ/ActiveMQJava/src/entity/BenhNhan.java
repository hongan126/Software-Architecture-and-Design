
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="BenhNhan")
@XmlType(propOrder={"masoBN","soCMND","hoTen","diaChi"})
public class BenhNhan implements Serializable{

	private String masoBN;
	private String soCMND;
	private String hoTen;
	private String diaChi;
	//private List<KhamBenh> listKhamBenh;
	
	public BenhNhan(String masoBN, String soCMND, String hoTen, String diaChi) {
		super();
		this.masoBN = masoBN;
		this.soCMND = soCMND;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		//this.listKhamBenh = new ArrayList<KhamBenh>();
	}

//	public BenhNhan(String masoBN, String soCMND, String hoTen, String diaChi, List<KhamBenh> listKhamBenh) {
//		super();
//		this.masoBN = masoBN;
//		this.soCMND = soCMND;
//		this.hoTen = hoTen;
//		this.diaChi = diaChi;
//		this.listKhamBenh = listKhamBenh;
//	}

	public BenhNhan() {
		
	}

	public String getMasoBN() {
		return masoBN;
	}

	public void setMasoBN(String masoBN) {
		this.masoBN = masoBN;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
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

	@Override
	public String toString() {
		return "BenhNhan [masoBN=" + masoBN + ", soCMND=" + soCMND + ", hoTen=" + hoTen + ", diaChi=" + diaChi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masoBN == null) ? 0 : masoBN.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BenhNhan other = (BenhNhan) obj;
		if (masoBN == null) {
			if (other.masoBN != null)
				return false;
		} else if (!masoBN.equals(other.masoBN))
			return false;
		return true;
	}

//	public List<KhamBenh> getListKhamBenh() {
//		return listKhamBenh;
//	}

	
	
}
