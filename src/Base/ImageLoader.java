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
	
	private static BufferedImage loadImage(String path) {
		BufferedImage image = null;
		if (path != null) {
			try {
				InputStream stream = ImageLoader.class.getResourceAsStream(path);
				image = ImageIO.read(stream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return image;
	}	
	
	public static ImageIcon getImageIconHelp16() {
		if (imgIconHelp16 == null) {
			imgIconHelp16 = new ImageIcon(loadImage("img/16x16_help.png"));
		}
		return imgIconHelp16;		
	}
	
	public static ImageIcon getImageIconHelp22() {
		if (imgIconHelp22 == null) {
			imgIconHelp22 = new ImageIcon(loadImage("img/22x22_help.png"));
		}
		return imgIconHelp22;	
	}
	
	public static ImageIcon getImageIconHelp32() {
		if (imgIconHelp32 == null) {
			imgIconHelp32 = new ImageIcon(loadImage("img/32x32_help.png"));
		}
		return imgIconHelp32;
	}
	
	public static ImageIcon getImageIconHelp48() {
		if (imgIconHelp48 == null) {
			imgIconHelp48 = new ImageIcon(loadImage("img/48x48_help.png"));
		}
		return imgIconHelp48;
	}
	
	public static ImageIcon getImageIconRabbit() {
		if (imgIconRabbit == null) {
			imgIconRabbit = new ImageIcon(loadImage("img/rabbit.png"));
		}
		return imgIconRabbit;
	}
	
	public static ImageIcon getImageIconTurtle() {
		if (imgIconTurtle == null) {
			imgIconTurtle = new ImageIcon(loadImage("img/turtle.png"));
		}
		return imgIconTurtle;
	}
	
	public static BufferedImage getBufferedImageRouter() {
		if (imgRouter == null) {
			imgRouter = loadImage("img/70px-Router.png");
		}
		return imgRouter;
	}
}
