
/*  Class Name:     ChangePasswordServlet
*   Developer:      Jet Virtusio
*   Description:    servlet used to change password of any employee type
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
import javax.servlet.http.HttpSession;

public class ChangePasswordServlet extends HttpServlet {

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
        
        String oldpass = request.getParameter("oldpassword");
        String newpass = request.getParameter("newpassword");
        RequestDispatcher view;
        HttpSession session = request.getSession();
        modelEmployee me;
        me = (modelEmployee) session.getAttribute("employee");
        
        if (Database.getInstance().isUserPassword(me.getEmployeeID(),oldpass)){
            Database.getInstance().changePassword(me.getEntryNum(), newpass);
            //request.setAttribute("error", "Success! Password Changed");
            view = request.getRequestDispatcher("ChangePasswordSuccess.jsp");
        } else {
            request.setAttribute("error", "Invalid Password");
            //request.setAttribute("error", "Invalid Username/Password");
          view = request.getRequestDispatcher("changePassword.jsp");
        }
        
        view.forward(request, response);    
    }
}
