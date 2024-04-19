package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DeleteAdminServlet POST");
		String id = request.getParameter("id");
		IUserDao dao = new UserDaoImpl();
		int n = dao.deleteUser(id);
		
		if(n>0) {
			response.sendRedirect("./allUser.do");
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
