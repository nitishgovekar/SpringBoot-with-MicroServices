package com.microservices.webservice.restfull.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount =3;
	
	static {
		users.add(new User(1,"Nitish",new Date()));
		users.add(new User(2, "Maddy", new Date()));
	}

	//Will retrieve all records 
	public List<User> getAllRecords(){
		return users;
	}

	//To save user
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	
	public User findById(int id) {
		for(User record: users) {
			if(record.getId() == id) {
				return record;
			}
		}
		return null;
	}
	
	
 public User deleteById(int id) {
	
	 Iterator<User> iterator = users.iterator();

	 while(iterator.hasNext()) {
		 User user = iterator.next();

		 if(user.getId() == id) {
			 iterator.remove();
			 return user;
		 }

	 }
	 return null;
 }
	
}
