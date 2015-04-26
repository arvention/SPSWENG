
/*  Class Name:     GenerateReport
*   Developer:      Hannah Sibayan
*   Description:    servlet used by the hr head and hr employee to generate report on employee leaves
*/  

package Servlets;

import Database.Database;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GenerateReport", urlPatterns = {"/GenerateReport"})
public class GenerateReport extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /*
    *   The doPost function of the servlet.
    *   Updates changes in the database using queries.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Database db = Database.getInstance();
        int month = parseInt(request.getParameter("m").trim());
        int year = parseInt(request.getParameter("y").trim());
        System.out.println("MONTH: "+month+"   YEAR:"+year);
        //ArrayList<ArrayList<String>> report = db.getLeaveReport(month, year);
        String x = db.getLeaveReport(month, year);
        System.out.println(x);
        response.setContentType("text/plain");  
        response.setCharacterEncoding("UTF-8"); 
        response.getWriter().write(x); 
        
        //RequestDispatcher view = request.getRequestDispatcher("GenerateReport.jsp");
        //view.forward(request, response);
        
        //RequestDispatcher view = request.getRequestDispatcher("GenerateReport.jsp");
        //view.forward(request, response);
    }
}
