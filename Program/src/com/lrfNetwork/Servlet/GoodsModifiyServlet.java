package com.lrfNetwork.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrfNetwork.jdbc.GoodsDaoImpl;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/api/table/edit")
public class GoodsModifiyServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		//获取数据
		String name=request.getParameter("name");
		//获取数据
		Integer id=Integer.parseInt(request.getParameter("id"));
		String type=request.getParameter("type");
		Integer save=Integer.parseInt(request.getParameter("save"));
		double price=Double.parseDouble(request.getParameter("price"));
		String size=request.getParameter("size");
		String manufacture=request.getParameter("manufacture");
		Integer period=Integer.parseInt(request.getParameter("period"));
		
		//获取当前时间
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
//		System.out.println(id+"\t"+type+"\t"+save+"\t"+price+"\t"+size+"\t"+manufacture+"\t"+period);
		Object[] object={name,type,save,price,size,sdf.format(date),manufacture,period,id};
		
		//是否成功
		boolean isSuccess=GoodsDaoImpl.modifiyGoodsInfo(object);
		
//		System.out.println(isSuccess);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("isSuccess",isSuccess);
		
		//传到前端
		PrintWriter pw=response.getWriter();
		pw.println(jsonObject);
		
	}
}
