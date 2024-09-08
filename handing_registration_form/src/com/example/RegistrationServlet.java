import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to text/html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get form parameters
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String location = request.getParameter("location");
        String education = request.getParameter("education");
        String phoneNumber = request.getParameter("phoneNumber");
        
        // Initialize validation status
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        // Validate First Name, Middle Name, Last Name
        if (!isValidAlpha(firstName)) {
            isValid = false;
            errorMessage.append("First Name should contain only alphabets.<br>");
        }
        if (!isValidAlpha(middleName)) {
            isValid = false;
            errorMessage.append("Middle Name should contain only alphabets.<br>");
        }
        if (!isValidAlpha(lastName)) {
            isValid = false;
            errorMessage.append("Last Name should contain only alphabets.<br>");
        }
        
        // Validate Password
        if (!isValidPassword(password)) {
            isValid = false;
            errorMessage.append("Password must contain at least 6 characters, including alphabets, numbers, and special characters.<br>");
        }
        
        // Validate Confirm Password
        if (!password.equals(confirmPassword)) {
            isValid = false;
            errorMessage.append("Passwords do not match.<br>");
        }
        
        // Generate response
        if (isValid) {
            out.println("<html><body>");
            out.println("<h2>Registration Successful!</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Registration Failed</h2>");
            out.println("<p>" + errorMessage.toString() + "</p>");
            out.println("<a href='register.html'>Go back to registration form</a>");
            out.println("</body></html>");
        }
    }

    private boolean isValidAlpha(String input) {
        return input != null && input.matches("[a-zA-Z]+");
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6
            && Pattern.compile("[a-zA-Z]").matcher(password).find()
            && Pattern.compile("[0-9]").matcher(password).find()
            && Pattern.compile("[!@#$%^&*(),.<>?;:'\"{}|]").matcher(password).find();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
