package com.lbw.sso.server.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.lbw.sso.server.service.entity.User;

/**
 * User Repository
 * 
 * @author BaoWenLiu
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	public int findUser(User user);

}
