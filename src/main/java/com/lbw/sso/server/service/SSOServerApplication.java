package com.lbw.sso.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * 
 * @author LiuBaoWen
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.lbw.sso.server" })
public class SSOServerApplication {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(SSOServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SSOServerApplication.class, args);

	}

}
