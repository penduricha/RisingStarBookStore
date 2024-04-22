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
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_TimKiemNhaCungCap extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_TK_NCC,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_TK_NCC,lbl_Title_DSNCC;
	private JLabel lbl_MaNCC,lbl_TenNCC,lbl_Email,lbl_DiaChi,lbl_SoDienThoai;
	private Custom_ComboBox cbo_MaSP,cbo_HoTen,cbo_DiaChi,cbo_Email,cbo_SoDienThoai;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_TimKiem,btn_XoaTrang;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSNCC;
	private DefaultTableModel dtm_NCC;
    // End of variables declaration//GEN-END:variables
    public Panel_TimKiemNhaCungCap() {
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
    	lbl_Title_TK_NCC = new JLabel("Tìm kiếm nhà cung cấp");
    	lbl_Title_TK_NCC.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_TK_NCC.setForeground(new Color(0, 0, 255));
		lbl_Title_TK_NCC.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_TK_NCC.setBounds(30,100,2500,50);
		
    	pn_TK_NCC = new JPanel();
		pn_TK_NCC.setIgnoreRepaint(true);
		pn_TK_NCC.setBackground(Color.white);
		pn_TK_NCC.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaNCC = new JLabel("Mã nhà cung cấp:");
		lbl_MaNCC.setForeground(Color.black);
		lbl_MaNCC.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TenNCC = new JLabel("Tên nhà cung cấp:");
		lbl_TenNCC.setForeground(Color.black);
		lbl_TenNCC.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_Email = new JLabel("Email:");
		lbl_Email.setForeground(Color.black);
		lbl_Email.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaSP = new Custom_ComboBox();
		cbo_MaSP.setForeground(Color.black);
		cbo_MaSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaSP.setOpaque(true);
		cbo_MaSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_HoTen = new Custom_ComboBox();
		cbo_HoTen.setForeground(Color.black);
		cbo_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_Email = new Custom_ComboBox();
		cbo_Email.setForeground(Color.black);
		cbo_Email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setForeground(Color.black);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSNCC = new JLabel("Danh sách nhà cung cấp");
		lbl_Title_DSNCC.setForeground(Color.BLUE);
		lbl_Title_DSNCC.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_NCC = new DefaultTableModel(new String[] {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Email","Địa chỉ"},0);
		
		tbl_DSNCC = new Custom_Table(dtm_NCC);
		tbl_DSNCC.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNCC.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSNV.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSNCC.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNCC.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNCC.align(3,new int[] {6,8,9,10,11});
		tbl_DSNCC.redrawn_Custom_Table();
		JScrollPane scr_DSNV = new JScrollPane(tbl_DSNCC);
		
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
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(1)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(pn_TK_NCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_TK_NCC))
								.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)))
						.addComponent(lbl_Title_DSNCC))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_TK_NCC)
					.addGap(1)
					.addComponent(pn_TK_NCC, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSNCC)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(0))
		);
        this.setLayout(layout);
        
        GroupLayout gl_pn_TK_NCC = new GroupLayout(pn_TK_NCC);
        gl_pn_TK_NCC.setHorizontalGroup(
        	gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_TK_NCC.createSequentialGroup()
        			.addGap(59)
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_MaNCC)
        				.addComponent(lbl_TenNCC, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_MaSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cbo_HoTen, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_Email)
        				.addComponent(lbl_DiaChi))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_TK_NCC.createSequentialGroup()
        					.addComponent(cbo_Email, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        					.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_TK_NCC.createSequentialGroup()
        							.addGap(11)
        							.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
        							.addComponent(cbo_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(gl_pn_TK_NCC.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(cbo_DiaChi, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        			.addGap(62))
        );
        gl_pn_TK_NCC.setVerticalGroup(
        	gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_TK_NCC.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_MaSP, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_MaNCC)
        				.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Email, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_Email, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(7)
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_TenNCC)
        				.addComponent(cbo_HoTen, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_DiaChi)
        				.addComponent(cbo_DiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_NCC.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pn_TK_NCC.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaSP, cbo_HoTen, cbo_Email, cbo_SoDienThoai, cbo_DiaChi});
        gl_pn_TK_NCC.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_Email, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_TK_NCC.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_TK_NCC.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_Email, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_TK_NCC.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        pn_TK_NCC.setLayout(gl_pn_TK_NCC);
       
    }// </editor-fold>//GEN-END:initComponents
    
}
