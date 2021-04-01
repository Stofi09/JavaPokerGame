package com.web.socket.websocket.controller;



import com.web.socket.websocket.bean.MessageBean;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
	
	private static int turn = 0;
	
	private static boolean hasDisconnected = false;
	
    
    @MessageMapping("/sendback")
    @SendTo("/topic/user")
    public MessageBean sendthat(@Payload MessageBean message) {
    	message.setType("sikerult");
    	return message;
    }
   
    
    public static void setHasDisconnectedToTrue() {
    	hasDisconnected = true;
    }

    private void setHasDisconnectedtoFalse() {
    	hasDisconnected = false;
    }
}
