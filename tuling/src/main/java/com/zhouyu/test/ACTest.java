package com.zhouyu.test;

import com.zhouyu.AppConfig;
import com.zhouyu.service.OrderService;
import com.zhouyu.service.User;
import com.zhouyu.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * ApplicationContext 功能案例
 * @author zhangds
 * @version 1.0
 * @since 2024/5/18
 */
public class ACTest {

	public static void main(String[] args) throws IOException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 国际化
		context.getMessage("test", null, new Locale("en-CN"));

		// 资源加载
		Resource resource = context.getResource("file://D:\\gitProjects\\spring-framework-5.3.10-main\\tuling\\src\\main\\java\\com\\zhouyu\\service\\User.java");
		System.out.println(resource.contentLength());
		System.out.println(resource.getFilename());

		Resource resource1 = context.getResource("https://www.baidu.com");
		System.out.println(resource1.contentLength());
		System.out.println(resource1.getURL());

		Resource resource2 = context.getResource("classpath:spring.xml");
		System.out.println(resource2.contentLength());
		System.out.println(resource2.getURL());

		Resource[] resources = context.getResources("classpath:com/zhouyu/*.class");
		for (Resource res : resources) {
			System.out.println(res.contentLength());
			System.out.println(res.getFilename());
		}

		// 运行环境
		Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
		System.out.println(systemEnvironment);

		System.out.println("=======");

		Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
		System.out.println(systemProperties);

		System.out.println("=======");

		MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
		System.out.println(propertySources);

		System.out.println("=======");

		// @PropertySource("classpath:spring.properties") 将文件中的参数添加到运行时环境中
		System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
		System.out.println(context.getEnvironment().getProperty("sun.jnu.encoding"));
		System.out.println(context.getEnvironment().getProperty("zhouyu"));

		// 类型转换：不做案例

		// OrderComparator
		OrderService a = new OrderService();
		UserService b = new UserService();
		AnnotationAwareOrderComparator comparator = new AnnotationAwareOrderComparator();
		System.out.println(comparator.compare(a, b));

		List list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.sort(comparator);
		System.out.println(list);

	}
}
