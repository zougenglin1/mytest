package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.po.Customer;
import com.itheima.utils.HibernateUtils;

public class HibernateTest {
	
	/***
	 * 保存数据
	 */
	@Test
	public void save() {
		
		//获得当前会话对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//创建实体类对象
		Customer customer = new Customer();
		//添加数据
		customer.setName("灭绝师太");
		
		//保存数据
		session.save(customer);
		//提交事务
		transaction.commit();
	}
	
	/***
	 * 查询一条数据
	 */
	@Test
	public void get1() {
		//获得当前会话对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//得到查询数据
		Customer customer = session.get(Customer.class, 2);
		
		System.out.println(customer.getName());
		//提交事务
		transaction.commit();
	}
	
	/***
	 * 延时加载查询数据
	 */
	@Test
	public void load1() {
		
		////获得当前会话对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//得到查询数据
		Customer customer = session.load(Customer.class, 1);
		
		System.out.println(customer.getName());
		System.out.println(customer.getName());
		System.out.println(customer.getName());
		//提交事务
		transaction.commit();
	}
	/**
	 * 更新修改数据
	 */
	@Test
	public void update() {
		
		////获得当前会话对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//得到实体类对象
		Customer customer = session.get(Customer.class, 1);
		//修改数据
		customer.setName("张三丰");
		//更新数据
		session.update(customer);
		//提交事务
		transaction.commit();
	}
	
	/***
	 * 删除数据
	 */
	@Test
	public void delete() {
		////获得当前会话对象
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//得到实体类对象
		Customer customer = session.get(Customer.class, 2);
		
		//删除数据
		session.delete(customer);
		//提交事务
		transaction.commit();
	}
}
