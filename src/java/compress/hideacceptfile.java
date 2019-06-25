/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compress;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class hideacceptfile extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            String userName =(String) session.getAttribute("n1");
            String userid=(String)session.getAttribute("userid");
            String s=request.getParameter("id");
            int ss=Integer.parseInt(s);
String na1 = null,pa1 = null,na2 = null,pa2 = null,na3 = null,pa3 = null;
            ResultSet ff;
                       String rrname=request.getParameter("idg");
                       String ret1=request.getParameter("idg1");
                        String ret2=request.getParameter("idg2");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditfree","root","root");
                PreparedStatement ps=con.prepareStatement("update hide set filereq=? where fileid=?");
           
                ps.setString(1, "no");
                ps.setInt(2, ss);
                 PreparedStatement ps31=con.prepareStatement("select name1,path1,name2,path2,name3,path3 from hide where fileid=?");
                     ps31.setInt(1, ss);
                   ff=ps31.executeQuery();
                   while(ff.next())
                   {
                       na1=ff.getString(1);
                       pa1=ff.getString(2);
                       na2=ff.getString(3);
                       pa2=ff.getString(4);
                       na3=ff.getString(5);
                       pa3=ff.getString(6);
                       
                   }
                       
                   
                 PreparedStatement ps1=con.prepareStatement("update request set status=? where fileid=? and reqname=?");
                 ps1.setString(1, "success");
                 ps1.setInt(2, ss);
                 ps1.setString(3, rrname);
                 int rr=ps1.executeUpdate();
                int r=ps.executeUpdate();
                if(ret1.equals(ret2)){
                    Random rd=new Random();
        int f2=rd.nextInt(100000000);
       String f=Integer.toString(f2);
                 PreparedStatement ps32=con.prepareStatement("update request set name1=?,path1=?,name2=?,path2=?,name3=?,path3=?,attributekey=? where fileid=? and reqname=?");
                   ps32.setString(1, na1);
                   ps32.setString(2, pa1);
                   ps32.setString(3, na2);
                   ps32.setString(4, pa2);
                   ps32.setString(5, na3);
                   ps32.setString(6, pa3);
                   ps32.setString(7, f);
                   ps32.setInt(8, ss);
                   ps32.setString(9, rrname);
                   int lw=ps32.executeUpdate();
                
                }
                else{
                    Random rd=new Random();
        int f2=rd.nextInt(100000000);
       String f=Integer.toString(f2);
                   PreparedStatement ps32=con.prepareStatement("update request set name1=?,path1=?,name2=?,path2=?,name3=?,path3=?,attributekey=? where fileid=? and reqname=?");
                   ps32.setString(1, na2);
                   ps32.setString(2, pa2);
                   ps32.setString(3, na2);
                   ps32.setString(4, pa2);
                   ps32.setString(5, na3);
                   ps32.setString(6, pa3);
                   ps32.setString(7, f);
                   ps32.setInt(8, ss);
                   ps32.setString(9, rrname);
                   int lw=ps32.executeUpdate();  
                }
                if(r!=0)
                {
                  
                   request.setAttribute("msg", "Request send successfully");
                    RequestDispatcher d=request.getRequestDispatcher("hideviewreq.jsp");
                    d.forward(request, response);
                }
                else
                {
                    request.setAttribute("msg", "Request not send");
                    RequestDispatcher d=request.getRequestDispatcher("hideviewreq.jsp");
                    d.forward(request, response);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "There is no file");
            }
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
