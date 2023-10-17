package com.myGcpProject;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.googlecode.objectify.ObjectifyService;

import StudentCRUDObjectify.Student;

@WebListener
public class ObjectifyWebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ObjectifyService.begin();
		// This is a good place to register your POJO entity classes.
		// ObjectifyService.register(YourEntity.class);
		ObjectifyService.register(Student.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
}