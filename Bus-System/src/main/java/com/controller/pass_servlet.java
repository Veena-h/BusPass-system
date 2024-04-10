package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.connection.connection;
import com.entity.pass_entity;
import com.model.bus_model;

/**
 * Servlet implementation class pass_servlet
 */
@WebServlet("/pass_servlet")
@MultipartConfig(maxFileSize = 999999990)
public class pass_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pass_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stop_no=request.getParameter("stop_no");
		String stud_name=request.getParameter("stud_name");
		String u_id=request.getParameter("uid");
		String date=request.getParameter("date");
		String start_date=request.getParameter("s_date");
		String end_date=request.getParameter("e_date");
		String status=request.getParameter("status");
		String select=request.getParameter("select");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		

		  // Extract Base64 image data
	        String base64ImageData = request.getParameter("base64Image");
	        
	        // Decode Base64 string into byte array
	        byte[] imageData = Base64.getDecoder().decode(base64ImageData);
	        
		
		
		pass_entity p= new pass_entity();
		p.setStop_no(stop_no);
		p.setStud_name(stud_name);
		p.setU_id(u_id);
		p.setStart_date(start_date);
		p.setEnd_date(end_date);
		p.setStatus(status);
		p.setSelect(select);
		p.setDate(date);
		p.setAddress(address);
		p.setPhone(phone);
		
		bus_model bb=new bus_model(connection.getconnection());
		try {
			boolean b1;
			b1=bb.insert_pass(p, imageData);
			if(b1)
			{
				response.sendRedirect("student_form_route.jsp");
			}else
			{
				response.sendRedirect("error.jsp");
			}
			
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
