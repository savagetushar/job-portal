<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<jsp:scriptlet>
    String name=(String)session.getAttribute("session_name");
    String profile_pic = (String) session.getAttribute("session_profilepic");
</jsp:scriptlet>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title> Welcome : <jsp:expression> name </jsp:expression> </title>
    </head>
    <body>
        <div class="row header_bg">
            <div class="col-md-4">
                <a href="index.jsp">
                    <img src="images/smartprogramminglogo.png" height="50" />
                    <span class="logo_text_design"> Job Portal </span>
                </a>
            </div>
            <div class="col-md-6">
                <span style="color: yellow"> <a href="profile.jsp" style="text-decoration: none; color: white; font-size: 18px"> <img src="profilepics/<jsp:expression>profile_pic</jsp:expression>" height="30" style="border-radius: 15px"/> <jsp:expression> name </jsp:expression> </a> </span>
            </div>
            <div class="col-md-2">
                <a href="Logout" class="hyperlinks_design"> Logout </a>
            </div>
        </div>
    </body>
</html>