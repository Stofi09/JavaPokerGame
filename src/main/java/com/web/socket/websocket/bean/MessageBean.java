package com.web.socket.websocket.bean;


public class MessageBean {
    private String name;
    private String oppName;
	private String message;
    private int credit;
    private int oppCredit;
    private int reCall;
    private int oppRaise;
    private int overCall;
    private boolean hasTurned;
	private boolean check;
    private boolean raise;
    private boolean fold;
    private boolean firstRaise;
    private boolean overRaise;
    private boolean callRaise;
    private String type; 
    private int [] cards;
    private int turn;
    private String result;
    private String id;
    



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public int getOppCredit() {
		return oppCredit;
	}

	public void setOppCredit(int oppCredit) {
		this.oppCredit = oppCredit;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isHasTurned() {
		return hasTurned;
	}

	public void setHasTurned(boolean hasTurned) {
		this.hasTurned = hasTurned;
	}

	public int getOppRaise() {
		return oppRaise;
	}

	public void setOppRaise(int oppRaise) {
		this.oppRaise = oppRaise;
	}
    
    public int getOverCall() {
		return overCall;
	}

	public void setOverCall(int overCall) {
		this.overCall = overCall;
	}

	public int getReCall() {
		return reCall;
	}

	public void setReCall(int reCall) {
		this.reCall = reCall;
	}

	public boolean isFirstRaise() {
		return firstRaise;
	}

	public void setFirstRaise(boolean firstRaise) {
		this.firstRaise = firstRaise;
	}

	public boolean isOverRaise() {
		return overRaise;
	}

	public void setOverRaise(boolean overRaise) {
		this.overRaise = overRaise;
	}

	public boolean isCallRaise() {
		return callRaise;
	}

	public void setCallRaise(boolean callRaise) {
		this.callRaise = callRaise;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int[] getCards() {
		return cards;
	}

	public void setCards(int[] cards) {
		this.cards = cards;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOppName() {
 		return oppName;
 	}

 	public void setOppName(String oppName) {
 		this.oppName = oppName;
 	}


	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public boolean isRaise() {
		return raise;
	}

	public void setRaise(boolean raise) {
		this.raise = raise;
	}

	public boolean isFold() {
		return fold;
	}

	public void setFold(boolean fold) {
		this.fold = fold;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getBean() {
		return this.name + "" + this.oppName;
	}
}
