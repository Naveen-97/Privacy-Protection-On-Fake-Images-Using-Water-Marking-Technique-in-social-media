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
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
/**
 *
 * @author Mahesh
 */
public class Allow extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
      HttpSession session=request.getSession();
       String uname=(String)session.getAttribute("uname");     
       String name = (String) session.getAttribute("fname");
        String macadd=(String)session.getAttribute("macaddress");
          String imgtype=(String)session.getAttribute("imgtype");
          String com=(String)session.getAttribute("com");
           String fname=(String)session.getAttribute("fname");
          String fid=(String)session.getAttribute("fid");
            File destImageFile=null;
       FileInputStream fp=null;
        FileOutputStream op=null;
        ResultSet rs=null;
 
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark", "root","root");
            Statement st = con.createStatement();
            
            String username="Select * from postedimages where Storedname='"+name+"' "; 
            rs=st.executeQuery(username);   
            
            
            if(rs.next())
            {
                st.executeUpdate("update dupimages set uploadstatus='pending', status='Allow' where Oldfileid='"+uname+"' and Filename='"+name+"' and Fileid='"+fid+"'");
                out.println("<script>");  
                out.println("alert('Permission Granted Successfully');");
                out.println("location='Userpage.jsp'");
                out.println("</script>"); 
            }
            else
            {
                String username1="Select * from profileimages where Storedname='"+name+"' "; 
                rs=st.executeQuery(username1); 
                if(rs.next())
                {
                    st.executeUpdate("update dupimages set uploadstatus='pending', status='Allow' where Oldfileid='"+uname+"' and Filename='"+name+"' and Fileid='"+fid+"'");
                    out.println("<script>");  
                    out.println("alert('Permission Granted Successfully');");
                    out.println("location='Userpage.jsp'");
                    out.println("</script>"); 
                }
                
            }
            
            
        }
        catch (Exception ex) 
         {
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
            Logger.getLogger(Allow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Allow.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Allow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Allow.class.getName()).log(Level.SEVERE, null, ex);
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
