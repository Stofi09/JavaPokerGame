package com.web.socket.websocket.game;

import java.util.ArrayList;

import org.springframework.stereotype.Component;


public class Card implements Comparable<Card> {
	public static ArrayList<Card> deck;
	private final int  color;
	private final int rank;
	private final int id;
	private final String img;
	
	public Card(int color,int rank,int id,String img) {
		this.color = color;
		this.rank  = rank;
		this.id	   =id;
		this.img = img;
	}

	public int getColor() {
		return color;
	}

	public int getRank() {
		return rank;
	}

	public int getId() {
		return id;
	}
	public String getImg() {
		return img;
	}

	@Override
	public String toString() {
		return "Card [" + this.img+"]" + this.id +"";
	}

//	@Override
//	public String toString() {
//		return "Card [color=" + color + ", rank=" + rank + ", id=" + id + "]";
//	}
	public static ArrayList<Card> makeDeck() {
		ArrayList<Card> deck = new ArrayList<>(); 
		for (Enum_Card e:Enum_Card.values()) {
			deck.add(new Card(e.getColor(),e.getRank(),e.getId(),e.getImg()));
		}
		return deck;
		}


	@Override
	public int compareTo(Card o) {
		if (rank == o.rank)return 1;
		else if(rank < o.rank)return 0;
		else return -1;
	}
	public boolean equals(Card card1 , Card card2) {
		if (card1.getRank() == card2.getRank())return true;
		else return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		return true;
	}
	
	
}
