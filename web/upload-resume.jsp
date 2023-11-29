<%-- 
    Document   : Profile
    Created on : 1 july, 2022, 4:08:36 PM
    Author     : sudhakar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="CheckCookie"></jsp:include>

<jsp:scriptlet>
    String name = (String) session.getAttribute("session_name");
    String profile_pic = (String) session.getAttribute("session_sudhakar");
</jsp:scriptlet>

<jsp:scriptlet>
    if (name == null || name.equals("")) {
        response.sendRedirect("login.jsp");
    }
</jsp:scriptlet>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Smart Programming - Upload Resume </title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <jsp:include page="profileheader.jsp" />
        <jsp:include page="menubar.jsp" />

        <div class="row">
            <div class="col-md-2"> </div>
            <div class="col-md-8">
                <div class="row" style="border: 1px solid gray; box-shadow: 0px 0px 2px gray; border-radius: 3px">
                    <div class="col-md-3">
                        <img src="profilepics/<jsp:expression>profile_pic</jsp:expression>" height="150" style="border-radius: 75px"/>
                    </div>
                    <div class="col-md-9">
                        <h2> Upload Resume </h2> <br>
                        <form action="UpdateResume" method="POST" enctype="multipart/form-data">
                            <b> <jsp:expression>name</jsp:expression> </b>(<jsp:expression> session.getAttribute("session_email") </jsp:expression>) <br> <br>
                            <input type="file" name="uploadresume" /> <br> <br>
                                <input type="submit" value="Update Resume" class="btn btn-danger" />
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-2"> </div>
            </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
