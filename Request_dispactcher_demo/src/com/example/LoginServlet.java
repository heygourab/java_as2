import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    private static final String CORRECT_PASSWORD = "Servlet";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get password from request
        String password = request.getParameter("password");
        
        if (CORRECT_PASSWORD.equals(password)) {
            // If password is correct, forward to WelcomeServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
            dispatcher.forward(request, response);
        } else {
            // If password is incorrect, redirect back to index.html with an error message
            request.setAttribute("errorMessage", "Invalid password. Please try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.include(request, response);
        }
    }
}
