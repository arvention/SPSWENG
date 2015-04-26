
/*  Class Name:     GetEmployeeServlet
*   Developer:      Jet Virtusio
*   Description:    servlet used to create user account
*/  

package Servlets;

import Database.Database;
import ClassHelpers.PasswordGenerator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/*
Developed by : Jet Virtusio
Created to save the account of the employee

*/
public class GetEmployeeServlet extends HttpServlet {

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

        String type = (String) request.getParameter("type");
        int entryNum = Integer.parseInt(request.getParameter("entry").trim());

        String password = PasswordGenerator.getInstance().getPassword();
        Database db = Database.getInstance();
        
        db.changePassword(entryNum, password);
        db.changeEmployeeType(entryNum, type);
        String fname = db.getFirstName(entryNum);
        String lname = db.getLastName(entryNum);

        String email = db.getEmailAddress(entryNum);
        
        // if (EmailNotifier.getInstance().sendEmail(email, "Welcome to Equilibrium, "+ fname +" "+lname+".\n"
        //       + "An account has been created by the Human Resources department, for you.\nYour password is " + password
        //     +"\nThank you!", "[Password]")) {
          
            request.setAttribute("response", new String("Password is sent to " + email));

        // } else {
        // request.setAttribute("response", new String("Failed to send password to " + email));
        // }

        RequestDispatcher view = request.getRequestDispatcher("UserAccountCreated.jsp");
        view.forward(request, response);
    }
}
