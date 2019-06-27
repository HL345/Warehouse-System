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
@WebServlet("/api/table/fetch")
public class GoodsDataoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
//		System.out.println(request.getParameter("currentPage"));
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer pageCount=Integer.parseInt(request.getParameter("currentPage"));
//		System.out.println(pageCount);
		ArrayList<Goods> resultSet=GoodsDaoImpl.selectGoodsByPage(pageCount);
		for (Goods goods : resultSet) {
			System.out.println(goods.getId()+"\t"+goods.getName()+"\t"+goods.getType()+"\t"+goods.getSave()+"\t"+goods.getPrice()+"\t"+goods.getSize()+"\t"+goods.getDate()+"\t"+goods.getManufacture()+"\t"+goods.getPeriod());
		}
		//创建一个Json数组
		JSONArray jsonArray=new JSONArray();
		//创建一个Json对象,存放数据库数据
		JSONObject jsonObject=new JSONObject();
		//遍历
		for (Goods goods : resultSet) {
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
		}
		Integer totalCount=GoodsDaoImpl.GoodsInfoCount();
		
		//创建一个Json数组
		JSONObject json=new JSONObject();
		json.put("data", jsonArray);
		json.put("total", totalCount);
		
		
//		//创建一个Json对象 存放总条数 对接的为total
//		JSONObject jsonObject1=new JSONObject();
//		jsonObject1.put("total", totalCount);
//		//传数据
//		PrintWriter pw=response.getWriter();
//		pw.println(jsonArray);
		//传数量
		PrintWriter pw=response.getWriter();
		pw.println(json);
	}
	
	protected void  doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
	}
}
