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

public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DeleteReplyServlet GET");
		
		String seq = request.getParameter("seq");
		
		IPersonalBoardDao dao = new PersonalBoardDaoImpl();
		
		int n = dao.deleteReply(seq);
		
		if(n>0) {
			response.sendRedirect("./personalBoardDetail.do?seq="+seq);
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
