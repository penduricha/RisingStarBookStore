package connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import entities.CTDonDatHang;
import entities.CTHoaDon;
import entities.DonDatHang;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhaCungCap;
import entities.NhanVien;
import entities.SanPham;
import entities.TaiKhoan;
public class Herbinate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("risingstar");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try 
		{
			String imageConan100 = "src/main/images/book_image/conan100.jpg"; // Đường dẫn đến tệp ảnh
	        byte[] imageBytesConan100 = convertImageToByteArray(imageConan100);
	        
	        String imageConan97= "src/main/images/book_image/conan97.jpg"; // Đường dẫn đến tệp ảnh
	        byte[] imageBytesConan97 = convertImageToByteArray(imageConan97);
			
			//tạo entities
			//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email)
			NhaCungCap nhaCungCap1=new NhaCungCap("NCC1", "Alex","8981646656", "alex@gmail.com", "192 Paul Street USA");
			//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int soLuong,String ngonNgu, double giaNhap)
			SanPham sanPham1=new SanPham("SP1", "Conan tập 1","Truyện tranh ","Gosho","Kim Đồng",2000,100,"Nhật Bản",1000000,1000000*1.2,imageBytesConan100 );
			SanPham sanPham2=new SanPham("SP2", "Conan tập 2","Truyện tranh ","Gosho","Kim Đồng",2000,100,"Nhật Bản",1000000,1000000*1.2,imageBytesConan97);
			//NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String email)
			NhanVien nhanVien1=new NhanVien("NV1","Nguyen Minh", "0911646636", "Nam","23 Tran Hung Dao HCM",(java.sql.Date) new Date(),"Nhan vien","060205000123", "minhtrd@gmail.com","Buổi sáng");
			//TaiKhoan(String maTK, String matKhau) 
			TaiKhoan taiKhoan1=new TaiKhoan("1234");
			//DonDatHang(String maDDH, Date ngayDat)
			DonDatHang donDatHang1=new DonDatHang("DDH1",(java.sql.Date) new Date());
			DonDatHang donDatHang2=new DonDatHang("DDH2",(java.sql.Date) new Date());
			//KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String diaChi)
			KhachHang khachHang1=new KhachHang("KH1","Bill Joen","7891646635",true,"13 Ohio");
			//HoaDon(String maHD, Date ngayLap)
			HoaDon hoaDon1=new HoaDon("HD1",(java.sql.Date) new Date(),2000000,4000000);
			HoaDon hoaDon2=new HoaDon("HD2",(java.sql.Date) new Date(),2000000,4000000);
			//CTHoaDon(String maCTHD, double donGia, int soLuong)
			CTHoaDon cTHoaDon1=new CTHoaDon(20000,34,20000*34);
			CTHoaDon cTHoaDon2=new CTHoaDon(20000,35,20000*35);
			//CTDonDatHang(String maCTDDH, double donGia, int soLuong)
			CTDonDatHang cTDonDatHang1=new CTDonDatHang(30000,23,500000);
			CTDonDatHang cTDonDatHang2=new CTDonDatHang(30000,23,500000);
			
			//set SanPham và NhaCungCap
			nhaCungCap1.getListSanPham().add(sanPham1);
			nhaCungCap1.getListSanPham().add(sanPham2);
			sanPham1.setNhaCungCap(nhaCungCap1);
			sanPham2.setNhaCungCap(nhaCungCap1);
			//set NhanVien và TaiKhoan
			nhanVien1.setTaiKhoan(taiKhoan1);
			taiKhoan1.setNhanVien(nhanVien1);
			//set NhanVien và DonDatHang
			nhanVien1.getListDonDatHang().add(donDatHang1);
			nhanVien1.getListDonDatHang().add(donDatHang2);
			donDatHang1.setNhanVien(nhanVien1);
			donDatHang2.setNhanVien(nhanVien1);
			//set KhacHang và DonDatHang
			khachHang1.getListDonDatHang().add(donDatHang1);
			khachHang1.getListDonDatHang().add(donDatHang2);
			donDatHang1.setKhachHang(khachHang1);
			donDatHang2.setKhachHang(khachHang1);
			//set HoaDon và NhanVien
			nhanVien1.getListHoaDon().add(hoaDon1);
			nhanVien1.getListHoaDon().add(hoaDon2);
			hoaDon1.setNhanVien(nhanVien1);
			hoaDon2.setNhanVien(nhanVien1);
			//set HoaDon và KhachHang
			khachHang1.getListHoaDon().add(hoaDon1);
			khachHang1.getListHoaDon().add(hoaDon2);
			hoaDon1.setKhachHang(khachHang1);
			hoaDon2.setKhachHang(khachHang1);
			//set CTHoaDon và HoaDon
			hoaDon1.getListCTHoaDon().add(cTHoaDon1);
			hoaDon1.getListCTHoaDon().add(cTHoaDon2);
			cTHoaDon1.setHoaDon(hoaDon1);
			cTHoaDon1.setHoaDon(hoaDon1);
			//set CTDonDatHang và SanPham
			cTDonDatHang1.setSanPham(sanPham1);
			sanPham1.setcTDonDatHang(cTDonDatHang1);
			//set CTDonDatHang và DonDatHang
			donDatHang1.getListCTDonDatHang().add(cTDonDatHang1);
			donDatHang1.getListCTDonDatHang().add(cTDonDatHang2);
			cTDonDatHang1.setDonDatHang(donDatHang1);
			cTDonDatHang2.setDonDatHang(donDatHang1);
			
			em.persist(nhaCungCap1);
			em.persist(nhanVien1);
			em.persist(khachHang1);
			System.out.println("Create database success");
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) 
		{
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally 
		{
			em.close();
			emf.close();
		}

	}
	public static byte[] convertImageToByteArray(String imagePath) {
        byte[] imageBytes = null;
        File file = new File(imagePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            imageBytes = new byte[(int) file.length()];
            fileInputStream.read(imageBytes);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }

}
