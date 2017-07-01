

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
 * Servlet implementation class Game2Servlet
 */
@WebServlet("/Game2Servlet")
public class Game2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setHeader("Expires","0"); 
		response.setDateHeader("Expires",-1); 

		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		if(session==null)
		{
			out.print("1st login then play");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			return ;
		}
		out.print("<h1>Game 2 started</h1>");
		int cnt=(Integer)session.getAttribute("cnt");
		out.print("<br />Cnt is " + cnt);
		out.print("<a href='LogoutServlet'>Click to Logout</a>");
	}

}
