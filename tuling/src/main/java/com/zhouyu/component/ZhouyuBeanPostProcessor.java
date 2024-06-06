package com.zhouyu.component;

import com.zhouyu.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 实例化前BPP
 * @author zhangds
 * @version 1.0
 * @since 2024/5/21
 */
@Component
public class ZhouyuBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
			throws BeansException {
		if ("userService".equals(beanName)) {
			System.out.println("实例化前");
//			return new UserService();
		}
		return null;
	}
}
