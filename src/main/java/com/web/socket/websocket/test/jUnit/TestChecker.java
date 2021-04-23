package com.web.socket.websocket.test.jUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.web.socket.websocket.game.Card;
import com.web.socket.websocket.result.Checker;

class TestChecker {
	
	ArrayList<Card> deck1 = Card.makeDeck(); 
	Checker CheckHigherHand = new Checker(deck1.get(0),deck1.get(1),deck1.get(2),deck1.get(3),deck1.get(4),deck1.get(5),deck1.get(6));		
	Checker CheckColors = new Checker(deck1.get(0),deck1.get(13),deck1.get(2),deck1.get(3),deck1.get(4),deck1.get(14),deck1.get(15));
	
	@Test
	void testHigher() {
		CheckHigherHand.doCheck();
		assertEquals(3,CheckHigherHand.getHigherCard());
		assertEquals(2,CheckHigherHand.getLesserCard());
	}
	@Test
	void testColor() {
		CheckColors.doCheck();
		assertEquals(3,CheckColors.getColorRes1());
		assertEquals(2,CheckColors.getColorRes2());
	}
	@Test
	void testSequence() {
		CheckHigherHand.doCheck();
		assertEquals(2,CheckHigherHand.getSeq());
		CheckColors.doCheck();
		assertEquals(1,CheckColors.getSeq());
	}
	
}
