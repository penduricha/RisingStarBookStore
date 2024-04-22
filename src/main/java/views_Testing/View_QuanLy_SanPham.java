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
import javax.swing.JSpinner;
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

public class View_QuanLy_SanPham extends JFrame implements ActionListener{
	private JPanel pn_Master,pn_Header,pn_QL_SP,pn_Table_DSSP;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_QL_SP,lbl_Title_DSSP;
	private JLabel lbl_MaSP,lbl_TenSP,lbl_LoaiSP,lbl_NgonNgu,lbl_NhaCungCap,lbl_NhaXuatBan,lbl_NamXuatBan,lbl_TacGia,lbl_SoLuongCon,lbl_SoLuongBan,lbl_GiaNhap,lbl_GiaBan;
	private Custom_ComboBox cbo_TenSP,cbo_LoaiSP,cbo_NgonNgu,cbo_NhaCungCap;
	private JTextField txt_TenSP,txt_NhaXuatBan,txt_TacGia,txt_GiaNhap,txt_GiaBan;
	private JLabel lbl_txt_MaSP,lbl_txt_SoLuongBan;
	private JSpinner spn_NamXuatBan,spn_SoLuongCon;
	private Custom_JLabel lbl_hinhAnhSP;
	private JScrollPane scr_DSSP;
	private Custom_Table tbl_DSSP;
	private DefaultTableModel dtm_SP;
	private Custom_Button btn_ChonAnh,btn_Them,btn_CapNhat,btn_XoaTrang;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_QuanLy_SanPham frame = new View_QuanLy_SanPham();
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
		
		lbl_Title_QL_SP = new JLabel("Quản lý sản phẩm");
		lbl_Title_QL_SP.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_QL_SP.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_QL_SP.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_QL_SP);
		
		pn_QL_SP = new JPanel();
		pn_QL_SP.setIgnoreRepaint(true);
		pn_QL_SP.setBackground(Color.white);
		pn_QL_SP.setLayout(null);
		pn_QL_SP.setBounds(new Rectangle(30, 150, 2500, 500));
		pn_QL_SP.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_QL_SP);
		
		lbl_MaSP = new JLabel("Mã sản phẩm:");
		lbl_MaSP.setLocation(20, 52);
		lbl_MaSP.setSize(298, 48);
		lbl_MaSP.setForeground(Color.black);
		lbl_MaSP.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_MaSP);
		
		lbl_TenSP = new JLabel("Tên sản phẩm:");
		lbl_TenSP.setLocation(20, 132);
		lbl_TenSP.setSize(298, 48);
		lbl_TenSP.setForeground(Color.black);
		lbl_TenSP.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_TenSP);
		
		lbl_LoaiSP = new JLabel("Loại sản phẩm:");
		lbl_LoaiSP.setLocation(20, 212);
		lbl_LoaiSP.setSize(298, 48);
		lbl_LoaiSP.setForeground(Color.black);
		lbl_LoaiSP.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_LoaiSP);
		
		lbl_NgonNgu = new JLabel("Ngôn ngữ:");
		lbl_NgonNgu.setLocation(20, 292);
		lbl_NgonNgu.setSize(298, 48);
		lbl_NgonNgu.setForeground(Color.black);
		lbl_NgonNgu.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NgonNgu);
		
		lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setLocation(700, 52);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_NhaCungCap = new JLabel("Nhà xuất bản:");
		lbl_NhaCungCap.setLocation(700, 132);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);

		lbl_NhaCungCap = new JLabel("Năm xuất bản:");
		lbl_NhaCungCap.setLocation(700, 212);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_NhaCungCap = new JLabel("Tác giả:");
		lbl_NhaCungCap.setLocation(700, 292);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_NhaCungCap = new JLabel("Số lượng còn:");
		lbl_NhaCungCap.setLocation(1363, 52);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_NhaCungCap = new JLabel("Số lượng bán:");
		lbl_NhaCungCap.setLocation(1363, 132);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_NhaCungCap = new JLabel("Giá nhập:");
		lbl_NhaCungCap.setLocation(1363, 212);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_NhaCungCap = new JLabel("Giá bán:");
		lbl_NhaCungCap.setLocation(1363, 292);
		lbl_NhaCungCap.setSize(298, 48);
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_SP.add(lbl_NhaCungCap);
		
		lbl_txt_MaSP = new JLabel();
		lbl_txt_MaSP.setLocation(318, 50);
		lbl_txt_MaSP.setSize(350, 50);
		lbl_txt_MaSP.setForeground(Color.black);
		lbl_txt_MaSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaSP.setOpaque(true);
		lbl_txt_MaSP.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		lbl_txt_MaSP.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		pn_QL_SP.add(lbl_txt_MaSP);
		
		
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
		pn_QL_SP.add(cbo_TenSP);
		
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
		pn_QL_SP.add(cbo_LoaiSP);
		
		cbo_NgonNgu = new Custom_ComboBox();
		cbo_NgonNgu.setLocation(318, 290);
		cbo_NgonNgu.setSize(350, 50);
		cbo_NgonNgu.setForeground(Color.black);
		cbo_NgonNgu.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_NgonNgu.setColor_Foreground(Color.black);
		cbo_NgonNgu.setBackground(Color.white);
		cbo_NgonNgu.setColor_Hightlight(Color.white);
		cbo_NgonNgu.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_NgonNgu.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_NgonNgu.redraw_Custom_Combobox();
		pn_QL_SP.add(cbo_NgonNgu);
		
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
		pn_QL_SP.add(cbo_NhaCungCap);
		
		txt_NhaXuatBan = new JTextField();
		txt_NhaXuatBan.setLocation(998, 130);
		txt_NhaXuatBan.setSize(350, 50);
		txt_NhaXuatBan.setForeground(Color.black);
		txt_NhaXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_NhaXuatBan.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_SP.add(txt_NhaXuatBan);
		
		spn_NamXuatBan = new JSpinner();
		spn_NamXuatBan.setLocation(998, 210);
		spn_NamXuatBan.setSize(350, 50);
		spn_NamXuatBan.setForeground(Color.black);
		spn_NamXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		spn_NamXuatBan.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_SP.add(spn_NamXuatBan);
		
		txt_TacGia = new JTextField();
		txt_TacGia.setLocation(998, 290);
		txt_TacGia.setSize(350, 50);
		txt_TacGia.setForeground(Color.black);
		txt_TacGia.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_TacGia.setBackground(Color.white);
		txt_TacGia.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_SP.add(txt_TacGia);
		
		spn_SoLuongCon = new JSpinner();
		spn_SoLuongCon.setLocation(1661, 50);
		spn_SoLuongCon.setSize(350, 50);
		spn_SoLuongCon.setForeground(Color.black);
		spn_SoLuongCon.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		spn_SoLuongCon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_SP.add(spn_SoLuongCon);
		
		lbl_txt_SoLuongBan = new JLabel();
		lbl_txt_SoLuongBan.setLocation(1661, 130);
		lbl_txt_SoLuongBan.setSize(350, 50);
		lbl_txt_SoLuongBan.setForeground(Color.black);
		lbl_txt_SoLuongBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lbl_txt_SoLuongBan.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_SoLuongBan.setOpaque(true);
		lbl_txt_SoLuongBan.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_SP.add(lbl_txt_SoLuongBan);
		
		txt_GiaNhap = new JTextField();
		txt_GiaNhap.setLocation(1661, 210);
		txt_GiaNhap.setSize(350, 50);
		txt_GiaNhap.setForeground(Color.black);
		txt_GiaNhap.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		txt_GiaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		pn_QL_SP.add(txt_GiaNhap);
		
		txt_GiaBan = new JTextField();
		txt_GiaBan.setLocation(1661, 290);
		txt_GiaBan.setSize(350, 50);
		txt_GiaBan.setForeground(Color.black);
		txt_GiaBan.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		txt_GiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_GiaBan.setBackground(Color.white);
		pn_QL_SP.add(txt_GiaBan);
		
		btn_ChonAnh = new Custom_Button();
		btn_ChonAnh.setBuffered_Icon("src/main/images/view_image/Add image.png");
		btn_ChonAnh.setText("Chọn ảnh");
		btn_ChonAnh.setFont(new Font("Inner", Font.BOLD, 40));
		btn_ChonAnh.resizeIcon(50,50);
		btn_ChonAnh.setRadius(45);
		btn_ChonAnh.setOver(true);
		btn_ChonAnh.setColor_Foreground(Color.black);
		btn_ChonAnh.setColor_Hightlight(Custom_ColorPicker.lavender_ED91FF);
		btn_ChonAnh.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_ChonAnh.setColor_Over(Color.white);
		btn_ChonAnh.setColor_Click(Color.black);
		btn_ChonAnh.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_ChonAnh.setLocation(1710, 370);
		btn_ChonAnh.setSize(300, 80);
		pn_QL_SP.add(btn_ChonAnh);
		
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
		btn_Them.setLocation(1400, 370);
		btn_Them.setSize(300, 80);
		pn_QL_SP.add(btn_Them);
		
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
		btn_CapNhat.setLocation(1090, 370);
		btn_CapNhat.setSize(300, 80);
		pn_QL_SP.add(btn_CapNhat);
		
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
		btn_XoaTrang.setLocation(780, 370);
		btn_XoaTrang.setSize(300, 80);
		pn_QL_SP.add(btn_XoaTrang);
		
		lbl_hinhAnhSP = new Custom_JLabel();
		lbl_hinhAnhSP.setLocation(2070,52);
		lbl_hinhAnhSP.setSize(400, 400);
		lbl_hinhAnhSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_hinhAnhSP.setOpaque(true);
		lbl_hinhAnhSP.setVisible(true);
		pn_QL_SP.add(lbl_hinhAnhSP);
		
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
		JScrollPane scr_DSSP = new JScrollPane(tbl_DSSP);
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
	public View_QuanLy_SanPham() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
}
