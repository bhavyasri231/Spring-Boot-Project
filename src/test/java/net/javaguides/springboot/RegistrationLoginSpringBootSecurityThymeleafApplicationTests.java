package net.javaguides.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistrationLoginSpringBootSecurityThymeleafApplicationTests {

	@Test
	void contextLoads() {
		String[] str = new String[]{};
		RegistrationLoginSpringBootSecurityThymeleafApplication.main(str);
		Assertions.assertEquals(1,2-1);
	}

}
