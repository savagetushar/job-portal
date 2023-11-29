<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sudhakar.connection.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<jsp:include page="CheckCookie"></jsp:include>

<jsp:scriptlet>
    String email=(String)session.getAttribute("session_email");
</jsp:scriptlet>

<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Companies</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div class="container-fluid">
            
            <jsp:scriptlet>
                if(email == null ? email == null : email.trim().equals("null"))
                {
            </jsp:scriptlet>
                <jsp:include page="header.jsp"></jsp:include>
            <jsp:scriptlet>
                }
                else
                {
            </jsp:scriptlet>
                    <jsp:include page="profileheader.jsp"></jsp:include>
            <jsp:scriptlet>
                }
            </jsp:scriptlet>
            <jsp:include page="menubar.jsp"></jsp:include>
            

                <div class="row">
                    <div class="col-md-3">
                        <ul>
                            <li> <a href=""> Smart Programming </a> </li>
                            <li> <a href=""> Infosys </a> </li>
                            <li> <a href=""> Wipro </a> </li>
                            <li> <a href=""> IBM </a> </li>
                            <li> <a href=""> Google </a> </li>
                        </ul>
                    </div>
                    <div class="col-md-6" style="background-color: #f9f8f9; margin-top: 10px">
                        <h2> Our Partners </h2>
                        <div class="row">
                        <jsp:scriptlet>
                            String c_id="", c_name="", c_email="", c_logo="", c_phoneno;
                            try
                            {
                                Connection con=DbConnection.getConnect();
                                
                                PreparedStatement ps=con.prepareStatement("select * from company_reg");
                                ResultSet rs=ps.executeQuery();
                                while(rs.next())
                                {
                                    c_id=rs.getString("id");
                                    c_name=rs.getString("c_name");
                                    c_email=rs.getString("c_email");
                                    c_logo=rs.getString("c_logo");
                                    c_phoneno=rs.getString("c_phoneno");
                                    </jsp:scriptlet>
                            
                            <div class="col-md-12 display_job_div">
                                <div class="row">
                                    <div class="col-md-2">
                                        <img src="company-logo/<jsp:expression>c_logo</jsp:expression>" height="50" />
                                    </div>
                                    <div class="col-md-10">
                                        <b> <jsp:expression>c_name</jsp:expression></b> <span style="font-size: 12px; color: #9f9d9d;"> (<jsp:expression>c_email</jsp:expression>)</span> <br> <br>
                                    <span class="glyphicon glyphicon-phone-alt"></span> &nbsp; <span style="color: #9f9d9d"> Phone No : </span> <jsp:expression>c_phoneno</jsp:expression> </span> <br>
                                    <br><a href="company-jobs.jsp?c_email=<jsp:expression>c_email</jsp:expression>"> See All Jobs of this company </a>
                                    </div>
                                </div>
                            </div>
                            
                        <jsp:scriptlet>
                                }
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        </jsp:scriptlet>
                            
                        </div>
                    </div>
                    <div class="col-md-3">
                        <ul>
                            <li> <a href=""> Smart Programming </a> </li>
                            <li> <a href=""> Infosys </a> </li>
                            <li> <a href=""> Wipro </a> </li>
                            <li> <a href=""> IBM </a> </li>
                            <li> <a href=""> Google </a> </li>
                        </ul>
                    </div>
                </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>