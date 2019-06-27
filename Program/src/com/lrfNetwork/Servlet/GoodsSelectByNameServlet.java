package com.lrfNetwork.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrfNetwork.Info.Goods;
import com.lrfNetwork.jdbc.GoodsDaoImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/api/table/search")
public class GoodsSelectByNameServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("content");
		ArrayList<Goods> goodsArray=new ArrayList<>();
		goodsArray=GoodsDaoImpl.SelectNeedInfo(name);
		
		//计数
		Integer count=0;
		//创建一个Json数组
		JSONArray jsonArray=new JSONArray();
		//创建一个Json对象,存放数据库数据
		JSONObject jsonObject=new JSONObject();
		//遍历
		for (Goods goods : goodsArray) {
			jsonObject.put("id", goods.getId());
			jsonObject.put("name", goods.getName());
			jsonObject.put("type", goods.getType());
			jsonObject.put("save", goods.getSave());
			jsonObject.put("price", goods.getPrice());
			jsonObject.put("size", goods.getSize());
			jsonObject.put("date", goods.getDate());
			jsonObject.put("manufacture", goods.getManufacture());
			jsonObject.put("period", goods.getPeriod());
			jsonArray.add(goods);
			count++;
		}
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("data", jsonArray);
		jsonObject2.put("total",count);
		PrintWriter pw=response.getWriter();
		pw.println(jsonObject2);
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
	}
}
