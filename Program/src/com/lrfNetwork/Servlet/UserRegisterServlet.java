package com.lrfNetwork.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrfNetwork.jdbc.UserDaoImpl;

import net.sf.json.JSONObject;


@SuppressWarnings("serial")
@WebServlet("/api/register")
public class UserRegisterServlet extends HttpServlet{
 
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		//获取当前时间
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		boolean isSuccess=false;
		//传入数据
		isSuccess=UserDaoImpl.insertUserInfo(username,password,email,sdf.format(date));
//		request.getRequestDispatcher("/login.html").forward(request, response);
		
		
		if (isSuccess==true) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("isSuccess", isSuccess);
			PrintWriter pw=response.getWriter();
			pw.println(jsonObject);//输出该json字符串
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
}
