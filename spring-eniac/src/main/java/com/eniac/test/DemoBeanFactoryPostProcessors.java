package com.eniac.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: wangjingen
 * @createDate: 2020-04-27 13:24
 **/
@Component
public class DemoBeanFactoryPostProcessors implements BeanDefinitionRegistryPostProcessor {


	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("wangjingen++++++++");
		System.out.println("wangjingen++++++++");
		System.out.println("wangjingen++++++++");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("wangjingen++++++++");
		System.out.println("wangjingen++++++++");
		System.out.println("wangjingen++++++++");
		System.out.println("wangjingen++++++++");
	}
}
