package com.lbw.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring4all.swagger.EnableSwagger2Doc;

import lombok.extern.slf4j.Slf4j;

/**
 * 启动类
 * 
 * @author LiuBaoWen
 *
 */
@Slf4j
@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan(basePackages = { "com.lbw.auth.server" })
public class AuthServerApplication {

	public static void main(String[] args) {
		log.info("==========>>> starting AuthServerApplication is start! <<<==========");
		SpringApplication.run(AuthServerApplication.class, args);
		log.info("==========>>> starting AuthServerApplication is complete! <<<==========");
	}

}
