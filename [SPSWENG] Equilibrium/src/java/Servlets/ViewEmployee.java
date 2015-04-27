
/*   Class Name:     ViewEmployee
 *   Developer:      Arces Talavera
 *   Description:    servlet used to get the employee to view and save it in the session
 */
package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEmployee extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String id = request.getParameter("id");
        Database db = Database.getInstance();

        modelEmployee employee = db.getEmployee(id);
        request.getSession().setAttribute("viewEmp", employee);
        RequestDispatcher reqDispatcher = request.getRequestDispatcher("ViewEmployeeRecords.jsp");
        reqDispatcher.forward(request, response);
    }

    /*
    *   The doPost function of the servlet.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
