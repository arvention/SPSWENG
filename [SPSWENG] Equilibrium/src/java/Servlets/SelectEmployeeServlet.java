
/*  Class Name:     SelectEmployeeServlet
 *   Developer:      Jet Virtusio
 *   Description:    Redirects a user to the function clicked in the search page
 */
package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SelectEmployeeServlet extends HttpServlet {

    /*
     *   The doGet function of the servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /*
     *   The doPost function of the servlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("idnumber");
        modelEmployee employee = Database.getInstance().getEmployee(id);

        System.out.println("ID OF EMPLOYEE IS " + id);

        HttpSession session = request.getSession();
        session.setAttribute("selectedemployee", employee);

        switch (request.getParameter("type")) {
            case "file":
                response.sendRedirect("FileMemo.jsp");
                break;
            case "award":
                response.sendRedirect("addAward.jsp");
                break;
            case "evaluate":
                response.sendRedirect("addEvaluation.jsp");
                break;
            case "med":
                response.sendRedirect("addMedical.jsp");
                break;
            case "training":
                response.sendRedirect("addTraining.jsp");
                break;
        }
    }
}
