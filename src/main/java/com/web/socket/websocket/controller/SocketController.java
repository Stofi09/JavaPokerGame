package com.web.socket.websocket.controller;



import com.web.socket.websocket.bean.MessageBean;
import com.web.socket.websocket.game.Card;
import com.web.socket.websocket.game.Game;
import com.web.socket.websocket.game.Player;
import com.web.socket.websocket.result.Result;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
	
	
	private static int turn = 0;
	
	private static boolean hasDisconnected = false;
	
	@Autowired
	private Result res;
	@Autowired
	private static Game game;
	@Autowired
	private Player player;
	@Autowired
	private Player player2;
	
	
    @MessageMapping("/Join")
    @SendTo("/topic/user")
    public MessageBean sendToAll(@Payload MessageBean message , @Header("simpSessionId") String sessionId) {
    	
    	setHasDisconnectedtoFalse();
    	System.out.println(sessionId);
    	if(game == null ) {
    		game = new Game();
    	}if (game.getPlayer1() == null) {
    	//	player = new Player(message.getName(),1000,sessionId);
    		game.setPlayer(message.getName(),1000,sessionId);
    		message.setId(sessionId);
    		message.setCredit(1000);
    		message.setType("Join");
    	}else if (game.getPlayer2() == null){
    	//	player2 = new Player(message.getName(),1000,sessionId);
    		game.setPlayer(message.getName(),1000,sessionId);
    		message.setOppName(game.getPlayer1().getName());
    		message.setId(sessionId);
    		message.setCredit(1000);
    		message.setOppCredit(1000);
    		message.setType("Join");
    	}else {
    		System.err.println("there are 2 players already");
    		message.setName("There are already two players playing. Please wait until they finish.");
			message.setType("reloadPage");
    	}
    	if (game.getPlayer1() != null && game.getPlayer2() != null) {
    		if (game.getPlayer1().getName().equals(game.getPlayer2().getName())) {
    			message.setName("There are already two players playing. Please wait until they finish.");
    			message.setType("reloadPage");
    		}
    	}
    	
    	System.out.println(message.getBean());
    	
        return message;
    }
    
  
    
    @MessageMapping("/sendback")
    @SendTo("/topic/user")
    public MessageBean sendthat(@Payload MessageBean message) {
    	message.setType("sikerult");
    	return message;
    }
   
    
    @MessageMapping("/start")
    @SendTo("/topic/user")
    public MessageBean sendStart(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    		//change the player cards? The player who starts the game should receive deck.get0 and 1
    		
    	// Null the game turn at the end of the game	
    	game.nullTurn();
    	turn = game.turnCounter();
    	
    	// keep the deck array- just shuffle if its not the first game
    	ArrayList<Card> deck = new ArrayList<>();
		deck = Card.makeDeck();
		Collections.shuffle(deck);
		
		player = new Player(message.getName());
		System.out.println("///|||\\"+player.getName());
		//these 3 methods could be just one.
		this.res.setResult(deck.get(0),deck.get(1),deck.get(4),deck.get(5), deck.get(6), deck.get(7), deck.get(8),player);
		//this.res.checkBooleans();
		//this.res.setPlayerResult(player);
		System.out.println(player.toString2() );
		System.out.println("-------------------");
		player2 = new Player(game.getOpponentName(message.getName()));
		System.out.println("///|||\\"+player2.getName());
		this.res.setResult(deck.get(2),deck.get(3),deck.get(4),deck.get(5), deck.get(6), deck.get(7), deck.get(8),player2);		
		//this.res.checkBooleans();
		//this.res.setPlayerResult(player2);
		System.out.println(player2.toString2() );
		System.out.println(player.toString2() + " and " + player2.toString2());
		
		message.setResult(Result.checkWinner(player, player2));
		
		System.out.println(message.getResult());
		int[] cards = {deck.get(0).getId(),deck.get(1).getId(),deck.get(2).getId(),deck.get(3).getId(),deck.get(4).getId(),deck.get(5).getId(),deck.get(6).getId(),deck.get(7).getId(),deck.get(8).getId()};
    	message.setCards(cards);
		message.setType("Start");
    	return message;
    	}
    }
    
    @MessageMapping("/check")
    @SendTo("/topic/user")
    public MessageBean sendCheck(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    	game.setCheckTurned(message.getName());
    	turn  = game.turnCounter();
    	message.setType("Check");
    	message.setTurn(turn);
    	
    	return message;
    	}
    }
    
    @MessageMapping("/allIn")
    @SendTo("/topic/user")
    public MessageBean sendAllIn(@Payload MessageBean message) {
    	System.out.println("sikerult111");
    	message.setTurn(5);
    	message.setType("allIn");
    	return message;
    }
    
    @MessageMapping("/firstRaise")
    @SendTo("/topic/user")
    public MessageBean sendRaise(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    	game.setRaiseTurned(message.getName());
    	turn  = game.turnCounter();
    	message.setTurn(turn);
    	//turn = game.setRaiseTurn(message.isRaise(), bol2, bol3)
    	System.out.println("Raise lefutott" + message.getCredit());
    	return message;
    	}
    }
    
    @MessageMapping("/equalCall")
    @SendTo("/topic/user")
    public MessageBean sendEqualCall(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    	//game.setRaiseTurned(message.getName());
    	//turn = game.setRaiseTurn(message.isRaise(), bol2, bol3)
    	game.setTurnedTrue();
    	turn  = game.turnCounter();
    	message.setTurn(turn);
    	return message;
    	}
    }
    
    @MessageMapping("/overCall")
    @SendTo("/topic/user")
    public MessageBean sendOverCall(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    	game.setRaiseTurned(message.getName());
    	message.setTurn(turn);
    	//turn = game.setRaiseTurn(message.isRaise(), bol2, bol3)
    	System.out.println("overCall lefutott" + message.getCredit());
    	return message;}
    }
    
    @MessageMapping("/calledOverRaise")
    @SendTo("/topic/user")
    public MessageBean sendCalledOverRaise(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    		game.setTurnedTrue();
        	turn  = game.turnCounter();
        	message.setTurn(turn);
    	System.out.println("calledOverRaise lefutott" + message.getCredit());
    	return message;}
    }
    
    @MessageMapping("/fold")
    @SendTo("/topic/user")
    public MessageBean sendFold(@Payload MessageBean message) {
    	if (hasDisconnected) {
    		message.setType("otherLeft");
        	return message;
    	}else {
    	game.nullTurn();
    	turn = game.turnCounter();
    	message.setType("Fold");
    	message.setTurn(0);
    	return message;}
    }
    
    public static void removePlayer(String id) {
    	System.out.println("Player is beeing removed: " + "" + id);
    	if (game != null) {
    		game.nullPlayerId(id);
    	}
    }
    public static void setHasDisconnectedToTrue() {
    	hasDisconnected = true;
    }

    private void setHasDisconnectedtoFalse() {
    	hasDisconnected = false;
    }
}
