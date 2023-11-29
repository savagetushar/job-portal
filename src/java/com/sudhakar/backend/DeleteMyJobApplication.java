/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudhakar.backend;

import com.sudhakar.connection.DbConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Deepak
 */
public class DeleteMyJobApplication extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("session_email");
        
        String jid=req.getParameter("jobid");
        
        Connection con=null;
        try
        {
            con=DbConnection.getConnect();
            con.setAutoCommit(false);
            
            PreparedStatement ps=con.prepareStatement("delete from applied_jobs where email=? and jobid=?");
            ps.setString(1, email);
            ps.setString(2, jid);
            int i=ps.executeUpdate();
            if(i>0)
            {
                con.commit();
                
                resp.sendRedirect("my-applied-jobs.jsp");
            }
            else
            {
                con.rollback();
                
                RequestDispatcher rd1=req.getRequestDispatcher("error.jsp");
                rd1.include(req, resp);
                RequestDispatcher rd2=req.getRequestDispatcher("job-description.jsp?jid="+jid);
                rd2.include(req, resp);
            }
        }
        catch(Exception e)
        {
            try
            {
                con.rollback();
                
                RequestDispatcher rd1=req.getRequestDispatcher("error.jsp");
                rd1.include(req, resp);
                RequestDispatcher rd2=req.getRequestDispatcher("job-description.jsp?jid="+jid);
                rd2.include(req, resp);
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
            e.printStackTrace();
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
