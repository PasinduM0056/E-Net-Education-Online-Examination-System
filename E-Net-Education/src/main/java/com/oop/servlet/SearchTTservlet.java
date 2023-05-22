package com.oop.servlet;
import com.oop.model.TimeT;


import com.oop.service.IStaffsupDBUtil;
import com.oop.service.StaffsupDBUtil;
import java.io.IOException;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SearchTTservlet")
//singleton Design Pattern
public class SearchTTservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String examno = request.getParameter("examno");
		IStaffsupDBUtil SSDB = new StaffsupDBUtil();
		
		try {
			
		List<TimeT> timetable = SSDB.validate(examno);
		request.setAttribute("timetable", timetable);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("timetable.jsp");
		dis.forward(request, response);
		
		
		
		
		
	}

}
