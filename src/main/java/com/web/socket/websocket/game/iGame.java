package com.web.socket.websocket.game;

import java.util.ArrayList;





public interface iGame {
	
	// At the beginning of a game the class Game needs players
	public void setPlayer(String name, int credit,String id);
	// Check whether there are enough players
	public boolean numOfPlayersIsTwo();
	//Turns are true or not
	public boolean hasTurned();
	//Set deck at the start of every game
	public void setDeck(ArrayList<Card> deck);
	// Void deck
	public void nullDeck();
	//Give credit from board to Player/ inside this func. there are methods to give P1,P2 or both credits.
	public void giveCredit(Player player, int credit);
	// Goes into the giveCredit func.
	public void creditToPlayer(Player player, int credit);
	public void creditToBothPlayers(Player player1,Player player2, int credit);
	//Null board credit
	public void nullBoardCredit();
	
	public int getBoardCredit();
	public void setBoardCredit(int credit);
}
