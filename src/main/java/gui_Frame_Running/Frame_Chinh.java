package gui_Frame_Running;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.AutoCompletionComboBox;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.model.ModelMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;

import customEntities.Custom_ImageIcon;
import gui_Panel.EmployeeCard;
import gui_Panel.MainForm;
import gui_Panel.Menu;
import gui_Panel.Panel_QuanLyKhachHang;
import gui_Panel.Panel_QuanLyNhaCungCap;
import gui_Panel.Panel_QuanLyNhanVien;
import gui_Panel.Panel_QuanLySanPham;
import gui_Panel.Panel_TimKiemHoaDon;
import gui_Panel.Panel_TimKiemKhachHang;
import gui_Panel.Panel_TimKiemNhaCungCap;
import gui_Panel.Panel_TimKiemNhanVien;
import gui_Panel.Panel_TimKiemSanPham;
import gui_Panel.Panel_TrangChu;
import net.miginfocom.swing.MigLayout;
import swing.MenuItem;
import swing.PanelTransparent;
import swing.PopupMenu;

public class Frame_Chinh extends JFrame implements ActionListener , WindowListener
{
	private MigLayout layout;
	private PanelTransparent bg;
	private Menu menu;
	private EmployeeCard employeeCard;
	private MainForm main;
	private Animator animator;

	public static void main(String[] args) {
		 try {
			// Khởi tạo một mảng chứa các giao diện người dùng đã được cài đặt 
			 UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
			// Duyệt qua mảng để tìm Nimbus Look and Feel 
			 for (UIManager.LookAndFeelInfo info : installedLookAndFeels) { 
				 // Nếu tên của giao diện người dùng là Nimbus 
				 if ("Nimbus".equals(info.getName())) { 
				 // Đặt Nimbus làm giao diện người dùng cho ứng dụng 
				 UIManager.setLookAndFeel(info.getClassName()); 
				 // Thoát khỏi vòng lặp break; 
				 } 
			 }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Frame_Chinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                //SwingAcrylic.prepareSwing();
	                Frame_Chinh frame = new Frame_Chinh();
	                frame.setTitle("Rising Star");
	                frame.setIconImage(new Custom_ImageIcon("src/main/images/view_image/Logo.png").getImage());
	                frame.setVisible(true);
	                //SwingAcrylic.processFrame(frame);
	            }
	        });
	}
	public Frame_Chinh() {
		initBackground();
		initComponents();
	}
	
	private void initComponents() {
		//  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
		layout = new MigLayout("fill", "10[]10[100%, fill]10", "10[fill, top]10");
        bg.setLayout(layout);
        menu = new Menu();
        employeeCard = new EmployeeCard();
        main = new MainForm();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
		initMenu();
		initAnimator();
	}
	private void initMenu() {
		menu = new Menu();
		bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
		menu.addEvent(new EventMenuSelected() {
			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {
				System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
				if (menuIndex == 0) {
					main.showForm(new Panel_TrangChu());
				}
				if (menuIndex == 1) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLyKhachHang());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemHoaDon());
				}
				if (menuIndex == 3) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLyKhachHang());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemKhachHang());
				}
				if (menuIndex == 4) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLyNhanVien());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemNhanVien());
				}
				if (menuIndex == 5) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLySanPham());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemSanPham());
				}
				if (menuIndex == 6) {
					if(subMenuIndex == 0)
						main.showForm(new Panel_QuanLyNhaCungCap());
					else if (subMenuIndex == 1)
						main.showForm(new Panel_TimKiemNhaCungCap());
				}
			}
		});
		menu.addEventShowPopup(new EventShowPopupMenu() {
			@Override
			public void showPopup(Component com) {
				MenuItem item = (MenuItem) com;
				PopupMenu popup = new PopupMenu(Frame_Chinh.this, item.getIndex(), item.getEventSelected(),
						item.getMenu().getSubMenu());
				int x = Frame_Chinh.this.getX() + 62;
				int y = Frame_Chinh.this.getY() + com.getY() + 95;
				popup.setLocation(x, y);
				popup.setVisible(true);
			}
		});
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Home.png",30,30), "Trang chủ"));
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Bill.png",30,30), "Hóa đơn",
				"Lập hóa đơn", "Tìm kiếm hóa đơn", "Thống kê doanh thu"));
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Preorder.png",30,30), "Đơn đặt",
				"Đặt hàng", "Tìm kiếm đơn đặt"));
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Customer.png",30,30), "Khách hàng",
				"Cập nhật", "Tìm kiếm"));
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Employee.png",30,30), "Nhân viên",
				"Cập nhật", "Tìm kiếm"));
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Product.png",30,30), "Sản phẩm",
				"Cập nhật", "Tìm kiếm"));
		menu.addMenu(new ModelMenu(new Custom_ImageIcon("src/main/images/view_image/Supplier.png",30,30), "Nhà cung cấp",
				"Cập nhật", "Tìm kiếm"));
		
	}
	private void initAnimator() {
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        menu.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        bg.add(main, "w 100%, h 100%");
        main.showForm(new Panel_TrangChu());
	}
	private void initBackground() {

        bg = new swing.PanelTransparent();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(false);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
        setLocationRelativeTo(null);
        addAction();
	}// </editor-fold>//GEN-END:initComponents
	private void addAction()
	{
		addWindowListener(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
		int response = JOptionPane.showConfirmDialog(null, "Bạn có lưu trước khi muốn thoát chương trình không ?", "Thông báo !!!!", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Xử lý khi người dùng chọn "Yes"
            JOptionPane.showMessageDialog(null, "Đã lưu thay đổi.");
            System.exit(0);
        }
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
