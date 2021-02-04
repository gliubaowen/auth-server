/**
 * 
 */
package com.lbw.sso.server.service.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Common-Controller
 * 
 * @author LiuBaoWen
 *
 */
@RestController
@RequestMapping("service")
public class SSOServerController {

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @param req
	 * @return
	 */
	@PostMapping("/login")
	public String login(String username, String password, HttpServletRequest req) {

		req.getSession().setAttribute("isLogin", true);

		return "success";

	}

	/**
	 * 注销
	 * 
	 * @param username
	 * @param password
	 * @param req
	 * @return
	 */
	@PostMapping("/logout")
	public String logout(String username, String password, HttpServletRequest req) {

		req.getSession().setAttribute("isLogin", false);

		return "success";

	}

	@GetMapping("")
	public String index() {
		return "Hello Index !";
	}

	@GetMapping("helloworld")
	public String helloWorld() {
		return "Hello Common Service!";
	}

}
