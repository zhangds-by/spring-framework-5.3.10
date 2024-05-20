package com.zhouyu.test;

import com.zhouyu.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * 类的元数据读取器
 * @author zhangds
 * @version 1.0
 * @since 2024/5/18
 */
public class MRTest {

	public static void main(String[] args) throws IOException {

		SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();

		// 利用工厂类构建一个MR
		MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader("com.zhouyu.service.UserService");

		// 获取ClassMetadata，获取类名
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		System.out.println(classMetadata);

		// 获取AnnotationMetadata，并获取类上的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		for (String annotationType : annotationMetadata.getAnnotationTypes()) {
			System.out.println(annotationType);
		}

	}
}
