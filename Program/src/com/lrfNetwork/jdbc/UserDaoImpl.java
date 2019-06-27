package com.lrfNetwork.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.lrfNetwork.Info.User;

public class UserDaoImpl {
	
	
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
	 * 选所有user信息*
	 */
	public static ArrayList<User> getAllUserInfo() {
		ArrayList<User> userArray=new ArrayList<>();
		Object[] object={null};
		String sql="SELECT * FROM user";
		//预处理
		ResultSet resultSet=DB_Function.reSelect(sql, object);
		try {
			while (resultSet.next()) {
				Integer id=resultSet.getInt(1);
				String username=resultSet.getString(2);
				String email=resultSet.getString(3);
				String password=resultSet.getString(4);
				Integer is_admin=resultSet.getInt(5);
				String reg_date=resultSet.getString(6);
				User user2=new User(id, username, email, password, is_admin, reg_date);
				userArray.add(user2);
			}
		} catch (Exception e) {
			System.err.println("getAllUserInfo 异常");
		}finally {
			try {
				if (resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				System.err.println("resultSet  关闭异常");
			}
		}
		return userArray;
	}
	
	/*
	 * 插入user*
	 */
//	public static void insertUserInfo(User user) {
//		String sql="INSERT INTO user(id,username,email,password,is_admin,reg_date) values(?,?,?,?,?,?) ";
//
//		//将User信息传入
//		Object[] object={user.getId(),user.getUsername(),user.getEmail(),user.getPassword(),user.getIs_admin(),user.getReg_date()};
//		
//		Integer rebackvalue=DB_Function.reUpdate(sql, object);
//		//判断是否成功
//		isSuccess(rebackvalue);
//	}
	
	
	
	/*
	 * 插入部分账号密码，邮箱*
	 *
	 */
	public static boolean  insertUserInfo(String username,String password,String email,String reg_date) {
		String sql="INSERT INTO user(username,password,email,reg_date) values(?,?,?,?) ";
	
		//将User信息传入
		Object[] object={username,password,email,reg_date};
		try {
			Integer rebackvalue=DB_Function.reUpdate(sql, object);
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
	public static boolean modifiyUserInfo(String password,Integer id) {
		String sql="UPDATE user SET password=? WHERE id=?";
		try {
			//将User信息传入
			Object[] object={password,id};
			Integer rebackvalue=DB_Function.reUpdate(sql, object);
			boolean juge=isSuccess(rebackvalue);
			return juge;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/*
	 * 选所有指定user信息*
	 */
	public static User getNeedUserInfo(Integer Needid) {
		
		User user = null;
		Object[] object={Needid};
		String sql="SELECT * FROM user WHERE id=?";
		//预处理
		ResultSet resultSet=DB_Function.reSelect(sql, object);
		try {
			while (resultSet.next()) {
				Integer id=resultSet.getInt(1);
				String username=resultSet.getString(2);
				String email=resultSet.getString(3);
				String password=resultSet.getString(4);
				Integer is_admin=resultSet.getInt(5);
				String reg_date=resultSet.getString(6);
				user=new User(id, username, password, email, is_admin, reg_date);
				return user;
			}
		} catch (Exception e) {
			System.err.println("getNeedUserInfo 异常");
		}finally {
			try {
				if (resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				System.err.println("resultSet  关闭异常");
			}
		}
		return user;
	}
}
