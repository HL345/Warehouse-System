package com.lrfNetwork.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrfNetwork.Info.User;
import com.lrfNetwork.jdbc.UserDaoImpl;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/api/user/info")
public class UserDataoutServlet extends HttpServlet {
	protected void  doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IIOException {
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		try {
			//修改字符
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		
		//创建arrayList存放返回来的数据
//		User user=null;
		//获取信息
		User user=UserDaoImpl.getNeedUserInfo(id);
		
		//创建json array存放数据  便于传输到前
		JSONObject jsonObject=new JSONObject();

		jsonObject.put("id", user.getId());
		jsonObject.put("username", user.getUsername());
		jsonObject.put("password", user.getPassword());
		jsonObject.put("email", user.getEmail());
		jsonObject.put("is_admin", user.getIs_admin());
		jsonObject.put("reg_date", user.getReg_date());
		
		System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getPassword()+"\t"+user.getEmail()+"\t"+user.getIs_admin()+"\t"+user.getReg_date());

		PrintWriter printWriter;
		try {
			printWriter = response.getWriter();
			printWriter.println(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	protected void  doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IIOException {
		doPost(request, response);
	}
}
