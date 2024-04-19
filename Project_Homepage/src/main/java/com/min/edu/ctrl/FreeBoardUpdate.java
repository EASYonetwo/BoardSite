package com.min.edu.ctrl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;

public class FreeBoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("FreeBoardUpdate GET");
		
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		
		IFreeBoardDao dao = new FreeBoardDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("content", content);
		int n = dao.updatePost(map);
		
		if(n>0) {
			response.sendRedirect("./freeBoardDetail.do?seq="+seq);
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
