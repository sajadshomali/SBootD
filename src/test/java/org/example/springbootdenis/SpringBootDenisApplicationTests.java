package org.example.springbootdenis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringBootDenisApplicationTests {

	/*public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}*/

	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Test
	void contextLoads() {
		System.out.println(encoder.encode("123"));
	}

}
