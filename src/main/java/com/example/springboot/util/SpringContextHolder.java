/*
 * @(#)SpringContextHolder.java 2013-11-7下午06:10:02
 * Copyright 2013 sinovatech, Inc. All rights reserved.
 */
package com.example.springboot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring上下文持有类
 * @modificationHistory.  
 * <ul>
 * <li>sunju 2013-11-7下午06:10:02 TODO</li>
 * </ul>
 */
@SuppressWarnings("unchecked")
@Component
public class SpringContextHolder implements ApplicationContextAware {
	/**
	 * 以静态变量保存Spring ApplicationContext,可在任何代码任何地方任何时候中取出ApplicaitonContext. 
	 */
	private static ApplicationContext applicationContext;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		SpringContextHolder.applicationContext = context;
	}
	/**
	 * 取得存储在静态变量中的ApplicationContext
	 * @author sunju
	 * @creationDate. 2013-11-7 下午06:16:33 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型 
	 * @author sunju
	 * @creationDate. 2013-11-7 下午06:16:40 
	 * @param <T>
	 * @param name
	 * @return
	 */
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}
	  
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型
	 * @author sunju
	 * @creationDate. 2013-11-7 下午06:17:01 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();  
		return (T) applicationContext.getBeansOfType(clazz);  
	}
	  
	/**
	 * 清除applicationContext静态变量 
	 * @author sunju
	 * @creationDate. 2013-11-7 下午06:18:12 
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}
	
	/**
	 * 检查注入
	 * @author sunju
	 * @creationDate. 2013-11-7 下午06:17:27
	 */
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在xml中定义SpringContextHolder");
		}
	}

}
