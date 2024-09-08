import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTrackingServlet")
public class SessionTrackingServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get the session, if it exists, or create a new one
        HttpSession session = request.getSession(true);
        
        String message;
        
        // Check if this is a new session
        if (session.isNew()) {
            message = "Welcome to the site! This is your first visit.";
            session.setAttribute("visitCount", 1);
        } else {
            // Get the current visit count from the session
            Integer visitCount = (Integer) session.getAttribute("visitCount");
            if (visitCount == null) {
                visitCount = 0;
            }
            visitCount++;
            session.setAttribute("visitCount", visitCount);
            message = "Welcome back! You have visited " + visitCount + " times.";
        }
        
        // Display the message to the user
        out.println("<html><body>");
        out.println("<h2>" + message + "</h2>");
        
        // Provide a link to invalidate the session
        out.println("<a href='SessionTrackingServlet?invalidate=true'>End Session</a>");
        out.println("</body></html>");
        
        // Handle session invalidation if the user chooses to end the session
        if ("true".equals(request.getParameter("invalidate"))) {
            session.invalidate();
            out.println("<h2>Session ended. Refresh the page to start a new session.</h2>");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
