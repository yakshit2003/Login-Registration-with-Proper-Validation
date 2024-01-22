package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DbConnection.DbConn;
import com.dao.UserDao;
import com.entity.Users;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher rd=null;

		 String uname= request.getParameter("signname");
		String uemail= request.getParameter("signemail");
		String upassword=request.getParameter("signpassword");
		
		if(uname==null || uname.equals("")) {
			request.setAttribute("status", "InvalidName");
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		if(uemail==null || uemail.equals("")) {
			request.setAttribute("status", "InvalidEmail");
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		if(upassword==null || upassword.equals("")) {
			request.setAttribute("status", "InvalidPassword");
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
			
		    Users u= new Users(uname,uemail,upassword);
			boolean flagg=UserDao.duplicacy(u);
			if(flagg) {
				request.setAttribute("status1", "AlreadyExist");
				rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			}else {
				rd=request.getRequestDispatcher("index.jsp");
				
			boolean f=UserDao.registerUser(u);
			
			if(f) {
				request.setAttribute("status", "Success");
				
			}
			else {
				request.setAttribute("status", "Failed");
				
			}
			rd.forward(request, response);
			
			
			}
		
			/*catch (SQLIntegrityConstraintViolationException p) {
			request.setAttribute("duplicateError", "error");
			RequestDispatcher Rd=request.getRequestDispatcher("index.jsp");
			Rd.forward(request, response);*/
			
		
	}
}
