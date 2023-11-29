<%-- 
    Document   : Profile
    Created on : 21 june, 2020, 4:08:36 PM
    Author     : sudhakar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="CheckCookie"></jsp:include>

<jsp:scriptlet>
    String name = (String) session.getAttribute("session_name");
    String gender = (String) session.getAttribute("session_gender");
    String city = (String) session.getAttribute("session_city");
    String fields = (String) session.getAttribute("session_fields");
    String title = (String) session.getAttribute("session_title");
    String profile_pic = (String) session.getAttribute("session_profilepic");
    if (title == null || title.equals("")) {
        title = "";
    }
    String skills = (String) session.getAttribute("session_skills");
    if (skills == null || skills.equals("")) {
        skills = "";
    }
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
        <title> Smart Programming - Profile </title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/style.css" />

        <script>
            function changeGender()
            {
                document.getElementById('chnggendertf').value = document.getElementById('chnggender').value;
            }
            function changeCity()
            {
                document.getElementById('chngcitytf').value = document.getElementById('chngcity').value;
            }
        </script>
    </head>
    <body>
        <jsp:include page="profileheader.jsp" />
        <jsp:include page="menubar.jsp" />

        <div class="row">
            <div class="col-md-2"> </div>
            <div class="col-md-8">
                <div class="row" style="border: 1px solid gray; box-shadow: 0px 0px 2px gray; border-radius: 3px">
                    <div class="col-md-2">
                        <img src="profilepics/<jsp:expression>profile_pic</jsp:expression>" height="100" style="border-radius: 50px"/>
                    </div>
                    <div class="col-md-10">
                        <h2> Edit Personal Details </h2> <br>
                        <form action="EditProfileAbout" method="POST">
                            <b> <jsp:expression>name</jsp:expression> </b>(<jsp:expression> session.getAttribute("session_email") </jsp:expression>) <br> <br>
                            <input type="text" value="<jsp:expression> name</jsp:expression>" name="name1" class="textfield_design" placeholder="Enter Name"/> <br> <br>
                            <input id="chnggendertf" type="text" value="<jsp:expression> gender</jsp:expression>" name="gender1" class="textfield_design" placeholder="Select Gender" readonly="" />
                                <select id="chnggender" onchange="changeGender()">
                                    <option disabled=""> Select Gender </option>
                                    <option> Male </option>
                                    <option> Female </option>
                                </select>
                                <br> <br>
                                <input id="chngcitytf" type="text" value="<jsp:expression> city</jsp:expression>" name="city1" class="textfield_design" placeholder="Select City" readonly=""/>
                                <select id="chngcity" onchange="changeCity()">
                                    <option disabled=""> Select City </option>
                                    <option value="Chandigarh"> Chandigarh </option>
                                    <option value="Panchkula"> Panchkula </option>
                                    <option value="Mohali"> Mohali </option>
                                </select>
                                <br> <br>
                                <input type="text" value="<jsp:expression> title</jsp:expression>" name="title1" class="textfield_design" placeholder="Profile Title" /> <br> <br>
                            <textarea placeholder="Skills" name="skills1" style="padding: 5px 10px; width: 300px; height: 100px; border-radius: 5px; border: 1px solid gray;"><jsp:expression>skills</jsp:expression></textarea> <br> <br>
                                <input type="submit" value="Update" class="btn btn-danger" />
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-2"> </div>
            </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
