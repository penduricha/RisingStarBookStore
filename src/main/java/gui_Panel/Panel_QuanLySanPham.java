package gui_Panel;

import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_ImageIcon;
import customEntities.Custom_JLabel;
import customEntities.Custom_Table;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

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
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JButton;

public class Panel_QuanLySanPham extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
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
	private Custom_Button btn_Them,btn_XoaTrang,btn_CapNhat,btn_ChonAnh;
	private JScrollPane scr_DSSP;
	private Custom_Table tbl_DSSP;
	private DefaultTableModel dtm_SP;
    // End of variables declaration//GEN-END:variables
    public Panel_QuanLySanPham() {
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
    	lbl_Title_QL_SP = new JLabel("Quản lý sản phẩm");
    	lbl_Title_QL_SP.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_QL_SP.setForeground(new Color(0, 0, 255));
		lbl_Title_QL_SP.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_QL_SP.setBounds(30,100,2500,50);
		
    	pn_QL_SP = new JPanel();
		pn_QL_SP.setIgnoreRepaint(true);
		pn_QL_SP.setBackground(Color.white);
		pn_QL_SP.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaSP = new JLabel("Mã sản phẩm:");
		lbl_MaSP.setForeground(Color.black);
		lbl_MaSP.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TenSP = new JLabel("Tên sản phẩm:");
		lbl_TenSP.setForeground(Color.black);
		lbl_TenSP.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_LoaiSP = new JLabel("Loại sản phẩm:");
		lbl_LoaiSP.setForeground(Color.black);
		lbl_LoaiSP.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgonNgu = new JLabel("Ngôn ngữ:");
		lbl_NgonNgu.setForeground(Color.black);
		lbl_NgonNgu.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NhaCungCap = new JLabel("Nhà cung cấp:");
		lbl_NhaCungCap.setForeground(Color.black);
		lbl_NhaCungCap.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NhaXuatBan = new JLabel("Nhà xuất bản:");
		lbl_NhaXuatBan.setForeground(Color.black);
		lbl_NhaXuatBan.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_NamXuatBan = new JLabel("Năm xuất bản:");
		lbl_NamXuatBan.setForeground(Color.black);
		lbl_NamXuatBan.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TacGia = new JLabel("Tác giả:");
		lbl_TacGia.setForeground(Color.black);
		lbl_TacGia.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoLuongCon = new JLabel("Số lượng còn:");
		lbl_SoLuongCon.setForeground(Color.black);
		lbl_SoLuongCon.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoLuongBan = new JLabel("Số lượng bán:");
		lbl_SoLuongBan.setForeground(Color.black);
		lbl_SoLuongBan.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GiaNhap = new JLabel("Giá nhập:");
		lbl_GiaNhap.setForeground(Color.black);
		lbl_GiaNhap.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GiaBan = new JLabel("Giá bán:");
		lbl_GiaBan.setForeground(Color.black);
		lbl_GiaBan.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_txt_MaSP = new JLabel();
		lbl_txt_MaSP.setForeground(Color.black);
		lbl_txt_MaSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_MaSP.setOpaque(true);
		lbl_txt_MaSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_TenSP = new Custom_ComboBox();
		cbo_TenSP.setForeground(Color.black);
		cbo_TenSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_TenSP.setColor_Foreground(Color.black);
		cbo_TenSP.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TenSP.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TenSP.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_TenSP.redraw_Custom_Combobox();
		
		cbo_LoaiSP = new Custom_ComboBox();
		cbo_LoaiSP.setForeground(Color.black);
		cbo_LoaiSP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_LoaiSP.setColor_Foreground(Color.black);
		cbo_LoaiSP.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_LoaiSP.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_LoaiSP.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_LoaiSP.redraw_Custom_Combobox();
		
		cbo_NgonNgu = new Custom_ComboBox();
		cbo_NgonNgu.setForeground(Color.black);
		cbo_NgonNgu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_NgonNgu.setColor_Foreground(Color.black);
		cbo_NgonNgu.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NgonNgu.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NgonNgu.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_NgonNgu.redraw_Custom_Combobox();
		
		cbo_NhaCungCap = new Custom_ComboBox();
		cbo_NhaCungCap.setForeground(Color.black);
		cbo_NhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_NhaCungCap.setColor_Foreground(Color.black);
		cbo_NhaCungCap.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NhaCungCap.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_NhaCungCap.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_NhaCungCap.redraw_Custom_Combobox();
		cbo_NhaCungCap.setRadius(0);
		
		txt_NhaXuatBan = new JTextField();
		txt_NhaXuatBan.setForeground(Color.black);
		txt_NhaXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		spn_NamXuatBan = new JSpinner();
		spn_NamXuatBan.setForeground(Color.black);
		spn_NamXuatBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_TacGia = new JTextField();
		txt_TacGia.setForeground(Color.black);
		txt_TacGia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		spn_SoLuongCon = new JSpinner();
		spn_SoLuongCon.setForeground(Color.black);
		spn_SoLuongCon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_txt_SoLuongBan = new JLabel();
		lbl_txt_SoLuongBan.setForeground(Color.black);
		lbl_txt_SoLuongBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl_txt_SoLuongBan.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_SoLuongBan.setOpaque(true);
		
		txt_GiaNhap = new JTextField();
		txt_GiaNhap.setForeground(Color.black);
		txt_GiaNhap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txt_GiaBan = new JTextField();
		txt_GiaBan.setForeground(Color.black);
		txt_GiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_hinhAnhSP = new Custom_JLabel();
		lbl_hinhAnhSP.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_hinhAnhSP.setOpaque(true);
		lbl_hinhAnhSP.setVisible(true);
		
		lbl_Title_DSSP = new JLabel("Danh sách sản phẩm");
		lbl_Title_DSSP.setForeground(Color.BLUE);
		lbl_Title_DSSP.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_SP.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}
		tbl_DSSP = new Custom_Table(dtm_SP);
		tbl_DSSP.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSSP.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSSP.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSSP.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSSP.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSSP.align(1,new int[] {6,8,9,10,11});
		tbl_DSSP.redrawn_Custom_Table();
		JScrollPane scr_DSSP = new JScrollPane(tbl_DSSP);
		
		btn_ChonAnh = new Custom_Button();
		btn_ChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ChonAnh.setBuffered_Icon("src/main/images/view_image/Add image.png");
		btn_ChonAnh.resizeIcon(14, 14);
		btn_ChonAnh.setText("Chọn ảnh");
		btn_ChonAnh.setFont(new Font("Inner", Font.BOLD, 12));
		btn_ChonAnh.setOver(true);
		btn_ChonAnh.setColor_Foreground(Color.black);
		btn_ChonAnh.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_ChonAnh.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_ChonAnh.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_ChonAnh.setColor_Click(Color.black);
		btn_ChonAnh.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
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
			layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_QL_SP))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DSSP))
						.addComponent(scr_DSSP, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pn_QL_SP, GroupLayout.PREFERRED_SIZE, 790, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_QL_SP)
					.addGap(1)
					.addComponent(pn_QL_SP, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSSP)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
		);
        this.setLayout(layout);
        
        GroupLayout gl_pn_QL_SP = new GroupLayout(pn_QL_SP);
        gl_pn_QL_SP.setHorizontalGroup(
        	gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_SP.createSequentialGroup()
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(5)
        					.addComponent(lbl_NgonNgu, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(7)
        					.addComponent(lbl_MaSP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lbl_TenSP, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGap(6)
        					.addComponent(lbl_LoaiSP)))
        			.addGap(6)
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addComponent(lbl_txt_MaSP, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(cbo_TenSP, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(cbo_LoaiSP, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        					.addGap(4))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(cbo_NgonNgu, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_TacGia)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_NhaCungCap))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_NamXuatBan)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_ChonAnh, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(txt_NhaXuatBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(txt_TacGia, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(spn_NamXuatBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addComponent(cbo_NhaCungCap, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        							.addGroup(gl_pn_QL_SP.createSequentialGroup()
        								.addGap(11)
        								.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING, false)
        									.addGroup(gl_pn_QL_SP.createSequentialGroup()
        										.addComponent(lbl_GiaBan, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        										.addGap(6))
        									.addGroup(gl_pn_QL_SP.createSequentialGroup()
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(lbl_SoLuongBan, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        								.addGap(4))
        							.addGroup(gl_pn_QL_SP.createSequentialGroup()
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(lbl_SoLuongCon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addPreferredGap(ComponentPlacement.RELATED)))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lbl_GiaNhap, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addComponent(spn_SoLuongCon, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txt_GiaBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txt_GiaNhap, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lbl_txt_SoLuongBan, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lbl_hinhAnhSP, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        			.addGap(0))
        );
        gl_pn_QL_SP.setVerticalGroup(
        	gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_SP.createSequentialGroup()
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_hinhAnhSP, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(4)
        							.addComponent(lbl_txt_MaSP, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        							.addGap(3)
        							.addComponent(cbo_TenSP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        							.addGap(8)
        							.addComponent(cbo_LoaiSP, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(6)
        							.addComponent(lbl_MaSP)
        							.addGap(7)
        							.addComponent(lbl_TenSP)
        							.addGap(12)
        							.addComponent(lbl_LoaiSP))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lbl_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txt_NhaXuatBan, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_SoLuongCon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addGap(6)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_NhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(cbo_NhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        							.addGap(8)
        							.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.LEADING)
        								.addComponent(spn_NamXuatBan, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_NamXuatBan, Alignment.TRAILING)))
        						.addGroup(gl_pn_QL_SP.createSequentialGroup()
        							.addGap(30)
        							.addComponent(lbl_SoLuongBan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        					.addGap(6)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lbl_GiaBan)
        						.addComponent(txt_TacGia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_TacGia)
        						.addComponent(lbl_NgonNgu)
        						.addComponent(cbo_NgonNgu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        					.addGap(0, 0, Short.MAX_VALUE))
        				.addGroup(gl_pn_QL_SP.createSequentialGroup()
        					.addComponent(spn_SoLuongCon, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        					.addGap(7)
        					.addComponent(lbl_txt_SoLuongBan)
        					.addGap(8)
        					.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txt_GiaNhap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_GiaNhap, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txt_GiaBan, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_pn_QL_SP.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_ChonAnh, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_CapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_Them, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {btn_ChonAnh, btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_MaSP, lbl_TenSP, lbl_LoaiSP, lbl_NgonNgu});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_NhaCungCap, lbl_NhaXuatBan, lbl_NamXuatBan, lbl_TacGia, lbl_SoLuongCon, lbl_SoLuongBan, lbl_GiaNhap, lbl_GiaBan});
        gl_pn_QL_SP.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_MaSP, cbo_TenSP, cbo_LoaiSP, cbo_NgonNgu, cbo_NhaCungCap, txt_NhaXuatBan, spn_NamXuatBan, txt_TacGia, spn_SoLuongCon, lbl_txt_SoLuongBan, txt_GiaNhap, txt_GiaBan});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_ChonAnh, btn_Them, btn_CapNhat, btn_XoaTrang});
        gl_pn_QL_SP.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_MaSP, lbl_TenSP, lbl_LoaiSP, lbl_NgonNgu, lbl_NhaCungCap, lbl_NamXuatBan, lbl_TacGia, lbl_SoLuongCon, lbl_SoLuongBan, lbl_GiaNhap, lbl_GiaBan});
        pn_QL_SP.setLayout(gl_pn_QL_SP);
    }// </editor-fold>//GEN-END:initComponents
}
