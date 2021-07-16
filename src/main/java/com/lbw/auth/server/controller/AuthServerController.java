/**
 * 
 */
package com.lbw.auth.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthServer-Controller
 * 
 * @author LiuBaoWen
 *
 */
@RestController
@RequestMapping("service")
public class AuthServerController {

	@GetMapping("/getCurrentUser")
	public Object getCurrentUser(Authentication authentication) {
		return authentication.getPrincipal();
	}

}
