package com.example.openshifttest.openshifttest;

import com.example.openshifttest.openshifttest.service.LdapUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenshiftTestApplicationTests {
	@Autowired
	private LdapUserService ldapUserService;
	@Test
	public void contextLoads() {
		ldapUserService.findUser("wangxm@fosun.com","p@ssword227");
	}

}
