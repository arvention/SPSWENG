package org.apache.jsp.CreateAccount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import AddAccountBeans.searchEmployeeBean;
import Bean.EmployeeBean;
import Bean.EmployeeBean;
import java.util.ArrayList;

public final class SearchEmp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"eq logo.ico\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"../css/SearchEmployee.css\"/>\r\n");
      out.write("        \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<DIV class =\"pageTop\">\r\n");
      out.write("\t<div id=\"box\">\r\n");
      out.write("\t<div id=\"results\">\r\n");
      out.write("\t\r\n");
      out.write("            \r\n");
      out.write("    ");

        searchEmployeeBean bean  =(searchEmployeeBean) session.getAttribute("search");
        ArrayList< EmployeeBean > collection = bean.getSearchResult();
        
        if(collection.size() ==0){
           
      out.write(" \r\n");
      out.write("           <h1> NO SEARCH RESULTS </h1>\r\n");
      out.write("       ");
 }
       
        else
        for(EmployeeBean result : collection ){
        
      out.write("\r\n");
      out.write("        <div class=\"result\">\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <form action =\"../SaveAccount\" method=\"POST\" >\r\n");
      out.write("\t\t<span class=\"name\"> ");
      out.print(result.getlastname());
      out.write(" ,  ");
      out.print(result.getfirstname());
      out.write(" </span><br>\r\n");
      out.write("\t\t<span class=\"idnum\">");
      out.print(result.getempid() );
      out.write("</span><br>\r\n");
      out.write("\t\t<span class=\"accStatus\">No Account</span>\r\n");
      out.write("\t\t<select required name=\"type\">\r\n");
      out.write("\t\t\t<option value=\"sm\"> Senior Manager </option>\r\n");
      out.write("\t\t\t<option value=\"m\"> Manager </option>\r\n");
      out.write("\t\t\t<option value =\"hr\"> HR Employee </option>\r\n");
      out.write("\t\t\t<option selected value=\"e\"> Employee </option>\r\n");
      out.write("                        <input type=\"hidden\"  name=\"entry\" value=\"");
      out.print(result.getentrynum());
      out.write("\">\r\n");
      out.write("                      <input type =\"submit\" value=\"Add Account\">  \r\n");
      out.write("                      \r\n");
      out.write("\t\t</select>\r\n");
      out.write("               \r\n");
      out.write("            <form>    \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("        ");

        }
       
      out.write("\r\n");
      out.write("    \r\n");
      out.write("           \r\n");
      out.write("       \r\n");
      out.write("         \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("         \r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
