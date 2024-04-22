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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_QuanLyKhachHang extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_QL_KH,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_QL_KH,lbl_Title_DSKH;
	private JLabel lbl_MaKH,lbl_HoTen,lbl_GioiTinh,lbl_DiaChi,lbl_SoDienThoai;
	private Custom_ComboBox cbo_GioiTinh;
	private JTextField txt_HoTen,txt_DiaChi,txt_SoDienThoai;
	private JLabel lbl_txt_MaKH;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_Them,btn_XoaTrang,btn_CapNhat;
	private JScrollPane scr_DSNV;
	private Custom_Table tbl_DSKH;
	private DefaultTableModel dtm_KH;
	private DataBase_KhachHang sqlKhachHang=new DataBase_KhachHang();
    // End of variables declaration//GEN-END:variables
    public Panel_QuanLyKhachHang() {
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
    	lbl_Title_QL_KH = new JLabel("Quản lý khách hàng:");
    	lbl_Title_QL_KH.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_QL_KH.setForeground(new Color(0, 0, 255));
		lbl_Title_QL_KH.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_QL_KH.setBounds(30,100,2500,50);
		
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
		
		lbl_txt_MaKH = new JLabel();
		lbl_txt_MaKH.setForeground(Color.black);
		lbl_txt_MaKH.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaKH.setOpaque(true);
		lbl_txt_MaKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_HoTen = new JTextField();
		txt_HoTen.setForeground(Color.black);
		txt_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setForeground(Color.black);
		txt_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setForeground(Color.black);
		txt_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSKH = new JLabel("Danh sách khách hàng");
		lbl_Title_DSKH.setForeground(Color.BLUE);
		lbl_Title_DSKH.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_KH = new DefaultTableModel(new String[] {"Mã khách hàng","Tên khách hàng","Số điện thoại","Giới tính","Địa chỉ"},0);
		/*
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
								.addComponent(pn_QL_KH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_QL_KH))
								.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)))
						.addComponent(lbl_Title_DSKH))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_QL_KH)
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
        					.addComponent(lbl_txt_MaKH, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addComponent(txt_HoTen, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
        			.addGap(4)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_GioiTinh)
        				.addComponent(lbl_DiaChi))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_KH.createSequentialGroup()
        					.addComponent(cbo_GioiTinh, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        					.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_QL_KH.createSequentialGroup()
        							.addGap(11)
        							.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
        							.addComponent(txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_KH.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(txt_DiaChi, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        			.addGap(62))
        );
        gl_pn_QL_KH.setVerticalGroup(
        	gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_KH.createSequentialGroup()
        			.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_KH.createSequentialGroup()
        					.addGap(41)
        					.addComponent(txt_HoTen, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_KH.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_KH.createSequentialGroup()
        							.addComponent(lbl_MaKH)
        							.addGap(13)
        							.addComponent(lbl_HoTen))
        						.addGroup(gl_pn_QL_KH.createSequentialGroup()
        							.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.LEADING)
        								.addComponent(txt_SoDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_GioiTinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_txt_MaKH, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addGap(8)
        							.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lbl_DiaChi)
        								.addComponent(txt_DiaChi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(gl_pn_QL_KH.createParallelGroup(Alignment.BASELINE)
        								.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))))
        			.addContainerGap(58, Short.MAX_VALUE))
        );
        gl_pn_QL_KH.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_MaKH, txt_HoTen, cbo_GioiTinh, txt_SoDienThoai, txt_DiaChi});
        gl_pn_QL_KH.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_QL_KH.linkSize(SwingConstants.VERTICAL, new Component[] {btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_KH.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_SoDienThoai});
        gl_pn_QL_KH.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_Them, btn_CapNhat, btn_XoaTrang});
        pn_QL_KH.setLayout(gl_pn_QL_KH);
        addAction();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
	{
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
		btn_Them.addActionListener(this);
		//btn_Logout.addActionListener(this);
		btn_CapNhat.addActionListener(this);
		btn_XoaTrang.addActionListener(this);
		//btn_Home.addActionListener(this);
		cbo_GioiTinh.addItem("Chọn");
		cbo_GioiTinh.addItem("Nam");
		cbo_GioiTinh.addItem("Nữ");
		cbo_GioiTinh.addActionListener(this);
		//tbl_DSKH.getValueAt(row, 2).toString()
		tbl_DSKH.addMouseListener(this);
	}
	/*
	private boolean kiemTraRangBuoc()
	{
		String tenKH=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		
	}*/
	private void xoaTrang()
	{
		lbl_txt_MaKH.setText("");
		txt_HoTen.setText("");
		txt_SoDienThoai.setText("");
		txt_DiaChi.setText("");
		cbo_GioiTinh.setSelectedItem("Chọn");
		dtm_KH.setRowCount(0);
		sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
	}
	/*
	 * try 
		{
			HangHoaKho h=new HangHoaKho(maHangHoa, tenHangHoa,dateSanXuat.getDate(), dateHetHan.getDate(), giaCaDouble, soLuongInt);
			if (dao.themHangHoaKho(h)) 
			{
				String[] row = {maHangHoa,tenHangHoa,dateSanXuat.getDate().toString(),dateHetHan.getDate().toString(),Double.toString(giaCaDouble),soLuong+""};
				tableModel.addRow(row);
				sqlHangHoaKho.themHangHoaKho(h);
				resetField();			
			}else 
			{
				JOptionPane.showMessageDialog(null, "Hàng hoá trùng nhau.");
				txtMaHangHoa.selectAll();
				txtMaHangHoa.requestFocus();
			}
		} catch (Exception ex) 
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
	 */
	//KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String diaChi)
	private boolean gioiTinhBool(String gioiTinh)
	{
		if(gioiTinh.equalsIgnoreCase("Nam"))
			return true;
		return false;
	}

	private boolean kiemTraRangBuoc()
	{
		String tenKH=txt_HoTen.getText();
		String diaChi=txt_DiaChi.getText();
		String sdt=txt_SoDienThoai.getText();
		String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
		if(tenKH.trim().equals("")||diaChi.trim().equals("")||sdt.trim().equals(""))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Vui lòng nhập hết dữ liệu.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_HoTen.requestFocus();
	        return false;
		}
		if(gioiTinh.equalsIgnoreCase("Chọn"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        //JOptionPane.showMessageDialog(null, "Hãy cẩn thận khi thực hiện thao tác này.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	        //JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.", "Warning", JOptionPane.ERROR_MESSAGE);
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
		}
		if(!tenKH.matches("^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)*$"))
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
		//^[a-zA-Z0-9 ]+$
		if(!diaChi.matches("^[a-zA-Z0-9,./\\p{L} ]*$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ do có kí tự đặc biệt.", "Warning", JOptionPane.WARNING_MESSAGE);
	        txt_DiaChi.requestFocus();
	        return false;
		}
		
		return true;
		
	}
	private void themKhachHang()
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
	/*
	 * private void xoaActions() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int maNV = Integer.parseInt((String) table.getModel().getValueAt(row, 0));
			int kTra = JOptionPane.showConfirmDialog(this, "Chắc chắn xoá không", "Chú ý", JOptionPane.YES_NO_OPTION);
			if (kTra == JOptionPane.YES_OPTION) {
				if (dao.xoaNhanVien(maNV))
					tableModel.removeRow(row);
			}
		}
	}
	 */
	private void capNhatKhachHang()
	{
		int row = tbl_DSKH.getSelectedRow();
		if(row!=-1)
		{
			String maKH=lbl_txt_MaKH.getText();
			String tenKH=txt_HoTen.getText();
			String diaChi=txt_DiaChi.getText();
			String sdt=txt_SoDienThoai.getText();
			String gioiTinh = (String) cbo_GioiTinh.getSelectedItem();
			KhachHang k=new KhachHang(maKH, tenKH, sdt, gioiTinhBool(gioiTinh), diaChi);
			sqlKhachHang.capNhatKhachHang(k);
			dtm_KH.setRowCount(0);
			sqlKhachHang.xuatDanhSachKhachHang(dtm_KH);
			//cập nhật xong thì bỏ chọn
			tbl_DSKH.clearSelection();
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn dữ liệu để cập nhật.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
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
			xoaTrang();
			txt_HoTen.requestFocus();
		}
		if(o.equals(btn_Them))
		{
			if(kiemTraRangBuoc())
				themKhachHang();
		}
		if(o.equals(btn_CapNhat))
		{
			if(kiemTraRangBuoc())
				capNhatKhachHang();
		}
		//if(o == btn)
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
		int row=tbl_DSKH.getSelectedRow();
		lbl_txt_MaKH.setText(tbl_DSKH.getValueAt(row, 0).toString());
		txt_HoTen.setText(tbl_DSKH.getValueAt(row, 1).toString());
		txt_SoDienThoai.setText(tbl_DSKH.getValueAt(row, 2).toString());
		cbo_GioiTinh.setSelectedItem(tbl_DSKH.getValueAt(row, 3).toString());
		txt_DiaChi.setText(tbl_DSKH.getValueAt(row, 4).toString());
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
