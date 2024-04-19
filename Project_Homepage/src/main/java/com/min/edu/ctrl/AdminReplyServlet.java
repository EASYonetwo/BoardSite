package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.min.edu.dto.PersonalBoardDto;
import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;

public class AdminReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("AdminReplyServlet GET");
		IPersonalBoardDao dao = new PersonalBoardDaoImpl();
		List<PersonalBoardDto> list = dao.selectAllPBAdmin();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/adminReply.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("AdminReplyServlet POST");
	}

}
