package com.lrfNetwork.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lrfNetwork.Info.Goods;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GoodsDaoImpl {		
		
		/*
		 * 判断是否执行成功*
		 */
		public static boolean isSuccess(int count) {
			if (count>0) {
				return true;
			}else {
				return false;
			}
		}
		
		
		/*
		 * 选所有goods信息*
		 */
		public static ArrayList<Goods> getAllGoodsInfo() {
			ArrayList<Goods> goodsArray=new ArrayList<>();
			Object[] object={null};
			String sql="SELECT * FROM goods";
			//预处理
			ResultSet resultSet=DB_Function.reSelect(sql, object);
			try {
				while (resultSet.next()) {
					Integer id=resultSet.getInt(1);
					String name=resultSet.getString(2);
					String type=resultSet.getString(3);
					Integer save=resultSet.getInt(4);
					double price=resultSet.getDouble(5);
					String size=resultSet.getString(6);
					String date=resultSet.getString(7);
					String manufacture=resultSet.getString(8);
					Integer period=resultSet.getInt(9);
					
					//创建对象
					Goods goods=new Goods(id, name, type, save, price, size, date, manufacture, period);
					goodsArray.add(goods);
				}
			} catch (Exception e) {
				System.err.println("getAllGoodsInfo 异常");
			}finally {
				try {
					if (resultSet!=null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					System.err.println("resultSet  关闭异常");
				}
			}
			return goodsArray;
		}
		
		
		
		
		/*
		 * 插入商品信息
		 *
		 */
		public static boolean  insertGoodsInfo(Object[] object) {
			String sql="INSERT INTO goods(name,type,save,price,size,date,manufacture,period) values(?,?,?,?,?,?,?,?) ";
		
			//将User信息传入
//			Object[] object={username,password,email,reg_date};
			try {
				Integer rebackvalue=DB_Function.reUpdate(sql,object);
				boolean juge=isSuccess(rebackvalue);	
				return juge;
			} catch (Exception e) {
				return false;
			}
			//判断是否成功
		}
		
		
		
		/*
		 * 修改Info*
		 */
		
		//账号密码修改
		public static boolean modifiyUserInfo(String username,String password,Integer id) {
			String sql="UPTAET user SET password=? WHERE id=?";
			try {
				//将User信息传入
				Object[] object={username,password,id};
				Integer rebackvalue=DB_Function.reUpdate(sql, object);
				boolean juge=isSuccess(rebackvalue);
				return juge;
			} catch (Exception e) {
				return false;
			}
		}
		
		/*
		 * 删除*
		 */
		public static boolean DeleteGoodsInfo(Integer id) {
			String sql="DELETE FROM goods WHERE id=?";
			ArrayList<Goods> goods=new ArrayList<>();
			boolean juge=false;
			//吧id放到一个对象里
			Object[] object={id};
			
			//将所有的信息存放在goods集合里
			goods=getAllGoodsInfo();
			//遍历找到要删除的id
			for (Goods goods2 : goods) {
				if (goods2.getId()==id) {
					Integer value=DB_Function.reUpdate(sql, object);
					//成功value大于1 失败为0
					juge=isSuccess(value);
					System.out.println("删除成功");
				}
			}
			return juge;
		}
		
		
		
		/*
		 * 查询数据库有多少条数据*
		 */
		
		public static int GoodsInfoCount() {
			String sql="SELECT COUNT(*) FROM goods";
			//因为不需要绑定参数，所以object数组赋值null
			Object[] object = {null};
			//拿来保存有多少条数据
			Integer count=0;
			ResultSet resultSet=DB_Function.reSelect(sql, object);
			try {
				while(resultSet.next()){
					count=resultSet.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("返回数据库数量异常");
				e.printStackTrace();
			}
			return count;
		}
		
		
		
		
		/*
		 * 通过分页limit查询*
		 * perPagecount  每页显示的数量
		 * pageCount 页数
		 */
		public static ArrayList<Goods> selectGoodsByPage(Integer pageCount) {
			//通过每页的数量判断一共有多少页  假如23条数据 每页5条 就需要5页显示  所以+1
//			Integer pageCount=(Integer)(GoodsInfoCount()/PerPagecount)+1;
			String sql="select * from goods LIMIT ?,5";
			//每页显示5条信息  当输入为4时  应该展示16-20这些条数据
			Object[] object={(pageCount-1)*5};
			
			//创建集合存放数据
			ArrayList<Goods> goodsArray=new ArrayList<>();
			
			ResultSet resultSet=DB_Function.reSelect(sql, object);
			try {
				while(resultSet.next()){
					Integer id=resultSet.getInt(1);
					String name=resultSet.getString(2);
					String type=resultSet.getString(3);
					Integer save=resultSet.getInt(4);
					double price=resultSet.getDouble(5);
					String size=resultSet.getString(6);
					String date=resultSet.getString(7);
					String manufacture=resultSet.getString(8);
					Integer period=resultSet.getInt(9);
					
					//创建对象
					Goods goods=new Goods(id, name, type, save, price, size, date, manufacture, period);
					goodsArray.add(goods);
				}
			} catch (Exception e) {
				System.err.println("selectGoodsByPage 异常");
			}finally {
				try {
					if (resultSet!=null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					System.err.println("resultSet  关闭异常");
				}
			}
			return goodsArray;
		}
		
		/*
		 * 查询通过名称,TYPE*
		 */
		
		public static ArrayList<Goods> SelectNeedInfo(String SelectInfo) {
			String sql="SELECT * FROM goods where CONCAT(name,type) like ? ";
			
			ArrayList<Goods> goodsArray=new ArrayList<>();
			Object[] object = {"%"+SelectInfo+"%"};
			ResultSet resultSet=DB_Function.reSelect(sql, object);
			try {
				while (resultSet.next()) {
					Integer id=resultSet.getInt(1);
					String name=resultSet.getString(2);
					String type=resultSet.getString(3);
					Integer save=resultSet.getInt(4);
					double price=resultSet.getDouble(5);
					String size=resultSet.getString(6);
					String date=resultSet.getString(7);
					String manufacture=resultSet.getString(8);
					Integer period=resultSet.getInt(9);
					
					//创建对象
					Goods goods=new Goods(id, name, type, save, price, size, date, manufacture, period);
					goodsArray.add(goods);
				}
			} catch (SQLException e) {
				System.out.println("SelectNeedInfo异常");
			}finally {
				try {
					if (resultSet!=null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					System.err.println("resultSet  关闭异常");
				}
			}
			return goodsArray;
		}
		
		/*
		 * 修改*
		 */
		
		public static boolean modifiyGoodsInfo(Object[] object) {
			String sql="UPDATE goods SET  name=?, type=?, save=?, price=?,size=?,date=?, manufacture=?, period=? WHERE id=?";
			Integer issuccess=DB_Function.reUpdate(sql, object);
			 if (isSuccess(issuccess)) {
				 System.out.println("修改成功");
				return true;
			}else {
				System.out.println("修改失败");
				return false;
			}
		
		}
		
		 /*
		  * 模糊查询*
		  */
		
		
		
}
