
/*  Class Name:     LeaveSubmit
*   Developer:      Arces Talavera
*   Description:    servlet used by the system to submit the leaves to the database
*/

package Servlets;

import Database.Database;
import ClassHelpers.EmailNotifier;
import Models.modelEmployee;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LeaveSubmit extends HttpServlet {

    private final int maxLeave = 15;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Database db = Database.getInstance();
        EmailNotifier en = EmailNotifier.getInstance();

        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        HttpSession reqSession = request.getSession();
        RequestDispatcher reqDispatcher = null;
        float dayCount = Float.parseFloat(request.getParameter("dayCount"));
        modelEmployee modelEmployee = (modelEmployee) reqSession.getAttribute("employee");

        if (endDate != null && startDate != null) {
            if (endDate.before(startDate)) {
                response.getWriter().write("<h4>The end date should not be earlier than the start date.</h4>");
            } else if (getDateDiff(startDate, endDate) != (int) Math.ceil(dayCount)) {
                response.getWriter().write("<h4>The number of days of leave doesn't match the duration between the start and end date.</h4>");
            } else if (maxLeave - (db.getApprovedLeaveCount(modelEmployee.getEmployeeID()) + dayCount) < 0) {
                response.getWriter().write("<h4>Sorry, your request exceeds the number of leaves that you can have.</h4>");
            } else {
                String leaveType = request.getParameter("leaveType");
                float duration = Float.parseFloat(request.getParameter("dayCount"));

                db.addLeaveForm(leaveType, modelEmployee.getEntryNum(), new java.sql.Date(startDate.getTime()), duration, modelEmployee.getManagerEntryNum());

                //send an email to the manager
                //en.sendLeaveRequest(modelEmployee.getEntryNum(), leaveType, startDate, endDate, duration);
            }
        }
    }

    // -- function/s ----------------------------------------
    public int getDateDiff(Date startDate, Date endDate) {
        int dateDiff = (int) (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);

        return dateDiff + 1;
    }
}
