package com.eniac.test;

import com.eniac.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: wangjingen
 * @description:
 * @createDate: 2020-03-14 10:50
 **/
public class DemoMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
//		Wang bean = (Wang) ac.getBean(Wang.class);
//		WangTest bean = (WangTest) ac.getBean("wangTest");
//		bean.print();
//		Wang bean = ac.getBean(Wang.class);
//		bean.print();
	}
}
