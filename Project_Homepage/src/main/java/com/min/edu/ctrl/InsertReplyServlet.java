package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;

public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("InsertReplyServlet GET");
		String seq = request.getParameter("seq");
		String adminreply = request.getParameter("reply");
		System.out.println("seq"+seq);
		System.out.println("adminreply"+adminreply);
		IPersonalBoardDao dao = new PersonalBoardDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("adminreply", adminreply);
		int n = dao.insertReply(map);
		
		if(n>0) {
			response.sendRedirect("./personalBoardDetail.do?seq="+seq);
		}else {
			response.sendRedirect("./main.do");
		}
	}

}
