package com.web.socket.websocket.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TurnCounter {

	@Autowired
	private BoolContainer cont;
	
	public TurnCounter() {}
	
	public void setCont(boolean bol1,boolean bol2,boolean bol3) {
		this.cont.setBools(bol1, bol2, bol3);
	}
	
	public boolean isNewTurn() {
		return result();
	}
	private boolean result() {
		if(this.cont.getCallRaise()&&!this.cont.getFirstRaise()&&!this.cont.getOverRaise())	return true;
		else return false;
	}
}
