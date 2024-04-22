package views_Testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_Function;
import customEntities.Custom_JTextField;
import customEntities.RoundedCornerBorder;

public class GUI_DangNhap extends JFrame implements ActionListener{
	private JPanel pn_Master;
	private JLabel picture_Books,picture_Knowledge,picture_Logo;
	private Custom_Button btn_Login,btn_Undo,btn_Close;
	private Custom_JTextField txt_MaTK;
	private JPasswordField txt_MatKhau;
	private JLabel lbl_DangNhap,lbl_MaTaiKhoan,lbl_MatKhau;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DangNhap frame = new GUI_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setting_View_DangNhap() {
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
		pn_Master.setBackground(Custom_ColorPicker.lavender_ED91FF);
		pn_Master.setLayout(null);
	}
	public void draw_View_DangNhap() {
		picture_Books = new JLabel();
		picture_Books.setBounds(1897,274,500,500);
		picture_Books.setIcon(new ImageIcon("src\\main\\images\\view_image\\Books.png"));
		picture_Books.setVisible(true);
		pn_Master.add(picture_Books);
		
		picture_Knowledge = new JLabel();
		picture_Knowledge.setBounds(143,274,500,500);
		picture_Knowledge.setIcon(new ImageIcon("src\\main\\images\\view_image\\Knowledge.png"));
		picture_Knowledge.setVisible(true);
		pn_Master.add(picture_Knowledge);
		
		picture_Logo = new JLabel();
		picture_Logo.setBounds(1053,294,500,500);
		picture_Logo.setIcon(new ImageIcon("src\\main\\images\\view_image\\Logo.png"));
		picture_Logo.setVisible(true);
		pn_Master.add(picture_Logo);
		
		lbl_DangNhap = new JLabel();
		lbl_DangNhap.setText("Đăng nhập");
		lbl_DangNhap.setFont(new Font("Inner", Font.BOLD, 64));
		lbl_DangNhap.setBounds(1144,75,339,125);
		lbl_DangNhap.setVisible(true);
		pn_Master.add(lbl_DangNhap);
		
		lbl_MaTaiKhoan = new JLabel();
		lbl_MaTaiKhoan.setText("Mã tài khoản");
		lbl_MaTaiKhoan.setFont(new Font("Inner", Font.BOLD, 64));
		lbl_MaTaiKhoan.setBounds(628,864,460,86);
		lbl_MaTaiKhoan.setVisible(true);
		pn_Master.add(lbl_MaTaiKhoan);
		
		lbl_MatKhau = new JLabel();
		lbl_MatKhau.setText("Mật khẩu");
		lbl_MatKhau.setFont(new Font("Inner", Font.BOLD, 64));
		lbl_MatKhau.setBounds(628,982,460,86);
		lbl_MatKhau.setVisible(true);
		pn_Master.add(lbl_MatKhau);
		
		txt_MaTK = new Custom_JTextField();
		txt_MaTK.setPlaceholder("VD: NVBH001");
		txt_MaTK.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		txt_MaTK.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txt_MaTK.setBounds(1088,864,797,86);
		txt_MaTK.setVisible(true);
		pn_Master.add(txt_MaTK);
		
		txt_MatKhau = new JPasswordField();
		txt_MatKhau.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		txt_MatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txt_MatKhau.setBounds(1088,982,797,86);
		txt_MatKhau.setVisible(true);
		pn_Master.add(txt_MatKhau);
		
		btn_Close = new Custom_Button();
		btn_Close.setBuffered_Icon("src/main/images/view_image/Close.png");
		btn_Close.resizeIcon(80,80);
		btn_Close.setRadius(40);
		btn_Close.setOver(true);
		btn_Close.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_Close.setColor_Over(Color.white);
		btn_Close.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Close.setBounds(2450, 12, 80, 80);
		pn_Master.add(btn_Close);
		btn_Close.addActionListener(this);
		
		btn_Undo = new Custom_Button();
		btn_Undo.setBuffered_Icon("src/main/images/view_image/Undo.png");
		btn_Undo.resizeIcon(80,80);
		btn_Undo.setRadius(40);
		btn_Undo.setOver(true);
		btn_Undo.setColor_Background(Custom_ColorPicker.lavender_ED91FF);
		btn_Undo.setColor_Over(Color.white);
		btn_Undo.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Undo.setBounds(2330, 12, 80, 80);
		pn_Master.add(btn_Undo);
		btn_Undo.addActionListener(this);
		
		btn_Login = new Custom_Button();
		btn_Login.setBuffered_Icon("src/main/images/view_image/Person Accepted.png");
		btn_Login.setText("Đăng nhập");
		btn_Login.setFont(new Font("Inner", Font.PLAIN, 30));
		btn_Login.resizeIcon(50,50);
		btn_Login.setRadius(30);
		btn_Login.setOver(true);
		btn_Login.setColor_Foreground(Custom_ColorPicker.lavender_ED91FF);
		btn_Login.setColor_Hightlight(Color.WHITE);
		btn_Login.setColor_Background(Color.white);
		btn_Login.setColor_Over(Custom_ColorPicker.lavender_ED91FF);
		btn_Login.setColor_Click(Color.black);
		btn_Login.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		btn_Login.setBounds(1164, 1172, 300, 80);
		pn_Master.add(btn_Login);
		btn_Login.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btn_Close) {
			System.exit(0);
		}
	}
	public GUI_DangNhap() {
		// TODO Auto-generated constructor stub
		setting_View_DangNhap();
		draw_View_DangNhap();
	}
}
