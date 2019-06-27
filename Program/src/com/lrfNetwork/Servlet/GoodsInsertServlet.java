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
@WebServlet("/api/table/add")
public class GoodsInsertServlet extends HttpServlet{
	protected void  doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
//		Integer id=Integer.parseInt(request.getParameter("id"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		Integer save=Integer.parseInt(request.getParameter("save"));
		double price=Double.parseDouble(request.getParameter("price"));
		String size=request.getParameter("size");
//		String date=request.getParameter("date");
		String manufacture=request.getParameter("manufacture");
		Integer period=Integer.parseInt(request.getParameter("period"));
		
		System.out.println(name+"\t"+type+"\t"+save+"\t"+price+"\t"+size+"\t"+manufacture+"\t"+period);
		//获取当前时间
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	
		
		//将数据存放在一个对象里面
		Object[] object={name,type,save,price,size,sdf.format(date),manufacture,period};
//		Goods goods=new Goods(id, name, type, save, price, size, date, manufacture, period);
		//传入到插入函数，返回一个bool值，看看是不是插入成功
		boolean issuccess=GoodsDaoImpl.insertGoodsInfo(object);
		
		//创建一个json对象拿来存放返回来的 bool传给前端页面
		JSONObject jsonObject=new JSONObject();
		//存放到对象里
		jsonObject.put("isSuccess", issuccess);
		//将json对象传给前端
		PrintWriter pw=response.getWriter();
		pw.println(jsonObject);
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {
		doPost(request, response);
	}
}
