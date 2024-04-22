package customEntities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Custom_JLabel extends JLabel{
	private BufferedImage buffered_Image;
	private int radius;
	
	public BufferedImage getBuffered_Image() {
		return buffered_Image;
	}
	public int getRadius() {
		return radius;
	}

	public void setBuffered_Image(BufferedImage buffered_Image) {
		this.buffered_Image = buffered_Image;
		setIcon(new ImageIcon(this.buffered_Image));
	}
	public void setBuffered_Image(String URL) {
		try {
			buffered_Image = ImageIO.read(new File(URL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIcon(new ImageIcon(buffered_Image));
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void resizeImage(int x,int y) {
		buffered_Image = Custom_Function.resize(buffered_Image, x, y);
		setBuffered_Image(buffered_Image);
	}
	public void reconnerImage() {
		buffered_Image = Custom_Function.makeRoundedCorner(buffered_Image, radius);
		setBuffered_Image(buffered_Image);
	}
}
