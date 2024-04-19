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
import com.min.edu.model.IUserDao;
import com.min.edu.model.PersonalBoardDaoImpl;
import com.min.edu.model.UserDaoImpl;

public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("UpdateUserInfoServlet POST");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		IUserDao dao = new UserDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("address", address);
		map.put("phone", phone);
		System.out.println(map);
		int n = dao.updateUserInfo(map);
		
		if(n>0) {
			response.sendRedirect("./mypage.do?id="+id);
		}else {
			response.sendRedirect("./main.do");
		}
	}
}
