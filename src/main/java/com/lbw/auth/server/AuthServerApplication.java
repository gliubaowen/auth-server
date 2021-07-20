package com.lbw.auth.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring4all.swagger.EnableSwagger2Doc;

/**
 * 启动类
 * 
 * @author LiuBaoWen
 *
 */
@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan(basePackages = { "com.lbw.auth.server" })
public class AuthServerApplication {

	private static final Logger log = LoggerFactory.getLogger(AuthServerApplication.class);

	public static void main(String[] args) {
		log.info("==========>>> starting AuthServerApplication is start! <<<==========");
		SpringApplication.run(AuthServerApplication.class, args);
		log.info("==========>>> starting AuthServerApplication is complete! <<<==========");
	}

}
