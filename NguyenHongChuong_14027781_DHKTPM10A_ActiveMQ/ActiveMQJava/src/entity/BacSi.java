package entity;

import java.util.ArrayList;
import java.util.List;

public class BacSi {

	private String msBacSi;
	private String hotenBS;
	private List<KhamBenh> listKhamBenh;
	
	public BacSi(String msBacSi, String hotenBS, List<KhamBenh> listKhamBenh) {
		super();
		this.msBacSi = msBacSi;
		this.hotenBS = hotenBS;
		this.listKhamBenh = listKhamBenh;
	}

	public BacSi(String msBacSi, String hotenBS) {
		super();
		this.msBacSi = msBacSi;
		this.hotenBS = hotenBS;
		this.listKhamBenh = new ArrayList<KhamBenh>();
	}

	public String getMsBacSi() {
		return msBacSi;
	}

	public void setMsBacSi(String msBacSi) {
		this.msBacSi = msBacSi;
	}

	public String getHotenBS() {
		return hotenBS;
	}

	public void setHotenBS(String hotenBS) {
		this.hotenBS = hotenBS;
	}

	public List<KhamBenh> getListKhamBenh() {
		return listKhamBenh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msBacSi == null) ? 0 : msBacSi.hashCode());
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
		BacSi other = (BacSi) obj;
		if (msBacSi == null) {
			if (other.msBacSi != null)
				return false;
		} else if (!msBacSi.equals(other.msBacSi))
			return false;
		return true;
	}
	
	
}
