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
        <title>Job Portal Website</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script>
            function searchJobByTech(tech)
            {
                //alert(tech);
                
                var obj;
                // 1. creates an XMLHttpRequest Object
                if(window.XMLHttpRequest)
                {
                    obj=new XMLHttpRequest();   //for latest browsers
                }
                else
                {
                    obj=new ActiveXObject("Microsoft.XMLHTTP");     //for old IE version
                }
                
                // 2. specify the request
                obj.open("POST", "JobSearchByTechnology?technology="+tech, true);
                
                // 3. sends the request to the server
                obj.send();
                
                // 4. calls the function when readyState property changes
                obj.onreadystatechange = function()
                {
                    if(obj.readyState === 4 && obj.status === 200)
                    {
                        document.getElementById('respgenerated').innerHTML = obj.responseText;
                    }
                };
            }
            function searchJobByLocation(location)
            {
                var obj;
                // 1. creates an XMLHttpRequest Object
                if(window.XMLHttpRequest)
                {
                    obj=new XMLHttpRequest();   //for latest browsers
                }
                else
                {
                    obj=new ActiveXObject("Microsoft.XMLHTTP");     //for old IE version
                }
                
                // 2. specify the request
                obj.open("POST", "JobSearchByLocation?location="+location, true);
                
                // 3. sends the request to the server
                obj.send();
                
                // 4. calls the function when readyState property changes
                obj.onreadystatechange = function()
                {
                    if(obj.readyState === 4 && obj.status === 200)
                    {
                        document.getElementById('respgenerated').innerHTML = obj.responseText;
                    }
                };
            }
        </script>
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

                <!-- ==============search job div starts================= -->
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8 job_search_div">
                        <h3> Find A Job at India's No.1 Job Site </h3>
                        <input type="text" placeholder="Search By Technology..." class="textfield_design" onkeyup="searchJobByTech(this.value)" /> <br> <br>
                        OR <br> <br>
                        <input type="text" placeholder="Search By Location..." class="textfield_design" onkeyup="searchJobByLocation(this.value)" /> <br> <br>
                    </div>
                    <div class="col-md-2"></div>
                </div>
                <!-- ==============search job div ends================= -->

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
                            <div class="col-md-12">
                                <span id="respgenerated"> No Result Found </span>
                            </div>
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