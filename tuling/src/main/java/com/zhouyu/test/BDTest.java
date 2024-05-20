package com.zhouyu.test;

import com.zhouyu.AppConfig;
import com.zhouyu.service.User;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangds
 * @version 1.0
 * @since 2024/5/18
 */
public class BDTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// ApplicationContext继承了BeanFactory，ApplicationContext底层实现是通过BeanFactory实现的
//		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// bean编程式定义
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(User.class);

		// 设置bean的属性
		// 设置作用域
		beanDefinition.setScope("prototype");
		// 设置初始化方法
		beanDefinition.setInitMethodName("init");
		// 设置懒加载
		beanDefinition.setLazyInit(true);
		context.registerBeanDefinition("user", beanDefinition);
//		beanFactory.registerBeanDefinition("user", beanDefinition);

		System.out.println(context.getBean("user"));
	}
}
