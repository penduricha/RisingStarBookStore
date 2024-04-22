package interface_Method_Database;

import javax.swing.table.DefaultTableModel;

import entities.KhachHang;

public interface Method_Select_KhachHang 
{
	/*
	 * Lấy tenKH và sdt.
	Lấy tenKH và diaChi.
	Lấy tenKH và gioiTinh.
	Lấy sdt và diaChi.
	Lấy sdt và gioiTinh.
	Lấy diaChi và gioiTinh.
	 */	
	public void timKiemTheo_tenKH_sdt(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_tenKH_diaChi(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_tenKH_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_sdt_diaChi(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_sdt_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_diaChi_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	/*
	 * Lấy tenKH, sdt, và diaChi.
		Lấy tenKH, sdt, và gioiTinh.
		Lấy tenKH, diaChi, và gioiTinh.
		Lấy sdt, diaChi, và gioiTinh.
	 */
	
	public void timKiemTheo_tenKH_sdt_diaChi(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_tenKH_sdt_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_tenKH_diaChi_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public void timKiemTheo_sdt_diaChi_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
}
