<%-- 
    Document   : contact-us-nouser
    Created on : 15 june, 2020, 3:45:24 PM
    Author     : sudhakar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>contact-us</title>
    </head>
    <body>
        <div class="reg_div_design">
            <form method="POST" action="ContactUs">
                <br> <h2> Contact Us </h2> <br>
                <input type="text" placeholder="Enter Name" name="name1" class="reglog_tf_design" /> <br> <br>
                <input type="text" placeholder="Enter Email" name="email1" class="reglog_tf_design" /> <br> <br>
                <input type="text" placeholder="Enter Subject" name="subject1" class="reglog_tf_design" /> <br> <br>
                <textarea placeholder="Enter Message" name="message1" style="padding: 5px 10px; width: 350px; height: 100px; border-radius: 5px; border: 1px solid gray;"></textarea> <br> <br>
                <input type="submit" value="Send" class="btn btn-primary" /> <br> <br> <br>
            </form>
        </div>
    </body>
</html>
