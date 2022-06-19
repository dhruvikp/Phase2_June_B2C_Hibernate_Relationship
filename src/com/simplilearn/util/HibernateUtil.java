package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Course;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory != null)
			return sessionFactory;

		// STEP 1: Creating Configuration object and providing DB inforamation and
		// mapping information
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(PhoneNumber.class);
		configuration.addAnnotatedClass(Course.class);
		
		// STEP 2: create Session Factory object and return
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;

	}

}
