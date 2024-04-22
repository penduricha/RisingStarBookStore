package customEntities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Custom_Button extends JButton {
	private String text;
	private boolean over;
	private BufferedImage buffered_Icon;
    private Color color_Background;
    private Color color_Over;
    private Color color_Click;
    private Color color_Border;
    private int radius;
    private Color color_Foreground;
    private Color color_Hightlight;
    private Color color_Clicked_Background;
	/**
     * @param over true thì nhấp nháy, false thì ngược lại
     * @param color_Background màu của background
     * @param color_Over màu của background khi chuột vào
     * @param color_Click màu của background khi click chuột
     * @param color_Border màu của viền
     * @param radius số đo góc
     * @param color_Foreground màu chữ
     * @param color_Hightlight màu chữ khi chọn
     */
    public Custom_Button() {
		makeButton();
	}
	public Custom_Button(String text) {
        //  Init Color
		setText(text);
        makeButton();
    }
	
	public String getText() {
		return text;
	}
	public boolean isOver() {
		return over;
	}
	public Color getColor_Background() {
		return color_Background;
	}
	public Color getColor_Over() {
		return color_Over;
	}
	public Color getColor_Click() {
		return color_Click;
	}
	public Color getColor_Border() {
		return color_Border;
	}
	public int getRadius() {
		return radius;
	}
	public Color getColor_Foreground() {
		return color_Foreground;
	}
	public Color getColor_Hightlight() {
		return color_Hightlight;
	}
	public Color getColor_Clicked_Background() {
		return color_Clicked_Background;
	}
	public void setText(String text) {
		this.text = text;
	}
	public BufferedImage getBuffered_Icon() {
		return buffered_Icon;
	}
	/**
	 * @param color_Over màu của background khi chuột vào
	 */
	public void setOver(boolean over) {
		this.over = over;
	}
	/**
	 * @param color_Background màu nền mặc định
	 */
	public void setColor_Background(Color color_Background) {
		this.color_Background = color_Background;
		super.setBackground(color_Background);
	}
	/**
	 * @param color_Over màu nền khi di chuột vào
	 */
	public void setColor_Over(Color color_Over) {
		this.color_Over = color_Over;
	}
	/**
	 * @param color_click màu nền khi nhấp chuột
	 */
	public void setColor_Click(Color color_Click) {
		this.color_Click = color_Click;
	}
	/**
	 * @param color_Border màu viền mặc định
	 */
	public void setColor_Border(Color color_Border) {
		this.color_Border = color_Border;
	}
	/**
	 * @param radius độ bo góc
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	/**
	 * @param color_Foreground màu chữ mặc định
	 */
	public void setColor_Foreground(Color color_Foreground) {
		this.color_Foreground = color_Foreground;
		super.setForeground(color_Foreground);
	}
	/**
	 * @param color_Hightlight màu chữ khi di chuột vào
	 */
	public void setColor_Hightlight(Color color_Hightlight) {
		this.color_Hightlight = color_Hightlight;
	}
	/**
	 * @param color_Clicked_Background màu nền khi nhấp chuột vào
	 */
	public void setColor_Clicked_Background(Color color_Clicked_Background) {
		this.color_Clicked_Background = color_Clicked_Background;
	}
	/**
	 * @param icon thêm đường dẫn hình ảnh để thành icon
	 */
	public void setBuffered_Icon(String URL) {
		try {
			buffered_Icon = ImageIO.read(new File(URL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIcon(new ImageIcon(buffered_Icon));
	}
	/**
	 * @param icon thêm icon
	 */
	public void setBuffered_Icon(BufferedImage icon) {
		this.buffered_Icon = buffered_Icon;
		setIcon(new ImageIcon(buffered_Icon));
	}
	private void makeButton(){
    	setForeground(color_Foreground);
        setContentAreaFilled(false);
        //  Add event mouse
        addMouseListener();
        setFocusPainted(false);
        setBorder(null);
    }
	public void resizeIcon(int x,int y) {
		buffered_Icon = Custom_Function.resize(buffered_Icon, x, y);
		setBuffered_Icon(buffered_Icon);
	}
	private void addMouseListener(){
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
            	if(over) {
            		setBackground(color_Over);
                    setForeground(color_Hightlight);
            	}
            }

            @Override
            public void mouseExited(MouseEvent me) {
            	if(over) {
            		setBackground(color_Background);
                    setForeground(color_Foreground);
            	}
            }

            @Override
            public void mousePressed(MouseEvent me) {
            	if(over) {
	        			setBackground(color_Clicked_Background);
	                	setForeground(color_Click);
            	}
                else {
                    	setBackground(color_Background);
	                	setForeground(color_Foreground);
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(color_Background);
                    setForeground(color_Foreground);
                }
            }
        });
	}
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(color_Background);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
