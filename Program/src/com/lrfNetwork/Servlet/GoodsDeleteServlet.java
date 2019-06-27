package com.lrfNetwork.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.lrfNetwork.jdbc.GoodsDaoImpl;
import com.sun.istack.internal.logging.Logger;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/api/table/remove")
public class GoodsDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		

		
		String idString=request.getParameter("ids");
//		System.out.println(idString);
		boolean issucess=true;
		String[] idArray=idString.split(",");
		int[] ids=new int[idArray.length];
		int deletecount=0;
		for (int i = 0; i < idArray.length; i++) {
			ids[i]=Integer.parseInt(idArray[i]);
			issucess=GoodsDaoImpl.DeleteGoodsInfo(ids[i]);
			if (issucess) {
				deletecount++;
			}
		}
		if (deletecount==idArray.length) {
			JSONObject object=new JSONObject();
			object.put("isSuccess",issucess);
			PrintWriter printWriter=response.getWriter();
			printWriter.println(object);
		}
	}
}
