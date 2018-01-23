package com.walker.webwalker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional("transactionManager")
@SpringBootTest
public class WebWalkerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
