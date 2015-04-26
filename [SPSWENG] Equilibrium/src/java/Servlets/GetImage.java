
/*  Class Name:     GetImage
*   Developer:      Jet Virtusio
*   Description:    servlet used to get image
*/

package Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetImage extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
         byte[] imageData = Database.Database.getInstance().getImage(13);
         response.setContentType("image/jpeg");
         response.getOutputStream().write(imageData);
         */
        String id = request.getParameter("id");
        int intid = Integer.parseInt(id.trim());

        String theFilename = "download";
        StringBuilder fname = new StringBuilder();
        InputStream is = Database.Database.getInstance().getInputStream(intid, fname);
        String filename = fname.toString();
        System.out.println("File name is " + filename);
        theFilename = theFilename + filename.substring(0, filename.lastIndexOf('.'));
        int fileLength = is.available();

        System.out.println("fileLength = " + fileLength);

        ServletContext context = getServletContext();

        // sets MIME type for the file download
        String mimeType = context.getMimeType(filename);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", filename);
        response.setHeader(headerKey, headerValue);

        // writes the file to the client
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while ((bytesRead = is.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        is.close();
        outStream.close();
    }

    /*
    *   The doPost function of the servlet.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // String imageId = request.getParameter("imageId");
        byte[] imageData = Database.Database.getInstance().getImage(13);
        response.setContentType("image/jpeg");
        response.getOutputStream().write(imageData);

    }
}
