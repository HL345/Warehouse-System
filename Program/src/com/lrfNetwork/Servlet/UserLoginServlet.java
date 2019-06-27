package com.lrfNetwork.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrfNetwork.Info.User;
import com.lrfNetwork.jdbc.UserDaoImpl;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/api/login")
public class UserLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		ArrayList<User> UserArray=new ArrayList<>();
		UserArray=UserDaoImpl.getAllUserInfo();
		
		boolean isSuccess=false;
		//创建一个json数组
//		JSONArray jsonArray=new JSONArray();
		for (User user : UserArray) {
			//判断是否在数据库中包含这个账号密码
			if (user.getEmail().equals(email)&&user.getPassword().equals(password)) {
				isSuccess=true;
				System.out.println("成功");
	
				
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("uuid", user.getId());
				jsonObject.put("username", user.getUsername());
//				jsonObject.put("password", user.getPassword());
//				jsonObject.put("email", user.getEmail());
				jsonObject.put("token", "8dfhassad0asdjwoeiruty");
				jsonObject.put("isSuccess", isSuccess);
				PrintWriter pw=response.getWriter();
				pw.println(jsonObject);//输出该json字符串
				
//				request.getRequestDispatcher("/afterLogin.html").forward(request, response);
			}
		}
	}
	
		
		
//        BufferedReader reader = request.getReader();
//        String json = reader.readLine();
//        System.out.println(json);
//        reader.close();
//        String jsonStr ="{\"username\":\"admin\",\"password\":\"admin\",\"uuid\":\"admin-uuid\",\"name\":\"管理员\",\"token\":\"8dfhassad0asdjwoeiruty\"}";
//        PrintWriter out =null ;
//        out =response.getWriter() ;
//        out.write(jsonStr);
//        out.close();
//	}
        
        
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
