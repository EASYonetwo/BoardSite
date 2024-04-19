package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class JoinIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("JoinIdCheckServlet GET");
		String id = request.getParameter("id");
		IUserDao dao = new UserDaoImpl();
		int cnt = dao.joinIdCheck(id);
		
		response.getWriter().print("{\"cnt\":"+cnt+"}");
	}
}
