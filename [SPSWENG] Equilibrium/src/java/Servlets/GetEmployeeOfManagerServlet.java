
/*  Class Name:     GetEmployeeOfManagerServlet
*   Developer:      Jet Virtusio
*   Description:    servlet used to get employees of a manager account.
*/  

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetEmployeeOfManagerServlet extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        modelEmployee emp = (modelEmployee) session.getAttribute("employee");
        
        Database db = Database.getInstance();
        ArrayList<modelEmployee> employees = db.getEmployeeOfManager(emp.getEntryNum());

        session.setAttribute("ManagerEmployee", employees);
        response.sendRedirect("FileMemo.jsp");
    }

    /*
    *   The doPost function of the servlet.
    *   Updates changes in the database using queries.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int entrynum = 1; 
    }
}
