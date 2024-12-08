package com.orm.launch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.orm.configu.ClassContainer;
import com.orm.entity.User;
import com.tap.daofile.UserHibDAOImpl;

public class Launch {

	public static void main(String[] args) {
	AnnotationConfigApplicationContext apx = new AnnotationConfigApplicationContext(ClassContainer.class);
    
	User u =(User)apx.getBean("user");
	
	UserHibDAOImpl userHibDao =  (UserHibDAOImpl)apx.getBean("userHibDAOImpl");
	userHibDao.insertUser(u);
	
	System.out.println("Data Inserted");
	
	}

}
