package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class MultiDeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("MultiDeleteUserServlet POST");
		String[] ids = request.getParameterValues("ch");
		List<String> idList = Arrays.asList(ids);
		IUserDao dao = new UserDaoImpl();
		int n = dao.multiDeleteUser(idList);
		
		if(n>0) {
			response.sendRedirect("./allUser.do");
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
