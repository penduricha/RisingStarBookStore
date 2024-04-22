package entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HoaDon")
@NamedQuery(name = "HoaDon.findAll", query = "FROM HoaDon")
public class HoaDon 
{
	@Id
	@Column(name = "maHD", length = 100, columnDefinition = "nvarchar(50)",nullable = false)
	private String maHD;
	@Override
	public int hashCode() {
		return Objects.hash(maHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHD, other.maHD);
	}
	@Column(name = "ngayLap", length = 100,nullable = true)
	private Date ngayLap;
	@Column(name = "tongTien", length = 100,nullable = true)
	private double tongTien;
	@Column(name = "tienKhachDua", length = 100,nullable = true)
	private double tienKhachDua;
	public double getTienKhachDua() {
		return tienKhachDua;
	}
	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	//Nối với NhanVien
	@ManyToOne
    @JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	public List<CTHoaDon> getListCTHoaDon() {
		return listCTHoaDon;
	}
	public void setListCTHoaDon(List<CTHoaDon> listCTHoaDon) {
		this.listCTHoaDon = listCTHoaDon;
	}
	//Nối với KhachHang
	@ManyToOne
    @JoinColumn(name = "maKH")
	private KhachHang khachHang;
	//Nối với CTHoaDon
	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
	List<CTHoaDon> listCTHoaDon=new ArrayList<>();
	//Ham Date
	public LocalDate getNgayLapLocalDate()
	{
		return ngayLap.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	public String getNgayLapToString()
	{
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return df.format(getNgayLapLocalDate());
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, Date ngayLap,double tongTien,double tienKhachDua) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.tongTien=tongTien;
		this.tienKhachDua = tienKhachDua;
	}
	public double getTienThoi()
	{
		return tienKhachDua-tongTien;
	}
	
	
}
