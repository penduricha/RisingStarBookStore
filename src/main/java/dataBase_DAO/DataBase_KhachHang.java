package dataBase_DAO;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import customEntities.Custom_ComboBox;
import entities.KhachHang;
import interface_Method_Database.Method_Select_KhachHang;
import list_Array_DAO.KhachHang_DAO;

public class DataBase_KhachHang implements Method_Select_KhachHang {
	private Connect con = new Connect();
	KhachHang_DAO listKhachHang_DAO=new KhachHang_DAO();
	public DataBase_KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public void xuatDanhSachHangHoaKho(DefaultTableModel tableModel) { String
	 * sqlSelect="Select*from HangHoaKho ORDER BY tenHangHoa;"; try { ResultSet
	 * rs=con.resultSet(sqlSelect); while(rs.next()) { String
	 * maHangHoa=rs.getString("maHangHoa"); String
	 * tenHangHoa=rs.getString("tenHangHoa"); Date
	 * ngaySanXuat=rs.getDate("ngaySanXuat"); //LocalDate
	 * ngaySanXuatLocalDate=ngaySanXuat.toInstant().atZone(ZoneId.systemDefault()).
	 * toLocalDate(); Date ngayHetHan=rs.getDate("ngayHetHan"); //LocalDate
	 * ngayHetHanLocalDate=ngayHetHan.toInstant().atZone(ZoneId.systemDefault()).
	 * toLocalDate(); double giaCa=rs.getDouble("giaCa"); int
	 * soLuong=rs.getInt("soLuong"); HangHoaKho h=new HangHoaKho(maHangHoa,
	 * tenHangHoa, ngaySanXuat, ngayHetHan, giaCa, soLuong); //String[] row=
	 * {h.getMaHangHoa(),h.getTenHangHoa(),dateFormatter.format(h.
	 * getNgaySanXuatLocalDate()),dateFormatter.format(h.getNgayHetHanLocalDate()),
	 * Double.toString(giaCa),Integer.toString(soLuong)}; String[] row=
	 * {h.getMaHangHoa(),h.getTenHangHoa(),ngaySanXuat.toString(),ngayHetHan.
	 * toString(),Double.toString(giaCa),Integer.toString(soLuong)};
	 * tableModel.addRow(row); } con.con().close(); con.stmt().close();
	 * }catch(SQLException e) { e.printStackTrace();
	 * JOptionPane.showMessageDialog(null, e.getMessage()); } }
	 * 
	 */
	public void xuatDanhSachKhachHang(DefaultTableModel dtm_KH) {
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

	/*
	 * public void themHangHoaKho(HangHoaKho h) { try { String sqlInsert =
	 * "insert into HangHoaKho(maHangHoa,tenHangHoa,ngaySanXuat,ngayHetHan,giaCa,soLuong) \r\n"
	 * + "values ('" + h.getMaHangHoa() + "','" + h.getTenHangHoa()+ "','" +
	 * h.getNgaySanXuatLocalDate() + "','" + h.getNgayHetHanLocalDate() + "'," +
	 * h.getGiaCa() + "," + h.getSoLuong() + ")";
	 * con.stmt().executeUpdate(sqlInsert); JOptionPane.showMessageDialog(null,
	 * "Hàng hoá với mã là "+h.getMaHangHoa()+" đã được thêm vào kho.");
	 * 
	 * } catch (SQLException e) { e.printStackTrace();
	 * JOptionPane.showMessageDialog(null, e.getMessage()); } }
	 */
	public boolean themKhachHang(KhachHang k) {

		try {
			String sqlInsert="DECLARE @NextIndex INT;\r\n"
					+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT)), 0) + 1 FROM KhachHang;\r\n"
					+ "DECLARE @NewMaKH VARCHAR(20);\r\n"
					+ "SET @NewMaKH = 'KH' + CAST(@NextIndex AS VARCHAR);\r\n"
					+ "INSERT [dbo].[KhachHang] ([gioiTinh], [diaChi], [maKH], [sdt], [tenKH]) "
					+ "VALUES ("+k.traGioiTinhThanhInt()+", N'"+k.getDiaChi()+"', @NewMaKH, N'"+k.getSdt()+"', N'"+k.getTenKH()+"')";
			
			con.stmt().executeUpdate(sqlInsert);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã thêm dữ liệu khách hàng thành công.", "Thông báo",
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

	/*
	 * public void capNhatHangHoaKho(HangHoaKho h) { String
	 * sqlUpdate="UPDATE HangHoaKho\r\n" +
	 * "		SET maHangHoa='"+h.getMaHangHoa()+"',\r\n" +
	 * "		tenHangHoa='"+h.getTenHangHoa()+"',\r\n" +
	 * "		ngaySanXuat='"+h.getNgaySanXuatLocalDate()+"',\r\n" +
	 * "		ngayHetHan='"+h.getNgayHetHanLocalDate()+"',\r\n" +
	 * "		giaCa="+h.getGiaCa()+",\r\n" +
	 * "		soLuong="+h.getSoLuong()+"\r\n" +
	 * "		WHERE maHangHoa='"+h.getMaHangHoa()+"';"; try {
	 * 
	 * con.stmt().executeUpdate(sqlUpdate); JOptionPane.showMessageDialog(null,
	 * "Hàng hoá với mã là "+h.getMaHangHoa()+" đã được cập nhật."); } catch
	 * (Exception e) { e.printStackTrace(); JOptionPane.showMessageDialog(null,
	 * e.getMessage()); }
	 * 
	 * }
	 */
	public boolean capNhatKhachHang(KhachHang k) {
		/*
		String sqlUpdate = "UPDATE [dbo].[KhachHang]\r\n" + "SET [tenKH] = '" + k.getTenKH() + "', [sdt] = '" + k.getSdt()
				+ "', [gioiTinh] = " + k.traGioiTinhThanhInt() + ", [diaChi] = '" + k.getDiaChi() + "'\r\n"
				+ "WHERE [maKH] = '" + k.getMaKH() + "';";*/
		String sqlUpdate = "UPDATE [dbo].[KhachHang] SET tenKH = ?, sdt = ?, gioiTinh = ?, diaChi = ? WHERE maKH = ?";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlUpdate);
		    
		    // Gán giá trị cho các tham số
		    preparedStatement.setString(1, k.getTenKH());
		    preparedStatement.setString(2, k.getSdt());
		    preparedStatement.setInt(3, k.traGioiTinhThanhInt()); // Giới tính, ví dụ: 1 cho nam, 0 cho nữ
		    preparedStatement.setString(4, k.getDiaChi());
		    preparedStatement.setString(5,k.getMaKH());

		    // Thực hiện câu lệnh UPDATE
		    preparedStatement.executeUpdate();
		    
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu khách hàng thành công.", "Thông báo",
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
	//Đẩy lên combobox
	public void dayComboBoxMaKH(Custom_ComboBox cbMaKH) {
		String sqlSelectMaKH = "SELECT maKH\r\n" + "FROM KhachHang\r\n"
				+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectMaKH);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				cbMaKH.addItem(maKH);
				// stringList.add(maKH);
				cbMaKH.getMyVector().add(maKH);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void dayComboBoxTenKH(Custom_ComboBox cbo_HoTen) {
		String sqlSelectTenKH = "SELECT tenKH\r\n" + "FROM KhachHang\r\n" + "ORDER BY tenKH ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectTenKH);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String tenKH = rs.getString("tenKH");
				cbo_HoTen.addItem(tenKH);
				cbo_HoTen.getMyVector().add(tenKH);
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

	public void dayComboBoxSDT(Custom_ComboBox cbo_SoDienThoai) {
		String sqlSelectSDT = "SELECT sdt\r\n" + "FROM KhachHang\r\n" + "ORDER BY sdt ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectSDT);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String sdt = rs.getString("sdt");
				cbo_SoDienThoai.addItem(sdt);
				cbo_SoDienThoai.getMyVector().add(sdt);
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

	public void dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) {
		String sqlSelectDiaChi = "SELECT diaChi\r\n" + "FROM KhachHang\r\n" + "ORDER BY diaChi ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectDiaChi);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String diaChi = rs.getString("diaChi");
				cbo_DiaChi.addItem(diaChi);
				cbo_DiaChi.getMyVector().add(diaChi);
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
	//TÌM KIẾM 1 Tiêu Chí
	public void timKiemTheoMaKH(String maKHCanTruyVan, DefaultTableModel dtm_KH) {
		String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n" + "WHERE maKH='" + maKHCanTruyVan + "';";
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

	private int chuyenGioiTinhThanhInt(String gioiTinh) {
		if (gioiTinh.equalsIgnoreCase("Nam"))
			return 1;
		if (gioiTinh.equalsIgnoreCase("Nữ"))
			return 0;
		return -1;
	}

	public void timKiemTheoGioiTinh(String gioiTinhCanTruyVan, DefaultTableModel dtm_KH) {
		String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n" + "WHERE gioiTinh="
				+ chuyenGioiTinhThanhInt(gioiTinhCanTruyVan) + "\r\n"
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
	//Tìm Kiếm theo địa chỉ
	public void timKiemTheoDiaChi(String diaChiCanTruyVan, DefaultTableModel dtm_KH) 
	{
		//Lấy hết data KhachHang
		String sqlSelect = "select * from [dbo].[KhachHang]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
		try {
			//List<KhachHang> listKhachHang_DAO=new ArrayList<>();
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
				listKhachHang_DAO.themKH(k);
			}
			listKhachHang_DAO.xuatBangTheo_DiaChi(diaChiCanTruyVan, dtm_KH);
			
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void timKiemTheoTen(String tenCanTruyVan, DefaultTableModel dtm_KH) {
		String sqlSelect = "select * from [dbo].[KhachHang]\r\n"
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
				listKhachHang_DAO.themKH(k);
			}
			listKhachHang_DAO.xuatBangTheo_Ten(tenCanTruyVan, dtm_KH);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void timKiemTheoSDT(String sdtTruyVan, DefaultTableModel dtm_KH) {
		String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n" + "WHERE sdt='" + sdtTruyVan + "'\r\n"
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
	//Tìm kiếm khách hàng khác maKH
	public void timKiemTheoTieuChiKhacMaKH(KhachHang k, DefaultTableModel dtm_KH) {
		String sqlSelect = "select * from [dbo].[KhachHang]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			List<KhachHang> listKH=new ArrayList<>();
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				String sdt = rs.getString("sdt");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				KhachHang khachHang = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
				//String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
				listKH.add(khachHang);
			}
			for(KhachHang kh:listKH)
			{
				if(kh.getTenKH().equalsIgnoreCase(k.getTenKH())&&
						kh.getSdt().equalsIgnoreCase(k.getSdt())&&
							kh.isGioiTinh()==k.isGioiTinh()
								&& kh.getDiaChi().equalsIgnoreCase(k.getDiaChi()))
						
				{
					String[] row = { kh.getMaKH(),kh.getTenKH(),kh.getSdt(), kh.traVeGioiTinh(), kh.getDiaChi()};
					dtm_KH.addRow(row);
				}
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

	/*
	 * SELECT * FROM KhachHang WHERE tenKH='Van Minh' AND sdt='0976646635';
	 * TÌM CHI TIẾT CỤ THỂ
	 */
	@Override
	public void timKiemTheo_tenKH_sdt(KhachHang k, DefaultTableModel dtm_KH) 
	{
		String sqlSelect="select * from [dbo].[KhachHang]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			List<KhachHang> listKH=new ArrayList<>();
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				String sdt = rs.getString("sdt");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				KhachHang khachHang = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
				listKH.add(khachHang);
			}
			for(KhachHang kh:listKH)
			{
				if(kh.getTenKH().equalsIgnoreCase(k.getTenKH())&&
						kh.getSdt().equalsIgnoreCase(k.getSdt()))
						
				{
					String[] row = { kh.getMaKH(),kh.getTenKH(),kh.getSdt(), kh.traVeGioiTinh(), kh.getDiaChi()};
					dtm_KH.addRow(row);
				}
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
	/*
	 * SELECT *
	FROM KhachHang
	WHERE 
	tenKH='Van Minh'
	AND diaChi='1 Os street';
	 */
	@Override
	public void timKiemTheo_tenKH_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND diaChi = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getTenKH());
	        preparedStatement.setString(2, k.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	/*
	 * SELECT *
	FROM KhachHang
	WHERE 
	tenKH='Van Minh'
	AND gioiTinh=1;
	 */
	@Override
	public void timKiemTheo_tenKH_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getTenKH());
	        preparedStatement.setBoolean(2, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	/*Theo sdt và diaChi
	 * 
	 */
	@Override
	public void timKiemTheo_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE sdt = ? AND diaChi = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getSdt());
	        preparedStatement.setString(2, k.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE sdt = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getSdt());
	        preparedStatement.setBoolean(2, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	//Tìm kiếm theo địa chỉ giới tính
	@Override
	public void timKiemTheo_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE diaChi = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getDiaChi());
	        preparedStatement.setBoolean(2, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}



	@Override
	public void timKiemTheo_tenKH_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND sdt = ? AND diaChi = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getTenKH());
	        preparedStatement.setString(2, k.getSdt());
	        preparedStatement.setString(3, k.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	@Override
	public void timKiemTheo_tenKH_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND sdt = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getTenKH());
	        preparedStatement.setString(2, k.getSdt());
	        preparedStatement.setBoolean(3, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	@Override
	public void timKiemTheo_tenKH_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND diaChi = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getTenKH());
	        preparedStatement.setString(2, k.getDiaChi());
	        preparedStatement.setBoolean(3, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}



	@Override
	public void timKiemTheo_sdt_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
	    String sqlSelect = "SELECT * FROM KhachHang WHERE sdt = ? AND diaChi = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getSdt());
	        preparedStatement.setString(2, k.getDiaChi());
	        preparedStatement.setBoolean(3, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH = rs.getString("maKH");
	            String tenKH = rs.getString("tenKH");
	            String sdt = rs.getString("sdt");
	            boolean gioiTinh = rs.getBoolean("gioiTinh");
	            String diaChi = rs.getString("diaChi");
	            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
	            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
	            dtm_KH.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


}
