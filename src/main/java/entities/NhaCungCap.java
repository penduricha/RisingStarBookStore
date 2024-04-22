package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "NhaCungCap")
@NamedQuery(name = "NhaCungCap.findAll", query = "FROM NhaCungCap")
public class NhaCungCap 
{
	
	@Id
	@Column(name = "maNCC", length = 100, columnDefinition = "nvarchar(20)",nullable = false)
	private String maNCC;
	@Column(name = "tenNCC", length = 100, columnDefinition = "nvarchar(150)",nullable = true)
	private String tenNCC;
	@Column(name = "diaChi", length = 100, columnDefinition = "nvarchar(150)",nullable = true)
	private String diaChi;
	@Column(name = "sdtNCC", length = 100, columnDefinition = "nvarchar(20)",nullable = true)
	private String sdtNCC;
	@Column(name = "email", length = 100, columnDefinition = "nvarchar(120)",nullable = true)
	private String email;
	//Nối với SanPham
	@OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
	List<SanPham> listSanPham=new ArrayList<>();
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdtNCC() {
		return sdtNCC;
	}
	public void setSdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<SanPham> getListSanPham() {
		return listSanPham;
	}
	public void setListSanPham(List<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNCC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(maNCC, other.maNCC);
	}
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.sdtNCC = sdtNCC;
		this.email = email;
	}
}
