package fr.formation.inti.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.UserService;

@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService service;

	public UserController() {
		service = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user = service.findByLoginAndPassword(login, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(300); // 30 secondes avant d�connexion auto
			session.setAttribute("user", user);
		} else {
			request.setAttribute("error", "login or password incorrect !");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}