import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCounterServlet")
public class VisitCounterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Initialize visit count
        int visitCount = 0;
        Cookie[] cookies = request.getCookies();
        
        // Check if there's a cookie named "visitCount"
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    // Parse the visit count from the cookie
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }
        
        // Increment the visit count
        visitCount++;
        
        // Create or update the visitCount cookie
        Cookie visitCountCookie = new Cookie("visitCount", Integer.toString(visitCount));
        visitCountCookie.setMaxAge(60 * 60 * 24 * 365); // Cookie lasts for 1 year
        response.addCookie(visitCountCookie);
        
        // Display the visit count to the user
        out.println("<html><body>");
        out.println("<h2>Welcome back! You have visited this servlet " + visitCount + " times.</h2>");
        out.println("</body></html>");
    }
}
