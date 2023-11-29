package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sudhakar.backend.PathDetails;
import java.io.File;
import com.sudhakar.connection.DbConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

Connection con=null;
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CheckCookie", out, false);
      out.write("\n");
      out.write("    \n");
      out.write('\n');
      out.write('\n');

    String name = (String) session.getAttribute("session_name");
    String emaill=(String) session.getAttribute("session_email");
    String gender = (String) session.getAttribute("session_gender");
    String city = (String) session.getAttribute("session_city");
    String fields = (String) session.getAttribute("session_fields");
    String profile_pic = (String) session.getAttribute("session_sudhakar");
    if (fields == null || fields.equals("")) {
        fields = "--- Not Available ---";
    }
    String title = (String) session.getAttribute("session_title");
    String skills = (String) session.getAttribute("session_skills");

      out.write('\n');
      out.write('\n');

    if (name == null || name.equals("")) {
        response.sendRedirect("login.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Welcome : ");
      out.print( name);
      out.write(" </title>\n");
      out.write("\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\">\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" ></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("            <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "profileheader.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menubar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-2\"> </div>\n");
      out.write("            <div class=\"col-md-8\">\n");
      out.write("                <div class=\"row\" style=\"border: 1px solid gray; box-shadow: 0px 0px 2px gray; border-radius: 3px\">\n");
      out.write("                    <div class=\"col-md-2\">\n");
      out.write("                        <a href=\"edit-profile-pic.jsp\" style=\"font-size: 12px; float: right\"> <span class=\"glyphicon glyphicon-pencil\"></span></a>\n");
      out.write("                        <img src=\"images/sudhakar.jpg\" ");
      out.print(profile_pic);
      out.write("\" height=\"100\" style=\"border-radius: 50px\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-10\">\n");
      out.write("                        <h3 style=\"color: blue\"> ");
      out.print( name.toUpperCase());
      out.write(" <a href=\"edit-profile-about.jsp\" style=\"font-size: 12px; float: right\"> <span class=\"glyphicon glyphicon-pencil\"></span> </a> </h3>\n");
      out.write("                        <b> ");
      out.print(title);
      out.write(" </b> <br> <br>\n");
      out.write("                        <span style=\"color: #acaaaa\"> Skills : </span> ");
      out.print(skills);
      out.write(" <br> <br>\n");
      out.write("                        <span style=\"color: #acaaaa\"> Gender : </span> ");
      out.print( gender);
      out.write(" <br>\n");
      out.write("                        <span style=\"color: #acaaaa\"> City : </span> ");
      out.print( city);
      out.write(" <br>\n");
      out.write("                        <span style=\"color: #acaaaa\"> Fields : </span> ");
      out.print( fields);
      out.write(" <br>\n");
      out.write("                        </div>\n");
      out.write("                </div> <br> <br>\n");
      out.write("                    <div class=\"row\"  style=\"border: 1px solid gray; box-shadow: 0px 0px 2px gray; border-radius: 3px\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h4> Education Details <a href=\"add-profile-education.jsp\" style=\"font-size: 12px; float: right\"> <span class=\"glyphicon glyphicon-plus\"></span> </a> </h4>\n");
      out.write("                        ");

                            String school="", degree="", grade="", year="", id="";
                            String email=(String)session.getAttribute("session_email");
                            try
                            {
                                con=DbConnection.getConnect();
            
                                PreparedStatement ps=con.prepareStatement("select * from education where email=?");
                                ps.setString(1, email);
                                ResultSet rs=ps.executeQuery();
                                while(rs.next())
                                {
                                    id=rs.getString("id");
                                    school=rs.getString("school");
                                    degree=rs.getString("degree");
                                    grade=rs.getString("grade");
                                    year=rs.getString("year");
                        
      out.write("\n");
      out.write("                            \n");
      out.write("                            <div class=\"row\" style=\"background-color: #eeecec\">\n");
      out.write("                                <div class=\"col-md-2\"> &nbsp;&nbsp;&nbsp; <img src=\"images/school.png\" height=\"70\" /> </div>\n");
      out.write("                                <div class=\"col-md-10\">\n");
      out.write("                                    <a href=\"edit-profile-education.jsp?id=");
      out.print(id);
      out.write("\" style=\"font-size: 12px; float: right\"> <span class=\"glyphicon glyphicon-pencil\"></span> </a>\n");
      out.write("                                    <b> <span class=\"glyphicon glyphicon-home\">&nbsp;</span> ");
      out.print(school);
      out.write(" <br> </b>\n");
      out.write("                                <span class=\"glyphicon glyphicon-book\"></span> &nbsp; ");
      out.print( degree );
      out.write(" <span style=\"color: #858585\">(");
      out.print( year );
      out.write(")</span> <br>\n");
      out.write("                                <span class=\"glyphicon glyphicon-file\"></span> &nbsp; ");
      out.print( grade );
      out.write("% <br>\n");
      out.write("                                </div>\n");
      out.write("                        </div> <br>\n");
      out.write("                            \n");
      out.write("                        ");

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
                                out.print(e);
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
                        
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div> <br> <br>\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\"  style=\"border: 1px solid gray; box-shadow: 0px 0px 2px gray; border-radius: 3px\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h4> Experience Details <a href=\"add-profile-experience.jsp\" style=\"font-size: 12px; float: right\"> <span class=\"glyphicon glyphicon-plus\"></span> </a> </h4>\n");
      out.write("                        ");

                            String company1="", location1="", jobtitle1="", year1="", id1="";
                            try
                            {
                                con=DbConnection.getConnect();
            
                                PreparedStatement ps=con.prepareStatement("select * from experience where email=?");
                                ps.setString(1, email);
                                ResultSet rs=ps.executeQuery();
                                while(rs.next())
                                {
                                    id1=rs.getString("id");
                                    company1=rs.getString("company");
                                    location1=rs.getString("location");
                                    jobtitle1=rs.getString("job_title");
                                    year1=rs.getString("year");
                        
      out.write("\n");
      out.write("                            \n");
      out.write("                            <div class=\"row\" style=\"background-color: #eeecec\">\n");
      out.write("                                <div class=\"col-md-2\"> &nbsp;&nbsp;&nbsp; <img src=\"images/school.png\" height=\"70\" /> </div>\n");
      out.write("                                <div class=\"col-md-10\">\n");
      out.write("                                    <a href=\"edit-profile-experience.jsp?id=");
      out.print(id1);
      out.write("\" style=\"font-size: 12px; float: right\"> <span class=\"glyphicon glyphicon-pencil\"></span> </a>\n");
      out.write("                                    <b> <span class=\"glyphicon glyphicon-home\">&nbsp;</span> ");
      out.print(company1);
      out.write(" <br> </b>\n");
      out.write("                                <span class=\"glyphicon glyphicon-book\"></span> &nbsp; ");
      out.print(location1);
      out.write(" <span style=\"color: #858585\">(");
      out.print( year1 );
      out.write(")</span> <br>\n");
      out.write("                                <span class=\"glyphicon glyphicon-file\"></span> &nbsp; ");
      out.print(jobtitle1);
      out.write(" <br>\n");
      out.write("                                </div>\n");
      out.write("                        </div> <br>\n");
      out.write("                            \n");
      out.write("                        ");

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
                                out.print(e);
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
                        
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div> <br> <br>\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\"  style=\"border: 1px solid gray; box-shadow: 0px 0px 2px gray; border-radius: 3px\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h4> Resume Details </h4>\n");
      out.write("                            <div class=\"row\" style=\"background-color: #ececec\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <a href=\"upload-resume.jsp\"> <span class=\"glyphicon glyphicon-plus\"></span> Upload Resume </a>\n");
      out.write("                            ");

                            String file_name=null;
                                try
                                {
                                    Connection con=DbConnection.getConnect();
                                    PreparedStatement ps=con.prepareStatement("select * from resumes where email=?");
                                    ps.setString(1, email);
                                    ResultSet rs=ps.executeQuery();
                                    if(rs.next())
                                    {
                                        file_name=rs.getString("path");
                                        
      out.write("\n");
      out.write("                                &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"DownloadResume?fn=");
      out.print(file_name);
      out.write("\" class=\"btn btn-success\"> Download Resume </a>\n");
      out.write("                            ");

                                    }
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                            
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <a href=\"resume-builder-details.jsp\"> <span class=\"glyphicon glyphicon-pencil\"></span> Resume Builder </a>\n");
      out.write("                            ");

                            
                            File f=new File(PathDetails.RESUME_BUILDER_PATH+emaill+".pdf");
                            if(f.exists())
                            {
                            
      out.write("\n");
      out.write("                                &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"DownloadResumeBuilder?fn=");
      out.print(emaill+".pdf");
      out.write("\" class=\"btn btn-success\"> Download Resume </a>\n");
      out.write("                            ");

                            }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div> <br> <br>\n");
      out.write("                    \n");
      out.write("                    <div class=\"row\" style=\"background-color: #ececec\">\n");
      out.write("                        <div class=\"col-md-2\"> </div>\n");
      out.write("                        <div class=\"col-md-8\"> <input type=\"submit\" value=\"Follow\" /> </div>\n");
      out.write("                        <div class=\"col-md-2\"> </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\"> </div>\n");
      out.write("            </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
