package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	//创建静态会话工厂对象
	private static SessionFactory sessionFactory;
	
	static {
		//创建读取配置文件的对象,并调用方法
		Configuration configuration = new Configuration();
		configuration.configure();
		//得到会话工厂
		sessionFactory = configuration.buildSessionFactory();
	}
	
	//获得会话操作对象
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
