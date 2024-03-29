package com.lbw.auth.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 用户服务类
 *
 * @author LiuBaoWen
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private List<User> userList;

	@PostConstruct
	public void initData() {
		String password = passwordEncoder.encode("123456");
		userList = new ArrayList<>();
		userList.add(new User("admin", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
		userList.add(new User("macro", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
		userList.add(new User("andy", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
		userList.add(new User("mark", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
	}

	/**
	 * 通过用户名加载用户信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> findUserList = userList.stream().filter(user -> user.getUsername().equals(username))
				.collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(findUserList)) {
			return findUserList.get(0);
		} else {
			throw new UsernameNotFoundException("用户名或密码错误");
		}
	}

}
