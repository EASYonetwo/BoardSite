package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class UpdateUserAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("UpdateUserAuthServlet GET");
		String id = request.getParameter("id");
		System.out.println(id);
		IUserDao dao = new UserDaoImpl();
		int n = dao.updateUserAuth(id);
		
		if(n>0) {
			response.sendRedirect("./userDetail.do?id="+id);
		}else {
			response.sendRedirect("./main.do");
		}
	}

}
