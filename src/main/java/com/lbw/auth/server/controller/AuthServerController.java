/**
 * 
 */
package com.lbw.auth.server.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * AuthServer-Controller
 * 
 * @author LiuBaoWen
 *
 */
@Slf4j
@Api(value = "认证", tags = "认证")
@RestController
@RequestMapping("service")
public class AuthServerController {

	@ApiOperation(value = "获取当前用户")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@GetMapping("/getCurrentUser")
	public Object getCurrentUser(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		log.info("token: {}", JSON.toJSON(principal));
		return authentication.getPrincipal();
	}

	@ApiOperation(value = "helloWorld")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Object.class) })
	@GetMapping("/helloWorld")
	public String helloWorld(String str) {
		return "Hello" + str;
	}

	/**
	 * 自定义登录页面
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	* 资源服务器提供的受保护接口
	* @param principal
	* @return
	*/
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println(principal);
		return principal;
	}

}
