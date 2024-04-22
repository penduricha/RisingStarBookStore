package views_Testing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.AutoCompletionComboBox;

import customEntities.Custom_ComboBox;
import customEntities.Custom_Table;
import customEntities.Custom_Button;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_JLabel;
import customEntities.Custom_ColorPicker;
import customEntities.RoundedCornerBorder;
import dataBase_DAO.DataBase_KhachHang;
import entities.KhachHang;


public class View_QuanLy_KhachHang extends JFrame implements ActionListener, MouseListener
{
	private JPanel pn_Master,pn_Header,pn_QL_KH;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_QL_KH,lbl_Title_DSKH;
	private JLabel lbl_MaKH,lbl_HoTen,lbl_SoDienThoai,lbl_DiaChi,lbl_GioiTinh;
	private Custom_ComboBox cbo_GioiTinh;
	private JTextField txt_HoTen,txt_SoDienThoai,txt_DiaChi;
	private JLabel lbl_txt_MaKH;
	private JScrollPane scr_DSKH;
	private Custom_Table tbl_DSKH;
	private DefaultTableModel dtm_KH;
	private Custom_Button btn_LamMoi,btn_Them,btn_CapNhat;
	//private NhanVien_DAO sqlNhanVien = new NhanVien_DAO();
	private DataBase_KhachHang sqlKhachHang=new DataBase_KhachHang();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_QuanLy_KhachHang frame = new View_QuanLy_KhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setting_View_TimKiem_SanPham() {
		setBounds(new Rectangle(0, 0, 2560, 1400));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2560,1400);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setting_MasterPanel();
	}
	public void setting_MasterPanel() {
		pn_Master = new JPanel();
		setContentPane(pn_Master);
		pn_Master.setIgnoreRepaint(true);
		pn_Master.setBackground(Color.white);
		pn_Master.setLayout(null);
	}
	public void draw_Header() {
		pn_Header = new JPanel();
		pn_Header.setIgnoreRepaint(true);
		pn_Header.setBackground(Custom_ColorPicker.lavender_ED91FF);
		pn_Header.setLayout(null);
		pn_Header.setBounds(new Rectangle(0, 0, 2560, 100));
		pn_Master.add(pn_Header);
		
		picture_Logo = new Custom_JLabel();
		picture_Logo.setBounds(15,10,80,80);
		picture_Logo.setBuffered_Image("src\\main\\images\\view_image\\Logo.png");
		picture_Logo.setRadius((int) (40*3.14));
		picture_Logo.resizeImage(80,80);
		picture_Logo.reconnerImage();
		picture_Logo.setVisible(true);
		pn_Header.add(picture_Logo);
		
		btn_Close = new Custom_Button();
		btn_Close.setBuffered_Icon("src/main/images/view_image/Close.png");
		btn_Close.resizeIcon(70,70);
		btn_Close.setRadius(40);
		btn_Close.setOver(true);
		btn_Close.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_Close.setColor_Over(Color.white);
		btn_Close.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Close.setBounds(2450, 12, 80, 80);
		pn_Header.add(btn_Close);
		btn_Close.addActionListener(this);
		
		btn_Home = new Custom_Button();
		btn_Home.setBuffered_Icon("src/main/images/view_image/Home.png");
		btn_Home.resizeIcon(80,80);
		btn_Home.setRadius(40);
		btn_Home.setOver(true);
		btn_Home.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_Home.setColor_Over(Color.white);
		btn_Home.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Home.setBounds(2350, 12, 80, 80);
		pn_Header.add(btn_Home);
		btn_Home.addActionListener(this);
		
		btn_Logout = new Custom_Button();
		btn_Logout.setBuffered_Icon("src/main/images/view_image/Logout.png");
		
		btn_Logout.setRadius(40);
		btn_Logout.resizeIcon(65,65);
		btn_Logout.setOver(true);
		btn_Logout.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_Logout.setColor_Over(Color.white);
		btn_Logout.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Logout.setBounds(2250, 12, 80, 80);
		pn_Header.add(btn_Logout);
		btn_Logout.addActionListener(this);
		
		lbl_Title_QL_KH = new JLabel("Tìm kiếm khách hàng");
		lbl_Title_QL_KH.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_QL_KH.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_QL_KH.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_QL_KH);
		
		pn_QL_KH = new JPanel();
		pn_QL_KH.setIgnoreRepaint(true);
		pn_QL_KH.setBackground(Color.white);
		pn_QL_KH.setLayout(null);
		pn_QL_KH.setBounds(new Rectangle(30, 150, 2500, 300));
		pn_QL_KH.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_QL_KH);
		
		lbl_MaKH = new JLabel("Mã khách hàng:");
		lbl_MaKH.setLocation(245, 20);
		lbl_MaKH.setSize(300, 48);
		lbl_MaKH.setForeground(Color.black);
		lbl_MaKH.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_KH.add(lbl_MaKH);
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setLocation(880, 20);
		lbl_HoTen.setSize(150, 48);
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_KH.add(lbl_HoTen);
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setLocation(1635, 20);
		lbl_SoDienThoai.setSize(545, 48);
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_KH.add(lbl_SoDienThoai);
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setLocation(245, 135);
		lbl_GioiTinh.setSize(180, 48);
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_KH.add(lbl_GioiTinh);
		
		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setLocation(640,135);
		lbl_DiaChi.setSize(298, 48);
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_KH.add(lbl_DiaChi);
		
		lbl_txt_MaKH = new JLabel();
		lbl_txt_MaKH.setLocation(545, 20);
		lbl_txt_MaKH.setSize(325, 50);
		lbl_txt_MaKH.setForeground(Color.black);
		lbl_txt_MaKH.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lbl_txt_MaKH.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaKH.setOpaque(true);
		lbl_txt_MaKH.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_KH.add(lbl_txt_MaKH);
		
		
		txt_HoTen = new JTextField();
		txt_HoTen.setLocation(1010, 20);
		txt_HoTen.setSize(610, 50);
		txt_HoTen.setForeground(Color.black);
		txt_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_HoTen.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_KH.add(txt_HoTen);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setLocation(1915, 20);
		txt_SoDienThoai.setSize(340, 50);
		txt_SoDienThoai.setForeground(Color.black);
		txt_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_SoDienThoai.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_KH.add(txt_SoDienThoai);
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setEditable(false);
		cbo_GioiTinh.setLocation(425, 135);
		cbo_GioiTinh.setSize(200, 50);
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Color.white);
		cbo_GioiTinh.setColor_Hightlight(Color.white);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_GioiTinh.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		pn_QL_KH.add(cbo_GioiTinh);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setLocation(790, 135);
		txt_DiaChi.setSize(1465, 50);
		txt_DiaChi.setForeground(Color.black);
		txt_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_DiaChi.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_KH.add(txt_DiaChi);
		
		
		btn_Them = new Custom_Button();
		btn_Them.setBuffered_Icon("src/main/images/view_image/Add product.png");
		btn_Them.setText("Thêm");
		btn_Them.setFont(new Font("Inner", Font.BOLD, 40));
		btn_Them.resizeIcon(50,50);
		btn_Them.setRadius(45);
		btn_Them.setOver(true);
		btn_Them.setColor_Foreground(Color.black);
		btn_Them.setColor_Hightlight(Custom_ColorPicker.lavender_ED91FF);
		btn_Them.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_Them.setColor_Over(Color.white);
		btn_Them.setColor_Click(Color.black);
		btn_Them.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Them.setLocation(1950, 200);
		btn_Them.setSize(300, 80);
		pn_QL_KH.add(btn_Them);
		
		btn_CapNhat = new Custom_Button();
		btn_CapNhat.setBuffered_Icon("src/main/images/view_image/Update.png");
		btn_CapNhat.setText("Cập nhật");
		btn_CapNhat.setFont(new Font("Inner", Font.BOLD, 40));
		btn_CapNhat.resizeIcon(50,50);
		btn_CapNhat.setRadius(45);
		btn_CapNhat.setOver(true);
		btn_CapNhat.setColor_Foreground(Color.black);
		btn_CapNhat.setColor_Hightlight(Custom_ColorPicker.lavender_ED91FF);
		btn_CapNhat.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_CapNhat.setColor_Over(Color.white);
		btn_CapNhat.setColor_Click(Color.black);
		btn_CapNhat.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_CapNhat.setLocation(1600, 200);
		btn_CapNhat.setSize(300, 80);
		pn_QL_KH.add(btn_CapNhat);
		
		btn_LamMoi = new Custom_Button();
		btn_LamMoi.setBuffered_Icon("src/main/images/view_image/Eraser.png");
		btn_LamMoi.setText("Làm mới");
		btn_LamMoi.setFont(new Font("Inner", Font.BOLD, 40));
		btn_LamMoi.resizeIcon(50,50);
		btn_LamMoi.setRadius(45);
		btn_LamMoi.setOver(true);
		btn_LamMoi.setColor_Foreground(Color.black);
		btn_LamMoi.setColor_Hightlight(Custom_ColorPicker.lavender_ED91FF);
		btn_LamMoi.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_LamMoi.setColor_Over(Color.white);
		btn_LamMoi.setColor_Click(Color.black);
		btn_LamMoi.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_LamMoi.setLocation(1250, 200);
		btn_LamMoi.setSize(300, 80);
		pn_QL_KH.add(btn_LamMoi);
		
		lbl_Title_DSKH = new JLabel("Danh sách khách hàng");
		lbl_Title_DSKH.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSKH.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSKH.setBounds(30,450,2500,50);
		pn_Master.add(lbl_Title_DSKH);
		
		dtm_KH = new DefaultTableModel(new String[] {"Mã khách hàng","Họ tên","Số điện thoại","Giới Tính","Địa chỉ"},0);
		/*
		for (int i = 0; i < 1000; i++) {
			dtm_KH.addRow(new String[] {"KH0001","Mr.Bean","0398785415","Nam","Ngoài hành tinh"});
		}*/
		
		tbl_DSKH = new Custom_Table(dtm_KH);
		tbl_DSKH.align(2,new int[] {2});
		tbl_DSKH.redrawn_Custom_Table();
		scr_DSKH = new JScrollPane(tbl_DSKH);
		scr_DSKH.setBounds(30,500,2500,875);
		pn_Master.add(scr_DSKH);
		addAction();
		
	}
	private void addAction()
	{
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
		btn_Them.addActionListener(this);
		btn_Logout.addActionListener(this);
		btn_CapNhat.addActionListener(this);
		btn_Close.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		btn_Home.addActionListener(this);
		cbo_GioiTinh.addItem("Chọn");
		cbo_GioiTinh.addItem("Nam");
		cbo_GioiTinh.addItem("Nữ");
		cbo_GioiTinh.addActionListener(this);
		//tbl_DSKH.getValueAt(row, 2).toString()
		tbl_DSKH.addMouseListener(this);
	}
	/*
	private boolean kiemTraRangBuoc()
	{
		String tenKH=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		
	}*/
	private void xoaTrang()
	{
		lbl_txt_MaKH.setText("");
		txt_HoTen.setText("");
		txt_SoDienThoai.setText("");
		txt_DiaChi.setText("");
		cbo_GioiTinh.setSelectedItem("Chọn");
		dtm_KH.setRowCount(0);
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
	}
	/*
	 * try 
		{
			HangHoaKho h=new HangHoaKho(maHangHoa, tenHangHoa,dateSanXuat.getDate(), dateHetHan.getDate(), giaCaDouble, soLuongInt);
			if (dao.themHangHoaKho(h)) 
			{
				String[] row = {maHangHoa,tenHangHoa,dateSanXuat.getDate().toString(),dateHetHan.getDate().toString(),Double.toString(giaCaDouble),soLuong+""};
				tableModel.addRow(row);
				sqlHangHoaKho.themHangHoaKho(h);
				resetField();			
			}else 
			{
				JOptionPane.showMessageDialog(null, "Hàng hoá trùng nhau.");
				txtMaHangHoa.selectAll();
				txtMaHangHoa.requestFocus();
			}
		} catch (Exception ex) 
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	 */
	//KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String diaChi)
	private boolean gioiTinhBool(String gioiTinh)
	{
		if(gioiTinh.equalsIgnoreCase("Nam"))
			return true;
		return false;
	}
	private boolean validString(String input,String pattern) {
		 // Regex pattern: Tên viết hoa chữ cái đầu tiên của mỗi từ sau dấu cách, tối đa 30 ký tự
		//String pattern = "^(?:[A-Z][a-z\\p{L}]*\\s?){1,5}$"; // Có thể có tối đa 5 từ, mỗi từ tối đa 30 ký tự

		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(input);

		return matcher.matches();

	}
	private boolean kiemTraRangBuoc()
	{
		String tenKH=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
		if(tenKH.trim().equals("")||diaChi.trim().equals("")||sdt.trim().equals(""))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, "Vui lòng nhập hết dữ liệu.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_HoTen.requestFocus();
	        return false;
		}
		if(gioiTinh.equalsIgnoreCase("Chọn"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        //JOptionPane.showMessageDialog(null, "Hãy cẩn thận khi thực hiện thao tác này.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        //JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.", "Warning", JOptionPane.ERROR_MESSAGE);
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
		}
		if(validString(tenKH, "^(?:[A-Z][a-z\\\\p{L}]*\\\\s?){1,5}$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, "Họ và tên không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_HoTen.requestFocus();
	        return false;
		}
		if(!sdt.matches("^0[0-9]{1,9}$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_SoDienThoai.requestFocus();
	        return false;
		}
		//^[a-zA-Z0-9 ]+$
		if(!diaChi.matches("^[\\p{L}0-9 ]+$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ do có kí tự đặc biệt.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_DiaChi.requestFocus();
	        return false;
		}
		return true;
		
	}
	private void themKhachHang()
	{
		String tenKH=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
		
		try
		{
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setDiaChi(diaChi);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			k.setSdt(sdt);
			sqlKhachHang.themKhachHang(k);
			dtm_KH.setRowCount(0);
			sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
			xoaTrang();
		}catch(Exception e)
		{
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	/*
	 * private void xoaActions() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int maNV = Integer.parseInt((String) table.getModel().getValueAt(row, 0));
			int kTra = JOptionPane.showConfirmDialog(this, "Chắc chắn xoá không", "Chú ý", JOptionPane.YES_NO_OPTION);
			if (kTra == JOptionPane.YES_OPTION) {
				if (dao.xoaNhanVien(maNV))
					tableModel.removeRow(row);
			}
		}
	}
	 */
	private void capNhatKhachHang()
	{
		int row = tbl_DSKH.getSelectedRow();
		if(row!=-1)
		{
			String maKH=lbl_txt_MaKH.getText();
			String tenKH=txt_HoTen.getText();
			String diaChi=txt_DiaChi.getText();
			String sdt=txt_SoDienThoai.getText();
			String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
			KhachHang k=new KhachHang(maKH, tenKH, sdt, gioiTinhBool(gioiTinh), diaChi);
			sqlKhachHang.capNhatKhachHang(k);
			dtm_KH.setRowCount(0);
			sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
			//cập nhật xong thì bỏ chọn
			tbl_DSKH.clearSelection();
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void draw_View_TimKiem_SanPham() {
		draw_Header();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o .equals(btn_Close) ) 
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
			int exit = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không ?", "Thông báo.", JOptionPane.YES_NO_OPTION);

	        if (exit == JOptionPane.YES_OPTION) {
	            // Xử lý khi người dùng chọn "Yes"
	        	System.exit(0);
	        } 	
		}
		if(o.equals(btn_LamMoi))
		{
			xoaTrang();
			txt_HoTen.requestFocus();
		}
		if(o.equals(btn_Them))
		{
			if(kiemTraRangBuoc())
				themKhachHang();
		}
		if(o.equals(btn_CapNhat))
		{
			if(kiemTraRangBuoc())
				capNhatKhachHang();
		}
		//if(o == btn)
	}
	public View_QuanLy_KhachHang() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
	/*
	 * public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 0).toString());// lay dong dang chon tren table
		txtHo.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
		radNu.setSelected(false);
		if (table.getValueAt(row, 3).toString().equalsIgnoreCase("true"))
			radNu.setSelected(true);
		txtTuoi.setText(table.getValueAt(row, 4).toString());
		txtTienLuong.setText(table.getValueAt(row, 5).toString());
	}
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=tbl_DSKH.getSelectedRow();
		lbl_txt_MaKH.setText(tbl_DSKH.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSKH.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSKH.getValueAt(row, 2).toString());
		cbo_GioiTinh.setSelectedItem(tbl_DSKH.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSKH.getValueAt(row, 4).toString());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
