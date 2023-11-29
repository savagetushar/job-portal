package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.sudhakar.connection.DbConnection;
import java.sql.Connection;

public final class my_002dapplied_002djobs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String email;

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CheckCookie", out, false);
      out.write('\n');
      out.write('\n');
      out.write('\n');

    email=(String)session.getAttribute("session_email");

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"ISO-8859-1\">\n");
      out.write("        <title>Job Portal Website</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" ></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            \n");
      out.write("            ");

                if(email == null ? email == null : email.trim().equals("null"))
                {
            
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            ");

                }
                else
                {
            
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "profileheader.jsp", out, false);
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menubar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li> <a href=\"\"> Smart Programming </a> </li>\n");
      out.write("                            <li> <a href=\"\"> Infosys </a> </li>\n");
      out.write("                            <li> <a href=\"\"> Wipro </a> </li>\n");
      out.write("                            <li> <a href=\"\"> IBM </a> </li>\n");
      out.write("                            <li> <a href=\"\"> Google </a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6\" style=\"background-color: #f9f8f9; margin-top: 10px\">\n");
      out.write("                        <h2> My Applied Jobs </h2>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                        ");

                            String jobid="",job_profile="", company="", experience="", description="", date1="", time1="";
                            try
                            {
                                Connection con=DbConnection.getConnect();
                                
                                PreparedStatement ps=con.prepareStatement("select * from applied_jobs where email=?");
                                ps.setString(1, email);
                                ResultSet rs=ps.executeQuery();
                                while(rs.next())
                                {
                                    jobid=rs.getString("jobid");
                                    
                                    PreparedStatement ps2=con.prepareStatement("select * from jobs where id=?");
                                    ps2.setString(1, jobid);
                                    ResultSet rs2=ps2.executeQuery();
                                    while(rs2.next())
                                    {
                                        job_profile=rs2.getString("job_profile");
                                        company=rs2.getString("company");
                                        experience=rs2.getString("experience");
                                        description=rs2.getString("description");
                                        date1=rs2.getString("date1");
                                        time1=rs2.getString("time1");
                                    
      out.write("\n");
      out.write("                            \n");
      out.write("                            <div class=\"col-md-12 display_job_div\">\n");
      out.write("                                <b> ");
      out.print(job_profile);
      out.write("</b> <span style=\"font-size: 12px; color: #9f9d9d; float: right\"> (");
      out.print(date1);
      out.write(" & ");
      out.print(time1);
      out.write(")</span> <br>\n");
      out.write("                            <span class=\"glyphicon glyphicon-home\"></span> <span style=\"color: #9f9d9d\"> Company : </span> ");
      out.print(company);
      out.write(" </span> <br>\n");
      out.write("                                <span> <span class=\"glyphicon glyphicon-book\"></span> <span style=\"color: #9f9d9d\"> Experience : </span> ");
      out.print(experience);
      out.write(" </span> <br>\n");
      out.write("                                <span> <span class=\"glyphicon glyphicon-file\"></span>  <span style=\"color: #9f9d9d\"> Job Description : </span> ");
      out.print(description);
      out.write(" </span> <br>\n");
      out.write("                                <br><a href=\"job-description.jsp?jid=");
      out.print(jobid);
      out.write("\"> See Full Details </a>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        ");

                                    }
                                }
                            }
                            catch(Exception e)
                            {
                                out.print(e);
                            }
                        
      out.write("\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li> <a href=\"\"> Smart Programming </a> </li>\n");
      out.write("                            <li> <a href=\"\"> Infosys </a> </li>\n");
      out.write("                            <li> <a href=\"\"> Wipro </a> </li>\n");
      out.write("                            <li> <a href=\"\"> IBM </a> </li>\n");
      out.write("                            <li> <a href=\"\"> Google </a> </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
