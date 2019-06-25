package compress;



import java.awt.image.BufferedImage;


/**
 * A simple Java-Class to write/read invisible messages in/from a spefic
 * BufferedImage.
 * 
 * If you want to store the BufferedImage localy, you have to choose a graphics
 * format, that employs lossless data compression and 24-Bit RGB True-Color
 * (optional also an alpha-channel) like PNG or BMP (successful tested with
 * these). JPG and GIF are not supported. Later, the message can be restored
 * from an BufferedImage representing the local file.
 * 
 * You can store up to (pixel * 3 / 8 - 3) bytes (letters) in one BufferedImage.
 * But attend, that one backslash needs two bytes.
 * 
 * @author Stefan Kiesel
 * @version 1.0
 * @since 1.5
 */
public class TextHider {

	private ImageConverter rwb = null;

	/**
	 * Creates a new ImageHider
	 */
	public TextHider() {
		rwb = new ImageConverter();
	}

	/**
	 * Hides a message in a BufferedImage.
	 * 
	 * @param message the message, that should be hidden
	 * @param img the image in which the message should be hidden
	 * @return the manipulated image
	 * @throws NotEnoughSpaceException thrown if the message is to long for the image
	 * @see ImageConverter#getBytes(BufferedImage)
	 * @see ImageConverter#getImage(int[])
	 * @see BitManipulator#manipulateBytes(int[], String)
	 */
	public BufferedImage hide(String message, BufferedImage img)
			throws NotEnoughSpaceException {
		return rwb.getImage(BitManipulator.manipulateBytes(rwb.getBytes(img),
				message));
	}

	/**
	 * Extracts the hidden information from the BufferedImage.
	 * 
	 * @param img the image with the hidden message
	 * @return the hidden message
	 * @see ImageConverter#getBytes(BufferedImage)
	 * @see BitManipulator#getInformation(int[], boolean)
	 */
	public String extract(BufferedImage img) {
		return BitManipulator.getInformation(rwb.getBytes(img), false);
	}

	/**
	 * Extracts all information, which are hidden with same algorithm as this
	 * library uses.
	 * 
	 * @param img the image with the hidden message
	 * @return all characters, which could be found
	 * @see ImageConverter#getBytes(BufferedImage)
	 * @see BitManipulator#getInformation(int[], boolean)
	 */
	public String extractAll(BufferedImage img) {
		return BitManipulator.getInformation(rwb.getBytes(img), true);
	}

	/**
	 * Returns the maximum number of characters, that can be stored in this
	 * BufferedImage.
	 * 
	 * @param img the BufferedImage
	 * @return the maximum number of characters
	 */
	public int getMaxBytes(BufferedImage img) {
		return img.getWidth() * img.getHeight() * 3 / 8 - 3;
	}

	/**
	 * Returns the last read alpha channel.
	 * 
	 * @return the last read alpha channel
	 * @see ImageConverter#getLastReadAlphaChannel()
	 */
	public int[] getLastReadAlphaChannel() {
		return rwb.getLastReadAlphaChannel();
	}

	/**
	 * Sets the alpha channel.
	 * 
	 * @param alpha the alpha channel
	 * @see ImageConverter#setAlphaChannel(int[])
	 */
	public void setAlphaChannel(int[] alpha) {
		rwb.setAlphaChannel(alpha);
	}
}