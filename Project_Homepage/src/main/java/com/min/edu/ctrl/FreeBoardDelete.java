package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardDelete GET");
		String seq = request.getParameter("seq");
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		int n = dao.deleteBoth(seq);
		if(n>0) {
			request.getRequestDispatcher("./freeBoard.do").forward(request, response);
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
