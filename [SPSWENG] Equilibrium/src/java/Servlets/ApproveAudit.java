
/*  Class Name:     ApproveAudit
*   Developer:      Arren Antioquia
*   Description:    servlet used by the hr head to approve an employee audit trail entry
*/  

package Servlets;

import Database.Database;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveAudit extends HttpServlet {

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
        
        /*  gets the database instance and the parameters from the request object   */
        Database db = Database.getInstance();
        int empAuditTrailID = Integer.parseInt(request.getParameter("empAuditTrailID"));
        String approveValue = request.getParameter("approveValue");
        
        /*  changes the audit status base on the value passed to the servlet    */
        db.changeAuditStatus(empAuditTrailID, approveValue);
        
        /*  if the audit trail is approved, change the value in the specified table */
        if (approveValue.equals("Approved")){
            /*  gets other parameters passed to the request object for changing values in the database  */
            String tableName = request.getParameter("tableName");
            int tableReferenceNum = Integer.parseInt(request.getParameter("tableReferenceNum"));
            String field = request.getParameter("field");
            Object value = request.getParameter("value");
            
            /*  changes the value in the field on the specified table   */
            db.changeFieldValue(tableName, tableReferenceNum, field, value);
        }
        
        /*  redirects back to homepage   */
        RequestDispatcher view = request.getRequestDispatcher("Homepage-HrHead.jsp");
        view.forward(request, response);
    }
}
