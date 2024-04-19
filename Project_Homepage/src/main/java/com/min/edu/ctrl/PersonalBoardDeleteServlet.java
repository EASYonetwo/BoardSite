package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;

public class PersonalBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("PersonalBoardDeleteServlet GET");
		
		String seq = request.getParameter("seq");
		String id = request.getParameter("id");
		IPersonalBoardDao dao = new PersonalBoardDaoImpl();
		int n = dao.deletePB(seq);
		
		if(n>0) {
			response.sendRedirect("./personalBoard.do?id="+id);
		}else {
			response.sendRedirect("./main.do");
		}
	}

}
