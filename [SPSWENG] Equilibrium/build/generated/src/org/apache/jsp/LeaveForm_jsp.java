package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class LeaveForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel = \"shortcut icon\" href=\"eq logo.ico\"/>\r\n");
      out.write("        <title>Leave Application - EQuilibrium</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap -->\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"css/jquery-ui.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" \tmedia=\"all\" href=\"css/LeaveForm.css\" />\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("        <!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                $(\"#datepicker\").datepicker({\r\n");
      out.write("                    changeMonth: true;\r\n");
      out.write("                    changeYear: true;\r\n");
      out.write("                });            \r\n");
      out.write("        </script>\r\n");
      out.write("        <script type = \"text/javascript\" src = \"js/LeaveForm.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class= \"header\">\r\n");
      out.write("            <h3>Leave Form Application</h3>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div align=\"center\" class=\"content\">\r\n");
      out.write("            <form id = \"leave_form\" action = \"LeaveSubmit\" method = \"post\"><br>\r\n");
      out.write("                <h4>ID Number: <input type=\"number\" name = \"idNum\" required></h4>\r\n");
      out.write("                <h4>Type of Leave:\r\n");
      out.write("                    <select name= \"leaveType\" required>\r\n");
      out.write("                        <option value= \"Sick\">Sick</option>\r\n");
      out.write("                        <option value= \"Vacation\">Vacation</option>\r\n");
      out.write("                        <option value= \"Emergency\">Emergency</option>\r\n");
      out.write("                        <option value= \"Maternity\">Maternity</option>\r\n");
      out.write("                        <option value= \"Paternity\">Paternity</option>\r\n");
      out.write("                        <option value= \"Bereavement\">Bereavement</option>\r\n");
      out.write("                    </select></h4>\r\n");
      out.write("                <h4>Days of Leave: <input type=\"number\" min=\"0.5\" max=\"15\" name = \"dayCount\" step=\"0.5\" required></h4><br/>\r\n");
      out.write("                <h4>\r\n");
      out.write("                    Inclusive Dates:\r\n");
      out.write("\r\n");
      out.write("                    <input type= \"date\" class= \"form-control\" id=\"dp\" name = \"startDate\" required/> \r\n");
      out.write("                    until \r\n");
      out.write("                    <input type= \"date\" class= \"form-control\" id=\"dp\" name = \"endDate\" required/>\r\n");
      out.write("                </h4>\r\n");
      out.write("                ");

                    HttpSession reqSession = request.getSession();
                    ArrayList<Boolean> errorFlags = (ArrayList)reqSession.getAttribute("errorFlags");
                    
                    if(errorFlags != null)
                    {
                        if(errorFlags.get(0))
                        {
                
      out.write("\r\n");
      out.write("                            <h4><hr/>Invalid Input! The end date is earlier than the start date.</h4>\r\n");
      out.write("                ");

                        }
                        else if(errorFlags.get(1))
                        {
                
      out.write("\r\n");
      out.write("                            <h4><hr/>Invalid Input! The number of days of leave doesn't match the duration between the start and end date.</h4>\r\n");
      out.write("                ");

                        }
                        else if(errorFlags.get(2))
                        {
                
      out.write("\r\n");
      out.write("                            <h4><hr/>Employee ID not found.</h4>\r\n");
      out.write("                ");
        
                        }
                    }
                
      out.write("\r\n");
      out.write("                <input class= \"submitButton\" type=\"submit\" value= \"Submit\" name= \"dataSubmit\"/>\r\n");
      out.write("                <a href=\"homepage.html\"><input class=\"back\" type=\"submit\" value=\"Back\" name=\"bBack\"/></a>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class= \"footer\">\r\n");
      out.write("            <hr width=\"75%\"/>\r\n");
      out.write("            EQUILIBRIUM INTERTRADE CORP.\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
