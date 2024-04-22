package entities;



import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CTDonDatHang")
public class CTDonDatHang 
{
	@Column(name = "donGia", length = 100,nullable = true)
	private double donGia;
	@Column(name = "soLuong", length = 100,nullable = true)
	private int soLuong;
	@Column(name = "thanhTien", length = 100,nullable = true)
	private double thanhTien;
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	//Nối với SanPham và CTDonDatHang
	@EmbeddedId
	@OneToOne
    @JoinColumn(name = "maSP")
	private SanPham sanPham;
	//Nối SanPham 
	@Id
	@ManyToOne
    @JoinColumn(name = "maDDH")
	private DonDatHang donDatHang;

	
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public DonDatHang getDonDatHang() {
		return donDatHang;
	}
	public void setDonDatHang(DonDatHang donDatHang) {
		this.donDatHang = donDatHang;
	}
	public CTDonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CTDonDatHang(double donGia, int soLuong, double thanhTien) {
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	
	
	
}
