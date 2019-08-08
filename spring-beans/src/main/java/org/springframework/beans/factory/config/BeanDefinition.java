/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.AttributeAccessor;
import org.springframework.lang.Nullable;

/**
 * BeanDefinition描述了一个bean实例
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	/**
	 * 	单例 	bean的生命周期
	 */
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	/**
	 * 	原型	bean的生命周期
	 */
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

	
	int ROLE_APPLICATION = 0;
	int ROLE_SUPPORT = 1;
	int ROLE_INFRASTRUCTURE = 2;


	/**
	 * 	设置父bean名称
	 */
	void setParentName(@Nullable String parentName);

	/**
	 * 	 获取父bean名称
	 */
	@Nullable
	String getParentName();

	/**
	 * 	获取Bean的类名称
	 */
	void setBeanClassName(@Nullable String beanClassName);

	/**
	 * 	获取Bean的类名称
	 */
	@Nullable
	String getBeanClassName();

	/**
	 *	设置bean的生命周期   SCOPE_SINGLETON  SCOPE_PROTOTYPE
	 */
	void setScope(@Nullable String scope);

	/**
	 * 	获取bean的生命周期
	 */
	@Nullable
	String getScope();

	/**
	 *	 设置是否懒加载
	 */
	void setLazyInit(boolean lazyInit);

	/**
	 * 	判断是否需要懒加载
	 */
	boolean isLazyInit();

	/**
	 * 	设置Bean依赖的所有的 Bean
	 */
	void setDependsOn(@Nullable String... dependsOn);

	/**
	 * 	获取Bean依赖的所有的 Bean
	 */
	@Nullable
	String[] getDependsOn();

	/*
	 * 	设置Bean是否可以注入到其他 Bean 中
	 */
	void setAutowireCandidate(boolean autowireCandidate);

	/**
	 *	Bean是否可以注入到其他Bean中
	 */
	boolean isAutowireCandidate();

	/**
	 * 	设置为主要的 当接口有多实现时 没有指定名称获取时  会优先选择设置为primary
	 */
	void setPrimary(boolean primary);

	/**
	 *	是否为主要的
	 */
	boolean isPrimary();

	/**
	 *	如果该Bean采用工厂方法生成 指定工厂名称
	 *	有些实例不是用反射生成的 而是用工厂模式生成的
	 */
	void setFactoryBeanName(@Nullable String factoryBeanName);

	/**
	 * 	获取工厂名称.
	 */
	@Nullable
	String getFactoryBeanName();

	/**
	 * 	指定工厂类中的 工厂方法名称
	 */
	void setFactoryMethodName(@Nullable String factoryMethodName);

	/**
	 * 	获取工厂类中的 工厂方法名称
	 */
	@Nullable
	String getFactoryMethodName();

	/**
	 * 	获取构造器参数
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/**
	 * Return if there are constructor argument values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasConstructorArgumentValues() {
		return !getConstructorArgumentValues().isEmpty();
	}

	/**
	 * bean中的属性值
	 */
	MutablePropertyValues getPropertyValues();

	/**
	 * Return if there are property values values defined for this bean.
	 * @since 5.0.2
	 */
	default boolean hasPropertyValues() {
		return !getPropertyValues().isEmpty();
	}


	// Read-only attributes

	/**
	 * 	是否Singleton
	 */
	boolean isSingleton();

	/**
	 * 	是否Prototype
	 */
	boolean isPrototype();

	/**
	 *	是否抽象的
	 */
	boolean isAbstract();


	int getRole();
	@Nullable
	String getDescription();
	@Nullable
	String getResourceDescription();
	@Nullable
	BeanDefinition getOriginatingBeanDefinition();

}
