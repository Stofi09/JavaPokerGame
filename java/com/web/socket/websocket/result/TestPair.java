package com.web.socket.websocket.result;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPair {

	
	@Test
	void testHandEqual() {
		assertEquals(true,Pair.handEqual(1, 1));		
		assertEquals(false,Pair.handEqual(3, 1));
	}
	
	@Test
	void testPairChecker() {
		assertEquals(0,Pair.pairChecker(1,2,3,3,4,5));	
		assertEquals(1,Pair.pairChecker(1,1,3,3,4,5));	
		assertEquals(2,Pair.pairChecker(1,1,1,3,4,5));	
		assertEquals(3,Pair.pairChecker(1,1,1,1,4,5));	
		assertEquals(4,Pair.pairChecker(1,1,1,1,1,5));	
	}
	
	@Test
	void testColorPair() {
		assertEquals(true,Pair.colorPair(1,1,1,1,1));	
		assertEquals(false,Pair.colorPair(0,1,1,1,0));
		
	}

}
