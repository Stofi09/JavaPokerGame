package com.web.socket.websocket.test.jUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.web.socket.websocket.game.Card;
import com.web.socket.websocket.game.Player;
import com.web.socket.websocket.result.Result;

class TestResult {
	
	Result res = new Result();
	ArrayList<Card> deck1 = Card.makeDeck(); 
	
	@Test
	void test1() {
		Player p = new Player("String", 1000, "id");
		res.setResult(deck1.get(0),deck1.get(1),deck1.get(2),deck1.get(3),deck1.get(4),deck1.get(5),deck1.get(6),p);
		assertEquals(9,p.getResult1()); 
		assertEquals(0,p.getResult2()); 
		assertEquals(3,p.getHigherCard()); 
		assertEquals(2,p.getLesserCard()); 
	
	}
	
	
	@Test
	void test2() {
		Player p = new Player("String", 1000, "id");
		res.setResult(deck1.get(0),deck1.get(13),deck1.get(2),deck1.get(31),deck1.get(24),deck1.get(15),deck1.get(36),p);
		assertEquals(2,p.getResult1()); 
		assertEquals(0,p.getResult2()); 
		assertEquals(2,p.getHigherCard()); 
		assertEquals(2,p.getLesserCard()); 
	
	}

}
