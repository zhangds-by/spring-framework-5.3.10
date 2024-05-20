package com.zhouyu.test;

import com.zhouyu.AppConfig;
import com.zhouyu.service.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author zhangds
 * @version 1.0
 * @since 2024/5/18
 */
public class BDRTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//		// 能解析的注解是：@Conditional，@Scope、@Lazy、@Primary、@DependsOn、@Role、@Description
//		AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
//		// 将User.class 解析为BD
//		beanDefinitionReader.register(User.class);

//		// 解析<bean/>标签
//		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
//		int i = xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");
//		System.out.println(context.getBean("user"));

		// 扫描某个包路径，对扫描的类进行解析为BD
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
		scanner.scan("com.zhouyu");

		System.out.println(context.getBean("userService"));

	}
}
