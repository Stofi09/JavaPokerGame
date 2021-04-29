package com.web.socket.websocket.controller;



import com.web.socket.websocket.bean.MessageBean;
import com.web.socket.websocket.game.Card;
import com.web.socket.websocket.game.Game;
import com.web.socket.websocket.game.Player;
import com.web.socket.websocket.result.Result;
import com.web.socket.websocket.service.EmailService;

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
	
	ArrayList<Card> deck;
	@Autowired
	EmailService em;
	
    @MessageMapping("/Join")
    @SendTo("/topic/user")
    public MessageBean sendToAll(@Payload MessageBean message , @Header("simpSessionId") String sessionId) {
    	setHasDisconnectedtoFalse();
    	System.out.println(sessionId);
    	if(game == null ) {
    		game = new Game();
    	}if (game.getPlayer1() == null) {
    		game.setPlayer(message.getName(),1000,sessionId);
    		message.setId(sessionId);
    		message.setCredit(1000);
    		message.setType("Join");
//    		if (!message.getEmail().equals("")) {
//    			System.out.println("email: "+ message.getEmail());
//        		em.sendMessage(message.getEmail(), message.getName());
//        	}
    	}else if (game.getPlayer2() == null){
    		game.setPlayer(message.getName(),1000,sessionId);
    		message.setOppName(game.getPlayer1().getName());
    		message.setId(sessionId);
    		message.setCredit(1000);
    		message.setOppCredit(1000);
    		message.setType("Join");
//    		if (!message.getEmail().equals("")) {
//    			System.out.println("email: "+ message.getEmail());
//        		em.sendMessage(message.getEmail(), message.getName());
//        	}
    	}else {
    		System.err.println("there are 2 players already");
    		message.setName("There are already two players playing. Please wait until they finish.");
			message.setType("reloadPage");
    	}
    	if (game.getPlayer1() != null && game.getPlayer2() != null) {
    		System.out.println("inside1");
    		if (game.getPlayer1().getName().equals(game.getPlayer2().getName())) {
    			System.out.println("inside2");
    			message.setName("There are already two players playing. Please wait until they finish.");
    			message.setType("reloadPage");
    		}
    	}
    	
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
    	// Null the game turn at the end of the game	
    	game.nullTurn();
    	turn = game.turnCounter();
    	// keep the deck array- just shuffle if its not the first game
    	if (deck == null) {
    	 deck = new ArrayList<>();
    	} 
		deck = Card.makeDeck();
		Collections.shuffle(deck);
		
		// Init player and assign result.
		player = new Player(message.getName());
		this.res.setResult(deck.get(0),deck.get(1),deck.get(4),deck.get(5), deck.get(6), deck.get(7), deck.get(8),player);
		
		player2 = new Player(game.getOpponentName(message.getName()));	
		this.res.setResult(deck.get(2),deck.get(3),deck.get(4),deck.get(5), deck.get(6), deck.get(7), deck.get(8),player2);		
		
		//Compare the two results
		message.setResult(Result.checkWinner(player, player2));
		
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
    
    @MessageMapping("/subscribe")
    @SendTo("/topic/user")
    public MessageBean subscribe(@Payload MessageBean message) {
    	if(!message.getEmail().equals("")) {
    		em.sendMessage(message.getEmail(), message.getName());
    	}
    	message.setType("afterSubscribe");
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
