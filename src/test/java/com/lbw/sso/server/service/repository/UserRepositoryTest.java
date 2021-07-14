/**
 * 
 */
package com.lbw.sso.server.service.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lbw.sso.server.service.SSOServerApplication;
import com.lbw.sso.server.service.entity.User;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(SSOServerApplication.class);

	@Autowired
	private UserRepository userRepository;

	@After
	public void test() {
		Iterable<User> findAll = userRepository.findAll();
		System.out.println(findAll);
		
	}

	@Test
	public void testDemo() {
		// save a few Users
		userRepository.save(new User("Jack", "Bauer"));
		userRepository.save(new User("Chloe", "O'Brian"));
		userRepository.save(new User("Kim", "Bauer"));
		userRepository.save(new User("David", "Palmer"));
		userRepository.save(new User("Michelle", "Dessler"));

		// fetch all Users
		log.info("Users found with findAll():");
		log.info("-------------------------------");
		for (User User : userRepository.findAll()) {
			log.info(User.toString());
		}
		log.info("");

		// fetch an individual User by ID
		User User = userRepository.findById(1L).get();
		log.info("User found with findById(1L):");
		log.info("--------------------------------");
		log.info(User.toString());
		log.info("");


		log.info("User found with count('Bauer'):");
		log.info("--------------------------------------------");
		long count = userRepository.count();
		log.info("{}", count);
		log.info("");
	}

}
