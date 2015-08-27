
/*  Class Name:     SaveMemo
*   Developer:      Jet Virtusio
*   Description:    servlet used to save the memo in the database
*/  
package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class SaveMemo extends HttpServlet {

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
        HttpSession session = request.getSession();
        modelEmployee employee = (modelEmployee) session.getAttribute("selectedemployee");
        Part filePart = request.getPart("filename");
        boolean flag = true;

        String typeofmemo = request.getParameter("listTypeMemo");
        int intid = employee.getEntryNum();
        String memo = request.getParameter("memoNote");
        InputStream inputStream = null;

        if (memo.length() >= 2500) {
            System.out.println("Oh no too much characters");
            session.setAttribute("error", new String("* Max characters reached."));
            //response.sendRedirect("FileMemo.jsp");
            flag = false;
        }
        if (filePart.getSize() != 0) {

            System.out.println("File Size is " + filePart.getSize());
            if (filePart.getSize() > 10847412) {
                session.setAttribute("error", new String("* Max File Size Reached."));
                // response.sendRedirect("FileMemo.jsp");
                flag = false;
            }

        }

        if (!flag) {
            System.out.println("Redirect now");
            response.sendRedirect("FileMemo.jsp");
        } else {

            Database db = Database.getInstance();
            if (filePart.getSize() != 0) {

                inputStream = filePart.getInputStream();
                String nameoffile = filePart.getSubmittedFileName();
                db.saveDisciplinary(intid, memo, typeofmemo, inputStream, nameoffile);
            } else {
                db.saveDisciplinary(intid, memo, typeofmemo, null, null);
                // response.sendRedirect("FileMemoSuccess.jsp");
            }
            session.removeAttribute("error");
            response.sendRedirect("FileMemoSuccess.jsp");
        }
    }
}
