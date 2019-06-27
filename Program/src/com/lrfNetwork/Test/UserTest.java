package com.lrfNetwork.Test;

import com.lrfNetwork.Info.User;
import com.lrfNetwork.jdbc.UserDaoImpl;

public class UserTest {
	public static void main(String[] args) {
		User user=UserDaoImpl.getNeedUserInfo(1130);
		System.out.println(user.getId()+"\t"+user.getUsername()+"\t"+user.getPassword()+"\t"+user.getEmail()+"\t"+user.getIs_admin()+"\t"+user.getReg_date());
				}

}
