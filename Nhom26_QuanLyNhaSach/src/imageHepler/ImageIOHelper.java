package imageHepler;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageIOHelper {
	public static Image resize(Image orgImage, int w, int h) {
		Image rsImage = orgImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return rsImage;
	}

	public static byte[] toByteArray(Image image, String type) throws IOException {
		BufferedImage bImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gp = bImage.createGraphics();
		gp.drawImage(image, 0, 0, null);
		gp.dispose();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bImage, type, baos);
		byte[] imageInByte = baos.toByteArray();
		return imageInByte;
	}

	public static Image createImage(byte[] data, String type) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		BufferedImage bImage2 = ImageIO.read(bais);
		
		Image image = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH);
		return image;
	}
}
