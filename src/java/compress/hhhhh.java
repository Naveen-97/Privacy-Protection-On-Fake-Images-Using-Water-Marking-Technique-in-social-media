/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import static compress.hide1.counter;
import static compress.hide1.destinationDir;
import static compress.hide1.hide_imagetxt;
import static compress.hide1.select_imagetxt;
import static compress.hide1.temp;
import static compress.hide1.temp2;
import static compress.hide1.temp3;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Kahilan
 */
public class hhhhh {
    public static String destinationDir = null;
	public static String temp = null;
	public static String temp2 = null;
	public static String temp3 = null;
        String ss,a1,a2,a3,a4;
        String save_pathtxt="D:\\Fake\\";
	public static int tempN = -1;
	public static int counter = 1;
      public static String hide_imagetxt=null;
                public static String select_imagetxt=null;
    FileHider fh = new FileHider(new FileHiderListener() {

			public BufferedImage requestNextImage() {

				try {
					return ImageIO.read(new File(temp));
				} 
				catch (IOException e) {
				}
				return null;
			}

			public BufferedImage requestNextImage(String bez) {

				try {
					return ImageIO.read(new File(destinationDir + bez));
				} 
				catch (IOException e) {
				}
				return null;
			}

			public String requestNextFileName() {

                            System.out.println("The file is to big, to save it into these "
                                    + counter
                                    + " image(s). Please insert the path to a next one.");
                            temp = select_imagetxt;
                            temp3 = new File(temp).getName();
                            temp3 = temp3.substring(0, temp3.lastIndexOf(".")) + ".jpg";
                            return temp3;
				
			}

			public void singleImageReady(BufferedImage img) {

				try {
					ImageIO.write(img, "jpg", new File(destinationDir + temp2));
					temp2 = temp3;
				} 
				catch (IOException e) {
				}
			}
		});
//    public static void main(String[] args) {
//        hhhhh h=new hhhhh();
//        h.add();
//    }
    public void add(String filename,String filename1)
    {
             
        try {
           hide_imagetxt="D:\\files\\"+filename;
           select_imagetxt="D:\\files\\"+filename1;
           a3=filename;
           a4=filename1;
           temp = hide_imagetxt;
					System.out.println("Please insert the path to the image, in which the file should be hidden");
					temp3 = select_imagetxt;
					temp2 = new File(temp3).getName();
                                        System.out.println("final des"+temp2);
					temp2 = temp2.substring(0, temp2.lastIndexOf(".")) + ".jpg";
            destinationDir = new File(save_pathtxt).getAbsolutePath() + "/";
            fh.hideInImage(new File(hide_imagetxt), new File(select_imagetxt));
        } catch (IOException ex) {
            Logger.getLogger(hhhhh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void add1(String filename,String filename1)
    {
             
        try {
           hide_imagetxt="D:\\files\\"+filename;
           select_imagetxt="D:\\files\\"+filename1;
           a3=filename;
           a4=filename1;
           temp = hide_imagetxt;
					System.out.println("Please insert the path to the image, in which the file should be hidden");
					temp3 = select_imagetxt;
					temp2 = new File(temp3).getName();
                                        System.out.println("final des"+temp2);
					temp2 = temp2.substring(0, temp2.lastIndexOf(".")) + ".jpg";
            destinationDir = new File(save_pathtxt).getAbsolutePath() + "/";
            fh.hideInImage(new File(hide_imagetxt), new File(select_imagetxt));
        } catch (IOException ex) {
            Logger.getLogger(hhhhh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
