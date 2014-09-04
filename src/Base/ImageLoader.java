/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageLoader {

	private static ImageIcon imgIconHelp16 = null;
	private static ImageIcon imgIconHelp22 = null;
	private static ImageIcon imgIconHelp32 = null;
	private static ImageIcon imgIconHelp48 = null;
	private static ImageIcon imgIconRabbit = null;
	private static ImageIcon imgIconTurtle = null;
	
	private static BufferedImage imgRouter = null;
	private static BufferedImage imgRouter2 = null;
	
	private static BufferedImage loadImage(String path) throws Exception {
		try {
			if (path == null) {
				throw new NullPointerException();
			}
			if (path.equals("")) {
				throw new IllegalArgumentException();
			}			
			InputStream stream = ImageLoader.class.getResourceAsStream(path);
			BufferedImage image = ImageIO.read(stream);	
			return image;
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	/*
	private static ImageIcon loadImageIconAsStream(String path) throws Exception {
		try {
			if (path == null) {
				throw new NullPointerException();
			}
			if (path.equals("")) {
				throw new IllegalArgumentException();
			}
			InputStream stream = ImageLoader.class.getResourceAsStream(path);
			BufferedImage image = ImageIO.read(stream);
			ImageIcon icon = new ImageIcon(image);
			return icon;
		} catch (Exception ex) {
			throw ex;
		}
	}
	*/
	
	private static ImageIcon loadImageIconDirectly(String path) {
		try {
			if (path == null) {
				throw new NullPointerException();
			}
			if (path.equals("")) {
				throw new IllegalArgumentException();
			}
			ImageIcon icon = new ImageIcon(ImageLoader.class.getResource(path));
			return icon;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public static ImageIcon getImageIconHelp16() {
		if (imgIconHelp16 == null) {
			imgIconHelp16 = loadImageIconDirectly("/Base/img/16x16_help.png");
		}
		return imgIconHelp16;
	}
	
	public static ImageIcon getImageIconHelp22() {
		if (imgIconHelp22 == null) {
			imgIconHelp22 = loadImageIconDirectly("/Base/img/22x22_help.png");
		}
		return imgIconHelp22;	
	}
	
	public static ImageIcon getImageIconHelp32() {
		if (imgIconHelp32 == null) {
			imgIconHelp32 = loadImageIconDirectly("/Base/img/32x32_help.png");
		}
		return imgIconHelp32;
	}
	
	public static ImageIcon getImageIconHelp48() {
		if (imgIconHelp48 == null) {
			imgIconHelp48 = loadImageIconDirectly("/Base/img/48x48_help.png");
		}
		return imgIconHelp48;
	}
	
	public static ImageIcon getImageIconRabbit() {
		if (imgIconRabbit == null) {
			imgIconRabbit = loadImageIconDirectly("/Base/img/rabbit.png");
		}
		return imgIconRabbit;
	}
	
	public static ImageIcon getImageIconTurtle() {
		if (imgIconTurtle == null) {
			imgIconTurtle = loadImageIconDirectly("/Base/img/turtle.png");
		}
		return imgIconTurtle;
	}
	
	public static BufferedImage getBufferedImageRouter() throws Exception {
		if (imgRouter == null) {
			imgRouter = loadImage("/Base/img/70px-Router.png");
		}
		return imgRouter;
	}
	
	public static BufferedImage getBufferedImageRouter2() throws Exception {
		if (imgRouter2 == null) {
			imgRouter2 = loadImage("/Base/img/300px-Router.svg.png");
		}
		return imgRouter2;
	}
}
