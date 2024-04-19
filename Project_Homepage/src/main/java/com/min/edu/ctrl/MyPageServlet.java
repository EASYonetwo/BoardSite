package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("MyPageServlet GET");
		String id = request.getParameter("id");
		IUserDao dao = new UserDaoImpl();
		UserDto dto = dao.getOneUser(id);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("MyPageServlet POST");
	}
}
