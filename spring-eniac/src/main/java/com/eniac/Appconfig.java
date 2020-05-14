package com.eniac;


import com.eniac.annotation.EnableOrignReq;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangjingen
 * @description:
 * @createDate: 2020-01-19 22:38
 **/
@ComponentScan(value = "com.eniac")
@Configuration
@EnableOrignReq({"com.eniac.wang"})
public class Appconfig {



}
