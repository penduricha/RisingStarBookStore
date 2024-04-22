package entities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhanVien")
@NamedQuery(name = "NhanVien.findAll", query = "FROM NhanVien")
public class NhanVien 
{
	
	@Id
	@Column(name = "maNV", length = 100, columnDefinition = "nvarchar(50)",nullable = false)
	private String maNV;
	@Column(name = "tenNV", length = 100, columnDefinition = "nvarchar(50)",nullable = true)
	private String tenNV;
	@Column(name = "sdt", length = 100, columnDefinition = "nvarchar(20)",nullable = true)
	private String sdt;
	@Column(name = "gioiTinh", length = 100, columnDefinition = "nvarchar(5)",nullable = true)
	private String gioiTinh;
	@Column(name = "diaChi", length = 100, columnDefinition = "nvarchar(150)",nullable =true)
	private String diaChi;
	@Column(name = "ngaySinh", length = 100, nullable = false)
	private Date ngaySinh;
	@Column(name = "chucVu", length = 100, columnDefinition = "nvarchar(20)",nullable = true)
	private String chucVu;
	@Column(name = "cMND", length = 100, columnDefinition = "nvarchar(30)",nullable = true)
	private String cMND;
	@Column(name = "email", length = 100, columnDefinition = "nvarchar(120)",nullable = true)
	private String email;
	@Column(name = "caLam", length = 100, columnDefinition = "nvarchar(20)",nullable = true)
	private String caLam;
	public String getCaLam() {
		return caLam;
	}
	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}
	//Nối NhanVien và TaiKhoan
	@OneToOne(mappedBy = "nhanVien", cascade = CascadeType.ALL)
	private TaiKhoan taiKhoan;
	//Nối NhanVien và donDatHang
	@OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
	List<DonDatHang> listDonDatHang=new ArrayList<>();
	//Nối NhanVien và HoaDon
	@OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
	List<HoaDon> listHoaDon=new ArrayList<>();
	//Hàm xử lí Date
	public LocalDate getNgaySinhLocalDate()
	{
		return ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	public List<HoaDon> getListHoaDon() {
		return listHoaDon;
	}
	public void setListHoaDon(List<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	public List<DonDatHang> getListDonDatHang() {
		return listDonDatHang;
	}
	public void setListDonDatHang(List<DonDatHang> listDonDatHang) {
		this.listDonDatHang = listDonDatHang;
	}
	public String getNgaySinhToString()
	{
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return df.format(getNgaySinhLocalDate());
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,
			String cMND, String email, String caLam) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.cMND = cMND;
		this.email = email;
		this.caLam=caLam;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
}
