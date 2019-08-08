/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dyy;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.StandardEnvironment;

import com.dyy.service.HiService;

/**
 * 
 * @author daiyangyang
 * @since 5.0
 */
public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		HiService hiService = applicationContext.getBean(HiService.class);
		String hi = hiService.hi("yangyangdai");
		System.out.println("hi=" + hi);
		StandardEnvironment environment = (StandardEnvironment)applicationContext.getEnvironment();
		Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
		for (Map.Entry<String, Object> o : systemEnvironment.entrySet()) {
			System.out.println("key : " + o.getKey() + " value : " + o.getValue());
		}
		Map<String, Object> systemProperties = environment.getSystemProperties();
		for (Map.Entry<String, Object> o : systemProperties.entrySet()) {
			System.out.println("key : " + o.getKey() + " value : " + o.getValue());
		}
	}
}
