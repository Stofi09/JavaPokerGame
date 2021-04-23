package com.web.socket.websocket.test.jUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;



import org.junit.jupiter.api.Test;

import com.web.socket.websocket.game.Card;
import com.web.socket.websocket.result.Sequence;

class TestSequence {

	
	@Test
	void test() {
		 ArrayList<Card> deck = new ArrayList<Card>();
		 deck = Card.makeDeck();
		 System.out.println(deck.toString());
		 assertEquals(2, Sequence.handsCheck(deck.get(0), deck.get(1), deck.get(2),deck.get(3), deck.get(4),deck.get(5), deck.get(6)));
		 assertEquals(3, Sequence.handsCheck(deck.get(8), deck.get(9), deck.get(10),deck.get(11), deck.get(12),deck.get(13), deck.get(14)));
		 assertEquals(1, Sequence.handsCheck(deck.get(0), deck.get(14), deck.get(2),deck.get(3), deck.get(4),deck.get(5), deck.get(6)));
	}

}
