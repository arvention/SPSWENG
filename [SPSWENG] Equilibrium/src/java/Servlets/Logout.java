
/*  Class Name:     Logout
*   Developer:      Arren Antioquia
*   Description:    servlet used by the employees to invalidate their session and log out
*/  

package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    *   logs the user out
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*  invalidate the session -> remove all saved attributes   */
        request.getSession().invalidate();
        
        /*  redirect back to log in page*/
        RequestDispatcher reqDispatcher;
        reqDispatcher = request.getRequestDispatcher("index.jsp");
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
