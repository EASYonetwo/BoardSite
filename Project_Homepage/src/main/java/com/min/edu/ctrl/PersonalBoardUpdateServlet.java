package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;

public class PersonalBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("PersonalBoardUpdateServlet GET");
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		
		IPersonalBoardDao dao = new PersonalBoardDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("content", content);
		int n = dao.updatePB(map);
		
		if(n>0) {
			response.sendRedirect("./personalBoardDetail.do?seq="+seq);
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
