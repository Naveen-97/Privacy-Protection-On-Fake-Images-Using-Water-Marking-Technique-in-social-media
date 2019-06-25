/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Watermark;

import Mail.Mailit;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mahesh
 */
public class Login extends HttpServlet {

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
        String un=request.getParameter("uname");
        String pw=request.getParameter("pass");
         PrintWriter out = response.getWriter();
       
        HttpSession session=request.getSession();
        session.setAttribute("uname",un);
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark","root","root");
            Statement st=con.createStatement();            
             String username="Select * from register where username= '"+un+"' and password='"+pw+"'"; 
              ResultSet rs=st.executeQuery(username);
               if(rs.next()){
                  String permit="Select * from register where username= '"+un+"' and password='"+pw+"' and Permit='Allow'";
                  ResultSet rs1=st.executeQuery(permit);
                  if(rs1.next()){
                      Mailit mm=new Mailit();
                      int key= new Random().nextInt(99999999-10000000)+10000000;
                      mm.SendMailto(key+"", un);
                      out.println("<script type=\"text/javascript\">");  
           out.println("alert('Login Success');");
           out.println("location='index.html'");
           out.println("</script>");
                  }else{
              out.println("<script type=\"text/javascript\">");  
           out.println("alert('Your MAC Address was Blocked');");
           out.println("location='index.html'");
           out.println("</script>");
               }}
               else
               {
                   out.println("<script type=\"text/javascript\">");  
           out.println("alert('Wrong Username or Password');");
           out.println("location='index.html'");
           out.println("</script>");
               }
        }
        finally
        {
            
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
