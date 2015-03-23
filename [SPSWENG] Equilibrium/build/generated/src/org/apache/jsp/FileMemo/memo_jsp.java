package org.apache.jsp.FileMemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.EmployeeBean;
import java.util.ArrayList;
import AddAccountBeans.searchEmployeeBean;

public final class memo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"eq logo.ico\"/>\r\n");
      out.write("\t<title> Memo Form - Equilibrium </title>\r\n");
      out.write("        <link href = \"../css/FileMemo.css\" rel = \"stylesheet\" />\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=#E8E8E8>\r\n");
      out.write("\t<div class = \"memoForm\">\r\n");
      out.write("\t\t<br/><br/><br/><br/><br/>\r\n");
      out.write("\t\t<text class= \"titleText\"> File a Memo </text>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<div class = \"contentText\">\r\n");
      out.write("\t\t<form action=\"../SaveMemo\" method=\"POST\">\r\n");
      out.write("\t\tMemo addressed to:\r\n");
      out.write("\t\t<select required name=\"listEmployees\">\r\n");
      out.write("                    \r\n");
      out.write("                 ");
 
                     searchEmployeeBean bean  =(searchEmployeeBean) session.getAttribute("ManagerEmployee");
                     ArrayList<EmployeeBean> list = bean.getSearchResult();
                     
                     for(EmployeeBean emp : list ){
                            
                 
      out.write("\r\n");
      out.write("                 <option value=\"");
      out.print(emp.getempid());
      out.write("\" > ");
      out.print(emp.getlastname());
      out.write(',');
      out.write(' ');
      out.print(emp.getfirstname());
      out.write("  </option>\r\n");
      out.write("                ");

                     }
                 
      out.write("\r\n");
      out.write("                \r\n");
      out.write("\t\r\n");
      out.write("\t\t</select></div>\r\n");
      out.write("\t\t<textarea rows=\"7\" cols = \"70\" name=\"memoNote\" class=\"memoText\" placeholder=\"Enter text here...\"required ></textarea>\r\n");
      out.write("\t\t<input type=\"submit\" class=\"submitButton\"/> </form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<DIV class = \"pageBottom\" style=\"margin-bottom: 3px\"><hr width =\"75%\"/></br> EQUILIBRIUM INTERTRADE CORP.</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
