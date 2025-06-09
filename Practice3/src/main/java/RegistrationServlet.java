import java.io.IOException;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
import com.UserInfo.User;
 
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");
        String gender = request.getParameter("gender");
 
        try {
            RegistrationBO registrationBO = new RegistrationBO();
            User user = new User(firstName, lastName, country, languages, gender);
            registrationBO.validate(user);
            int registrationId = new RegisterDAO().save(user);
            request.setAttribute("regId", registrationId);
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
            rd.forward(request, response);
        } catch (BusinessException e) {
            request.setAttribute("error", "<span style='color:red'>" + e.getMessage() + "</span>");
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
 