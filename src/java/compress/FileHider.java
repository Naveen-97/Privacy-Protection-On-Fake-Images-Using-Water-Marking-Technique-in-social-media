package compress;



import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 * A simple Java-Class (build up on TextHider) to hide and restore complete
 * Files in one or more images.
 */
public class FileHider {

	private TextHider th = null;

	private FileInputStream fis = null;

	private BufferedOutputStream bos = null;

	private FileHiderListener listener = null;

	private StringBuilder build = null;

	/**
	 * Creates a new FileHider with the spefic FileHiderListener.
	 * 
	 * @param fhl the FileHiderListener
	 */
	public FileHider(FileHiderListener fhl) {

		th = new TextHider();
		setFileHiderListener(fhl);
	}

	/**
	 * Sets the current FileHiderListener
	 * 
	 * @param fhl
	 */
	public void setFileHiderListener(FileHiderListener fhl) {
		listener = fhl;
	}

	/**
	 * Extracts a File from an image. Is the file stored in more than one image,
	 * this method needs the first image and requests later the next images.
	 * 
	 * @param img the image, in that (the fist part of) the file is saved
	 * @param saveIn the path to the file, where the extracted file should be saved
	 * @param destinationDir the directory, where all needed images are stored
	 * @return true if the file is extracted
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean extractFile(BufferedImage img, File saveIn, String destinationDir) throws FileNotFoundException, IOException {

		bos = new BufferedOutputStream(new FileOutputStream(saveIn));
		String information = null;
		String nextFile = null;
		while (true) {
			information = th.extract(img);
			if (information == null) {
				return false;
			}
			nextFile = information.substring(information.lastIndexOf("?") + 1);
			if (new File(destinationDir + nextFile).exists()) {
				information = information.substring(0, information.lastIndexOf("?"));
			} else {
				nextFile = null;
			}
			for (int i = 0; i < information.length(); i++) {
				bos.write(information.charAt(i));
			}
			if (nextFile == null) {
				break;
			} else {
				img = listener.requestNextImage(nextFile);
			}
		}
		bos.close();
		return true;
	}

	/**
	 * Hides a file in an image
	 * 
	 * @param f the file to hide
     * @param img1
	 * @return true if the image is saved
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean hideInImage(File f, File img1) throws FileNotFoundException, IOException {
FileInputStream fis1 = new FileInputStream(img1);
BufferedImage  img=ImageIO.read(fis1);
		fis = new FileInputStream(f);
		setNextImage(img);
		fis.close();
		return true;
	}

	/**
	 * Reads data from an image, requests the next image if necessary.
	 * 
	 * @param img the current image
	 * @throws IOException
	 */
	private void setNextImage(BufferedImage img) throws IOException {

		int max = th.getMaxBytes(img) - 30;
		int cur = 0;
		int bytesRead = 0;
		build = new StringBuilder();
		while ((cur = fis.read()) != -1) {
			build.append((char) cur);
			bytesRead++;
			if ((char) cur == '\\') {
				bytesRead++;
			}
			if (bytesRead >= max) {
				String file = "?" + listener.requestNextFileName();
				if (file.equals("?")) {
					return;
				}
				if (file.length() > 29) {
					file = file.substring(0, 29);
				}
				build.append(file);
				try {
					img = th.hide(build.toString(), img);
					listener.singleImageReady(img);
					img = listener.requestNextImage();
					bytesRead = 0;
					max = th.getMaxBytes(img) - 30 * 8;
					build = new StringBuilder();
				} catch (NotEnoughSpaceException ignore) {
					ignore.printStackTrace();
				}
			}
		}
		try {
			img = th.hide(build.toString(), img);
		} catch (NotEnoughSpaceException ignore) {
		}
		listener.singleImageReady(img);
	}
}