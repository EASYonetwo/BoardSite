package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;


public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DeleteUserServlet POST");
		String id = request.getParameter("id");
		IUserDao dao = new UserDaoImpl();
		int n = dao.deleteUser(id);
		
		if(n>0) {
			HttpSession session = request.getSession(false);
			session.setAttribute("loginInfo", null);
			response.sendRedirect("./main.do");
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
