package interface_Method_Database;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;

import entities.NhaCungCap;

public interface Method_NhaCungCap {
	//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
	public void xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC);
	public boolean themNhaCungCap(NhaCungCap n);
	public boolean capNhatNhaCungCap(NhaCungCap n);
	//Đẩy lên combobox
	public void dayComboBoxMaNCC(Custom_ComboBox cbMaNCC);
	public void dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC);
	public void dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi);
	public void dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT);
	public void dayComboBoxEmail(Custom_ComboBox cbo_Email);
	//Chức năng tìm kiếm theo nhiều tiêu chí
	//tìm kiếm 1 tiêu chí
	public void timKiemTheoMaNCC(String maNCC, DefaultTableModel dtm_NCC);
	public void timKiemTheoTenNCC(String tenNCC, DefaultTableModel dtm_NCC);
	public void timKiemTheoDiaChi(String diaChi, DefaultTableModel dtm_NCC);
	public void timKiemTheoSoDienThoaiNCC(String sdtNCC, DefaultTableModel dtm_NCC);
	public void timKiemTheoEmail(String email, DefaultTableModel dtm_NCC);
	//Tìm kiếm đầy đủ điều kiện trừ maNCC
	public void timKiemTheoTieuChiKhacMaNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	/*maNCC, tenNCC
	maNCC, diaChi
	maNCC, sdtNCC
	maNCC, email
	tenNCC, diaChi
	tenNCC, sdtNCC
	tenNCC, email
	diaChi, sdtNCC
	diaChi, email
	sdtNCC, email*/
	public void timKiemTheo_maNCC_tenNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_maNCC_diaChi(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_maNCC_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_maNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_tenNCC_diaChi(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_tenNCC_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_tenNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_diaChi_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_diaChi_email(NhaCungCap c, DefaultTableModel dtm_KH);
	public void timKiemTheo_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
	/*
	 * maNCC, tenNCC, diaChi*/
	public void timKiemTheo_maNCC_tenNCC_diaChi(NhaCungCap c, DefaultTableModel dtm_KH);
	/*
	maNCC, tenNCC, sdtNCC*/
	public void timKiemTheo_maNCC_tenNCC_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	//maNCC, tenNCC, email
	public void timKiemTheo_maNCC_tenNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
	//maNCC, diaChi, sdtNCC
	public void timKiemTheo_maNCC_diaChi_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	//maNCC, diaChi, email
	public void timKiemTheo_maNCC_diaChi_email(NhaCungCap c, DefaultTableModel dtm_KH);
	//maNCC, sdtNCC, email
	public void timKiemTheo_maNCC_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
	//tenNCC, diaChi, sdtNCC
	public void timKiemTheo_tenNCC_diaChi_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH);
	//tenNCC, diaChi, email
	public void timKiemTheo_tenNCC_diaChi_email(NhaCungCap c, DefaultTableModel dtm_KH);
	//tenNCC, sdtNCC, email
	public void timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
	//diaChi, sdtNCC, email
	public void timKiemTheo_diaChi_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH);
}
