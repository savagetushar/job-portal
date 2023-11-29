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

/**
 *
 * @author Deepak
 */
public class DeleteExperienceDetails extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id2=req.getParameter("id1");
        
        Connection con=null;
        try
        {
            con=DbConnection.getConnect();
            con.setAutoCommit(false);
            
            PreparedStatement ps=con.prepareStatement("delete from experience where id=?");
            ps.setString(1, id2);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                con.commit();
                resp.sendRedirect("profile.jsp");
            }
            else
            {
                con.rollback();
                
                RequestDispatcher rd1=req.getRequestDispatcher("error.jsp");
                rd1.include(req, resp);
                
                RequestDispatcher rd2=req.getRequestDispatcher("edit-profile-experience.jsp");
                rd2.include(req, resp);
            }
        }
        catch(Exception e)
        {
            try
            {
                con.rollback();
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
            RequestDispatcher rd1=req.getRequestDispatcher("error.jsp");
            rd1.include(req, resp);

            RequestDispatcher rd2=req.getRequestDispatcher("edit-profile-experience.jsp");
            rd2.include(req, resp);
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
