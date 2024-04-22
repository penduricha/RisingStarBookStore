package dataBase_DAO;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import customEntities.Custom_ComboBox;

import entities.NhaCungCap;
import interface_Method_Database.Method_NhaCungCap;

public class DataBase_NhaCungCap implements Method_NhaCungCap
{
	Connect con = new Connect();
	//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
	public DataBase_NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public void xuatDanhSachKhachHang(DefaultTableModel dtm_KH) {
		String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n"
				+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				String sdt = rs.getString("sdt");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				KhachHang k = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
				String[] row = { maKH, tenKH, sdt, k.traVeGioiTinh(), diaChi };
				dtm_KH.addRow(row);
			}
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	 */
	@Override
	public void xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC) {
		String sqlSelect = "select*from NhaCungCap\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
			while (rs.next()) {
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String diaChi=rs.getString("diaChi");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				String[] row = {n.getMaNCC(), n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi()};
				dtm_NCC.addRow(row);
			}
			con.con().close();
			con.stmt().close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	@Override
	public boolean themNhaCungCap(NhaCungCap n) 
	{
		try {
			String sqlInsert = "DECLARE @NextIndex INT;\r\n"
					+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT)), 0) + 1 FROM NhaCungCap;\r\n"
					+ "DECLARE @NewMaNCC VARCHAR(20);\r\n"
					+ "SET @NewMaNCC = 'NCC' + CAST(@NextIndex AS VARCHAR);\r\n"
					+ "INSERT [dbo].[NhaCungCap] ([diaChi], [email], [maNCC], [sdtNCC], [tenNCC]) \r\n"
					+ "VALUES (N'"+n.getDiaChi()+"', N'"+n.getEmail()+"', @NewMaNCC, N'"+n.getSdtNCC()+"', N'"+n.getTenNCC()+"');";
			con.stmt().executeUpdate(sqlInsert);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã thêm dữ liệu nhà cung cấp thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	@Override
	public boolean capNhatNhaCungCap(NhaCungCap n) 
	{
		
		String sqlUpdate="UPDATE [dbo].[NhaCungCap] SET tenNCC= ? , sdtNCC= ? ,email= ? ,diaChi= ? WHERE maNCC= ? ";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlUpdate);		    
		    // Gán giá trị cho các tham số
		    preparedStatement.setString(1, n.getTenNCC());
		    preparedStatement.setString(2,n.getSdtNCC());
		    preparedStatement.setString(3, n.getEmail()); // Giới tính, ví dụ: 1 cho nam, 0 cho nữ
		    preparedStatement.setString(4, n.getDiaChi());
		    preparedStatement.setString(5,n.getMaNCC());
		    
		    // Thực hiện câu lệnh UPDATE
		    preparedStatement.executeUpdate();
		    
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu nhà cung cấp thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	@Override
	public void dayComboBoxMaNCC(Custom_ComboBox cbMaNCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dayComboBoxEmail(Custom_ComboBox cbo_Email) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheoMaNCC(String maNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheoTenNCC(String tenNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheoDiaChi(String diaChi, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheoSoDienThoaiNCC(String sdtNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheoEmail(String email, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheoTieuChiKhacMaNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_tenNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_diaChi(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_tenNCC_diaChi(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_tenNCC_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_tenNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_diaChi_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_diaChi_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_tenNCC_diaChi(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_tenNCC_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_tenNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_diaChi_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_diaChi_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_maNCC_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_tenNCC_diaChi_sdtNCC(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_tenNCC_diaChi_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timKiemTheo_diaChi_sdtNCC_email(NhaCungCap c, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		
	}
	
}
