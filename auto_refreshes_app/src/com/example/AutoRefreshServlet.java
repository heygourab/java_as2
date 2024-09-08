import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AutoRefreshServlet")
public class AutoRefreshServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to text/html
        response.setContentType("text/html");
        
        // Get the current time
        long currentTimeMillis = System.currentTimeMillis();
        
        // Print the HTML content
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Auto Refresh Page</title>");
        out.println("<meta http-equiv='refresh' content='5'>"); // Refresh every 5 seconds
        out.println("</head><body>");
        out.println("<h2>Current Time: " + currentTimeMillis + "</h2>");
        out.println("<p>This page will auto-refresh every 5 seconds.</p>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
