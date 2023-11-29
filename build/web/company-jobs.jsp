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
    String c_email=request.getParameter("c_email");
</jsp:scriptlet>

<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Job Portal Website</title>

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
                        <div class="row">
                        <jsp:scriptlet>
                            String id,job_profile, company, experience, description, date1, time1;
                            try
                            {
                                Connection con=DbConnection.getConnect();
                                
                                PreparedStatement ps=con.prepareStatement("select * from jobs where c_email=?");
                                ps.setString(1, c_email);
                                ResultSet rs=ps.executeQuery();
                                while(rs.next())
                                {
                                    id=rs.getString("id");
                                    job_profile=rs.getString("job_profile");
                                    company=rs.getString("company");
                                    experience=rs.getString("experience");
                                    description=rs.getString("description");
                                    date1=rs.getString("date1");
                                    time1=rs.getString("time1");
                                    </jsp:scriptlet>
                            
                            <div class="col-md-12 display_job_div">
                                <b> <jsp:expression>job_profile</jsp:expression></b> <span style="font-size: 12px; color: #9f9d9d; float: right"> (<jsp:expression>date1</jsp:expression> & <jsp:expression>time1</jsp:expression>)</span> <br>
                            <span class="glyphicon glyphicon-home"></span> <span style="color: #9f9d9d"> Company : </span> <jsp:expression>company</jsp:expression> </span> <br>
                                <span> <span class="glyphicon glyphicon-book"></span> <span style="color: #9f9d9d"> Experience : </span> <jsp:expression>experience</jsp:expression> </span> <br>
                                <span> <span class="glyphicon glyphicon-file"></span>  <span style="color: #9f9d9d"> Job Description : </span> <jsp:expression>description</jsp:expression> </span> <br>
                                <br><a href="job-description.jsp?jid=<jsp:expression>id</jsp:expression>"> See Full Details </a>
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