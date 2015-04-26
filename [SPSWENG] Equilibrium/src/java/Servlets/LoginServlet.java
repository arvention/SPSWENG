
/*  Class Name:     LoginServlet
*   Developer:      Arren Antioquia
*   Description:    servlet used to login to the system
*/  

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /*
    *   The doPost function of the servlet.
    *   checks the database if the username and the password match for an actual account
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        /*  gets request object */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Database database = Database.getInstance();
        
        /*  gets session    */
        HttpSession session = request.getSession();
        
        /*  get Employee Account, returns null if the account does not exists*/
        modelEmployee modelEmployee = database.getEmployeeAccount(username, password);
        
        /*  if account exists, go to proper homepage    */
        if (modelEmployee != null){
            if (modelEmployee.getEmployeeType().equalsIgnoreCase("Employee")){
                session.setAttribute("employee", modelEmployee);
                RequestDispatcher view = request.getRequestDispatcher("Homepage-Employee.jsp");
                view.forward(request, response);
            }
            else if (modelEmployee.getEmployeeType().equalsIgnoreCase("Hr Head")){
                session.setAttribute("employee", modelEmployee);
                RequestDispatcher view = request.getRequestDispatcher("Homepage-HrHead.jsp");
                view.forward(request, response);
            }
            else if (modelEmployee.getEmployeeType().equalsIgnoreCase("Hr Employee")){
                session.setAttribute("employee", modelEmployee);
                RequestDispatcher view = request.getRequestDispatcher("Homepage-HrEmployee.jsp");
                view.forward(request, response);
            }
            else if (modelEmployee.getEmployeeType().equalsIgnoreCase("Manager")){
                session.setAttribute("employee", modelEmployee);
                RequestDispatcher view = request.getRequestDispatcher("Homepage-Manager.jsp");
                view.forward(request, response);
            }
            else if (modelEmployee.getEmployeeType().equalsIgnoreCase("Senior Manager")){
                session.setAttribute("employee", modelEmployee);
                RequestDispatcher view = request.getRequestDispatcher("Homepage-SManager.jsp");
                view.forward(request, response);
            }
        }
        
        /*  else show error, and go back to the log in page */
        else{
            request.setAttribute("error", "Invalid Username/Password");
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
    }
}
