package com.zhouyu.test;

import com.zhouyu.AppConfig;
import com.zhouyu.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * @author zhangds
 * @version 1.0
 * @since 2024/5/21
 */
public class BeanLifeCycleTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 实例化设置Supplier
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setInstanceSupplier(new Supplier<Object>() {
			@Override
			public Object get() {
				return new UserService();
			}
		});
		context.registerBeanDefinition("userService", beanDefinition);
	}
}
