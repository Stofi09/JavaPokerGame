package com.web.socket.websocket.game;

import org.springframework.stereotype.Component;

@Component
public class BoolContainer {

	private boolean overRaise;
	private boolean callRaise;
	private boolean firstRaise;
	
	public BoolContainer() {
	}
	
	public void setBools(boolean overRaise,boolean callRaise,boolean firstRaise) {
		this.overRaise = overRaise;
		this.callRaise = callRaise;
		this.firstRaise = firstRaise;
	
	}
	public boolean getOverRaise() {
		return this.overRaise;
	}
	public boolean getCallRaise() {
		return this.callRaise;
	}
	public boolean getFirstRaise() {
		return this.firstRaise;
	}
}
