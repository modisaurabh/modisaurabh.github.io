

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(user.equals("admin") && pass.equals("matrix"))
		{
			HttpSession session=request.getSession(true);
			out.print("<br />New " + session.isNew());
			out.print("<br />Id " + session.getId());
			out.print("<br />Creation time " + new java.util.Date(session.getCreationTime()));
			out.print("<br />Creation time " + new java.util.Date(session.getLastAccessedTime()));
			session.setAttribute("cnt",5);
			RequestDispatcher rd=request.getRequestDispatcher("/Game2Servlet");
			rd.include(request, response);
		}
		else
		{
			out.print("Invalid user or pass");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}

}
