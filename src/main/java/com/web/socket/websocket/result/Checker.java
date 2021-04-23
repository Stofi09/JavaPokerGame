package com.web.socket.websocket.result;

import org.springframework.stereotype.Component;

import com.web.socket.websocket.game.Card;



@Component
public class Checker {

	//Players cards rank to compare them in the Result
	private int higherCard;
	private int lesserCard;
	
	private Card Card1;
	private Card Card2;
	private Card Card3;
	private Card Card4;
	private Card Card5;
	private Card Card6;
	private Card Card7;
	
	// the result of the higher card
	private int cardRes1;
	// the result of the lesser card
	private int cardRes2;
	//results for pair ranks
	private int pairRankRes1;
	private int pairRankRes2;
	// results for pair colors
	private int pairColorRes1;
	private int pairColorRes2;
	private int sequence;
	
	public Checker() {}
	public Checker(Card card1, Card card2, Card card3, Card card4, Card card5, Card card6, Card card7) {
		this.Card1 = card1;
		this.Card2 = card2;
		this.Card3 = card3;
		this.Card4 = card4;
		this.Card5 = card5;
		this.Card6 = card6;
		this.Card7 = card7;
	}
	
	//Getters for results
	public int getCardRes1() {
		return this.cardRes1;
	}
	
	public int getCardRes2() {
		return this.cardRes2;
	}
	
	//Do I need this?
	public void doCheck() {
		getHigher();
		System.out.println("higher:"+ this.higherCard+"and "+this.lesserCard);
		pair();
		System.out.println("pairRank:"+ this.pairRankRes1+"and "+this.pairRankRes2);
		pairColor();
		System.out.println("pairCOlor:"+ this.pairColorRes1+"and "+this.pairColorRes2);
		checkSeq();
		System.out.println("res:"+ this.sequence);
	}
	// Method to decide wich cards rank is higher
	// Do I need an else if? 
	private void getHigher() {
		if (this.Card1.getRank()>this.Card2.getRank()) {
			this.higherCard = this.Card1.getRank();
			this.lesserCard = this.Card2.getRank();
		}
		else if(this.Card1.getRank()<this.Card2.getRank()) {
			this.higherCard = this.Card2.getRank();
			this.lesserCard = this.Card1.getRank();
		}
		else {
			this.higherCard = this.Card1.getRank();
			this.lesserCard = this.Card1.getRank();
		}	
	}
	// Check for pairs in rank
	public void pair() {
		if ((this.Card1.getRank()== this.Card2.getRank())){
			System.out.println("lapok azonosak");
			this.pairRankRes1 = Pair.pairChecker(this.Card1.getRank(), this.Card3.getRank(),this.Card4.getRank(), this.Card5.getRank(), this.Card6.getRank(), this.Card7.getRank());
			this.pairRankRes1++; // same card pair
		}
		else {
			System.out.println("nem azonosaka");
			this.pairRankRes1 = Pair.pairChecker(this.Card1.getRank(), this.Card3.getRank(),this.Card4.getRank(), this.Card5.getRank(), this.Card6.getRank(), this.Card7.getRank());
			
			this.pairRankRes2 = Pair.pairChecker(this.Card2.getRank(), this.Card3.getRank(),this.Card4.getRank(), this.Card5.getRank(), this.Card6.getRank(), this.Card7.getRank());
		}
		
	}

	//check if it contains  same
	public void pairColor() {
		if (Pair.handEqual(this.Card1.getColor(), this.Card2.getColor())){
			System.out.println("lapok azonosak,Color");
			this.pairColorRes1 = Pair.pairChecker(this.Card1.getColor(), this.Card3.getColor(),this.Card4.getColor(), this.Card5.getColor(), this.Card6.getColor(), this.Card7.getColor());
			this.pairColorRes1++;
		}
		else {
			System.out.println("nem azonosoka,Color");
			this.pairColorRes1 = Pair.pairChecker(this.Card1.getColor(), this.Card3.getColor(),this.Card4.getColor(), this.Card5.getColor(), this.Card6.getColor(), this.Card7.getColor());
			this.pairColorRes2 = Pair.pairChecker(this.Card2.getColor(), this.Card3.getColor(),this.Card4.getColor(), this.Card5.getColor(), this.Card6.getColor(), this.Card7.getColor());
		} 
	}
	
	public void checkSeq() {
		
		this.sequence = Sequence.handsCheck(this.Card1, this.Card2,this.Card3,this.Card4, this.Card5, this.Card6, this.Card7);
	}
	
	public int getPairRes1() {
		return this.pairRankRes1;
	}
	public int getPairRes2() {
		return this.pairRankRes2;
	}
	
	public int getColorRes1() {
		return this.pairColorRes1;
	}
	public int getColorRes2() {
		return this.pairColorRes2;
	}
	public int getHigherCard() {
		return this.higherCard;
	}
	public int getLesserCard() {
		return this.lesserCard;
	}
	public int getSeq() {
		return this.sequence;
	}

	@Override
	public String toString() {
		return "Checker [higherCard=" + higherCard + ", lesserCard=" + lesserCard + ", cardRes1=" + cardRes1
				+ ", cardRes2=" + cardRes2 + ", pairRankRes1=" + pairRankRes1 + ", pairRankRes2=" + pairRankRes2
				+ ", pairColorRes1=" + pairColorRes1 + ", pairColorRes2=" + pairColorRes2 + ", sequence=" + sequence
				+ "]";
	}
	
	
}
