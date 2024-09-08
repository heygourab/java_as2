import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the file name from the request
        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            response.getWriter().println("File name can't be null or empty");
            return;
        }

        // Construct the file path
        String applicationPath = getServletContext().getRealPath("");
        String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
        String filePath = downloadPath + File.separator + fileName;

        // Set content type
        response.setContentType("application/octet-stream");
        response.setContentLength((int) new File(filePath).length());

        // Set header
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // Get the file and write it to the response
        FileInputStream inStream = new FileInputStream(filePath);
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }
}
