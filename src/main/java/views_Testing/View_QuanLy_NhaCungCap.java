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
import dataBase_DAO.DataBase_NhaCungCap;
import entities.KhachHang;
import entities.NhaCungCap;
import javazoom.jl.player.advanced.jlap;

public class View_QuanLy_NhaCungCap extends JFrame implements ActionListener, MouseListener{
	private JPanel pn_Master,pn_Header,pn_QL_NCC;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_QL_NCC,lbl_Title_DSNCC;
	private JLabel lbl_MaNCC,lbl_TenNCC,lbl_SoDienThoai,lbl_Email,lbl_DiaChi;
	private JLabel lbl_txt_MaNCC;
	private JTextField txt_TenNCC,txt_SoDienThoai,txt_Email,txt_DiaChi;
	private JScrollPane scr_DSNCC;
	private Custom_Table tbl_DSNCC;
	private DefaultTableModel dtm_NCC;
	private Custom_Button btn_Them,btn_CapNhat,btn_LamMoi;
	private DataBase_NhaCungCap sqlNhaCungCap=new DataBase_NhaCungCap();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_QuanLy_NhaCungCap frame = new View_QuanLy_NhaCungCap();
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
		
		lbl_Title_QL_NCC = new JLabel("Tìm kiếm nhà cung cấp");
		lbl_Title_QL_NCC.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_QL_NCC.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_QL_NCC.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_QL_NCC);
		
		pn_QL_NCC = new JPanel();
		pn_QL_NCC.setIgnoreRepaint(true);
		pn_QL_NCC.setBackground(Color.white);
		pn_QL_NCC.setLayout(null);
		pn_QL_NCC.setBounds(new Rectangle(30, 150, 2500, 300));
		pn_QL_NCC.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_QL_NCC);
		
		lbl_MaNCC = new JLabel("Mã nhà cung cấp:");
		lbl_MaNCC.setLocation(46, 32);
		lbl_MaNCC.setSize(330, 48);
		lbl_MaNCC.setForeground(Color.black);
		lbl_MaNCC.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NCC.add(lbl_MaNCC);
		
		lbl_TenNCC = new JLabel("Tên nhà cung cấp:");
		lbl_TenNCC.setLocation(780, 32);
		lbl_TenNCC.setSize(380, 48);
		lbl_TenNCC.setForeground(Color.black);
		lbl_TenNCC.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NCC.add(lbl_TenNCC);
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setLocation(1720, 32);
		lbl_SoDienThoai.setSize(260, 48);
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NCC.add(lbl_SoDienThoai);
		
		lbl_Email = new JLabel("Email:");
		lbl_Email.setLocation(50, 132);
		lbl_Email.setSize(125, 48);
		lbl_Email.setForeground(Color.black);
		lbl_Email.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NCC.add(lbl_Email);
		
		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setLocation(780,132);
		lbl_DiaChi.setSize(145, 48);
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NCC.add(lbl_DiaChi);
		
		lbl_txt_MaNCC = new JLabel();
		lbl_txt_MaNCC.setLocation(380, 35);
		lbl_txt_MaNCC.setSize(395, 50);
		lbl_txt_MaNCC.setForeground(Color.black);
		lbl_txt_MaNCC.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lbl_txt_MaNCC.setOpaque(true);
		lbl_txt_MaNCC.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NCC.add(lbl_txt_MaNCC);
		
		txt_TenNCC = new JTextField();
		txt_TenNCC.setLocation(1130, 35);
		txt_TenNCC.setSize(585, 50);
		txt_TenNCC.setForeground(Color.black);
		txt_TenNCC.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_TenNCC.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NCC.add(txt_TenNCC);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setLocation(1985, 35);
		txt_SoDienThoai.setSize(467, 50);
		txt_SoDienThoai.setForeground(Color.black);
		txt_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_SoDienThoai.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NCC.add(txt_SoDienThoai);
		
		txt_Email = new JTextField();
		txt_Email.setLocation(175, 135);
		txt_Email.setSize(600, 50);
		txt_Email.setForeground(Color.black);
		txt_Email.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_Email.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NCC.add(txt_Email);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setLocation(925, 135);
		txt_DiaChi.setSize(1527, 50);
		txt_DiaChi.setForeground(Color.black);
		txt_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_DiaChi.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NCC.add(txt_DiaChi);
		
		
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
		btn_Them.setLocation(2150, 200);
		btn_Them.setSize(300, 80);
		pn_QL_NCC.add(btn_Them);
		
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
		btn_CapNhat.setLocation(1840, 200);
		btn_CapNhat.setSize(300, 80);
		pn_QL_NCC.add(btn_CapNhat);
		
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
		btn_LamMoi.setLocation(1530, 200);
		btn_LamMoi.setSize(300, 80);
		pn_QL_NCC.add(btn_LamMoi);
		
		lbl_Title_DSNCC = new JLabel("Danh sách nhà cung cấp");
		lbl_Title_DSNCC.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSNCC.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSNCC.setBounds(30,450,2500,50);
		pn_Master.add(lbl_Title_DSNCC);
		
		dtm_NCC = new DefaultTableModel(new String[] {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Email","Địa chỉ"},0);
		
		tbl_DSNCC = new Custom_Table(dtm_NCC);
		tbl_DSNCC.align(2,new int[] {2});
		tbl_DSNCC.redrawn_Custom_Table();
		scr_DSNCC = new JScrollPane(tbl_DSNCC);
		scr_DSNCC.setBounds(30,500,2500,875);
		pn_Master.add(scr_DSNCC);
		addAction();
	}
	public void draw_View_TimKiem_SanPham() {
		draw_Header();
	}
	private void addAction()
	{
		sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
		btn_Them.addActionListener(this);
		btn_CapNhat.addActionListener(this);
		btn_Close.addActionListener(this);
		btn_Home.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		btn_Logout.addActionListener(this);
		tbl_DSNCC.addMouseListener(this);
	}
	/*
	 * private void themKhachHang()
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
	 */
	private void themNhaCungCap()
	{
		String tenNCC=txt_TenNCC.getText();
		String sdt=txt_SoDienThoai.getText();
		String diaChi=txt_DiaChi.getText();
		String email=txt_DiaChi.getText();
		try
		{
			NhaCungCap n=new NhaCungCap();
			n.setTenNCC(tenNCC);
			n.setSdtNCC(sdt);
			n.setEmail(email);
			n.setDiaChi(diaChi);
			sqlNhaCungCap.themNhaCungCap(n);
			dtm_NCC.setRowCount(0);
			sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
		}catch(Exception e)
		{
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	private void xoaTrang()
	{
		txt_TenNCC.setText("");
		txt_DiaChi.setText("");
		txt_SoDienThoai.setText("");
		txt_Email.setText("");
		lbl_txt_MaNCC.setText("");
		txt_TenNCC.requestFocus();
		dtm_NCC.setRowCount(0);
		sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
	}
	private void capNhatNhaCungCap()
	{
		int row = tbl_DSNCC.getSelectedRow();
		if(row!=-1)
		{
			String maNCC=lbl_txt_MaNCC.getText();
			String tenNCC=txt_TenNCC.getText();
			String sdt=txt_SoDienThoai.getText();
			String diaChi=txt_DiaChi.getText();
			String email=txt_DiaChi.getText();
			NhaCungCap n=new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email);
			sqlNhaCungCap.capNhatNhaCungCap(n);
			dtm_NCC.setRowCount(0);
			sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
			//cập nhật xong thì bỏ chọn
			tbl_DSNCC.clearSelection();
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o .equals(btn_Close) ) {
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
			int exit = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không ?", "Thông báo.", JOptionPane.YES_NO_OPTION);

	        if (exit == JOptionPane.YES_OPTION) {
	            // Xử lý khi người dùng chọn "Yes"
	        	System.exit(0);
	        } 
		}
		if(o.equals(btn_Them))
		{
			themNhaCungCap();
		}
		if(o.equals(btn_CapNhat))
		{
			capNhatNhaCungCap();
		}
		if(o.equals(btn_LamMoi))
		{
			xoaTrang();
		}
		if(o.equals(btn_Home))
		{
			
		}
	}
	public View_QuanLy_NhaCungCap() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
	/*
	 * int row=tbl_DSKH.getSelectedRow();
		lbl_txt_MaKH.setText(tbl_DSKH.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSKH.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSKH.getValueAt(row, 2).toString());
		cbo_GioiTinh.setSelectedItem(tbl_DSKH.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSKH.getValueAt(row, 4).toString());
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=tbl_DSNCC.getSelectedRow();
		lbl_txt_MaNCC.setText(tbl_DSNCC.getValueAt(row, 0).toString());
		txt_TenNCC.setText(tbl_DSNCC.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSNCC.getValueAt(row, 2).toString());
		txt_Email.setText(tbl_DSNCC.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSNCC.getValueAt(row, 4).toString());
		
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
