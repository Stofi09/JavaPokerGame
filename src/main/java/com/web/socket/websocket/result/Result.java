package com.web.socket.websocket.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.web.socket.websocket.game.Card;
import com.web.socket.websocket.game.Player;



@Component
public class Result {

private boolean pair = false;
private boolean twoPair = false;
private boolean threeOfAKind = false;
private boolean fourOfAKind = false;
private boolean color5OfAKind = false;
private boolean Seq = false;
private boolean flushSeq = false;
private boolean royalFlush = false;
private static int hand = 0;
private int res1;
private int res2;

@Autowired
private  Checker check;

	public Result() {}
	public void setResult (Card card1, Card card2, Card card3, Card card4, Card card5, Card card6,Card card7,Player player) {
		this.check = new Checker(card1,card2,card3,card4,card5,card6,card7);
		hand++;
		checkBooleans();
		setPlayerResult(player);
	}

//Using the checker to find hands.
public void checkBooleans() {
	falsify();
	this.check.doCheck();
	if (this.check.getPairRes1()==1) this.pair = true;
	if (this.check.getPairRes2()==1) this.pair = true;
	if (this.check.getPairRes1()==1&&this.check.getPairRes2()==1) this.twoPair = true;
	if(this.check.getPairRes1()==2)this.threeOfAKind = true;
	if(this.check.getPairRes2()==2)this.threeOfAKind = true;
	if(this.check.getPairRes1()==3)this.fourOfAKind = true;
	if(this.check.getColorRes1()==4||this.check.getColorRes2()==4)this.color5OfAKind = true;
	if(this.check.getSeq()==1)this.Seq = true;
	if(this.check.getSeq()==2)this.flushSeq = true;
	if(this.check.getSeq()==3)this.royalFlush = true;
	doReSolve();
}

//Checking the booleans if any of them are true.
public void doReSolve() {
	if(this.pair) reSolver(2);
	if(this.twoPair) reSolver(3);
	if(this.threeOfAKind) reSolver(4);
	if(this.Seq) reSolver(5);
	if(this.color5OfAKind) reSolver(6);
	if(this.threeOfAKind&&this.pair) reSolver(7);
	if(this.fourOfAKind) reSolver(8);
	if(this.flushSeq) reSolver(9);
	if (this.royalFlush) reSolver(10);
}

//Set booleans to false.
private void falsify() {
	this.pair = false;
	this.twoPair = false;
	this.threeOfAKind = false;
	this.fourOfAKind = false;
	this.color5OfAKind = false;
	this.Seq = false;
	this.flushSeq = false;
	this.royalFlush = false;
	this.res1 = 0;
	this.res2 = 0;
	
	
}

//Set results according to doResolve(); .
private void reSolver(int result ) {
	
	if(this.res1 > result) 	this.res2 = result;
	else this.res1 = result;
 
}

public  void setPlayerResult(Player player) {
	player.setResult(getRes1(), getRes2(), getCHeckerHigher(), getCheckerLesser());
	this.check = null;
	falsify();
}

//Draw == 0
//Player1 == 1 - Firstplayer in React
//Player2 == 2
public static String checkWinner(Player player1, Player player2) {
	String result = "draw";
	if (player1.getResult1() > player2.getResult1()) result = player1.getName();
	else if (player1.getResult1() < player2.getResult1()) result = player2.getName();
	else {
		if (player1.getResult2() > player2.getResult2()) result = player1.getName();
		else if (player1.getResult2() < player2.getResult2()) result = player2.getName();
	}
	if (result == "draw") { // Checking the ranks of the cards.
		if(player1.getHigherCard() > player2.getHigherCard()) result = player1.getName();
		else if (player1.getHigherCard() < player2.getHigherCard()) result = player2.getName();	
		else {
			if (player1.getLesserCard() > player2.getLesserCard()) result = player1.getName();
			else if (player1.getLesserCard() < player2.getLesserCard()) result = player2.getName();
		}
	}
	return result;
}


public int getRes1() {
	return this.res1;
}

public int getRes2() {
	return this.res2;
}
public int getCHeckerHigher() {
	return this.check.getHigherCard();
}
public int getCheckerLesser() {
	return this.check.getLesserCard();
}

@Override
public String toString() {
	return "Result [pair=" + pair + ", twoPair=" + twoPair + ", threeOfAKind=" + threeOfAKind + ", fourOfAKind="
			+ fourOfAKind + ", color5OfAKind=" + color5OfAKind + ", Seq=" + Seq + ", flushSeq=" + flushSeq
			+ ", royalFlush=" + royalFlush + "]";
}
	
public String toString2() {
	return this.res1 + "" + this.res2 + "" + this.check.getCardRes1();
}
	
	
}
