<%-- 
    Document   : Userpage
    Created on : Oct 7, 2016, 4:47:03 PM
    Author     : Mahesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>An Automated Model to Detect Fake Profiles and botnets in Online Social Networks Using Steganography Technique</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" />
    <link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
    <link rel="stylesheet" href="css/normalize.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery.fancybox.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/queries.css">
    <link rel="stylesheet" href="css/etline-font.css">
    <link rel="stylesheet" href="bower_components/animate.css/animate.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body id="top">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
   <%   String uname=(String)session.getAttribute("uname");%>
    <section class="hero">
        <section style="margin-top: -230px;margin-bottom: 75px"class="navigation">
             <section id="home>"
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="hero-content text-center">
                        <div style="margin-left: -75px;margin-right: -100px"><h1 style="font-size:290%">An Automated Model to Detect Fake Profiles and botnets in Online Social Networks Using Steganography Technique</h1>
                    </div>
                       
                    </div>
                </div>
            </div>
        </div>
       
        </section>
            <header >
                <div  class="header-content">
                  
                    <div class="header-nav">
                        <nav>
                            <ul class="primary-nav">
                                <li><a href="#">Home</a></li>
                                <li><a href="#profile">Profile</a></li>
                                <li><a href="#upload">Upload</a></li>
                                <!--<li><a href="#cupload">Cloud Upload</a></li>!-->
                                <li><a href="#photos">Photos</a></li>
                                <li><a href="#dwn">Download</a></li>
                                <li><a href="#downhis">UserHistory</a></li>
                                <li><a href="#notification">Notifications</a>
                            </ul>
                            <ul class="member-actions">
                               
                                <li><a href="index.html" class="btn-white btn-small">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="navicon">
                        <a class="nav-toggle" href="#"><span></span></a>
                    </div>
                </div>
            </header>
        </section>
        <div class="down-arrow floating-arrow"><a href="#"><i class="fa fa-angle-down"></i></a></div>
    </section>
    
    <section class="testimonial-slider section-padding text-center">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="flexslider">
                        <ul class="slides">
                            <% 
                    
            try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/watermark","root","root");
            Statement st=con.createStatement();
            
                            String img="Select * from profileimages where Fileid='"+uname+"'"; 
                  
          
            ResultSet rs=st.executeQuery(img);
             if(rs.next()){
                 String fname=rs.getString(2);
                    %>        <li>
                                <div class="avatar"><a href="#profilepic"><img src="Images/Posts/<%=fname%>" alt="Edit"></a></div>
                            <a  style="color: wheat"href="#profilepic">   Change</a>
                                <h2>Welcome <%=uname%></h2>
                               
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
                               
    <section class="features section-padding" id="profile">
        <div class="container">
            <div class="row">
                <div class="col-md-5 col-md-offset-7">
                    <div class="feature-list">
                        <h3>Profile</h3>
                        <%
             }
                  String username="Select * from register where Username='"+uname+"'"; 
                  
          
            ResultSet rs1=st.executeQuery(username);
             if(rs1.next()){
                 String name=rs1.getString(1);
                
                 String dob=rs1.getString(3); 
                 String gen=rs1.getString(4);
                 String mail=rs1.getString(5); 
       
                 String phno=rs1.getString(6); 
                 
                          
                 
             
            %>   
                        <ul class="features-stack">
                          
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe040;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                    <h5>Name</h5>
                                    <p><%=name%></p>
                                </div>
                            </li>
                           
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe040;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                   <h5>Date of Birth</h5>
                                    <p><%=dob%></p> </div>
                            </li>
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe040;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                   <h5>Gender</h5>
                                    <p><%=gen%></p>     </div>
                            </li>
                            <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe040;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                 <h5>Mail ID</h5>
                                    <p><%=mail%></p>    </div>
                            </li>
                             <li class="feature-item">
                                <div class="feature-icon">
                                    <span data-icon="&#xe040;" class="icon"></span>
                                </div>
                                <div class="feature-content">
                                  <h5>Phone</h5>
                                    <p><%=phno%></p>   </div>
                            </li>
                 
                        </ul>
                    </div>
                </div>
            </div>
        </div>
                        <div class="device-showcase">
            <div class="devices">
                <div  class="ipad-wrap wp1"></div>
                <div class="iphone-wrap wp2"></div>
            </div>
        </div>
        <div class="responsive-feature-img"><img src="Images/w3.jpeg" alt="responsive devices"></div>
    </section>
                            <% }%>
   <section class="sign-up section-padding text-center" id="upload">
        <div style="margin-top: 120px" class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Post your Images</h3>
                    <div style="margin-top: 20px">    
                    <form class="signup-form" action="uploadn" method="POST">
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i><input  type="file"  name="file" class="" >
                        </div> 
                         <div class="form-input-group">
                             <i class="fa fa-envelope"></i><input type="text"   placeholder="Comment about Image" name="comment" class="" >
                       
                         </div> 
                       
                        <input type="submit" value="Upload" class="btn-fill sign-up-btn">
                    </form></div>
                </div>
            </div>
        </div>
    </section>
    
    <!---<section class="sign-up section-padding text-center" id="cupload">
        <div style="margin-top: 120px" class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>CLOUD UPLOAD</h3>
                    <div style="margin-top: 120px">    
                    <form class="signup-form" action="hideimage" method="POST">
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i>SELECT FILE<input  type="file"  name="file" class="" placeholder="select text" >
                        </div> 
                         <div class="form-input-group">
                             <i class="fa fa-envelope"></i>COVER IMAGE<input  type="file"  name="file1" class="" placeholder="cover image" >
                        </div> 
                       
                        <input type="submit" value="Upload" class="btn-fill sign-up-btn">
                    </form></div>
                </div>
            </div>
        </div>
    </section>!-->
   <section class="sign-up section-padding text-center" id="dwn">
        <div style="margin-top: 120px"class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Download Picture Here...</h3>
                 <div style="margin-top: 20px"> 
                     <center>
                     <table border="1">
                         <tr><th>User Name</th><th>Photo Name</th><th>Type</th></tr>
            <%  
                
        
//        String name=(String)session.getAttribute("un");
//          String pos=(String)session.getAttribute("type");
               
            
                  //String user="Select * from postedimages where fileid!='"+uname+"'" ; 
                  String user="SELECT postedimages.fileid, postedimages.storedname FROM postedimages WHERE fileid!='"+uname+"' and NOT EXISTS (SELECT dupimages.oldfileid, dupimages.filename FROM dupimages WHERE  postedimages.fileid = dupimages.oldfileid and postedimages.filename = dupimages.filename)";
          
            ResultSet rs5=st.executeQuery(user);
             while(rs5.next()){
                 String Name=rs5.getString(1);
                
              String usname=rs5.getString(2);
//                 String gkey=rs.getString(3);
                 
             
            %>   
            
            
                         <tr> <td><%=Name%></td> <td><%=usname%></td><td>Posted</td></tr>
            
             
            <%
             } %> 
         <%  
                
        
//        String name=(String)session.getAttribute("un");
//          String pos=(String)session.getAttribute("type");
               
            
                  String proimg="SELECT profileimages.fileid, profileimages.filename FROM profileimages WHERE fileid!='"+uname+"' and storedname!='' and NOT EXISTS (SELECT dupimages.oldfileid, dupimages.filename FROM dupimages WHERE  profileimages.fileid = dupimages.oldfileid and profileimages.filename = dupimages.filename)";
                  
          
            ResultSet rs6=st.executeQuery(proimg);
             while(rs6.next()){
                 String Name=rs6.getString(1);
                
              String usname=rs6.getString(2);
//                 String gkey=rs.getString(3);
                 
             
            %>   
            
            
            <tr> <td><%=Name%></td> <td><%=usname%></td><td>Profile</td></tr>
            
             
            <%
             } %>
         </table> <br/>         
         </center>
                    <form class="signup-form" action="UDONLOAD" method="POST">
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i><input type="text"  name="file" placeholder="Enter Image Name"class="" >
                        </div>
                       
                        <input type="submit" value="Click Request" class="btn-fill sign-up-btn">
                    </form>
         
                 </div><br/><br/>
         <center><form action="Download"><table border="1">
                 <tr>
                 <th>UserName</th>
                 <th>FileName</th>
                 </tr>
                 <%
                     try {
                    String downstatus="select oldfileid, filename from dupimages where uploadstatus='pending' and fileid='"+uname+"'";
                    ResultSet rs7=st.executeQuery(downstatus);
                    while(rs7.next())
                    {                       
                 %>
                 <tr>
                     <td><%=rs7.getString(1)%></td>
                     <td><input type="radio" name="imgname" value="<%=rs7.getString(2)%>"><%=rs7.getString(2)%></input></td>                     
                 </tr>
                 
                 <%}}catch(Exception e)
            {
                    e.printStackTrace();
            }%>
                 <tr><td style="text-align:center" colspan="2"> <input type="submit" value="download" class="btn-fill sign-up-btn"></input></td></tr>
             </table></form></center>
                </div>
            </div>
        </div>         
    </section>
    <section class="sign-up section-padding text-center" id="downhis">
        <div style="margin-top: 120px"class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>My Profile User List...</h3>
                 <div style="margin-top: 20px"> 
                        <div class="form-input-group">
                            <center>
                            <table border="1">
                                <tr>
                                    <th>UserName</th>
                                    <th>ProfilePicName</th>
                                </tr>
                                <%
                                    try 
                                    {
                                        String downstatus="select fileid, filename from dupimages where oldfileid='"+uname+"'";
                                        ResultSet rs8=st.executeQuery(downstatus);
                                        if(rs8.next())
                                        {                       
                                %>
                                            <tr>
                                                <td><%=rs8.getString(1)%></td>
                                                <td><%=rs8.getString(2)%></td>                     
                                            </tr>

                                <%
                                        }
                                        else
                                        {                                %>
                                            <tr>
                                                <td colspan="2" style="text-align: center;">Not Now</td>                                                                     
                                            </tr>
                                <%
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                %>
                            </table>
                            </center>
                        </div>
                 </div>
                </div>
            </div>
        </div>
    </section>            
                 
                 
                 
                 
                 
                 
    <section class="sign-up section-padding text-center" id="profilepic">
        <div style="margin-top: 120px"class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Upload your Profile Picture Here...</h3>
                 <div style="margin-top: 20px">   
                    <form class="signup-form" action="Profilepic" method="POST">
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i><input type="file"  name="file" class="" >
                        </div>
                       
                        <input type="submit" value="Upload" class="btn-fill sign-up-btn">
                    </form></div>
                </div>
            </div>
        </div>
    </section>
                        <section class="blog text-center" id="photos">
        <div style="margin-top: 200px" class="container-fluid">
     <%       String imgpost="Select * from postedimages where Fileid='"+uname+"'"; 
                  
          
            ResultSet rs2=st.executeQuery(imgpost);
             while(rs2.next()){
                 String pfname=rs2.getString(2);
                 String com=rs2.getString(3);
                 %>
            <div  class="row">
                
                 <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                             <img  style="width:300px;height:300px" src="Images/Posts/<%=pfname%>" alt="Posts"/>
                           <figcaption>
                            <p><a href="#" class="blog-post-title"><%=com%> <i class="fa fa-angle-right"></i></a></p>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                
            </div>
        </div>
            
    </section> <% }%>
      <section  id="notification"  class="hero">
      
<div   class="hero-strip section-padding">
        <div style="margin-top:20px" class="container">
            <div class="col-md-12 text-center">
          <%       String dup="Select * from dupimages where OldFileid='"+uname+"' and status='Waiting'"; 
                  
          
            ResultSet rs3=st.executeQuery(dup);
             if(rs3.next()){
                 String fid=rs3.getString(1);
                 String fname=rs3.getString(2);
                 String itype=rs3.getString(5);
                 String com=rs3.getString(4);
                 String mac=rs3.getString(6);
                 session.setAttribute("macaddress",mac);
                  session.setAttribute("imgtype",itype);
                  session.setAttribute("com",com);
                  session.setAttribute("fname",fname);
                  session.setAttribute("fid",fid);
                 %>        
                
                <h2>
                  The <%=itype%> Image of You was uploaded by <%=fid%> 
                </h2>
                 <%} 
             
             else{%>
             <p>    No Notifications</p>
              <%    }
               
        }finally
{
        
}       %>  
           <div >
               <div style="margin-left: -150px" >   <form class="signup-form" action="Allow" method="POST">
                           <input type="submit" value="Allow" class="btn btn-fill btn-large btn-margin-right">
                          
                       </form> 
                   <div style="margin-left: 350px;margin-top: -55px"  >    <form action="Block" method="Post">
                           <input type="submit" value="Block" class="btn btn-fill btn-large btn-margin-right">
                       </form> 
                   </div>
                   </div> 
                   <div class="logo-placeholder floating-logo"><img src="img/sketch-logo.png" alt="Sketch Logo"></div>
                   </div>
        </div> </div>
        </div>
            
        
    </section>
    <section class="to-top">
        <div class="container">
            
                <div class="to-top-wrap">
                    <a href="#top" class="top"><i class="fa fa-angle-up"></i></a>
                </div>
            </div>
        
    </section>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div class="footer-links">
                       
                        <p>An Automated Model to Detect Fake Profiles and botnets in Online Social Networks Using Steganography Technique 
                    </div>
                </div>
                <div class="social-share">
                   
                </div>
            </div>
        </div>
    </footer>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
    <script src="bower_components/retina.js/dist/retina.js"></script>
    <script src="js/jquery.fancybox.pack.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/jquery.flexslider-min.js"></script>
    <script src="bower_components/classie/classie.js"></script>
    <script src="bower_components/jquery-waypoints/lib/jquery.waypoints.min.js"></script>
    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
    <script>
    (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
    function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
    e=o.createElement(i);r=o.getElementsByTagName(i)[0];
    e.src='//www.google-analytics.com/analytics.js';
    r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
    ga('create','UA-XXXXX-X','auto');ga('send','pageview');
    </script>   
</body>
</html>