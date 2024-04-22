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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

public class View_TimKiem_KhachHang extends JFrame implements ActionListener, MouseListener{
	private JPanel pn_Master,pn_Header,pn_TK_KH;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_TK_KH,lbl_Title_DSKH;
	private JLabel lbl_MaKH,lbl_HoTen,lbl_SoDienThoai,lbl_DiaChi,lbl_GioiTinh;
	private Custom_ComboBox cbo_MaKH,cbo_HoTen,cbo_SoDienThoai,cbo_DiaChi,cbo_GioiTinh;
	private JScrollPane scr_DSKH;
	private Custom_Table tbl_DSKH;
	private DefaultTableModel dtm_KH;
	private Custom_Button btn_LamMoi,btn_TimKiem;
	private DataBase_KhachHang sqlKhachHang=new DataBase_KhachHang();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_TimKiem_KhachHang frame = new View_TimKiem_KhachHang();
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
		
		lbl_Title_TK_KH = new JLabel("Tìm kiếm khách hàng");
		lbl_Title_TK_KH.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_TK_KH.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_TK_KH.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_TK_KH);
		
		pn_TK_KH = new JPanel();
		pn_TK_KH.setIgnoreRepaint(true);
		pn_TK_KH.setBackground(Color.white);
		pn_TK_KH.setLayout(null);
		pn_TK_KH.setBounds(new Rectangle(30, 150, 2500, 300));
		pn_TK_KH.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_TK_KH);
		
		lbl_MaKH = new JLabel("Mã khách hàng:");
		lbl_MaKH.setLocation(245, 20);
		lbl_MaKH.setSize(300, 48);
		lbl_MaKH.setForeground(Color.black);
		lbl_MaKH.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_KH.add(lbl_MaKH);
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setLocation(880, 20);
		lbl_HoTen.setSize(150, 48);
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_KH.add(lbl_HoTen);
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setLocation(1635, 20);
		lbl_SoDienThoai.setSize(545, 48);
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_KH.add(lbl_SoDienThoai);
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setLocation(245, 135);
		lbl_GioiTinh.setSize(180, 48);
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_KH.add(lbl_GioiTinh);
		
		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setLocation(640,135);
		lbl_DiaChi.setSize(298, 48);
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_KH.add(lbl_DiaChi);
		
		cbo_MaKH = new Custom_ComboBox();
		cbo_MaKH.setLocation(545, 20);
		cbo_MaKH.setSize(325, 50);
		cbo_MaKH.setForeground(Color.black);
		cbo_MaKH.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_MaKH.setColor_Foreground(Color.black);
		cbo_MaKH.setColor_Background(Color.white);
		cbo_MaKH.setColor_Hightlight(Color.white);
		cbo_MaKH.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaKH.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaKH.redraw_Custom_Combobox();
		cbo_MaKH.setRadius(0);
		pn_TK_KH.add(cbo_MaKH);
		
		
		cbo_HoTen = new Custom_ComboBox();
		cbo_HoTen.setLocation(1020, 20);
		cbo_HoTen.setSize(610, 50);
		cbo_HoTen.setForeground(Color.black);
		cbo_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_HoTen.setColor_Foreground(Color.black);
		cbo_HoTen.setColor_Background(Color.white);
		cbo_HoTen.setColor_Hightlight(Color.white);
		cbo_HoTen.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen.redraw_Custom_Combobox();
		pn_TK_KH.add(cbo_HoTen);
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setLocation(1900, 20);
		cbo_SoDienThoai.setSize(355, 50);
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_SoDienThoai.setColor_Foreground(Color.black);
		cbo_SoDienThoai.setColor_Background(Color.white);
		cbo_SoDienThoai.setColor_Hightlight(Color.white);
		cbo_SoDienThoai.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai.redraw_Custom_Combobox();
		pn_TK_KH.add(cbo_SoDienThoai);
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setEditable(false);
		cbo_GioiTinh.setLocation(425, 135);
		cbo_GioiTinh.setSize(210, 50);
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Color.white);
		cbo_GioiTinh.setColor_Hightlight(Color.white);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_GioiTinh.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		pn_TK_KH.add(cbo_GioiTinh);
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setLocation(790, 135);
		cbo_DiaChi.setSize(1465, 50);
		cbo_DiaChi.setForeground(Color.black);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_DiaChi.setColor_Foreground(Color.black);
		cbo_DiaChi.setColor_Background(Color.white);
		cbo_DiaChi.setColor_Hightlight(Color.white);
		cbo_DiaChi.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_DiaChi.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_DiaChi.redraw_Custom_Combobox();
		pn_TK_KH.add(cbo_DiaChi);
		
		
		btn_TimKiem = new Custom_Button();
		btn_TimKiem.setBuffered_Icon("src/main/images/view_image/Search.png");
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setFont(new Font("Inner", Font.BOLD, 40));
		btn_TimKiem.resizeIcon(50,50);
		btn_TimKiem.setRadius(45);
		btn_TimKiem.setOver(true);
		btn_TimKiem.setColor_Foreground(Color.black);
		btn_TimKiem.setColor_Hightlight(Custom_ColorPicker.lavender_ED91FF);
		btn_TimKiem.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_TimKiem.setColor_Over(Color.white);
		btn_TimKiem.setColor_Click(Color.black);
		btn_TimKiem.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_TimKiem.setLocation(1950, 200);
		btn_TimKiem.setSize(300, 80);
		pn_TK_KH.add(btn_TimKiem);
		
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
		btn_LamMoi.setLocation(1600, 200);
		btn_LamMoi.setSize(300, 80);
		pn_TK_KH.add(btn_LamMoi);
		
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
		addDataComboBox();
		addAction();
	}
	private void addAction()
	{
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
		//sqlKhachHang.dayComboBoxMaKH(cbo_MaKH);
		btn_Close.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		btn_Logout.addActionListener(this);
		btn_TimKiem.addActionListener(this);
		btn_Home.addActionListener(this);
		//Them su kien cho comboBox
		cbo_MaKH.addActionListener(this);
		cbo_HoTen.addActionListener(this);
		cbo_DiaChi.addActionListener(this);
		cbo_SoDienThoai.addActionListener(this);
		cbo_GioiTinh.addActionListener(this);
		tbl_DSKH.addMouseListener(this);
		//
	}
	private void addDataComboBox()
	{
		//maKH
		cbo_MaKH.addItem("Chọn");
		sqlKhachHang.dayComboBoxMaKH(cbo_MaKH);
		//gioiTinh
		cbo_GioiTinh.addItem("Chọn");
		cbo_GioiTinh.addItem("Nam");
		cbo_GioiTinh.addItem("Nữ");
		//hoTen
		cbo_HoTen.addItem("Chọn");
		sqlKhachHang.dayComboBoxTenKH(cbo_HoTen);
		//sdt cbo_SoDienThoai
		cbo_SoDienThoai.addItem("Chọn");
		sqlKhachHang.dayComboBoxSDT(cbo_SoDienThoai);
		cbo_DiaChi.addItem("Chọn");
		sqlKhachHang.dayComboBoxDiaChi(cbo_DiaChi);
		
	}
	private void resetComboBox()
	{
		cbo_MaKH.setSelectedItem("Chọn");
		cbo_HoTen.setSelectedItem("Chọn");
		cbo_SoDienThoai.setSelectedItem("Chọn");
		cbo_GioiTinh.setSelectedItem("Chọn");
		cbo_DiaChi.setSelectedItem("Chọn");
		dtm_KH.setRowCount(0);
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
	}
	private boolean gioiTinhBool(String gioiTinh)
	{
		if(gioiTinh.equalsIgnoreCase("Nam"))
			return true;
		return false;
	}
	private void timKiem()
	{
		//String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
		String maKH=(String) cbo_MaKH.getSelectedItem();
		String tenKH=(String) cbo_HoTen.getSelectedItem();
		String gioiTinh=(String) cbo_GioiTinh.getSelectedItem();
		String diaChi=(String) cbo_DiaChi.getSelectedItem();
		String sdt=(String) cbo_SoDienThoai.getSelectedItem();
		if(maKH.equalsIgnoreCase("Chọn")&&
				tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 35));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 33));
			JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin để tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		//Tìm theo MaKH
		if(!maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoMaKH(maKH, dtm_KH);
		}
		//Tìm theo gioiTinh
		if(maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoGioiTinh(gioiTinh, dtm_KH);
		}
		//Tìm theo diaChi
		if(maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&!diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoDiaChi(diaChi, dtm_KH);
		}
		//Tìm theo tên
		if(maKH.equalsIgnoreCase("Chọn")&&!tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoTen(tenKH, dtm_KH);
		}
		
		if(maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoSDT(sdt, dtm_KH);
		}	
		//Tìm theo tenKH và địa chỉ
		if(maKH.equalsIgnoreCase("Chọn")&&!tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&!diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setDiaChi(diaChi);
			sqlKhachHang.timKiemTheo_tenKH_diaChi(k, dtm_KH);
		}
		//Tìm theo tenKH và gioiTinh
		if(maKH.equalsIgnoreCase("Chọn")&&!tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			sqlKhachHang.timKiemTheo_tenKH_gioiTinh(k, dtm_KH);
		}
		//tìm theo tenKH và sdt
		if(maKH.equalsIgnoreCase("Chọn")&&!tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setSdt(sdt);
			sqlKhachHang.timKiemTheo_tenKH_sdt(k, dtm_KH);
		}
		//timKiemTheo_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) 
		if(maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn")&&!diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();			
			k.setSdt(sdt);
			k.setDiaChi(diaChi);
			sqlKhachHang.timKiemTheo_sdt_diaChi(k, dtm_KH);
		}
		//public void timKiemTheo_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH)
		if(maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();			
			k.setSdt(sdt);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			sqlKhachHang.timKiemTheo_sdt_gioiTinh(k, dtm_KH);
		}
		//public void timKiemTheo_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH)
		if(maKH.equalsIgnoreCase("Chọn")&&tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn")&&!diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();			
			k.setDiaChi(diaChi);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			sqlKhachHang.timKiemTheo_sdt_gioiTinh(k, dtm_KH);
		}
		if(maKH.equalsIgnoreCase("Chọn") &&!tenKH.equalsIgnoreCase("Chọn")&&
				gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn") && !diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setDiaChi(diaChi);
			k.setSdt(sdt);
			sqlKhachHang.timKiemTheo_tenKH_sdt_diaChi(k, dtm_KH);
		}
		//timKiemTheo_tenKH_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) 
		if(maKH.equalsIgnoreCase("Chọn") &&!tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn") && diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setSdt(sdt);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			sqlKhachHang.timKiemTheo_tenKH_sdt_gioiTinh(k, dtm_KH);
		}
		//timKiemTheo_sdt_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH)
		if(maKH.equalsIgnoreCase("Chọn") &&tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn") &&! diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setSdt(sdt);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			k.setDiaChi(diaChi);
			sqlKhachHang.timKiemTheo_sdt_diaChi_gioiTinh(k, dtm_KH);
		}
		//Tìm kiếm theo tất cả điều kiện trừ maKH
		if(maKH.equalsIgnoreCase("Chọn") &&!tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn") && !diaChi.equalsIgnoreCase("Chọn"))		
		{
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setDiaChi(diaChi);
			k.setSdt(sdt);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoTieuChiKhacMaKH(k, dtm_KH);
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
			resetComboBox();
		}
		if(o.equals(btn_TimKiem))
		{		
			timKiem();
		}
	}
	public View_TimKiem_KhachHang() {
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
		// TODO Auto-generated method stub
		int row=tbl_DSKH.getSelectedRow();
		String maKH=tbl_DSKH.getValueAt(row, 0).toString();
		String tenKH=tbl_DSKH.getValueAt(row, 1).toString();
		String sdt=tbl_DSKH.getValueAt(row, 2).toString();
		String gioiTinh=tbl_DSKH.getValueAt(row, 3).toString();
		String diaChi=tbl_DSKH.getValueAt(row, 4).toString();	
		cbo_MaKH.setSelectedItem(maKH);
		cbo_HoTen.setSelectedItem(tenKH);
		cbo_GioiTinh.setSelectedItem(gioiTinh);
		cbo_DiaChi.setSelectedItem(diaChi);
		cbo_SoDienThoai.setSelectedItem(sdt);
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

