import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@SuppressWarnings("serial")
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		HttpSession session=req.getSession(false);
		if(session !=null) {
			session.invalidate();
		}
		res.sendRedirect("login.html");
	}
}