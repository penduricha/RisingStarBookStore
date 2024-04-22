package list_Array_DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import entities.KhachHang;
import interface_Method_ArrayList.method_ArrayList_KhachHang;

public class KhachHang_DAO implements method_ArrayList_KhachHang
{
	private ArrayList<KhachHang> listKhachHang;

	public ArrayList<KhachHang> getListKhachHang() {
		return listKhachHang;
	}

	public void setListKhachHang(ArrayList<KhachHang> listKhachHang) {
		this.listKhachHang = listKhachHang;
	}

	public KhachHang_DAO() {
		super();
		setListKhachHang(new ArrayList<KhachHang>());
	}
	public boolean themKH(KhachHang k)
	{
		if(!listKhachHang.contains(k))
		{
			listKhachHang.add(k);
			return true;
		}
		return false;
	}
	public KhachHang timKiemKhachHang(String maKH)
	{
		for(KhachHang k:listKhachHang)
		{
			if(k.getMaKH().equalsIgnoreCase(maKH))
				return k;
		}
		return null;
	}
	public boolean xoaKhachHang(String maKHCanXoa)
	{
		KhachHang k=timKiemKhachHang(maKHCanXoa);
		if(k!=null)
		{
			listKhachHang.remove(k);
			return true;
		}
		return false;
	}
	//Xuất dữ liệu bảng theo DiaChi
	public void xuatBangTheo_DiaChi(String diaChi,DefaultTableModel dtm_KH)
	{
		for(KhachHang k: listKhachHang)
		{
			if(k.getDiaChi().equalsIgnoreCase(diaChi))
			{
				String[] row = { k.getMaKH(),k.getTenKH(),k.getSdt(), k.traVeGioiTinh(), k.getDiaChi() };
				dtm_KH.addRow(row);
			}
		}
	}
	@Override
	public void xuatBangTheo_Ten(String tenKH, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		for(KhachHang k: listKhachHang)
		{
			if(k.getTenKH().equalsIgnoreCase(tenKH))
			{
				String[] row = { k.getMaKH(),k.getTenKH(),k.getSdt(), k.traVeGioiTinh(), k.getDiaChi() };
				dtm_KH.addRow(row);
			}
		}
	}

}
