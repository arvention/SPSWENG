
/*  Class Name:     DisplayImage
*   Developer:      JetVirtusio
*   Description:    servlet used to display the image of each employee
*/  

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayImage extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        String id = request.getParameter("id");
        int intid = Integer.parseInt(id.trim());
        byte[] imageData = Database.Database.getInstance().getImage(intid);
        
        if (imageData != null){
            response.setContentType("image/jpeg");
            response.getOutputStream().write(imageData);
        }
    }

    /*
    *   The doPost function of the servlet.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
