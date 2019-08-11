package com.dyy;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dyy.service.HiService;

/**
 * 
 * @author daiyangyang
 * @since 5.0
 */
public class IOCDemo{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		HiService hiService = applicationContext.getBean(HiService.class);
		String result = hiService.hi("yangyangdai");
		System.out.println("hi=" + result);
	}
}
