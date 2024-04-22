package gui_Panel;

import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_ImageIcon;
import customEntities.Custom_JLabel;
import customEntities.Custom_Table;
import dataBase_DAO.DataBase_KhachHang;
import entities.KhachHang;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_TimKiemKhachHang extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_QL_KH,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_TK_KH,lbl_Title_DSKH;
	private JLabel lbl_MaKH,lbl_HoTen,lbl_GioiTinh,lbl_DiaChi,lbl_SoDienThoai;
	private Custom_ComboBox cbo_MaKH,cbo_GioiTinh,cbo_HoTen,cbo_DiaChi,cbo_SoDienThoai;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_TimKiem,btn_XoaTrang;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSKH;
	private DefaultTableModel dtm_KH;
    // End of variables declaration//GEN-END:variables
	private DataBase_KhachHang sqlKhachHang=new DataBase_KhachHang();
    public Panel_TimKiemKhachHang() {
        initComponents();
        setOpaque(false);
    }



    private void showMessage(String message) {
        Message obj = new Message(Frame_Chinh.getFrames()[0], true);
        obj.showMessage(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	lbl_Title_TK_KH = new JLabel("Tìm kiếm khách hàng");
    	lbl_Title_TK_KH.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_TK_KH.setForeground(new Color(0, 0, 255));
		lbl_Title_TK_KH.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_TK_KH.setBounds(30,100,2500,50);
		
    	pn_QL_KH = new JPanel();
		pn_QL_KH.setIgnoreRepaint(true);
		pn_QL_KH.setBackground(Color.white);
		pn_QL_KH.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaKH = new JLabel("Mã khách hàng:");
		lbl_MaKH.setForeground(Color.black);
		lbl_MaKH.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaKH = new Custom_ComboBox();
		cbo_MaKH.setForeground(Color.black);
		cbo_MaKH.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaKH.setOpaque(true);
		cbo_MaKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_HoTen = new Custom_ComboBox();
		cbo_HoTen.setForeground(Color.black);
		cbo_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setForeground(Color.black);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSKH = new JLabel("Danh sách khách hàng");
		lbl_Title_DSKH.setForeground(Color.BLUE);
		lbl_Title_DSKH.setFont(new Font("SansSerif", Font.BOLD, 12));
		dtm_KH = new DefaultTableModel(new String[] {"Mã khách hàng","Tên khách hàng","Số điện thoại","Giới tính","Địa chỉ"},0);
		/*
		dtm_KH = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_KH.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}*/
		tbl_DSKH = new Custom_Table(dtm_KH);
		tbl_DSKH.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSKH.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSNV.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSKH.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSKH.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSKH.align(3,new int[] {6,8,9,10,11});
		tbl_DSKH.redrawn_Custom_Table();
		JScrollPane scr_DSNV = new JScrollPane(tbl_DSKH);
		
		btn_TimKiem = new Custom_Button();
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setFont(new Font("Inner", Font.BOLD, 12));
		btn_TimKiem.setBuffered_Icon("src/main/images/view_image/Search.png");
		btn_TimKiem.resizeIcon(14, 14);
		btn_TimKiem.setOver(true);
		btn_TimKiem.setColor_Foreground(Color.black);
		btn_TimKiem.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_TimKiem.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_TimKiem.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_TimKiem.setColor_Click(Color.black);
		btn_TimKiem.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		btn_XoaTrang = new Custom_Button();
		btn_XoaTrang.setText("Xóa trắng");
		btn_XoaTrang.setFont(new Font("Inner", Font.BOLD, 12));
		btn_XoaTrang.setBuffered_Icon("src/main/images/view_image/Refresh.png");
		btn_XoaTrang.resizeIcon(14, 14);
		btn_XoaTrang.setOver(true);
		btn_XoaTrang.setColor_Foreground(Color.black);
		btn_XoaTrang.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_XoaTrang.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_XoaTrang.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_XoaTrang.setColor_Click(Color.black);
		btn_XoaTrang.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(1)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(pn_QL_KH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_TK_KH))
								.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)))
						.addComponent(lbl_Title_DSKH))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_TK_KH)
					.addGap(1)
					.addComponent(pn_QL_KH, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSKH)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(0))
		);
        this.setLayout(layout);
        
        GroupLayout gl_pn_QL_KH = new GroupLayout(pn_QL_KH);
        gl_pn_QL_KH.setHorizontalGroup(
        	gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_KH.createSequentialGroup()
        			.addGap(59)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_HoTen, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_MaKH))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_KH.createSequentialGroup()
        					.addComponent(cbo_MaKH, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addComponent(cbo_HoTen, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
        			.addGap(4)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_GioiTinh)
        				.addComponent(lbl_DiaChi))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_KH.createSequentialGroup()
        					.addComponent(cbo_GioiTinh, GroupLayout.PREFERRED_SIZE, 117, Short.MAX_VALUE)
        					.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_QL_KH.createSequentialGroup()
        							.addGap(11)
        							.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        							.addGap(12)
        							.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 117, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_KH.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(cbo_DiaChi, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
        			.addGap(62))
        );
        gl_pn_QL_KH.setVerticalGroup(
        	gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_KH.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_MaKH)
        				.addComponent(cbo_MaKH, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_GioiTinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(7)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_DiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_DiaChi)
        				.addComponent(cbo_HoTen, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_HoTen))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pn_QL_KH.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaKH, cbo_HoTen, cbo_GioiTinh, cbo_SoDienThoai, cbo_DiaChi});
        gl_pn_QL_KH.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_QL_KH.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_QL_KH.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_QL_KH.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        pn_QL_KH.setLayout(gl_pn_QL_KH);
        addDataComboBox();
		addAction();
    }// </editor-fold>//GEN-END:initComponents

    private void addAction()
	{
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
		//sqlKhachHang.dayComboBoxMaKH(cbo_MaKH);
		//btn_Close.addActionListener(this);
		btn_XoaTrang.addActionListener(this);
		btn_TimKiem.addActionListener(this);
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
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
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
		//Tìm theo tên
		if(maKH.equalsIgnoreCase("Chọn")&&!tenKH.equalsIgnoreCase("Chọn")&&
						gioiTinh.equalsIgnoreCase("Chọn")&&
						sdt.equalsIgnoreCase("Chọn")&&diaChi.equalsIgnoreCase("Chọn"))
		{
			dtm_KH.setRowCount(0);
			sqlKhachHang.timKiemTheoTen(tenKH, dtm_KH);
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
			sqlKhachHang.timKiemTheo_diaChi_gioiTinh(k, dtm_KH);
		}
		//3 tiêu chí
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
		//Tìm kiếm theo tenKH, diaChi, gioiTinh
		if(maKH.equalsIgnoreCase("Chọn") &&!tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				sdt.equalsIgnoreCase("Chọn") &&! diaChi.equalsIgnoreCase("Chọn"))
		{
			
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			k.setDiaChi(diaChi);
			sqlKhachHang.timKiemTheo_tenKH_diaChi_gioiTinh(k, dtm_KH);
		}
		//Tìm kiếm theo tất cả điều kiện trừ maKH
		if(maKH.equalsIgnoreCase("Chọn") &&!tenKH.equalsIgnoreCase("Chọn")&&
				!gioiTinh.equalsIgnoreCase("Chọn")&&
				!sdt.equalsIgnoreCase("Chọn") && !diaChi.equalsIgnoreCase("Chọn"))		
		{
			dtm_KH.setRowCount(0);
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setDiaChi(diaChi);
			k.setSdt(sdt);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			sqlKhachHang.timKiemTheoTieuChiKhacMaKH(k, dtm_KH);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		/*
		if(o .equals(btn_Close) ) 
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			int exit = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không ?", "Thông báo.", JOptionPane.YES_NO_OPTION);

	        if (exit == JOptionPane.YES_OPTION) {
	            // Xử lý khi người dùng chọn "Yes"
	        	System.exit(0);
	        } 	
		}*/
		if(o.equals(btn_XoaTrang))
		{
			resetComboBox();
		}
		if(o.equals(btn_TimKiem))
		{		
			timKiem();
		}
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
