/**
 * 
 */
package com.lbw.sso.server.service.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbw.common.utils.cipher.EncryptUtils;
import com.lbw.sso.server.service.entity.User;
import com.lbw.sso.server.service.repository.UserRepository;

/**
 * Common-Controller
 * 
 * @author LiuBaoWen
 *
 */
@RestController
@RequestMapping("service")
public class SSOServerController {

	@Autowired
	UserRepository UserRepository;

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

		byte[] passwordBytes = password.getBytes();
		byte[] encryptMD5 = null;

		try {
			encryptMD5 = EncryptUtils.encryptMD5(passwordBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int userCount = UserRepository.findUser(new User(username, encryptMD5.toString()));

		UUID token = UUID.randomUUID();

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
