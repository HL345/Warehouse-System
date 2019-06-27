package com.lrfNetwork.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;


public class DB_Function {
	private static InputStream inputStream=null;
	private static String driver=null;
	private static String username=null;
	private static String password=null;
	private static String url=null;
	
	private static Connection connecter=null;
	private static PreparedStatement preparedStatement=null;
//	private static ResultSet resultSet=null;
	
	static {
		try {
			//创建Properties类
			Properties prop=new Properties();
			//把db.properties通过流的形式加载
			inputStream=DB_Function.class.getClassLoader().getResourceAsStream("db.properties");
			//把输入流加载到Properties对象里
			prop.load(inputStream);
			
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			//加载驱动
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("数据加载失败");
		} finally {
			try {
				if (null!=inputStream) {
					inputStream.close();
				}
			} catch (Exception e2) {
				System.err.println("输入流关闭异常");
			}
		}
	}
	
	//链接数据库
	public static Connection getconnection() {	
	
		try {
			connecter=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.err.println("数据库连接异常");
		}
		return connecter;
	}
	
	//关闭资源
	public static void closeResourceConnection(PreparedStatement preparedStatement,ResultSet resultSet,Connection connecter) {
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.err.println("preparedStatement关闭异常");
			}
		}
		
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.err.println("resultSet关闭异常");
			}
		}
		if (connecter!=null) {
			try {
				connecter.close();
			} catch (SQLException e) {
				System.err.println("connecter关闭异常");
			}
		}
	}
	
	
	//预编译通道
	public static PreparedStatement getpreparedStatement(String sql) {
		try {
			//预编译处理
			preparedStatement=getconnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("预编译处理失败");
		}
		return preparedStatement;	
	}
	
	
	//自动识别传入的参数类型并完成绑定
	public static void Parameter_bind(Object[] object,PreparedStatement preparedStatement) {
		for (int i = 0; i < object.length; i++) {
				//int
				if (object[i] instanceof Integer) {
					try {
//						System.out.println("ineger"+object[i]);
						preparedStatement.setInt(i+1, (Integer)object[i]);
						
					} catch (SQLException e) {
						e.printStackTrace();
						System.err.println("int参数绑定异常");
					}
					//String
				}else if (object[i] instanceof String) {
					try {
//					System.out.println("String"+object[i]);
						preparedStatement.setString(i+1, (String)object[i]);
					} catch (SQLException e) {
						e.printStackTrace();
						System.err.println("String参数绑定异常");
					}
					//Double
				}else if (object[i] instanceof Double) {
					try {
//						System.out.println("Double"+object[i]);
						preparedStatement.setDouble(i+1, (double)object[i]);
					} catch (SQLException e) {
						e.printStackTrace();
						System.err.println("Double参数绑定异常");
					}
				}else if (object[i] instanceof Date) {
					try {
//						System.out.println("Date"+object[i]);
						preparedStatement.setDate(i+1, (Date)object[i]);
					} catch (SQLException e) {
						e.printStackTrace();
						System.err.println("date参数绑定异常");
					}
				}
			}
	}
	
	//查询功能
	public static ResultSet reSelect(String sql ,Object object[]) {
		//创建结果离线ji
		CachedRowSet cachedRowSet=null;
		//预编译处理
		preparedStatement=getpreparedStatement(sql);
		//绑定参数
		Parameter_bind(object,preparedStatement);
		
		try {
			//获取结果集
			ResultSet resultSet=preparedStatement.executeQuery();
			
			//将获取到的resultSet结果放到离线结果集中
			cachedRowSet=new CachedRowSetImpl();
			cachedRowSet.populate(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("查询异常");
		}
		return cachedRowSet;	
	}
	
	//修改功能
	public static Integer reUpdate(String sql,Object[] object) {
		Integer i = null;
//		for (int j = 0; j < object.length; j++) {
//			System.out.println(object[j]);
//		}
		preparedStatement=getpreparedStatement(sql);
		//绑定参数
		Parameter_bind(object, preparedStatement);
			//修改成功返回大于0 否则为0
			try {
				i=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("修改异常");
			}	
		return i;
	}
	
}
