package com.lbw.auth.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServerApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		System.out.println("Hello Spring Boot");

//		log.info("token:{}", token);
		// /newoa/sso/isLogin.jsp

		// 调用OA系统获取用户信息
		MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>(1);
		paramMap.add("token", "dadaasdf");

		ResponseEntity<String> responseEntity = restTemplate
				.postForEntity("http://10.162.60.28:82/newoa/sso/isLogin.jsp", paramMap, String.class); // 提交的body内容为user对象，请求的返回的body类型为String
		String body = responseEntity.getBody();

		OALoginRes oALoginRes = JSONObject.parseObject(body, OALoginRes.class);
		System.out.println(oALoginRes);

	}

}
