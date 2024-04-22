package views_Testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.AutoCompletionComboBox;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_ComboBox;
import customEntities.Custom_Table;
import customEntities.DateLabelFormatter;
import customEntities.Custom_Button;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_JLabel;
import customEntities.Custom_ColorPicker;
import customEntities.RoundedCornerBorder;
import customEntities.ScaledImg;

public class View_TimKiem_NhanVien extends JFrame implements ActionListener{
	private JPanel pn_Master,pn_Header,pn_TK_NV;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_TK_NV,lbl_Title_DSNV;
	private JLabel lbl_MaNV,lbl_HoTen,lbl_ChucVu,lbl_MatKhau,lbl_NgaySinh,lbl_GioiTinh,lbl_DiaChi,lbl_CCCD,lbl_SoDienThoai;
	private Custom_ComboBox cbo_MaNV,cbo_HoTen,cbo_ChucVu,cbo_GioiTinh,cbo_DiaChi,cbo_CCCD,cbo_SoDienThoai;
	private JLabel lbl_txt_MatKhau;
	private Custom_ComboBox cbo_Ngay;
	private Custom_ComboBox cbo_Thang;
	private Custom_ComboBox cbo_Nam;
	private JDateChooser dcr_NgaySinh;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_JLabel lbl_hinhAnhNV;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSNV;
	private DefaultTableModel dtm_NV;
	private Custom_Button btn_XoaTrang,btn_TimKiem;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_TimKiem_NhanVien frame = new View_TimKiem_NhanVien();
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
		
		lbl_Title_TK_NV = new JLabel("Tìm kiếm nhân viên");
		lbl_Title_TK_NV.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_TK_NV.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_TK_NV.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_TK_NV);
		
		pn_TK_NV = new JPanel();
		pn_TK_NV.setIgnoreRepaint(true);
		pn_TK_NV.setBackground(Color.white);
		pn_TK_NV.setLayout(null);
		pn_TK_NV.setBounds(new Rectangle(30, 150, 2500, 500));
		pn_TK_NV.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_TK_NV);
		
		lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setLocation(20, 52);
		lbl_MaNV.setSize(298, 48);
		lbl_MaNV.setForeground(Color.black);
		lbl_MaNV.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_MaNV);
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setLocation(20, 132);
		lbl_HoTen.setSize(298, 48);
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_HoTen);
		
		lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setLocation(20, 212);
		lbl_ChucVu.setSize(298, 48);
		lbl_ChucVu.setForeground(Color.black);
		lbl_ChucVu.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_ChucVu);
		
		lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setLocation(20, 292);
		lbl_MatKhau.setSize(298, 48);
		lbl_MatKhau.setForeground(Color.black);
		lbl_MatKhau.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_MatKhau);
		
		lbl_NgaySinh = new JLabel("Ngày sinh:");
		lbl_NgaySinh.setLocation(925, 52);
		lbl_NgaySinh.setSize(298, 48);
		lbl_NgaySinh.setForeground(Color.black);
		lbl_NgaySinh.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_NgaySinh);
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setLocation(925, 132);
		lbl_GioiTinh.setSize(298, 48);
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_GioiTinh);

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setLocation(925, 212);
		lbl_DiaChi.setSize(298, 48);
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_DiaChi);
		
		lbl_CCCD = new JLabel("CCCD:");
		lbl_CCCD.setLocation(1760, 52);
		lbl_CCCD.setSize(298, 48);
		lbl_CCCD.setForeground(Color.black);
		lbl_CCCD.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_CCCD);
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setLocation(1760, 132);
		lbl_SoDienThoai.setSize(298, 48);
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NV.add(lbl_SoDienThoai);
		
		
		cbo_MaNV = new Custom_ComboBox();
		cbo_MaNV.setLocation(318, 50);
		cbo_MaNV.setSize(350, 50);
		cbo_MaNV.setForeground(Color.black);
		cbo_MaNV.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_MaNV.setColor_Foreground(Color.black);
		cbo_MaNV.setColor_Background(Color.white);
		cbo_MaNV.setColor_Hightlight(Color.white);
		cbo_MaNV.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaNV.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaNV.redraw_Custom_Combobox();
		cbo_MaNV.setRadius(0);
		pn_TK_NV.add(cbo_MaNV);
		
		
		cbo_HoTen = new Custom_ComboBox();
		cbo_HoTen.setLocation(318, 130);
		cbo_HoTen.setSize(350, 50);
		cbo_HoTen.setForeground(Color.black);
		cbo_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_HoTen.setColor_Foreground(Color.black);
		cbo_HoTen.setColor_Background(Color.white);
		cbo_HoTen.setColor_Hightlight(Color.white);
		cbo_HoTen.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_HoTen);
		
		cbo_ChucVu = new Custom_ComboBox();
		cbo_ChucVu.setEditable(false);
		cbo_ChucVu.setLocation(318, 210);
		cbo_ChucVu.setSize(350, 50);
		cbo_ChucVu.setForeground(Color.black);
		cbo_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_ChucVu.setColor_Foreground(Color.black);
		cbo_ChucVu.setColor_Background(Color.white);
		cbo_ChucVu.setColor_Hightlight(Color.white);
		cbo_ChucVu.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_ChucVu.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_ChucVu.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_ChucVu);
		
		lbl_txt_MatKhau = new JLabel();
		lbl_txt_MatKhau.setLocation(318, 290);
		lbl_txt_MatKhau.setSize(350, 50);
		lbl_txt_MatKhau.setForeground(Color.black);
		lbl_txt_MatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lbl_txt_MatKhau.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MatKhau.setOpaque(true);
		lbl_txt_MatKhau.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_TK_NV.add(lbl_txt_MatKhau);
		
		String[] string_NgayTrongThang = new String[31];
		for (int i = 0; i < 31; i++) {
			string_NgayTrongThang[i] = String.format("%02d",i+1);
		}
		cbo_Ngay = new Custom_ComboBox(string_NgayTrongThang);
		cbo_Ngay.setEditable(false);
		cbo_Ngay.setLocation(1150, 50);
		cbo_Ngay.setSize(100, 50);
		cbo_Ngay.setForeground(Color.black);
		cbo_Ngay.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_Ngay.setColor_Foreground(Color.black);
		cbo_Ngay.setColor_Background(Color.white);
		cbo_Ngay.setColor_Hightlight(Color.white);
		cbo_Ngay.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_Ngay.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_Ngay.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_Ngay);
		
		String[] string_ThangTrongNam = new String[12];
		for (int i = 0; i < 12; i++) {
			string_ThangTrongNam[i] = String.format("%02d",i+1);
		}
		cbo_Thang = new Custom_ComboBox(string_ThangTrongNam);
		cbo_Thang.setEditable(false);
		cbo_Thang.setLocation(1260, 50);
		cbo_Thang.setSize(100, 50);
		cbo_Thang.setForeground(Color.black);
		cbo_Thang.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_Thang.setColor_Foreground(Color.black);
		cbo_Thang.setColor_Background(Color.white);
		cbo_Thang.setColor_Hightlight(Color.white);
		cbo_Thang.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_Thang.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_Thang.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_Thang);
		
		String[] string_Nam = new String[1500];
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		for (int i = 0; i < 1500; i++) {
			string_Nam[i] = String.format("%04d",namHienTai-i);
		}
		cbo_Nam = new Custom_ComboBox(string_Nam);
		cbo_Nam.setEditable(false);
		cbo_Nam.setLocation(1370, 50);
		cbo_Nam.setSize(140, 50);
		cbo_Nam.setForeground(Color.black);
		cbo_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_Nam.setColor_Foreground(Color.black);
		cbo_Nam.setColor_Background(Color.white);
		cbo_Nam.setColor_Hightlight(Color.white);
		cbo_Nam.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_Nam.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_Nam.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_Nam);
		
		/*
		dcr_NgaySinh = new JDateChooser ();
		try {
			bfi_ChonNgay = ImageIO.read(new File("src\\main\\images\\view_image\\Calendar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bfi_ChonNgay = Custom_Function.resize(bfi_ChonNgay, 50, 50);
		dcr_NgaySinh.setIcon (new ImageIcon(bfi_ChonNgay));
		dcr_NgaySinh.getCalendarButton().setBackground (Custom_ColorPicker.lavender_ED91FF);
		dcr_NgaySinh.setLocation(1150,50); 
		dcr_NgaySinh.setSize(350, 50);
		ftf_NgaySinh = (JFormattedTextField) dcr_NgaySinh.getComponent(1);
		ftf_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		ftf_NgaySinh.setPreferredSize(new Dimension(300,50));
		ftf_NgaySinh.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		ftf_NgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		dcr_NgaySinh.getComponent(0).setPreferredSize(new Dimension(50,50));
		dcr_NgaySinh.getJCalendar().setPreferredSize (new Dimension (dcr_NgaySinh.getWidth(), dcr_NgaySinh.getWidth()));
		dcr_NgaySinh.setDateFormatString("dd-MM-yyyy");
		pn_TK_NV.add(dcr_NgaySinh);
		*/
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setEditable(false);
		cbo_GioiTinh.setLocation(1150, 130);
		cbo_GioiTinh.setSize(360, 50);
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Color.white);
		cbo_GioiTinh.setColor_Hightlight(Color.white);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_GioiTinh.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_GioiTinh.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_GioiTinh);
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setLocation(1150, 210);
		cbo_DiaChi.setSize(1240, 50);
		cbo_DiaChi.setForeground(Color.black);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_DiaChi.setColor_Foreground(Color.black);
		cbo_DiaChi.setColor_Background(Color.white);
		cbo_DiaChi.setColor_Hightlight(Color.white);
		cbo_DiaChi.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_DiaChi.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_DiaChi.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_DiaChi);
		
		cbo_CCCD = new Custom_ComboBox();
		cbo_CCCD.setLocation(2040, 50);
		cbo_CCCD.setSize(350, 50);
		cbo_CCCD.setForeground(Color.black);
		cbo_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_CCCD.setColor_Foreground(Color.black);
		cbo_CCCD.setColor_Background(Color.white);
		cbo_CCCD.setColor_Hightlight(Color.white);
		cbo_CCCD.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_CCCD.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_CCCD.redraw_Custom_Combobox();
		pn_TK_NV.add(cbo_CCCD);
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setLocation(2040, 130);
		cbo_SoDienThoai.setSize(350, 50);
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_SoDienThoai.setColor_Foreground(Color.black);
		cbo_SoDienThoai.setColor_Background(Color.white);
		cbo_SoDienThoai.setColor_Hightlight(Color.white);
		cbo_SoDienThoai.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai.redraw_Custom_Combobox();
		cbo_SoDienThoai.setRadius(0);
		pn_TK_NV.add(cbo_SoDienThoai);
		
		
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
		btn_TimKiem.setLocation(2090, 370);
		btn_TimKiem.setSize(300, 80);
		pn_TK_NV.add(btn_TimKiem);
		
		btn_XoaTrang = new Custom_Button();
		btn_XoaTrang.setBuffered_Icon("src/main/images/view_image/Eraser.png");
		btn_XoaTrang.setText("Xóa trắng");
		btn_XoaTrang.setFont(new Font("Inner", Font.BOLD, 40));
		btn_XoaTrang.resizeIcon(50,50);
		btn_XoaTrang.setRadius(45);
		btn_XoaTrang.setOver(true);
		btn_XoaTrang.setColor_Foreground(Color.black);
		btn_XoaTrang.setColor_Hightlight(Custom_ColorPicker.lavender_ED91FF);
		btn_XoaTrang.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_XoaTrang.setColor_Over(Color.white);
		btn_XoaTrang.setColor_Click(Color.black);
		btn_XoaTrang.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_XoaTrang.setLocation(1690, 370);
		btn_XoaTrang.setSize(300, 80);
		pn_TK_NV.add(btn_XoaTrang);
		
		lbl_Title_DSNV = new JLabel("Danh sách nhân viên");
		lbl_Title_DSNV.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSNV.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSNV.setBounds(30,650,2500,50);
		pn_Master.add(lbl_Title_DSNV);
		
		dtm_NV = new DefaultTableModel(new String[] {"Mã nhân viên","Họ tên","Chức vụ","Mật khẩu","Ngày sinh","Giới tính","Địa chỉ","CCCD","Số điện thoại"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_NV.addRow(new String[] {"NV0001","Từ Quang Nhật","Nhân ziên","tqn123","02-02-2011","Nam","Trái Đất","0124865478456","0124865478"});
		}
		tbl_DSNV = new Custom_Table(dtm_NV);
		tbl_DSNV.align(2,new int[] {4,7,8});
		tbl_DSNV.redrawn_Custom_Table();
		scr_DSNV = new JScrollPane(tbl_DSNV);
		scr_DSNV.setBounds(30,700,2500,675);
		pn_Master.add(scr_DSNV);
	}
	public void draw_View_TimKiem_SanPham() {
		draw_Header();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btn_Close) {
			System.exit(0);
		}
		//if(o == btn)
	}
	public View_TimKiem_NhanVien() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
}
