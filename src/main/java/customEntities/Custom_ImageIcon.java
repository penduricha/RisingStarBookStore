package customEntities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Custom_ImageIcon extends ImageIcon{
	private BufferedImage bufferedImage;

	/**
	 * @return the bufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	/**
	 * @param bufferedImage the bufferedImage to set
	 */
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	/**
	 * @param bufferedImage the bufferedImage to set
	 */
	public void setBufferedImage(String url) {
		try {
			bufferedImage = ImageIO.read(new File(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Custom_ImageIcon(BufferedImage bufferedImage) {
		super();
		setBufferedImage(bufferedImage);
		setImage(bufferedImage);
	}
	public Custom_ImageIcon(String url,int x,int y) {
		super();
		setBufferedImage(url);
		resizeImage(x, y);
		setImage(bufferedImage);
	}
	public Custom_ImageIcon(String url) {
		super();
		setBufferedImage(url);
		setImage(bufferedImage);
	}
	public void resizeImage(int x,int y) {
		bufferedImage = Custom_Function.resize(bufferedImage, x, y);
		setBufferedImage(bufferedImage);
	}
	public void reconnerImage(int radius) {
		bufferedImage = Custom_Function.makeRoundedCorner(bufferedImage, radius);
		setBufferedImage(bufferedImage);
	}
}
