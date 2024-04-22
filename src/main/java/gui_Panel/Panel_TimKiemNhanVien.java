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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_TimKiemNhanVien extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_TK_NV,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_TK_NV,lbl_Title_DSNV;
	private JLabel lbl_MaNV,lbl_HoTen,tK,lbl_ChucVu,lbl_GioiTinh,lbl_NgaySinh,lbl_DiaChi,lbl_CaLam,lbl_CCCD,lbl_SoDienThoai;
	private Custom_ComboBox cbo_MaNV,cbo_NgonNgu,cbo_GioiTinh,cbo_CaLam;
	private JLabel lbl_txt_MatKhau;
	private Custom_ComboBox cbo_HoTen,cbo_DiaChi,cbo_CCCD,cbo_Ngay,cbo_Thang,cbo_Nam,cbo_SoDienThoai;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_TimKiem,btn_XoaTrang;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSNV;
	private DefaultTableModel dtm_SP;
    // End of variables declaration//GEN-END:variables
    public Panel_TimKiemNhanVien() {
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
    	lbl_Title_TK_NV = new JLabel("Tìm kiếm nhân viên");
    	lbl_Title_TK_NV.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_TK_NV.setForeground(new Color(0, 0, 255));
		lbl_Title_TK_NV.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_TK_NV.setBounds(30,100,2500,50);
		
    	pn_TK_NV = new JPanel();
		pn_TK_NV.setIgnoreRepaint(true);
		pn_TK_NV.setBackground(Color.white);
		pn_TK_NV.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setForeground(Color.black);
		lbl_MaNV.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.PLAIN, 14));
		
		tK = new JLabel("Mật khẩu:");
		tK.setForeground(Color.black);
		tK.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setForeground(Color.black);
		lbl_ChucVu.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgaySinh = new JLabel("Ngày sinh:");
		lbl_NgaySinh.setForeground(Color.black);
		lbl_NgaySinh.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_CaLam = new JLabel("Ca làm:");
		lbl_CaLam.setForeground(Color.black);
		lbl_CaLam.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_CCCD = new JLabel("CCCD:");
		lbl_CCCD.setForeground(Color.black);
		lbl_CCCD.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaNV = new Custom_ComboBox();
		cbo_MaNV.setForeground(Color.black);
		cbo_MaNV.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaNV.setOpaque(true);
		cbo_MaNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_HoTen = new Custom_ComboBox();
		cbo_HoTen.setForeground(Color.black);
		cbo_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_txt_MatKhau = new JLabel();
		lbl_txt_MatKhau.setForeground(Color.black);
		lbl_txt_MatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl_txt_MatKhau.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MatKhau.setOpaque(true);
		
		cbo_NgonNgu = new Custom_ComboBox();
		cbo_NgonNgu.setForeground(Color.black);
		cbo_NgonNgu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_NgonNgu.setColor_Foreground(Color.black);
		cbo_NgonNgu.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NgonNgu.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NgonNgu.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_NgonNgu.redraw_Custom_Combobox();
		
		String[] string_NgayTrongThang = new String[31];
		for (int i = 0; i < 31; i++) {
			string_NgayTrongThang[i] = String.format("%02d",i+1);
		}
		
		cbo_Ngay = new Custom_ComboBox(string_NgayTrongThang);
		cbo_Ngay.setForeground(Color.black);
		cbo_Ngay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Ngay.setColor_Foreground(Color.black);
		cbo_Ngay.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Ngay.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Ngay.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Ngay.setArrowButton_IsVisible(false);
		cbo_Ngay.redraw_Custom_Combobox();
		cbo_Ngay.setRadius(0);
		
		String[] string_ThangTrongNam = new String[12];
		for (int i = 0; i < 12; i++) {
			string_ThangTrongNam[i] = String.format("%02d",i+1);
		}
		cbo_Thang = new Custom_ComboBox(string_ThangTrongNam);
		cbo_Thang.setForeground(Color.black);
		cbo_Thang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Thang.setColor_Foreground(Color.black);
		cbo_Thang.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Thang.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Thang.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Thang.setArrowButton_IsVisible(false);
		cbo_Thang.redraw_Custom_Combobox();
		cbo_Thang.setRadius(0);
		
		String[] string_Nam = new String[1500];
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		for (int i = 0; i < 1500; i++) {
			string_Nam[i] = String.format("%04d",namHienTai-i);
		}
		
		cbo_Nam = new Custom_ComboBox(string_Nam);
		cbo_Nam.setForeground(Color.black);
		cbo_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Nam.setColor_Foreground(Color.black);
		cbo_Nam.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Nam.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Nam.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Nam.setArrowButton_IsVisible(false);
		cbo_Nam.redraw_Custom_Combobox();
		cbo_Nam.setRadius(0);
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		
		
		cbo_CaLam = new Custom_ComboBox();
		cbo_CaLam.setForeground(Color.black);
		cbo_CaLam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_CCCD = new Custom_ComboBox();
		cbo_CCCD.setForeground(Color.black);
		cbo_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setForeground(Color.black);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSNV = new JLabel("Danh sách nhân viên");
		lbl_Title_DSNV.setForeground(Color.BLUE);
		lbl_Title_DSNV.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_SP.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}
		tbl_DSNV = new Custom_Table(dtm_SP);
		tbl_DSNV.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNV.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSNV.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSNV.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNV.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNV.align(2,new int[] {6,8,9,10,11});
		tbl_DSNV.redrawn_Custom_Table();
		JScrollPane scr_DSNV = new JScrollPane(tbl_DSNV);
		
		btn_TimKiem = new Custom_Button();
		btn_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
			layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_TK_NV))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DSNV))
						.addComponent(scr_DSNV, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pn_TK_NV, GroupLayout.PREFERRED_SIZE, 790, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_TK_NV)
					.addGap(1)
					.addComponent(pn_TK_NV, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSNV)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
		);
        this.setLayout(layout);
        
        
        
        GroupLayout gl_pn_TK_NV = new GroupLayout(pn_TK_NV);
        gl_pn_TK_NV.setHorizontalGroup(
        	gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_TK_NV.createSequentialGroup()
        			.addGap(59)
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_ChucVu, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_HoTen, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_MaNV, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(tK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(6)
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_TK_NV.createSequentialGroup()
        							.addComponent(cbo_MaNV, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(cbo_HoTen, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        						.addComponent(lbl_txt_MatKhau, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
        					.addGap(4))
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addComponent(cbo_NgonNgu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_NgaySinh, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_CaLam)
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_GioiTinh))
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_DiaChi)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_CaLam, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        						.addComponent(cbo_GioiTinh, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        						.addGroup(gl_pn_TK_NV.createSequentialGroup()
        							.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)))
        					.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_TK_NV.createSequentialGroup()
        							.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(gl_pn_TK_NV.createSequentialGroup()
        									.addGap(11)
        									.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_pn_TK_NV.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lbl_CCCD, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        								.addComponent(cbo_CCCD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(cbo_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        						.addGroup(gl_pn_TK_NV.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(cbo_DiaChi, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
        			.addGap(18))
        );
        gl_pn_TK_NV.setVerticalGroup(
        	gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_TK_NV.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_MaNV)
        				.addComponent(cbo_MaNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_NgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_CCCD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_CCCD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_GioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_HoTen, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_HoTen))
        			.addGap(8)
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_DiaChi)
        				.addComponent(cbo_DiaChi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tK)
        				.addComponent(lbl_txt_MatKhau, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addGap(6)
        					.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_ChucVu)
        						.addComponent(cbo_NgonNgu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_CaLam)
        						.addComponent(cbo_CaLam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_pn_TK_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_TK_NV.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(28, Short.MAX_VALUE))
        );
        gl_pn_TK_NV.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaNV, cbo_HoTen, lbl_txt_MatKhau, cbo_NgonNgu, cbo_Ngay, cbo_Thang, cbo_Nam, cbo_GioiTinh, cbo_CaLam, cbo_CCCD, cbo_SoDienThoai, cbo_DiaChi});
        gl_pn_TK_NV.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_GioiTinh, lbl_NgaySinh, lbl_DiaChi, lbl_CaLam, lbl_CCCD, lbl_SoDienThoai});
        gl_pn_TK_NV.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_TK_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_CaLam, lbl_CCCD, lbl_SoDienThoai});
        gl_pn_TK_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        pn_TK_NV.setLayout(gl_pn_TK_NV);
    }// </editor-fold>//GEN-END:initComponents
}
