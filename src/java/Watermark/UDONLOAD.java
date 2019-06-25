package Watermark;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UDONLOAD extends HttpServlet 
{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, ClassNotFoundException, SQLException {response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String name=request.getParameter("file");
        session.setAttribute("fname",name);
        String uname = (String) session.getAttribute("uname");
        //String fname = request.getParameter("file");
        FileInputStream fp=null;
        FileOutputStream op=null;
        Connection con=null;
        Statement st=null;   
        String ouname="";
        try 
        {
            InetAddress ia = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ia.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ia);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) 
            {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		
            }
            String macadd=sb.toString();
            System.out.println("Mac Address...."+macadd);
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark","root","root");
            st=con.createStatement();
            
            String fileid="select * From postedimages where Storedname='"+name.trim()+"'";
            ResultSet rs2=st.executeQuery(fileid);
            if(rs2.next())
            {
                ouname=rs2.getString(1);
                System.out.println(ouname);
            }
            else
            {
            String pfileid="select * From profileimages where Storedname='"+name.trim()+"'";
            ResultSet rs1=st.executeQuery(pfileid);
            if(rs1.next()){
                ouname=rs1.getString(1);
                System.out.println(ouname);
            } 
            }
            String sql = "insert into Dupimages values ('" + uname + "','" + name + "','" + ouname + "','cmd','Posts','"+macadd+"','Waiting','no access')";
            st.executeUpdate(sql);    
            out.println("<script>");
            out.println("alert('Your Request is Sent Success to "+ouname+" User');");
            out.println("location='Userpage.jsp'");
            out.println("</script>");
            
            
            
     /*******************       ****************/ }       
        finally
        {            
            out.close();
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
            Logger.getLogger(UDONLOAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UDONLOAD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UDONLOAD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UDONLOAD.class.getName()).log(Level.SEVERE, null, ex);
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
