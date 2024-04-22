package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SanPham")
@NamedQuery(name = "SanPham.findAll", query = "FROM SanPham")
public class SanPham 
{
	@Id
	@Column(name = "maSP", length = 100, columnDefinition = "varchar(20)",nullable = false)
	private String maSP;
	@Column(name = "tenSP", length = 100, columnDefinition = "nvarchar(50)",nullable = true)
	private String tenSP;
	@Column(name = "loaiSP", length = 100, columnDefinition = "nvarchar(20)",nullable = true)
	private String loaiSP;
	@Column(name = "tacGia", length = 100, columnDefinition = "nvarchar(50)",nullable = true)
	private String tacGia;
	@Column(name = "nhaXuatBan", length = 100, columnDefinition = "nvarchar(50)",nullable = true)
	private String nhaXuatBan;
	@Column(name = "namXuatBan", length = 100, nullable = true)
	private int namXuatBan;
	@Column(name = "soLuong", length = 100,nullable = true)
	private int soLuong;
	@Column(name = "ngonNgu", length = 100,columnDefinition = "nvarchar(50)",nullable = true)
	private String ngonNgu;
	@Column(name = "giaNhap", length = 100,nullable = true)
	private double giaNhap;
	@Column(name = "giaBan", length = 100,nullable = true)
	private double giaBan;
	@Lob
    @Column(name = "hinhAnh", columnDefinition = "VARBINARY(MAX)")
    private byte[] hinhAnh;
	public byte[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	//Nối với NhaCungCap
	@ManyToOne
    @JoinColumn(name = "maNCC")
	private NhaCungCap nhaCungCap;
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public List<CTHoaDon> getListCTHoaDon() {
		return listCTHoaDon;
	}
	public void setListCTHoaDon(List<CTHoaDon> listCTHoaDon) {
		this.listCTHoaDon = listCTHoaDon;
	}
	public CTDonDatHang getcTDonDatHang() {
		return cTDonDatHang;
	}
	public void setcTDonDatHang(CTDonDatHang cTDonDatHang) {
		this.cTDonDatHang = cTDonDatHang;
	}
	//Nối với CTHoaDon
	@OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL)
	List<CTHoaDon> listCTHoaDon=new ArrayList<>();
	//Nối với CTDonDatHang
	@OneToOne(mappedBy = "sanPham", cascade = CascadeType.ALL)
	private CTDonDatHang cTDonDatHang;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
			int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
		this.ngonNgu = ngonNgu;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.hinhAnh=hinhAnh;
	}
	
	
}
