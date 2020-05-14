package com.eniac.test;

import com.eniac.annotation.EnableOrignReq;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author: wangjingen
 * @createDate: 2020-04-27 13:24
 **/

public class DemoBeanFactoryPostProcessors implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {

	private ResourceLoader resourceLoader;

	private Environment environment;

	private DemoFactoryBean<?> demoFactoryBean =  new DemoFactoryBean<Object>();
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableOrignReq.class.getName()));
		String[] values = annoAttrs.getStringArray("value");
////		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry,
////				false, this.environment, this.resourceLoader);
//		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);  // super(registry, false);
//		scanner.addIncludeFilter(new TypeFilter() {
//			@Override
//			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//				return true;
//			}
//		});
//		scanner.addExcludeFilter(new TypeFilter() {
//			@Override
//			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//				String className = metadataReader.getClassMetadata().getClassName();
//				return className.endsWith("package-info");
//			}
//		});

		ClassPathMapperScanner classPathMapperScanner = new ClassPathMapperScanner(registry, false);
		classPathMapperScanner.registerFilters();
		Set<BeanDefinitionHolder> beanDefinitionHolders = classPathMapperScanner.doScan(values);
		System.out.println(beanDefinitionHolders.size() + "===================");
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
//			Class<?> oldClass = null;
//			try {
//				oldClass = Class.forName(beanDefinition.getBeanClassName());
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
			beanDefinition.setBeanClass(demoFactoryBean.gettClass());
			beanDefinition.setBeanClass(DemoFactoryBean.class);
			beanDefinition.setAutowireCandidate(true);
			beanDefinition.setAutowireMode(beanDefinition.AUTOWIRE_BY_NAME);
		}


	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
}
