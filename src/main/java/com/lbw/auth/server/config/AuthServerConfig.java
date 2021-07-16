/**
 * 
 */
package com.lbw.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lbw.auth.server.runner.CustomerApplicationRunner;

/**
 * 项目配置类
 * 
 * @author LiuBaoWen
 *
 */
@Configuration
public class AuthServerConfig {

	/**
	 * ApplicationRunner
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@Bean
	public CustomerApplicationRunner customerApplicationRunner() {
		return new CustomerApplicationRunner();
	}

}
