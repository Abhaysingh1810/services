package com.example.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UsersMap {

	private static Map<Integer,User> userMap=new HashMap<>();
	
	private UsersMap(){
		
	}
	
	static{
		
		User jane = new User(1L, "Jane");
		User john = new User(2L, "John");
		userMap.put(1, jane);
		userMap.put(2, john);
	}
	
	public static  synchronized Map<Integer, User> getUsersMap(){
		return Collections.synchronizedMap(userMap);
	}
	
}
