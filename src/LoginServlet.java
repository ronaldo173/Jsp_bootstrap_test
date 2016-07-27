import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtUserName");
		String pass = request.getParameter("txtPass");

		if (name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
			System.out.println("success");
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			request.setAttribute("username", name);
			rd.forward(request, response);
		} else {// if name&pass not match then it display error page//
			response.sendRedirect("error.jsp");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}