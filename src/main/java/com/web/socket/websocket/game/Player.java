package com.web.socket.websocket.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Player {
	
	private int credit;
	private int result1;
	private int result2;
	private int higherCard;
	private int lesserCard;
	private Card card1;
	private Card card2;
	private String name;
	private String id;
	
	@Autowired
	private TurnCounter counter;
	
	@Autowired
	public ResultHolder resultHolder;
	
	private boolean hasTurned;
	
	public Player() {}
	public Player(String name) {
		this.name = name;
	}
	
	public Player(String name, int credit,String id) {
		this.name = name;
		this.credit = credit;
		this.id = id;
	}
	
	public void setResult(int betterHand, int worseHand, int higherCard, int lesserCard) {
		setResult1(betterHand);
		setResult2(worseHand);
		setHigherCard(higherCard);
		setLesserCard(lesserCard);
	}
	
	public void setCounter(boolean bol1,boolean bol2,boolean bol3) {
		this.counter.setCont(bol1, bol2, bol3);
	}
	private boolean checkTurn() {
		return this.counter.isNewTurn();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// take credit from player
	public void raiseCredit(int raiseCredit) {
		this.credit = this.credit - raiseCredit;
	}
	
	public void setHand(Card card1, Card card2) {
		this.card1 = card1;
		this.card2 = card2;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = this.credit+credit;
	}

	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public boolean getHasTurned() {
		return hasTurned;
	}

	public void setHasTurned(boolean hasTurned) {
		this.hasTurned = hasTurned;
	}
	
	
	public int getResult1() {
		return result1;
	}
	public void setResult1(int result1) {
		this.result1 = result1;
	}
	public int getResult2() {
		return result2;
	}
	public void setResult2(int result2) {
		this.result2 = result2;
	}
	public int getHigherCard() {
		return higherCard;
	}
	public void setHigherCard(int higherCard) {
		this.higherCard = higherCard;
	}
	public int getLesserCard() {
		return lesserCard;
	}
	public void setLesserCard(int lesserCard) {
		this.lesserCard = lesserCard;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	@Override
	public String toString() {
		return "Player [credit=" + credit + ", card1=" + card1 + ", card2=" + card2 + ", name=" + name + "]";
	}
	

	public String toString2() {
		return "Player [res:" + result1 + ", result2=" + result2 + ", card2=" + card2 + ", name=" + name + "]";
	}
}
