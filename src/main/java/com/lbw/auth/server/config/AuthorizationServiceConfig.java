/**
 * 
 */
package com.lbw.auth.server.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 认证服务配置类
 * 
 * @author LiuBaoWen
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServiceConfig extends AuthorizationServerConfigurerAdapter {

	/** 认证管理器 */
	@Autowired
	private AuthenticationManager authenticationManager;
	/** 密码管理器 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	/** 用户信息服务 */
	@Autowired
	private UserDetailsService userDetailsService;
	/** 数据源 */
	@Autowired
	private DataSource dataSource;

	// 声明TokenStore实现
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	// 声明 ClientDetails实现
	@Bean
	public ClientDetailsService clientDetails() {
		return new JdbcClientDetailsService(dataSource);
	}

	/**
	* 使用密码模式需要配置
	*/
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}

	/**
	 * 客户端信息配置
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("admin")// 配置client_id
				.secret(passwordEncoder.encode("admin"))// 配置client_secret
				.accessTokenValiditySeconds(3600)// 配置访问token的有效期
				.refreshTokenValiditySeconds(864000)// 配置刷新token的有效期
				.redirectUris("http://localhost/auth-client/login")// 配置redirect_uri，用于授权成功后跳转
				.scopes("all")// 配置申请的权限范围
				.authorizedGrantTypes("authorization_code", "password", "client_credentials", "refresh_token",
						"implicit");// 配置grant_type，表示授权类型
	}

}
