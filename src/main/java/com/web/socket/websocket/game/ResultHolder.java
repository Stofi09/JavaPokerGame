package com.web.socket.websocket.game;

import org.springframework.stereotype.Component;

@Component
public class ResultHolder {

	private int betterHand;
	private int worseHand;
	private int higherCard;
	private int lesserCard;
	
	public ResultHolder() {}

	public void setResult(int betterHand, int worseHand, int higherCard, int lesserCard) {
		setBetterHand(betterHand);
		setWorseHand(worseHand);
		setHigherCard(higherCard);
		setLesserCard(lesserCard);
	}
	
	public int getBetterHand() {
		return betterHand;
	}

	public void setBetterHand(int betterHand) {
		this.betterHand = betterHand;
	}

	public int getWorseHand() {
		return worseHand;
	}

	public void setWorseHand(int worseHand) {
		this.worseHand = worseHand;
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

	@Override
	public String toString() {
		return "ResultHolder [betterHand=" + betterHand + ", worseHand=" + worseHand + ", higherCard=" + higherCard
				+ ", lesserCard=" + lesserCard + "]";
	}
	
	
	
}
