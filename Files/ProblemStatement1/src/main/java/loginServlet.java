import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@SuppressWarnings("serial")
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)  throws IOException,ServletException {
		//PrintWriter pw=res.getWriter();
		User uobj=new User();
		res.setContentType("text/html");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		uobj.setUsername(username);
		uobj.setUsername(password);
		LoginBO lbo=new LoginBO();
		try {
			if(lbo.validate(username,password)) {
				HttpSession session=req.getSession();
				session.setAttribute("username",username);
				res.sendRedirect("welcome.html");
 
			}
		else {
			//res.sendRedirect("login.html");
			//req.setAttribute("errorMessage","Invalid username/password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("error.jsp");
			dispatcher.include(req, res);
			//res.sendRedirect("login.html?error=InvalidUsername/Password");
			//res.sendRedirect("login.html?error=Invalid Username/Password");
		}
 
	}catch (BusinessException e) {
        //req.setAttribute("error", e.getMessage());
		req.setAttribute("error", "<span style='color:red'>" + e.getMessage() + "</span>");
        RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
        rd.include(req, res);
		//req.setAttribute("errorMessage",e.getMessage());
		//RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		//dispatcher.forward(req, res);
		//res.sendRedirect("login.html?error=" + e.getMessage() );
	}
}
}