package com.web.socket.websocket.result;

import java.util.ArrayList;

public class Pair {

	
	// For result check if hand has eq. cards. If yes go with pairCheckerEqual func. else go with pairChecker 2 times
	public static boolean  handEqual(int card1,int card2) {
		if (card1 == card2) return true;
		else 				return false;
	}
	
	
	//Checks card1 against the other cards to find pairs
	public static int pairChecker(int card1,int card2,int card3,int card4,int card5,int card6) {
		int result = 0;
		ArrayList<Integer> board = new ArrayList<>();
	       {
	           board.add(card2);
	           board.add(card3);
	           board.add(card4);
	           board.add(card5);
	           board.add(card6);
	       }
	       for (int i = 0; i < board.size();i++)
	       {
	           if (board.get(i) == card1)
	           {
	        	   result++;
	           }
	       }
		
		return result;
	}


	// Checks whether the seq. is a Straight Flush
	public static boolean colorPair(int card1, int card2, int card3, int card4, int card5) {
		if (card1==card2&&card2==card3&&card3==card4&&card4==card5) return  true;
		return false;	
	}
	
}
