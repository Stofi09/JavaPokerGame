package com.web.socket.websocket.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.web.socket.websocket.game.Card;




//result = 1 -> Straight , result = 2 -> Straight flush , result = 3 -> Royal flush 
public class Sequence {

	 static int card1;
	 static int card2;
	
	  public static int handsCheck(Card Hand1, Card Hand2,Card board1,Card board2,Card board3,Card board4,Card board5){
		  card1 = Hand1.getRank();
		  card2 = Hand2.getRank();
	      int result = 0;
	      List<Card> dupboard = new ArrayList<Card>();
	       {
	    	   dupboard.add(Hand1);
	    	   dupboard.add(Hand2);
	    	   dupboard.add(board1);
	    	   dupboard.add(board2);
	    	   dupboard.add(board3);
	    	   dupboard.add(board4);
	    	   dupboard.add(board5);
	       }
	       
	       //Remove duplicates
	       List<Card> board = dupboard.stream().distinct().collect(Collectors.toList());
	       int boardSize = board.size();
	       Collections.sort(board);
	       Collections.reverse(board);
	       for (Card card : board) {
	    	   System.out.println("///"+card.getRank());
	       }
	      
	       if (boardSize >=5) {
		        if (Sequence.contains(board.get(0).getRank(),board.get(1).getRank(),board.get(2).getRank(),board.get(3).getRank(),board.get(4).getRank())){
		        	int preResult = sequence(board.get(0),board.get(1),board.get(2),board.get(3),board.get(4));
		        	if (preResult >= result) result = preResult; 
		        	System.out.println("1. lefut");
		        }
		       }
	       if (boardSize >=6) {
		       if ( Sequence.contains(board.get(1).getRank(),board.get(2).getRank(),board.get(3).getRank(),board.get(4).getRank(),board.get(5).getRank())) {
		    	   int preResult = sequence(board.get(1),board.get(2),board.get(3),board.get(4),board.get(5));
		    	   System.out.println("2. lefut");
		    	   if (preResult >= result) result = preResult; 
		       }
	       }
	       if (boardSize == 7) {
		       if (Sequence.contains(board.get(2).getRank(),board.get(3).getRank(),board.get(4).getRank(),board.get(5).getRank(),board.get(6).getRank())) {
		    	   int preResult = sequence(board.get(2),board.get(3),board.get(4),board.get(5),board.get(6));     
		    	   if (preResult >= result) result = preResult;
		    	   System.out.println("3. lefut");
		       }
	       }
	       
	       return result;
	       
	    }

// private method used in handsCheck to do the results 	  
	  private static int sequence(Card card1,Card card2, Card card3,Card card4,Card card5) {
		  int result = 0;
		  
		  System.out.println(card1.getRank() + "||" + card2.getRank() + "|| " + card3.getRank() + "|| " + card4.getRank() + "|| " + card5.getRank());
		  if((card1.getRank()+1)==card2.getRank()&&(card2.getRank()+1)==card3.getRank()&&(card3.getRank()+1)==card4.getRank()&&(card4.getRank()+1)==card5.getRank()) {
			  if (Pair.colorPair(card1.getColor(), card2.getColor(), card3.getColor(), card4.getColor(), card5.getColor())) {
					 System.out.println(card1.getRank() + " " + card5.getRank());
					  if (card1.getRank()==10&&card5.getRank()==14) {
								  result = 3;
					  }
					  else {
						  result = 2;
					  }	
				  }
			else {
				result = 1;
			}
			}	  
		 System.out.println("result : " + result); 
		  return result; 
	  }
// Checking wether one of the players card is within these cards.	  
	  private static boolean contains (int board1,int board2,int board3,int board4,int board5) {
		  boolean result = false;
		  System.out.println(card1 + " /// " + card2);
		  if (card1==board1||card1==board2||card1==board3||card1==board4||card1==board5) {
			  result = true;
		  }
		  else if (card2==board1||card2==board2||card2==board3||card2==board4||card2==board5) {
			  result = true;
		  }
		  System.out.println("result :" + result);
		  return result;
	  }
	  
	 
}
