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
import dataBase_DAO.DataBase_NhaCungCap;
import entities.NhaCungCap;
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

public class Panel_QuanLyNhaCungCap extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_QL_NCC,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_QL_NCC,lbl_Title_DSNCC;
	private JLabel lbl_MaNCC,lbl_TenNCC,lbl_Email,lbl_DiaChi,lbl_SoDienThoai;
	private JTextField txt_HoTen,txt_DiaChi,txt_Email,txt_SoDienThoai;
	private JLabel lbl_txt_MaNCC;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_Them,btn_XoaTrang,btn_CapNhat;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSNCC;
	private DefaultTableModel dtm_NCC;
	private DataBase_NhaCungCap sqlNhaCungCap=new DataBase_NhaCungCap();
    // End of variables declaration//GEN-END:variables
    public Panel_QuanLyNhaCungCap() {
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
    	lbl_Title_QL_NCC = new JLabel("Quản lý nhà cung cấp:");
    	lbl_Title_QL_NCC.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_QL_NCC.setForeground(new Color(0, 0, 255));
		lbl_Title_QL_NCC.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_QL_NCC.setBounds(30,100,2500,50);
		
    	pn_QL_NCC = new JPanel();
		pn_QL_NCC.setIgnoreRepaint(true);
		pn_QL_NCC.setBackground(Color.white);
		pn_QL_NCC.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
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
		
		lbl_txt_MaNCC = new JLabel();
		lbl_txt_MaNCC.setForeground(Color.black);
		lbl_txt_MaNCC.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaNCC.setOpaque(true);
		lbl_txt_MaNCC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_HoTen = new JTextField();
		txt_HoTen.setForeground(Color.black);
		txt_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_Email = new JTextField();
		txt_Email.setForeground(Color.black);
		txt_Email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setForeground(Color.black);
		txt_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setForeground(Color.black);
		txt_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSNCC = new JLabel("Danh sách nhà cung cấp");
		lbl_Title_DSNCC.setForeground(Color.BLUE);
		lbl_Title_DSNCC.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_NCC = new DefaultTableModel(new String[] {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Email","Địa chỉ"},0);
		/*
		dtm_NCC = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_NCC.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}*/
		tbl_DSNCC = new Custom_Table(dtm_NCC);
		tbl_DSNCC.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNCC.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSNV.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSNCC.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNCC.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSNCC.align(3,new int[] {6,8,9,10,11});
		tbl_DSNCC.redrawn_Custom_Table();
		JScrollPane scr_DSNV = new JScrollPane(tbl_DSNCC);
		
		btn_Them = new Custom_Button();
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Them.setText("Thêm");
		btn_Them.setFont(new Font("Inner", Font.BOLD, 12));
		btn_Them.setBuffered_Icon("src/main/images/view_image/Add product.png");
		btn_Them.resizeIcon(14, 14);
		btn_Them.setOver(true);
		btn_Them.setColor_Foreground(Color.black);
		btn_Them.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_Them.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_Them.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_Them.setColor_Click(Color.black);
		btn_Them.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		btn_CapNhat = new Custom_Button();
		btn_CapNhat.setText("Cập nhật");
		btn_CapNhat.setFont(new Font("Inner", Font.BOLD, 12));
		btn_CapNhat.setBuffered_Icon("src/main/images/view_image/Update.png");
		btn_CapNhat.resizeIcon(14, 14);
		btn_CapNhat.setOver(true);
		btn_CapNhat.setColor_Foreground(Color.black);
		btn_CapNhat.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_CapNhat.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_CapNhat.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_CapNhat.setColor_Click(Color.black);
		btn_CapNhat.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
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
								.addComponent(pn_QL_NCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_QL_NCC))
								.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)))
						.addComponent(lbl_Title_DSNCC))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_QL_NCC)
					.addGap(1)
					.addComponent(pn_QL_NCC, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSNCC)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(0))
		);
        this.setLayout(layout);
        
        GroupLayout gl_pn_QL_NCC = new GroupLayout(pn_QL_NCC);
        gl_pn_QL_NCC.setHorizontalGroup(
        	gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_NCC.createSequentialGroup()
        			.addGap(59)
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_MaNCC)
        				.addComponent(lbl_TenNCC, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_txt_MaNCC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(txt_HoTen, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_Email)
        				.addComponent(lbl_DiaChi))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_NCC.createSequentialGroup()
        					.addComponent(txt_Email, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        					.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_QL_NCC.createSequentialGroup()
        							.addGap(11)
        							.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
        							.addComponent(txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_NCC.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(txt_DiaChi, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        			.addGap(62))
        );
        gl_pn_QL_NCC.setVerticalGroup(
        	gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_NCC.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_txt_MaNCC, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_MaNCC)
        				.addComponent(txt_SoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txt_Email, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_Email, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addGap(7)
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_TenNCC)
        				.addComponent(txt_HoTen, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_DiaChi)
        				.addComponent(txt_DiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NCC.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pn_QL_NCC.linkSize(SwingConstants.VERTICAL, new Component[] {btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_NCC.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_Email, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_QL_NCC.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_MaNCC, txt_HoTen, txt_Email, txt_SoDienThoai, txt_DiaChi});
        gl_pn_QL_NCC.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_NCC.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_Email, lbl_DiaChi, lbl_SoDienThoai});
        pn_QL_NCC.setLayout(gl_pn_QL_NCC);
        addAction();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
	{
		sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
		btn_Them.addActionListener(this);
		btn_CapNhat.addActionListener(this);
		btn_XoaTrang.addActionListener(this);	
		tbl_DSNCC.addMouseListener(this);
	}
	/*
	 * private void themKhachHang()
	{
		String tenKH=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
		
		try
		{
			KhachHang k=new KhachHang();
			k.setTenKH(tenKH);
			k.setDiaChi(diaChi);
			k.setGioiTinh(gioiTinhBool(gioiTinh));
			k.setSdt(sdt);
			sqlKhachHang.themKhachHang(k);
			dtm_KH.setRowCount(0);
			sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
			xoaTrang();
		}catch(Exception e)
		{
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	 */
	private void themNhaCungCap()
	{
		String tenNCC=txt_HoTen.getText();
		String sdt=txt_SoDienThoai.getText();
		String diaChi=txt_DiaChi.getText();
		String email=txt_Email.getText();
		try
		{
			NhaCungCap n=new NhaCungCap();
			n.setTenNCC(tenNCC);
			n.setSdtNCC(sdt);
			n.setEmail(email);
			n.setDiaChi(diaChi);
			sqlNhaCungCap.themNhaCungCap(n);
			dtm_NCC.setRowCount(0);
			sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
		}catch(Exception e)
		{
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	private void xoaTrang()
	{
		txt_HoTen.setText("");
		txt_DiaChi.setText("");
		txt_SoDienThoai.setText("");
		txt_Email.setText("");
		lbl_txt_MaNCC.setText("");
		txt_HoTen.requestFocus();
		dtm_NCC.setRowCount(0);
		sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
	}
	private void capNhatNhaCungCap()
	{
		int row = tbl_DSNCC.getSelectedRow();
		if(row!=-1)
		{
			String maNCC=lbl_txt_MaNCC.getText();
			String tenNCC=txt_HoTen.getText();
			String sdt=txt_SoDienThoai.getText();
			String diaChi=txt_DiaChi.getText();
			String email=txt_Email.getText();
			NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdt, email, diaChi);
			sqlNhaCungCap.capNhatNhaCungCap(n);
			dtm_NCC.setRowCount(0);
			sqlNhaCungCap.xuatDanhSachNhaCungCap(dtm_NCC);
			//cập nhật xong thì bỏ chọn
			tbl_DSNCC.clearSelection();
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private boolean kiemTraRangBuoc()
	{
		String tenNCC=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		String email=txt_Email.getText();
		if(tenNCC.trim().equals("")||diaChi.trim().equals("")||sdt.trim().equals("")||email.trim().equals(""))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Vui lòng nhập hết dữ liệu.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_HoTen.requestFocus();
	        return false;
		}
		if(!tenNCC.matches("^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)*$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Họ và tên không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_HoTen.requestFocus();
	        return false;
		}
		if(!sdt.matches("^0[0-9]{9}$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_SoDienThoai.requestFocus();
	        return false;
		}
		if(!diaChi.matches("^[a-zA-Z0-9,./\\p{L} ]*$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ do có kí tự đặc biệt.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_DiaChi.requestFocus();
	        return false;
		}
		if(!email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Email không hợp lệ.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_DiaChi.requestFocus();
	        return false;
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
	
		if(o.equals(btn_Them))
		{
			if(kiemTraRangBuoc())
				themNhaCungCap();
		}
		if(o.equals(btn_CapNhat))
		{
			capNhatNhaCungCap();
		}
		if(o.equals(btn_XoaTrang))
		{
			xoaTrang();
		}
	}
	
	/*
	 * int row=tbl_DSKH.getSelectedRow();
		lbl_txt_MaKH.setText(tbl_DSKH.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSKH.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSKH.getValueAt(row, 2).toString());
		cbo_GioiTinh.setSelectedItem(tbl_DSKH.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSKH.getValueAt(row, 4).toString());
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=tbl_DSNCC.getSelectedRow();
		lbl_txt_MaNCC.setText(tbl_DSNCC.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSNCC.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSNCC.getValueAt(row, 2).toString());
		txt_Email.setText(tbl_DSNCC.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSNCC.getValueAt(row, 4).toString());
		
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
