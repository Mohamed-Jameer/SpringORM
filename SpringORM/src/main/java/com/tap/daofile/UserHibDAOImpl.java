package com.tap.daofile;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.orm.entity.User;

@Component
public class UserHibDAOImpl {
	
	private static Session session;

	static {
		session = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.buildSessionFactory()
				.openSession();
	}

	private Transaction t;
	
	public void insertUser(User user) {
		session.beginTransaction();
		 session.persist(user);
		 session.getTransaction().commit();
		 
	}
	
	
	public ArrayList<User> fetchAll() {
		  session.beginTransaction();
//		  Query q = session.createQuery("from student");
//		   ArrayList<Student> sList=( ArrayList<Student>) q.list();

//		   ArrayList<Student> sList=( ArrayList<Student>) session.createQuery("from student").list();

		   return (ArrayList<User>) session.createQuery("from StudentDemo").list() ;
		
	}

	
	public User fetchOne(int sid) {
	//	StudentDemo student= session.get(StudentDemo.class, sid);
		return session.get(User.class, sid);
	}

	
	
	public void delete(int sid) {
		
		session.beginTransaction();
	//	StudentDemo s = fetchOne(sid);
		session.delete(fetchOne(sid));
		session.getTransaction().commit();;
		System.out.println("Data Deleted ");
		
	}

	public void updateUser(String email, int sid) {
		session.beginTransaction();
		User s = session.get(User.class, sid);
		if(s!=null) {
			s.setEmail(email);
			session.persist(s);
		}
		session.getTransaction().commit();
		
	}
	
	
	public void insertStudentDetails(User sds) {
		  t = session.beginTransaction();
			session.persist(sds);
			t.commit();
		
	}
	
	// Update One To One
	
	public void updateStudentDetails(String email,String city ,int sid) {
		session.beginTransaction();
		User s = session.get(User.class, sid);
		if(s!=null) {
			s.setEmail(email);
			s.setCity(city);
			session.persist(s);
		}
		session.getTransaction().commit();
		
	}
	

}
