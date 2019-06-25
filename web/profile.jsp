<%-- 
    Document   : profile
    Created on : Oct 13, 2016, 10:57:08 AM
    Author     : Mahesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <img src="D:\Fake\Profile\asd_00022.jpg">
   <%    
       try
        {
            String uname="asd";
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark","root","root");
            Statement st=con.createStatement();
            
                            String img="Select * from profileimages where Fileid='"+uname+"'"; 
                  
          
            ResultSet rs=st.executeQuery(img);
             if(rs.next()){
                 String fname=rs.getString(2);
                  String Filepath="D:/Fake/Profile/"+uname;
                    %>
        <img src="asd_1.jpg">
             
             <% }}
             finally{
                     
                     }%>
    
    </body>
</html>
