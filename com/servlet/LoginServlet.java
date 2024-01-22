package com.servlet;
import com.entity.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DbConnection.DbConn;
import com.dao.UserDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String unam= request.getParameter("lemail");
			String upwd= request.getParameter("lpassword");
		    try {
			RequestDispatcher rd = null;
			HttpSession session =request.getSession();
			    UserDao dao=new UserDao(DbConn.getConn());
				Users u =dao.loginUser(unam, upwd);
				 if(u!=null) {
					session.setAttribute("condition", u);
					response.sendRedirect("home.jsp");
					 //request.setAttribute("condition", "success");
					 //rd=request.getRequestDispatcher("home.jsp");
					
				 }else {
					 session.setAttribute("condition", "failed");
						response.sendRedirect("index.jsp");
					 //request.setAttribute("condition", "failed");
					 //rd=request.getRequestDispatcher("index.jsp");
				 }
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
				 //rd.forward(request, response);
			
	}

}
