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
@Table(name = "KhachHang")
@NamedQuery(name = "DonDatHang.findAll", query = "FROM KhachHang")
public class KhachHang 
{
	@Id
	@Column(name = "maKH", length = 100, columnDefinition = "nvarchar(50)",nullable = false)
	private String maKH;
	@Column(name = "tenKH", length = 100, columnDefinition = "nvarchar(50)",nullable = true)
	private String tenKH;
	@Column(name = "sdt", length = 100, columnDefinition = "nvarchar(20)",nullable = true)
	private String sdt;
	@Column(name = "gioiTinh", length = 100,nullable = true)
	private boolean gioiTinh;
	@Column(name = "diaChi", length = 100, columnDefinition = "nvarchar(150)",nullable = true)
	private String diaChi;
	//Nối KhachHang voi DonDatHang
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
	List<DonDatHang> listDonDatHang=new ArrayList<>();
	//Nối KhachHang voi HoaDon
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
	List<HoaDon> listHoaDon=new ArrayList<>();
	public List<HoaDon> getListHoaDon() {
		return listHoaDon;
	}
	public void setListHoaDon(List<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public List<DonDatHang> getListDonDatHang() {
		return listDonDatHang;
	}
	public void setListDonDatHang(List<DonDatHang> listDonDatHang) {
		this.listDonDatHang = listDonDatHang;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	public String traVeGioiTinh()
	{
		if(gioiTinh==true)
			return "Nam";
		else
			return "Nữ";
	}
	public int traGioiTinhThanhInt()
	{
		if(gioiTinh==true)
			return 1;
		else
			return 0;
	}
	
}
