package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.User;

@SpringBootTest
class SimCoinApplicationTests {

	@Test
	public void test_set_get() {
		User user = new User();
		user.setBtc(1);
		user.setEth(1);
		user.setLtc(1);
		user.setXmr(1);
		user.setTrx(1);
		user.setCash(1);
		
		assertEquals(1, user.getBtc());
		assertEquals(1, user.getEth());
		assertEquals(1, user.getLtc());
		assertEquals(1, user.getXmr());
		assertEquals(1, user.getTrx());
		assertEquals(1, user.getCash());
	}

}
