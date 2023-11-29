<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<jsp:include page="CheckCookie"></jsp:include>

<html>
    <head>
        <meta charset="ISO-8859-1">
        <title> Register -online jobportel </title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/style.css" />
        
        
        <script>
            function val(v)
            {
                document.getElementById(v).innerHTML="";
            }
            function validation()
            {
                var flag=true;
                
                var name2=document.regform.name1.value;
                var email2=document.regform.email1.value;
                var pass2=document.regform.pass1.value;
                var gender2=document.regform.gender1.value;
                //var fields2=document.regform.field1.value;
                var city2=document.regform.city1.value;
                
                var name_pattern=/^[a-zA-Z ]{3,30}$/;
                var email_pattern = /^([a-zA-Z0-9])(([a-zA-Z0-9])*([\._\+-])*([a-zA-Z0-9]))*@(([a-zA-Z0-9\-])+(\.))+([a-zA-Z]{2,4})+$/;
                var password_pattern = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
                
                /*
                if you dont want to remember the regex pattern then simply use below code
        
                if(pass2.length<6 && pass2.length>16)
                {
                    
                }
                if(pass2.search(/[a-zA-Z]/) < 0)
                {
                    
                }
                if(pass2.search(/[0-9]/) < 0)
                {
                    
                }
                if(pass2.search(/[@_]/) < 0)
                {
                    
                }*/
                
                if(!name2.match(name_pattern))
                {
                    document.getElementById('name_error').innerHTML="Name is not properly formated";
                    flag=false;
                }
                if(name2==="")
                {
                    document.getElementById('name_error').innerHTML="Name cannot be empty";
                    flag=false;
                }
                
                if(!email2.match(email_pattern))
                {
                    document.getElementById('email_error').innerHTML="Email is not properly formatted";
                    flag=false;
                }
                if(email2==="")
                {
                    document.getElementById('email_error').innerHTML="Email cannot be empty";
                    flag=false;
                }
                
                if(!pass2.match(password_pattern))
                {
                    document.getElementById('password_error').innerHTML="Password is not properly formatted (should contain 0-9,special characters)";
                    flag=false;
                }
                if(pass2==="")
                {
                    document.getElementById('password_error').innerHTML="Password cannot be empty";
                    flag=false;
                }
                if(gender2==="")
                {
                    document.getElementById('gender_error').innerHTML="Please select gender";
                    flag=false;
                }
                /*else if(fields2==="")
                {
                    alert("Please select atleast one field");
                    return false;
                }*/
                if(city2==="Select City")
                {
                    document.getElementById('city_error').innerHTML="Please select the city";
                    flag=false;
                }
                return flag;
                
                /*if(name2==="")
                {
                    alert("Name cannot be empty");
                    return false;
                }
                else if(email2==="")
                {
                    alert("Email cannot be empty");
                    return false;
                }
                else if(pass2==="")
                {
                    alert("Password cannot be empty");
                    return false;
                }
                else if(gender2==="")
                {
                    alert("Please select gender");
                    return false;
                }
                else if(fields2==="")
                {
                    alert("Please select atleast one field");
                    return false;
                }
                else if(city2==="Select City")
                {
                    alert("Please select the city");
                    return false;
                }
                else
                {
                    document.regform.action="reg";
                    document.regform.submit();
                }*/
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="menubar.jsp"></jsp:include>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="reg_div_design">
                            <form method="post" name="regform" onsubmit="return validation()" action="reg">
                                <br> <h2> Register Here </h2> <br>
                                <input type="text" placeholder="Enter Name" name="name1" class="reglog_tf_design" onkeyup="val('name_error')" /> <br> <span id="name_error" style="color: red"> </span> <br> <br>
                                <input type="text" placeholder="Enter Email" name="email1" class="reglog_tf_design" onkeyup="val('email_error')" /> <br> <span id="email_error" style="color: red"> </span> <br> <br>
                                <input type="password" placeholder="Enter Password" name="pass1" class="reglog_tf_design" onkeyup="val('password_error')" /> <br> <span id="password_error" style="color: red"> </span> <br> <br>
                                <b> Select Gender : </b> <input type="radio" name="gender1" value="Male" /> Male <input type="radio" name="gender1" value="Female" /> Female <br> <span id="gender_error" style="color: red"> </span> <br> <br>
                                <b> Select Fields : </b> <input type="checkbox" name="field1" value="Information Technology" /> Information Technology <br>
                                <input type="checkbox" name="field1" value="Marketing" /> Marketing
                                <input type="checkbox" name="field1" value="Finance" /> Finance <br> <br>
                                <select name="city1" class="reglog_tf_design">
                                    <option> Select City </option>
                                    <option value="Patna"> Patna </option>
                                    <option value="Delhi"> Delhi </option>
                                    <option value="punjab"> Punjab </option>
                                     <option value="punjab"> Bangalore </option>
                                </select> <br> <span id="city_error" style="color: red"> </span> <br> <br>
                                <input type="submit" value="Register" class="btn btn-primary" /> <br> <br>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3"></div>
                </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>