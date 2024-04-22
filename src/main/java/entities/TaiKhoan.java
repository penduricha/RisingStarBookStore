package entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
@NamedQuery(name = "TaiKhoan.findAll", query = "FROM TaiKhoan")
public class TaiKhoan 
{
	
	@Column(name = "matKhau", length = 100,columnDefinition = "varchar(200)",nullable = false)
	private String matKhau;
	//Nối với NhanVien
	@Id
	@OneToOne
    @JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String matKhau) {
		super();
		this.matKhau = matKhau;
	}
}
