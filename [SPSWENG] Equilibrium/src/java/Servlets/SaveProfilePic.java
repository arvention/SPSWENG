
/*  Class Name:     SaveProfPic
*   Developer:      Jet Virtusio
*   Description:    servlet used to save the profile pic to the database
*/  

package Servlets;

import Database.Database;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class SaveProfilePic extends HttpServlet {

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

        Part filePart = request.getPart("filename");

        System.out.println("Heree");

        String id = request.getParameter("id");
        int intid = Integer.parseInt(id.trim());
        InputStream inputStream = filePart.getInputStream();
        String name = filePart.getSubmittedFileName();

        String reply = "0";

        try {
            if (filePart.getSize() != 0) {
                Database.getInstance().savePic(intid, inputStream, filePart.getSubmittedFileName());

            } else {
                reply = "2";
            }

        } catch (Exception e) {
            reply = "1";
            System.out.println(e);
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(reply);

    // response.sendRedirect("ViewEmployeeRecords.jsp");
    }
}
