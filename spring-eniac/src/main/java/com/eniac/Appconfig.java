package com.eniac;


import com.eniac.test.Jin;
import com.eniac.test.Wang;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangjingen
 * @description:
 * @createDate: 2020-01-19 22:38
 **/
@ComponentScan(value = "com.eniac")
@Configuration
public class Appconfig {
	@Bean
	public Jin getJin() {
		getWang();
		return new Jin();
	}
	@Bean
	public Wang getWang() {
		return new Wang();
	}






}
