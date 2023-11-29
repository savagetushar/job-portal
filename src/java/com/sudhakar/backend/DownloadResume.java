/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudhakar.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Deepak
 */
public class DownloadResume extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out=resp.getWriter();
        
        String file_name=req.getParameter("fn");
        resp.setHeader("Content-Disposition", "attchment; filename=\""+file_name);
        
        FileInputStream fis=new FileInputStream(PathDetails.RESUME_PATH+file_name);
        int i;
        while((i=fis.read()) != -1)
        {
            out.write(i);
        }
        
        fis.close();
        out.close();
    }
}
