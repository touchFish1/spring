package com.eniac.test;

import com.eniac.wang.WangTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: wangjingen
 * @description:
 * @createDate: 2020-03-14 10:56
 **/
@Component
public class Wang {
	@Autowired
	@Qualifier("wangTest")
	private WangTest wangTest;

	public Wang() {
	}

	@PostConstruct
	public void wang2() {
		System.out.println("PostConstruct");
	}

	public void print() {
		wangTest.test();
	}

}
