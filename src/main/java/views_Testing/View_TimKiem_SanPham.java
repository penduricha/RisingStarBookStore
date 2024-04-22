package views_Testing;

import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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

public class View_TimKiem_SanPham extends JFrame implements ActionListener{
	private JPanel pn_Master,pn_Header,pn_TK_SP;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_TK_SP,lbl_Title_DSSP;
	private JLabel lbl_MaSP,lbl_TenSP,lbl_LoaiSP,lbl_NgonNgu,lbl_NhaCungCap,lbl_NhaXuatBan,lbl_NamXuatBan,lbl_TacGia,lbl_SoLuongCon,lbl_SoLuongBan,lbl_GiaNhap,lbl_GiaBan;
	private Custom_ComboBox cbo_MaSP,cbo_TenSP,cbo_LoaiSP,cbo_NgonNgu,cbo_NhaCungCap,cbo_NhaXuatBan,cbo_NamXuatBan,cbo_TacGia,cbo_SoLuongCon,cbo_SoLuongBan,cbo_GiaNhap,cbo_GiaBan;
	private Custom_JLabel lbl_hinhAnhSP;
	private JScrollPane scr_DSSP;
	private Custom_Table tbl_DSSP;
	private DefaultTableModel dtm_SP;
	private Custom_Button btn_XoaTrang,btn_TimKiem;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_TimKiem_SanPham frame = new View_TimKiem_SanPham();
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
		
		lbl_Title_TK_SP = new JLabel("Tìm kiếm sản phẩm");
		lbl_Title_TK_SP.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_TK_SP.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_TK_SP.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_TK_SP);
		
		pn_TK_SP = new JPanel();
		pn_TK_SP.setIgnoreRepaint(true);
		pn_TK_SP.setBackground(Color.white);
		pn_TK_SP.setLayout(null);
		pn_TK_SP.setBounds(new Rectangle(30, 150, 2500, 500));
		pn_TK_SP.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_TK_SP);
		
		lbl_MaSP = new JLabel("Mã sản phẩm:");
		lbl_MaSP.setLocation(20, 52);
		lbl_MaSP.setSize(298, 48);
		lbl_MaSP.setForeground(Color.black);
		lbl_MaSP.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_MaSP);
		
		lbl_TenSP = new JLabel("Tên sản phẩm:");
		lbl_TenSP.setLocation(20, 132);
		lbl_TenSP.setSize(298, 48);
		lbl_TenSP.setForeground(Color.black);
		lbl_TenSP.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_TenSP);
		
		lbl_LoaiSP = new JLabel("Loại sản phẩm:");
		lbl_LoaiSP.setLocation(20, 212);
		lbl_LoaiSP.setSize(298, 48);
		lbl_LoaiSP.setForeground(Color.black);
		lbl_LoaiSP.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_LoaiSP);
		
		lbl_NgonNgu = new JLabel("Ngôn ngữ:");
		lbl_NgonNgu.setLocation(20, 292);
		lbl_NgonNgu.setSize(298, 48);
		lbl_NgonNgu.setForeground(Color.black);
		lbl_NgonNgu.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_NgonNgu);
		
		lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setLocation(700, 52);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_NhaCungCap);
		
		lbl_NhaXuatBan = new JLabel("Nhà xuất bản:");
		lbl_NhaXuatBan.setLocation(700, 132);
		lbl_NhaXuatBan.setSize(298, 48);
		lbl_NhaXuatBan.setForeground(Color.black);
		lbl_NhaXuatBan.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_NhaXuatBan);

		lbl_NamXuatBan = new JLabel("Năm xuất bản:");
		lbl_NamXuatBan.setLocation(700, 212);
		lbl_NamXuatBan.setSize(298, 48);
		lbl_NamXuatBan.setForeground(Color.black);
		lbl_NamXuatBan.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_NamXuatBan);
		
		lbl_TacGia = new JLabel("Tác giả:");
		lbl_TacGia.setLocation(700, 292);
		lbl_TacGia.setSize(298, 48);
		lbl_TacGia.setForeground(Color.black);
		lbl_TacGia.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_TacGia);
		
		lbl_SoLuongCon = new JLabel("Số lượng còn:");
		lbl_SoLuongCon.setLocation(1363, 52);
		lbl_SoLuongCon.setSize(298, 48);
		lbl_SoLuongCon.setForeground(Color.black);
		lbl_SoLuongCon.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_SoLuongCon);
		
		lbl_SoLuongBan = new JLabel("Số lượng bán:");
		lbl_SoLuongBan.setLocation(1363, 132);
		lbl_SoLuongBan.setSize(298, 48);
		lbl_SoLuongBan.setForeground(Color.black);
		lbl_SoLuongBan.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_SoLuongBan);
		
		lbl_GiaNhap = new JLabel("Giá nhập:");
		lbl_GiaNhap.setLocation(1363, 212);
		lbl_GiaNhap.setSize(298, 48);
		lbl_GiaNhap.setForeground(Color.black);
		lbl_GiaNhap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_GiaNhap);
		
		lbl_GiaBan = new JLabel("Giá bán:");
		lbl_GiaBan.setLocation(1363, 292);
		lbl_GiaBan.setSize(298, 48);
		lbl_GiaBan.setForeground(Color.black);
		lbl_GiaBan.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_SP.add(lbl_GiaBan);
		
		cbo_MaSP = new Custom_ComboBox();
		cbo_MaSP.setLocation(318, 50);
		cbo_MaSP.setSize(350, 50);
		cbo_MaSP.setForeground(Color.black);
		cbo_MaSP.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_MaSP.setColor_Foreground(Color.black);
		cbo_MaSP.setColor_Background(Color.white);
		cbo_MaSP.setColor_Hightlight(Color.white);
		cbo_MaSP.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaSP.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaSP.redraw_Custom_Combobox();
		cbo_MaSP.setRadius(0);
		pn_TK_SP.add(cbo_MaSP);
		
		
		cbo_TenSP = new Custom_ComboBox();
		cbo_TenSP.setLocation(318, 130);
		cbo_TenSP.setSize(350, 50);
		cbo_TenSP.setForeground(Color.black);
		cbo_TenSP.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_TenSP.setColor_Foreground(Color.black);
		cbo_TenSP.setColor_Background(Color.white);
		cbo_TenSP.setColor_Hightlight(Color.white);
		cbo_TenSP.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_TenSP.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_TenSP.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_TenSP);
		
		cbo_LoaiSP = new Custom_ComboBox();
		cbo_LoaiSP.setLocation(318, 210);
		cbo_LoaiSP.setSize(350, 50);
		cbo_LoaiSP.setForeground(Color.black);
		cbo_LoaiSP.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_LoaiSP.setColor_Foreground(Color.black);
		cbo_LoaiSP.setColor_Background(Color.white);
		cbo_LoaiSP.setColor_Hightlight(Color.white);
		cbo_LoaiSP.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_LoaiSP.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_LoaiSP.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_LoaiSP);
		
		cbo_NgonNgu = new Custom_ComboBox();
		cbo_NgonNgu.setLocation(318, 290);
		cbo_NgonNgu.setSize(350, 50);
		cbo_NgonNgu.setForeground(Color.black);
		cbo_NgonNgu.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_NgonNgu.setColor_Foreground(Color.black);
		cbo_NgonNgu.setColor_Background(Color.white);
		cbo_NgonNgu.setColor_Hightlight(Color.white);
		cbo_NgonNgu.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_NgonNgu.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_NgonNgu.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_NgonNgu);
		
		cbo_NhaCungCap = new Custom_ComboBox();
		cbo_NhaCungCap.setLocation(998, 50);
		cbo_NhaCungCap.setSize(350, 50);
		cbo_NhaCungCap.setForeground(Color.black);
		cbo_NhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_NhaCungCap.setColor_Foreground(Color.black);
		cbo_NhaCungCap.setColor_Background(Color.white);
		cbo_NhaCungCap.setColor_Hightlight(Color.white);
		cbo_NhaCungCap.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_NhaCungCap.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_NhaCungCap.redraw_Custom_Combobox();
		cbo_NhaCungCap.setRadius(0);
		pn_TK_SP.add(cbo_NhaCungCap);
		
		cbo_NhaXuatBan = new Custom_ComboBox();
		cbo_NhaXuatBan.setLocation(998, 130);
		cbo_NhaXuatBan.setSize(350, 50);
		cbo_NhaXuatBan.setForeground(Color.black);
		cbo_NhaXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_NhaXuatBan.setColor_Foreground(Color.black);
		cbo_NhaXuatBan.setColor_Background(Color.white);
		cbo_NhaXuatBan.setColor_Hightlight(Color.white);
		cbo_NhaXuatBan.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_NhaXuatBan.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_NhaXuatBan.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_NhaXuatBan);
		
		cbo_NamXuatBan = new Custom_ComboBox();
		cbo_NamXuatBan.setLocation(998, 210);
		cbo_NamXuatBan.setSize(350, 50);
		cbo_NamXuatBan.setForeground(Color.black);
		cbo_NamXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_NamXuatBan.setColor_Foreground(Color.black);
		cbo_NamXuatBan.setColor_Background(Color.white);
		cbo_NamXuatBan.setColor_Hightlight(Color.white);
		cbo_NamXuatBan.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_NamXuatBan.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_NamXuatBan.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_NamXuatBan);
		
		cbo_TacGia = new Custom_ComboBox();
		cbo_TacGia.setLocation(998, 290);
		cbo_TacGia.setSize(350, 50);
		cbo_TacGia.setForeground(Color.black);
		cbo_TacGia.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_TacGia.setColor_Foreground(Color.black);
		cbo_TacGia.setColor_Background(Color.white);
		cbo_TacGia.setColor_Hightlight(Color.white);
		cbo_TacGia.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_TacGia.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_TacGia.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_TacGia);
		
		cbo_SoLuongCon = new Custom_ComboBox();
		cbo_SoLuongCon.setLocation(1661, 50);
		cbo_SoLuongCon.setSize(350, 50);
		cbo_SoLuongCon.setForeground(Color.black);
		cbo_SoLuongCon.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_SoLuongCon.setColor_Foreground(Color.black);
		cbo_SoLuongCon.setColor_Background(Color.white);
		cbo_SoLuongCon.setColor_Hightlight(Color.white);
		cbo_SoLuongCon.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoLuongCon.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoLuongCon.redraw_Custom_Combobox();
		cbo_SoLuongCon.setRadius(0);
		pn_TK_SP.add(cbo_SoLuongCon);
		
		cbo_SoLuongBan = new Custom_ComboBox();
		cbo_SoLuongBan.setLocation(1661, 130);
		cbo_SoLuongBan.setSize(350, 50);
		cbo_SoLuongBan.setForeground(Color.black);
		cbo_SoLuongBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_SoLuongBan.setColor_Foreground(Color.black);
		cbo_SoLuongBan.setColor_Background(Color.white);
		cbo_SoLuongBan.setColor_Hightlight(Color.white);
		cbo_SoLuongBan.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoLuongBan.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoLuongBan.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_SoLuongBan);
		
		cbo_GiaNhap = new Custom_ComboBox();
		cbo_GiaNhap.setLocation(1661, 210);
		cbo_GiaNhap.setSize(350, 50);
		cbo_GiaNhap.setForeground(Color.black);
		cbo_GiaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_GiaNhap.setColor_Foreground(Color.black);
		cbo_GiaNhap.setColor_Background(Color.white);
		cbo_GiaNhap.setColor_Hightlight(Color.white);
		cbo_GiaNhap.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_GiaNhap.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_GiaNhap.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_GiaNhap);
		
		cbo_GiaBan = new Custom_ComboBox();
		cbo_GiaBan.setLocation(1661, 290);
		cbo_GiaBan.setSize(350, 50);
		cbo_GiaBan.setForeground(Color.black);
		cbo_GiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_GiaBan.setColor_Foreground(Color.black);
		cbo_GiaBan.setColor_Background(Color.white);
		cbo_GiaBan.setColor_Hightlight(Color.white);
		cbo_GiaBan.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_GiaBan.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_GiaBan.redraw_Custom_Combobox();
		pn_TK_SP.add(cbo_GiaBan);
		
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
		btn_TimKiem.setLocation(1710, 370);
		btn_TimKiem.setSize(300, 80);
		pn_TK_SP.add(btn_TimKiem);
		
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
		btn_XoaTrang.setLocation(1350, 370);
		btn_XoaTrang.setSize(300, 80);
		pn_TK_SP.add(btn_XoaTrang);
		
		lbl_hinhAnhSP = new Custom_JLabel();
		lbl_hinhAnhSP.setLocation(2070,52);
		lbl_hinhAnhSP.setSize(400, 400);
		lbl_hinhAnhSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_hinhAnhSP.setOpaque(true);
		lbl_hinhAnhSP.setVisible(true);
		pn_TK_SP.add(lbl_hinhAnhSP);
		
		lbl_Title_DSSP = new JLabel("Danh sách sản phẩm");
		lbl_Title_DSSP.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSSP.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSSP.setBounds(30,650,2500,50);
		pn_Master.add(lbl_Title_DSSP);
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_SP.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}
		tbl_DSSP = new Custom_Table(dtm_SP);
		tbl_DSSP.align(2,new int[] {6,8,9,10,11});
		tbl_DSSP.redrawn_Custom_Table();
		scr_DSSP = new JScrollPane(tbl_DSSP);
		scr_DSSP.setBounds(30,700,2500,675);
		pn_Master.add(scr_DSSP);
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
	public View_TimKiem_SanPham() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
}
