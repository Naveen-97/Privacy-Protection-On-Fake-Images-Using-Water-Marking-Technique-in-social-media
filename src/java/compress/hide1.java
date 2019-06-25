/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class hide1 extends HttpServlet {
public static String destinationDir = null;
	public static String temp = null;
	public static String temp2 = null;
	public static String temp3 = null;
        String ss,a1,a2,a3,a4;
        String save_pathtxt="D:\\NetBeansProjects\\iaas\\web\\enc\\";
	public static int tempN = -1;
	public static int counter = 1;
      public static String hide_imagetxt=null;
                public static String select_imagetxt=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        TextHider th = new TextHider();
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
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
               Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/auditfree", "root","root");
        ss=(String)session.getAttribute("n1");
    Statement st=con.createStatement();
    String strQuery = "select path1,path2,name1,name2 from stegno";
//    "select photo from photoinfo where id="+id
    ResultSet rs = st.executeQuery(strQuery);
    while(rs.next())
    {
        hide_imagetxt=rs.getString(1);
select_imagetxt=rs.getString(2);

               a3=rs.getString(3);
              a4=rs.getString(4);
    }
                        
                                        PreparedStatement prt3 = con.prepareStatement("select * from hide where name2=? and name3=?");
                                        prt3.setString(1, a4);
                                        prt3.setString(2, a4);
                                        ResultSet rs1 = prt3.executeQuery();
    if(rs1.next())
    {
        out.println("<script type=\"text/javascript\">");
   out.println("alert('Filename already exist');");
   out.println("location='hide.jsp';");
   out.println("</script>");
    }else{   String tr=session.getAttribute("n2").toString();
    String ffgpath=new File(save_pathtxt).getAbsolutePath() + "/";
    String ffgpath1=ffgpath+a4;
                                        PreparedStatement prt2 = con.prepareStatement("insert into hide(username,name1,path1,name2,path2,name3,path3,userid,status,filereq,download) values(?,?,?,?,?,?,?,?,?,?,?)");
           prt2.setString(1, ss);
               prt2.setString(2, a3);
           prt2.setString(3, hide_imagetxt);
           prt2.setString(4, a4);
           prt2.setString(5, select_imagetxt);
         prt2.setString(6, a4);
          prt2.setString(7, ffgpath1);
          prt2.setString(8, tr);
          prt2.setString(9, "hide");
          prt2.setString(10, "no");
          prt2.setString(11, "not done");
           int ii=prt2.executeUpdate();
           if(ii>0)
           {
               PreparedStatement prtt2 = con.prepareStatement("truncate stegno");
               int i78=prtt2.executeUpdate();
           }
                                       }
					System.out.println("Please insert the destination directory");
					destinationDir = new File(save_pathtxt).getAbsolutePath() + "/";
                                        System.out.println("final des"+destinationDir);
					System.out.println("Please insert the path to the file, which should be hidden");
					temp = hide_imagetxt;
					System.out.println("Please insert the path to the image, in which the file should be hidden");
					temp3 = select_imagetxt;
					temp2 = new File(temp3).getName();
                                        System.out.println("final des"+temp2);
					temp2 = temp2.substring(0, temp2.lastIndexOf(".")) + ".jpg";
					fh.hideInImage(new File(temp), new File(temp3));
                                     
                         out.println("<script type=\"text/javascript\">");
   out.println("alert('Hide Successfully');");
   out.println("location='hide.jsp';");
   out.println("</script>");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
