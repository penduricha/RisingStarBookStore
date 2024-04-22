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
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import customEntities.Custom_ComboBox;
import customEntities.Custom_Table;
import customEntities.Custom_Button;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_JLabel;
import customEntities.Custom_ColorPicker;
import customEntities.RoundedCornerBorder;

public class View_TimKiem_HoaDon extends JFrame implements ActionListener{
	private JPanel pn_Master,pn_Header,pn_TK_HD;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_TK_HD,lbl_Title_DSHD,lbl_Title_DSCTHD;
	private JLabel lbl_MaHD,lbl_HoTen_NV,lbl_HoTen_KH,lbl_SoDienThoai_KH,lbl_ThoiGianLap,lbl_TongTien;
	private Custom_ComboBox cbo_MaHD,cbo_HoTen_NV,cbo_HoTen_KH,cbo_Gio_ThoiGianLap,cbo_Phut_ThoiGianLap,cbo_SoDienThoai_KH,cbo_TongTien;
	private JDateChooser dcr_NgayLap;
	private BufferedImage bfi_ChonNgay;
	private JFormattedTextField ftf_NgaySinh;
	private JScrollPane scr_DSHD,scr_DSCTHD;
	private Custom_Table tbl_DSHD,tbl_DSCTHD;
	private DefaultTableModel dtm_HD,dtm_CTHD;
	private Custom_Button btn_XoaTrang,btn_TimKiem;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_TimKiem_HoaDon frame = new View_TimKiem_HoaDon();
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
		
		lbl_Title_TK_HD = new JLabel("Tìm kiếm nhà cung cấp");
		lbl_Title_TK_HD.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_TK_HD.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_TK_HD.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_TK_HD);
		
		pn_TK_HD = new JPanel();
		pn_TK_HD.setIgnoreRepaint(true);
		pn_TK_HD.setBackground(Color.white);
		pn_TK_HD.setLayout(null);
		pn_TK_HD.setBounds(new Rectangle(30, 150, 2500, 300));
		pn_TK_HD.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_TK_HD);
		
		lbl_MaHD = new JLabel("Mã hóa đơn:");
		lbl_MaHD.setLocation(46, 32);
		lbl_MaHD.setSize(330, 48);
		lbl_MaHD.setForeground(Color.black);
		lbl_MaHD.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_HD.add(lbl_MaHD);
		
		lbl_HoTen_KH = new JLabel("Họ tên khách hàng:");
		lbl_HoTen_KH.setLocation(780, 32);
		lbl_HoTen_KH.setSize(390, 48);
		lbl_HoTen_KH.setForeground(Color.black);
		lbl_HoTen_KH.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_HD.add(lbl_HoTen_KH);
		
		lbl_ThoiGianLap = new JLabel("Thời gian lập:");
		lbl_ThoiGianLap.setLocation(1720, 32);
		lbl_ThoiGianLap.setSize(260, 48);
		lbl_ThoiGianLap.setForeground(Color.black);
		lbl_ThoiGianLap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_HD.add(lbl_ThoiGianLap);
		
		lbl_HoTen_NV = new JLabel("Họ tên nhân viên:");
		lbl_HoTen_NV.setLocation(50, 132);
		lbl_HoTen_NV.setSize(380, 48);
		lbl_HoTen_NV.setForeground(Color.black);
		lbl_HoTen_NV.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_HD.add(lbl_HoTen_NV);
		
		lbl_SoDienThoai_KH = new JLabel("Số điện thoại khách:");
		lbl_SoDienThoai_KH.setLocation(780,132);
		lbl_SoDienThoai_KH.setSize(390, 48);
		lbl_SoDienThoai_KH.setForeground(Color.black);
		lbl_SoDienThoai_KH.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_HD.add(lbl_SoDienThoai_KH);
		
		lbl_TongTien = new JLabel("Tổng tiền:");
		lbl_TongTien.setLocation(1720,132);
		lbl_TongTien.setSize(260, 48);
		lbl_TongTien.setForeground(Color.black);
		lbl_TongTien.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_HD.add(lbl_TongTien);
		
		cbo_MaHD = new Custom_ComboBox();
		cbo_MaHD.setLocation(380, 35);
		cbo_MaHD.setSize(395, 50);
		cbo_MaHD.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_MaHD.setColor_Foreground(Color.black);
		cbo_MaHD.setColor_Background(Color.white);
		cbo_MaHD.setColor_Hightlight(Color.white);
		cbo_MaHD.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaHD.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaHD.redraw_Custom_Combobox();
		cbo_MaHD.setRadius(0);
		pn_TK_HD.add(cbo_MaHD);
		
		cbo_HoTen_KH = new Custom_ComboBox();
		cbo_HoTen_KH.setLocation(1165, 35);
		cbo_HoTen_KH.setSize(550, 50);
		cbo_HoTen_KH.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_HoTen_KH.setColor_Foreground(Color.black);
		cbo_HoTen_KH.setColor_Background(Color.white);
		cbo_HoTen_KH.setColor_Hightlight(Color.white);
		cbo_HoTen_KH.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen_KH.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen_KH.redraw_Custom_Combobox();
		pn_TK_HD.add(cbo_HoTen_KH);
		
		String[] string_GioTrongNgay = new String[24];
		for (int i = 0; i < 24; i++) {
			string_GioTrongNgay[i] = String.format("%02d",i);
		}
		cbo_Gio_ThoiGianLap = new Custom_ComboBox(string_GioTrongNgay);
		cbo_Gio_ThoiGianLap.setLocation(1985, 35);
		cbo_Gio_ThoiGianLap.setSize(100, 50);
		cbo_Gio_ThoiGianLap.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_Gio_ThoiGianLap.setColor_Foreground(Color.black);
		cbo_Gio_ThoiGianLap.setColor_Background(Color.white);
		cbo_Gio_ThoiGianLap.setColor_Hightlight(Color.white);
		cbo_Gio_ThoiGianLap.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_Gio_ThoiGianLap.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_Gio_ThoiGianLap.redraw_Custom_Combobox();
		pn_TK_HD.add(cbo_Gio_ThoiGianLap);
		String[] string_PhutTrongGio = new String[60];
		for (int i = 0; i < 60; i++) {
			string_PhutTrongGio[i] = String.format(":%02d",i);
		}
		cbo_Phut_ThoiGianLap = new Custom_ComboBox(string_PhutTrongGio);
		cbo_Phut_ThoiGianLap.setLocation(2090, 35);
		cbo_Phut_ThoiGianLap.setSize(100, 50);
		cbo_Phut_ThoiGianLap.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_Phut_ThoiGianLap.setColor_Foreground(Color.black);
		cbo_Phut_ThoiGianLap.setColor_Background(Color.white);
		cbo_Phut_ThoiGianLap.setColor_Hightlight(Color.white);
		cbo_Phut_ThoiGianLap.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_Phut_ThoiGianLap.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_Phut_ThoiGianLap.redraw_Custom_Combobox();
		pn_TK_HD.add(cbo_Phut_ThoiGianLap);
		
		dcr_NgayLap = new JDateChooser ();
		try {
			bfi_ChonNgay = ImageIO.read(new File("src\\main\\images\\view_image\\Calendar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bfi_ChonNgay = Custom_Function.resize(bfi_ChonNgay, 50, 50);
		dcr_NgayLap.setIcon (new ImageIcon(bfi_ChonNgay));
		dcr_NgayLap.getCalendarButton().setBackground (Custom_ColorPicker.lavender_ED91FF);
		dcr_NgayLap.setLocation(2200,35); 
		dcr_NgayLap.setSize(250, 50);
		ftf_NgaySinh = (JFormattedTextField) dcr_NgayLap.getComponent(1);
		ftf_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		ftf_NgaySinh.setPreferredSize(new Dimension(300,50));
		ftf_NgaySinh.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		ftf_NgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		dcr_NgayLap.getComponent(0).setPreferredSize(new Dimension(50,50));
		dcr_NgayLap.getJCalendar().setPreferredSize (new Dimension (dcr_NgayLap.getWidth(), dcr_NgayLap.getWidth()));
		dcr_NgayLap.setDateFormatString("dd-MM-yyyy");
		pn_TK_HD.add(dcr_NgayLap);
		
		cbo_HoTen_NV = new Custom_ComboBox();
		cbo_HoTen_NV.setLocation(380, 135);
		cbo_HoTen_NV.setSize(395, 50);
		cbo_HoTen_NV.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_HoTen_NV.setColor_Foreground(Color.black);
		cbo_HoTen_NV.setColor_Background(Color.white);
		cbo_HoTen_NV.setColor_Hightlight(Color.white);
		cbo_HoTen_NV.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen_NV.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_HoTen_NV.redraw_Custom_Combobox();
		cbo_HoTen_NV.setRadius(0);
		pn_TK_HD.add(cbo_HoTen_NV);
		
		cbo_SoDienThoai_KH = new Custom_ComboBox();
		cbo_SoDienThoai_KH.setLocation(1165, 135);
		cbo_SoDienThoai_KH.setSize(550, 50);
		cbo_SoDienThoai_KH.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_SoDienThoai_KH.setColor_Foreground(Color.black);
		cbo_SoDienThoai_KH.setColor_Background(Color.white);
		cbo_SoDienThoai_KH.setColor_Hightlight(Color.white);
		cbo_SoDienThoai_KH.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai_KH.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai_KH.redraw_Custom_Combobox();
		pn_TK_HD.add(cbo_SoDienThoai_KH);
		
		cbo_TongTien = new Custom_ComboBox();
		cbo_TongTien.setLocation(1985, 135);
		cbo_TongTien.setSize(465, 50);
		cbo_TongTien.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_TongTien.setColor_Foreground(Color.black);
		cbo_TongTien.setColor_Background(Color.white);
		cbo_TongTien.setColor_Hightlight(Color.white);
		cbo_TongTien.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_TongTien.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_TongTien.redraw_Custom_Combobox();
		pn_TK_HD.add(cbo_TongTien);
		
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
		btn_TimKiem.setLocation(2150, 200);
		btn_TimKiem.setSize(300, 80);
		pn_TK_HD.add(btn_TimKiem);
		
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
		btn_XoaTrang.setLocation(1750, 200);
		btn_XoaTrang.setSize(300, 80);
		pn_TK_HD.add(btn_XoaTrang);
		
		lbl_Title_DSHD = new JLabel("Danh sách nhà cung cấp");
		lbl_Title_DSHD.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSHD.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSHD.setBounds(30,450,2500,50);
		pn_Master.add(lbl_Title_DSHD);
		
		dtm_HD = new DefaultTableModel(new String[] {"Mã hóa đơn","Họ tên nhân viên","Họ tên khách hàng","Số điện thoại khách","Thời gian lập","Tổng tiền"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_HD.addRow(new String[] {"HD0001","Mr.Bean","Doraemon","0365874865","15:39 12-02-2023","230000đ"});
		}
		tbl_DSHD = new Custom_Table(dtm_HD);
		tbl_DSHD.align(2,new int[] {3,4,5});
		tbl_DSHD.redrawn_Custom_Table();
		scr_DSHD = new JScrollPane(tbl_DSHD);
		scr_DSHD.setBounds(30,500,2500,675);
		pn_Master.add(scr_DSHD);
		
		lbl_Title_DSCTHD = new JLabel("Danh sách chi tiết đơn hàng");
		lbl_Title_DSCTHD.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSCTHD.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSCTHD.setBounds(30,1175,2500,50);
		pn_Master.add(lbl_Title_DSCTHD);
		
		dtm_CTHD = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng","Thành tiền"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_CTHD.addRow(new String[] {"SP0001","Mùa hè không tên","20000đ","2","40000đ"});
		}
		tbl_DSCTHD = new Custom_Table(dtm_CTHD);
		tbl_DSCTHD.align(2,new int[] {2,3,4});
		tbl_DSCTHD.redrawn_Custom_Table();
		scr_DSCTHD = new JScrollPane(tbl_DSCTHD);
		scr_DSCTHD.setBounds(30,1225,2500,150);
		pn_Master.add(scr_DSCTHD);
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
	public View_TimKiem_HoaDon() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
}
