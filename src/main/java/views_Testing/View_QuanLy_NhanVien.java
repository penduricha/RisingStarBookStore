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

public class View_QuanLy_NhanVien extends JFrame implements ActionListener{
	private JPanel pn_Master,pn_Header,pn_QL_NV;
	private Custom_JLabel picture_Logo;
	private Custom_Button btn_Close,btn_Home,btn_Logout;
	private JLabel lbl_Title_QL_NV,lbl_Title_DSNV;
	private JLabel lbl_MaNV,lbl_HoTen,lbl_ChucVu,lbl_MatKhau,lbl_NgaySinh,lbl_GioiTinh,lbl_DiaChi,lbl_CCCD,lbl_SoDienThoai;
	private Custom_ComboBox cbo_ChucVu,cbo_GioiTinh;
	private JLabel lbl_txt_MaNV;
	private JTextField txt_HoTen,txt_MatKhau,txt_DiaChi,txt_CCCD,txt_SoDienThoai;
	private JDateChooser dcr_NgaySinh;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_JLabel lbl_hinhAnhNV;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSNV;
	private DefaultTableModel dtm_NV;
	private Custom_Button btn_XoaTrang,btn_CapNhat,btn_Them;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_QuanLy_NhanVien frame = new View_QuanLy_NhanVien();
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
		
		lbl_Title_QL_NV = new JLabel("Quản lý nhân viên");
		lbl_Title_QL_NV.setForeground(Custom_ColorPicker.lavender_ED91FF);
		lbl_Title_QL_NV.setFont(new Font("Inter",Font.BOLD,40));
		lbl_Title_QL_NV.setBounds(30,100,2500,50);
		pn_Master.add(lbl_Title_QL_NV);
		
		pn_QL_NV = new JPanel();
		pn_QL_NV.setIgnoreRepaint(true);
		pn_QL_NV.setBackground(Color.white);
		pn_QL_NV.setLayout(null);
		pn_QL_NV.setBounds(new Rectangle(30, 150, 2500, 500));
		pn_QL_NV.setBorder(BorderFactory.createLineBorder(Custom_ColorPicker.lavender_ED91FF, 3));
		pn_Master.add(pn_QL_NV);
		
		lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setLocation(20, 52);
		lbl_MaNV.setSize(298, 48);
		lbl_MaNV.setForeground(Color.black);
		lbl_MaNV.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_MaNV);
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setLocation(20, 132);
		lbl_HoTen.setSize(298, 48);
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_HoTen);
		
		lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setLocation(20, 212);
		lbl_ChucVu.setSize(298, 48);
		lbl_ChucVu.setForeground(Color.black);
		lbl_ChucVu.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_ChucVu);
		
		lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setLocation(20, 292);
		lbl_MatKhau.setSize(298, 48);
		lbl_MatKhau.setForeground(Color.black);
		lbl_MatKhau.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_MatKhau);
		
		lbl_NgaySinh = new JLabel("Ngày sinh:");
		lbl_NgaySinh.setLocation(925, 52);
		lbl_NgaySinh.setSize(298, 48);
		lbl_NgaySinh.setForeground(Color.black);
		lbl_NgaySinh.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_NgaySinh);
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setLocation(925, 132);
		lbl_GioiTinh.setSize(298, 48);
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_GioiTinh);

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setLocation(925, 212);
		lbl_DiaChi.setSize(298, 48);
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_DiaChi);
		
		lbl_CCCD = new JLabel("CCCD:");
		lbl_CCCD.setLocation(1760, 52);
		lbl_CCCD.setSize(298, 48);
		lbl_CCCD.setForeground(Color.black);
		lbl_CCCD.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_CCCD);
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setLocation(1760, 132);
		lbl_SoDienThoai.setSize(298, 48);
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.BOLD, 40));
		pn_QL_NV.add(lbl_SoDienThoai);
		
		
		lbl_txt_MaNV = new JLabel();
		lbl_txt_MaNV.setLocation(318, 50);
		lbl_txt_MaNV.setSize(350, 50);
		lbl_txt_MaNV.setForeground(Color.black);
		lbl_txt_MaNV.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lbl_txt_MaNV.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaNV.setOpaque(true);
		pn_QL_NV.add(lbl_txt_MaNV);
		
		
		txt_HoTen = new JTextField();
		txt_HoTen.setLocation(318, 130);
		txt_HoTen.setSize(350, 50);
		txt_HoTen.setForeground(Color.black);
		txt_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_HoTen.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NV.add(txt_HoTen);
		
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
		pn_QL_NV.add(cbo_ChucVu);
		
		txt_MatKhau = new JTextField();
		txt_MatKhau.setLocation(318, 290);
		txt_MatKhau.setSize(350, 50);
		txt_MatKhau.setForeground(Color.black);
		txt_MatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_MatKhau.setOpaque(true);
		txt_MatKhau.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NV.add(txt_MatKhau);
		
		
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
		pn_QL_NV.add(dcr_NgaySinh);

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
		pn_QL_NV.add(cbo_GioiTinh);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setLocation(1150, 210);
		txt_DiaChi.setSize(1240, 50);
		txt_DiaChi.setForeground(Color.black);
		txt_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_DiaChi.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NV.add(txt_DiaChi);
		
		txt_CCCD = new JTextField();
		txt_CCCD.setLocation(2040, 50);
		txt_CCCD.setSize(350, 50);
		txt_CCCD.setForeground(Color.black);
		txt_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_CCCD.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NV.add(txt_CCCD);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setLocation(2040, 130);
		txt_SoDienThoai.setSize(350, 50);
		txt_SoDienThoai.setForeground(Color.black);
		txt_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		txt_SoDienThoai.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Custom_ColorPicker.lavender_ED91FF, Custom_ColorPicker.snowwhite_F2F0EB));
		pn_QL_NV.add(txt_SoDienThoai);
		
		
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
		btn_Them.setLocation(2090, 370);
		btn_Them.setSize(300, 80);
		pn_QL_NV.add(btn_Them);
		
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
		btn_CapNhat.setLocation(1740, 370);
		btn_CapNhat.setSize(300, 80);
		pn_QL_NV.add(btn_CapNhat);
		
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
		btn_XoaTrang.setLocation(1390, 370);
		btn_XoaTrang.setSize(300, 80);
		pn_QL_NV.add(btn_XoaTrang);
		
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
	public View_QuanLy_NhanVien() {
		setting_View_TimKiem_SanPham();
		draw_View_TimKiem_SanPham();
	}
}
