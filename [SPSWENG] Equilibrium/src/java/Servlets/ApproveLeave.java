
/*  Class Name:     ApproveLeave
*   Developer:      Arren Antioquia
*   Description:    servlet used by the hr head to approve a leave of his employee
*/  

package Servlets;

import Database.Database;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveLeave extends HttpServlet {

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
        /*  gets instance of the database   */
        Database db = Database.getInstance();
        
        /*  gets the parameters passed to the request object    */
        int leaveID = Integer.parseInt(request.getParameter("leaveID"));
        String approveValue = request.getParameter("approveValue");
        String curpage = request.getParameter("curpage");
        
        /*  changes the leave status to the value passed to the request object  */
        db.changeLeaveStatus(leaveID, approveValue);
        
        /*  redirects to the page   */
        if (curpage.equals("homepage-manager")){
            RequestDispatcher view = request.getRequestDispatcher("Homepage-Manager.jsp");
            view.forward(request, response);
        } else if (curpage.equals("homepage-smanager")){
            RequestDispatcher view = request.getRequestDispatcher("Homepage-SManager.jsp");
            view.forward(request, response);
        }
        else if (curpage.equals("homepage-hrhead")){
            RequestDispatcher view = request.getRequestDispatcher("Homepage-HrHead.jsp");
            view.forward(request, response);
        }
    }
}
