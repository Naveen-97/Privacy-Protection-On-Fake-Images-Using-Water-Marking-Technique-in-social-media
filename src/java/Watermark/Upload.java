/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Watermark;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Mahesh
 */
@MultipartConfig(maxFileSize = 1666666666)
public class Upload extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("uname");
        String fname = request.getParameter("file");
        String com = request.getParameter("comment");
        

        try {
            InetAddress ia = InetAddress.getLocalHost();
             System.out.println("Current IP address : " + ia.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(ia);
		byte[] mac = network.getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		
                }
                String macadd=sb.toString();
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark", "root","root");
            Statement st = con.createStatement();
            File folder = new File("D:\\Project\\FakeProfile\\web\\Images\\Posts");
            File[] listOfFiles = folder.listFiles();
            FileInputStream id = new FileInputStream("D:\\files\\"+fname);
            long imgsize = id.getChannel().size();
            long fileimgsize = 0;
            String imgname="";
            String ouname="";
            int temp = 0;
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    FileInputStream f2 = new FileInputStream(listOfFiles[i]);
                    fileimgsize = f2.getChannel().size();
                    String nnn=listOfFiles[i].toString();
                    imgname=nnn.trim().substring(40);
                            
//        int data;
//        while ((data = f2.read()) != -1)
//        {
//            if (data == id.read())
//            {   temp=1;
//                        } else {
//                            temp = 2;
//                        }
//                    }
                }
//                if (temp == 1) {
//                    break;
//                }
            }
                 ResultSet er=st.executeQuery("Select * from profileimages");
        while(er.next())
        {
            String fn=er.getString("Filename");
            if(fn.equals(fname))
            {
               temp++; 
            }
        }
        ResultSet er1=st.executeQuery("Select * from postedimages");
        while(er1.next())
        {
            String fn=er1.getString("Filename");
            if(fn.equals(fname))
            {
               temp++; 
            }
        }
            if (temp != 0) {
                 {
                    String fileid="select * From postedimages where Storedname='"+imgname+"'";
                    ResultSet rs=st.executeQuery(fileid);
                    if(rs.next()){
                        ouname=rs.getString(1);
                    }else{
                    String pfileid="select * From profileimages where Storedname='"+imgname+"'";
                    ResultSet rs1=st.executeQuery(pfileid);
                    if(rs1.next()){
                        ouname=rs1.getString(1);
                    }}
                    String sql = "insert into Dupimages values ('" + uname + "','" + fname + "','" + ouname + "','" + com + "','Posts','"+macadd+"','Waiting','NotAccess')";
                    st.executeUpdate(sql);
                     
                    out.println("<script>");
                    out.println("alert('Image already Exists Upload Only with user Permission');");
                    out.println("location='Userpage.jsp'");
                    out.println("</script>");
                }
            }else{

                                
               File sourceImageFile = new File("D:\\files\\" + fname);
                File destImageFile = new File("D:\\Project\\FakeProfile\\web\\Images\\Posts\\"+ fname);
                BufferedImage sourceImage = ImageIO.read(sourceImageFile);
                Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();

                // initializes necessary graphic properties
                AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
                g2d.setComposite(alphaChannel);
                g2d.setColor(Color.BLUE);
                g2d.setFont(new Font("Arial", Font.BOLD, 64));
                FontMetrics fontMetrics = g2d.getFontMetrics();
                Rectangle2D rect = fontMetrics.getStringBounds(uname, g2d);

                // calculates the coordinate where the String is painted
                int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
                int centerY = sourceImage.getHeight() / 2;

                // paints the textual watermark
                g2d.drawString(uname, centerX, centerY);

                ImageIO.write(sourceImage, "png", destImageFile);
                g2d.dispose();

                String sql = "insert into postedimages values ('" + uname + "','" + fname + "','"+ fname+"','" + com + "')";
                st.executeUpdate(sql);
                 FileInputStream ip1= new FileInputStream("D:\\Project\\FakeProfile\\web\\Images\\Posts\\"+ fname);
     FileOutputStream  op1= new FileOutputStream("D:\\Fake\\"+ uname +"\\"+ fname);
       int c;
                 while ((c=ip1.read())!= -1) {
             op1.write(c);
   }

                out.println("<script>");
                out.println("alert('File uploaded successfully');");
                out.println("location='Userpage.jsp'");
                out.println("</script>");

            }
        } catch (IOException ex) {
            System.err.println(ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }
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
