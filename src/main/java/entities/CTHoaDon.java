package entities;



import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CTHoaDon")
public class CTHoaDon {

	@Column(name = "donGia", length = 100, nullable = true)
	private double donGia;
	@Column(name = "soLuong", length = 100, nullable = true)
	private int soLuong;
	@Column(name = "thanhTien", length = 100, nullable = true)
	private double thanhTien;

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	// Nối CTHoaDon và HoaDon
	@Id
	@ManyToOne
	@JoinColumn(name = "maHD")
	private HoaDon hoaDon;
	@EmbeddedId
	@ManyToOne
	@JoinColumn(name = "maSP")
	private SanPham sanPham;


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

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public CTHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTHoaDon(double donGia, int soLuong, double thanhTien) {
		super();
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

}
