package compress;

import java.awt.image.BufferedImage;

public interface FileHiderListener {

	/**
	 * Called if the file is to big for the image(s). Requests a new
	 * BufferedImage to store the rest.
	 * 
	 * @return the new BufferedImage
	 */
	public BufferedImage requestNextImage();

	/**
	 * Called if a file was stored in more than one image and all informations
	 * are read from the previouse image.
	 * 
	 * @param bez the detected next file-name (without directory)
	 * @return the next BufferedImage
	 */
	public BufferedImage requestNextImage(String bez);

	/**
	 * Called if the file is to big for the image(s). Requests the
	 * identification name for the next image.
	 * 
	 * @return the identification name for the next image
	 */
	public String requestNextFileName();

	/**
	 * Called if one image is complete manipulated
	 * 
	 * @param img the manipulated image
	 */
	public void singleImageReady(BufferedImage img);
}