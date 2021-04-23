package com.web.socket.websocket.test.jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.web.socket.websocket.result.High;


class TestHigh {

	High h = null;
	
	
	@Test
	void testHigh() {
		//Draw
		assertEquals(0,High.high(1, 1));
		//First card is higher
		assertEquals(1,High.high(3, 1));
		//Second card is higher
		assertEquals(2,High.high(1, 10000));
		
	}

}
