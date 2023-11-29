/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudhakar.backend;

import com.sudhakar.connection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        
        String email2=req.getParameter("email1");
        String pass2=req.getParameter("pass1");
        String remme2=req.getParameter("rememberme1");
        
        Connection con = null;
        try
        {
            con=DbConnection.getConnect();
            
            PreparedStatement ps=con.prepareStatement("select * from register1 where email=? and password=?");
            ps.setString(1, email2);
            ps.setString(2, pass2);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                if(remme2==null || remme2.equals("null"))
                {
                    remme2="";
                }
                if(remme2.equals("rememberme"))
                {
                    Cookie ck1=new Cookie("cookie_email", email2);
                    ck1.setMaxAge(60*60*24*365);
                    resp.addCookie(ck1);
                    
                    Cookie ck2=new Cookie("cookie_status", "true");
                    ck2.setMaxAge(60*60*24*365);
                    resp.addCookie(ck2);
                }
                
                RequestDispatcher rd=req.getRequestDispatcher("GetUserData");
                rd.include(req, resp);
                
                resp.sendRedirect("profile.jsp");
            }
            else
            {
                //resp.sendRedirect("login.jsp");
                RequestDispatcher rd1=req.getRequestDispatcher("header.jsp");
                rd1.include(req, resp);
                
                RequestDispatcher rd2=req.getRequestDispatcher("menubar.jsp");
                rd2.include(req, resp);
                
                req.setAttribute("error_message", "Invalid email id and password...!!");
                RequestDispatcher rd3=req.getRequestDispatcher("error.jsp");
                rd3.include(req, resp);
                
                RequestDispatcher rd4=req.getRequestDispatcher("logindiv.jsp");
                rd4.include(req, resp);
                
                RequestDispatcher rd5=req.getRequestDispatcher("footer.jsp");
                rd5.include(req, resp);
            }
        }
        catch(Exception e)
        {
            //out.print("Exception : "+e);
            
            RequestDispatcher rd1=req.getRequestDispatcher("header.jsp");
            rd1.include(req, resp);

            RequestDispatcher rd2=req.getRequestDispatcher("menubar.jsp");
            rd2.include(req, resp);

            req.setAttribute("error_message", e.getMessage());
            RequestDispatcher rd3=req.getRequestDispatcher("error.jsp");
            rd3.include(req, resp);

            RequestDispatcher rd4=req.getRequestDispatcher("logindiv.jsp");
            rd4.include(req, resp);

            RequestDispatcher rd5=req.getRequestDispatcher("footer.jsp");
            rd5.include(req, resp);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
