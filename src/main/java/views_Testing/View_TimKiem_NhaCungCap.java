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

public class View_TimKiem_NhaCungCap extends JFrame implements ActionListener{
	private JPanel pn_Master,pn_Header,pn_TK_NCC;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_TK_NCC,lbl_Title_DSNCC;
	private JLabel lbl_MaNCC,lbl_TenNCC,lbl_SoDienThoai,lbl_Email,lbl_DiaChi;
	private Custom_ComboBox cbo_MaNCC,cbo_TenNCC,cbo_SoDienThoai,cbo_Email,cbo_DiaChi;
	private JScrollPane scr_DSNCC;
	private Custom_Table tbl_DSNCC;
	private DefaultTableModel dtm_NCC;
	private Custom_Button btn_XoaTrang,btn_TimKiem;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_TimKiem_NhaCungCap frame = new View_TimKiem_NhaCungCap();
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
		
		lbl_Title_TK_NCC = new JLabel("Tìm kiếm nhà cung cấp");
		lbl_Title_TK_NCC.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_TK_NCC.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_TK_NCC.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_TK_NCC);
		
		pn_TK_NCC = new JPanel();
		pn_TK_NCC.setIgnoreRepaint(true);
		pn_TK_NCC.setBackground(Color.white);
		pn_TK_NCC.setLayout(null);
		pn_TK_NCC.setBounds(new Rectangle(30, 150, 2500, 300));
		pn_TK_NCC.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_TK_NCC);
		
		lbl_MaNCC = new JLabel("Mã nhà cung cấp:");
		lbl_MaNCC.setLocation(46, 32);
		lbl_MaNCC.setSize(330, 48);
		lbl_MaNCC.setForeground(Color.black);
		lbl_MaNCC.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NCC.add(lbl_MaNCC);
		
		lbl_TenNCC = new JLabel("Tên nhà cung cấp:");
		lbl_TenNCC.setLocation(780, 32);
		lbl_TenNCC.setSize(380, 48);
		lbl_TenNCC.setForeground(Color.black);
		lbl_TenNCC.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NCC.add(lbl_TenNCC);
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setLocation(1720, 32);
		lbl_SoDienThoai.setSize(260, 48);
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NCC.add(lbl_SoDienThoai);
		
		lbl_Email = new JLabel("Email:");
		lbl_Email.setLocation(50, 132);
		lbl_Email.setSize(125, 48);
		lbl_Email.setForeground(Color.black);
		lbl_Email.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NCC.add(lbl_Email);
		
		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setLocation(780,132);
		lbl_DiaChi.setSize(145, 48);
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.BOLD, 40));
		pn_TK_NCC.add(lbl_DiaChi);
		
		cbo_MaNCC = new Custom_ComboBox();
		cbo_MaNCC.setLocation(380, 35);
		cbo_MaNCC.setSize(395, 50);
		cbo_MaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_MaNCC.setColor_Foreground(Color.black);
		cbo_MaNCC.setColor_Background(Color.white);
		cbo_MaNCC.setColor_Hightlight(Color.white);
		cbo_MaNCC.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaNCC.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_MaNCC.redraw_Custom_Combobox();
		cbo_MaNCC.setRadius(0);
		pn_TK_NCC.add(cbo_MaNCC);
		
		
		cbo_TenNCC = new Custom_ComboBox();
		cbo_TenNCC.setLocation(1130, 35);
		cbo_TenNCC.setSize(585, 50);
		cbo_TenNCC.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_TenNCC.setColor_Foreground(Color.black);
		cbo_TenNCC.setColor_Background(Color.white);
		cbo_TenNCC.setColor_Hightlight(Color.white);
		cbo_TenNCC.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_TenNCC.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_TenNCC.redraw_Custom_Combobox();
		pn_TK_NCC.add(cbo_TenNCC);
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setLocation(1985, 35);
		cbo_SoDienThoai.setSize(467, 50);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_SoDienThoai.setColor_Foreground(Color.black);
		cbo_SoDienThoai.setColor_Background(Color.white);
		cbo_SoDienThoai.setColor_Hightlight(Color.white);
		cbo_SoDienThoai.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_SoDienThoai.redraw_Custom_Combobox();
		pn_TK_NCC.add(cbo_SoDienThoai);
		
		cbo_Email = new Custom_ComboBox();
		cbo_Email.setLocation(175, 135);
		cbo_Email.setSize(600, 50);
		cbo_Email.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_Email.setColor_Foreground(Color.black);
		cbo_Email.setColor_Background(Color.white);
		cbo_Email.setColor_Hightlight(Color.white);
		cbo_Email.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_Email.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_Email.redraw_Custom_Combobox();
		cbo_Email.setRadius(0);
		pn_TK_NCC.add(cbo_Email);
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setLocation(925, 135);
		cbo_DiaChi.setSize(1527, 50);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		cbo_DiaChi.setColor_Foreground(Color.black);
		cbo_DiaChi.setColor_Background(Color.white);
		cbo_DiaChi.setColor_Hightlight(Color.white);
		cbo_DiaChi.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		cbo_DiaChi.setColor_Border(Custom_ColorPicker.lavender_ED91FF);
		cbo_DiaChi.redraw_Custom_Combobox();
		pn_TK_NCC.add(cbo_DiaChi);
		
		
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
		pn_TK_NCC.add(btn_TimKiem);
		
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
		pn_TK_NCC.add(btn_XoaTrang);
		
		lbl_Title_DSNCC = new JLabel("Danh sách nhà cung cấp");
		lbl_Title_DSNCC.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_DSNCC.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_DSNCC.setBounds(30,450,2500,50);
		pn_Master.add(lbl_Title_DSNCC);
		
		dtm_NCC = new DefaultTableModel(new String[] {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Email","Địa chỉ"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_NCC.addRow(new String[] {"NCC0001","Mr.Bean","0398785415","ohno@gmail.com","Vũ trụ X"});
		}
		tbl_DSNCC = new Custom_Table(dtm_NCC);
		tbl_DSNCC.align(2,new int[] {2});
		tbl_DSNCC.redrawn_Custom_Table();
		scr_DSNCC = new JScrollPane(tbl_DSNCC);
		scr_DSNCC.setBounds(30,500,2500,875);
		pn_Master.add(scr_DSNCC);
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
	public View_TimKiem_NhaCungCap() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
}
