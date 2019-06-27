package com.lrfNetwork.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrfNetwork.jdbc.UserDaoImpl;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/api/user/pass")
public class UserModifiyInfo extends HttpServlet {

		protected void  doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			String password=request.getParameter("password");
			Integer id=Integer.parseInt(request.getParameter("id"));
			boolean issuccess=UserDaoImpl.modifiyUserInfo(password, id);
			
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("isSuccess", issuccess);
			PrintWriter pw=response.getWriter();
			pw.println(jsonObject);
		}
		
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {
			doPost(request, response);
		}
}
