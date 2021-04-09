package com.web.socket.websocket.game;


public enum Enum_Card {
//Four types of cards: Heart,Diamond,Spade,Club
// Length: Ace 2 3 4 5 6 7 8 9 10 Jack Queen King
	
//Hearts	

H2	(1 ,2 ,1,"2H.png"),
H3	(1 ,3 ,2,"3H.png"),
H4	(1 ,4 ,3,"4H.png"),
H5	(1 ,5 ,4,"5H.png"),
H6	(1 ,6 ,5,"6H.png"),
H7	(1 ,7 ,6,"7H.png"),
H8	(1 ,8 ,7,"8H.png"),
H9	(1 ,9 ,8,"9H.png"),
H10	(1 ,10 ,9,"10H.png"),
HJ	(1 ,11 ,10,"JH.png"),
HQ	(1 ,12 ,11,"QH.png"),
HK	(1 ,13 ,12,"KH.png"),
HA	(1, 14, 13,"AH.png"),

//Diamonds

D2	(2 ,2 ,14,"2D.png"),
D3	(2 ,3 ,15,"3D.png"),
D4	(2 ,4 ,16,"4D.png"),
D5	(2 ,5 ,17,"5D.png"),
D6	(2 ,6 ,18,"6D.png"),
D7	(2 ,7 ,19,"7D.png"),
D8	(2 ,8 ,20,"8D.png"),
D9	(2 ,9 ,21,"9D.png"),
D10	(2 ,10 ,22,"10D.png"),
DJ	(2 ,11 ,23,"JD.png"),
DQ	(2 ,12 ,24,"QD.png"),
DK	(2 ,13 ,25,"KD.png"),
DA	(2, 14, 26,"AD.png"),

//Spades

S2	(3, 2, 27,"2S.png"),
S3	(3 ,3 ,28,"3S.png"),
S4	(3 ,4 ,29,"4S.png"),
S5	(3 ,5 ,30,"5S.png"),
S6	(3 ,6 ,31,"6S.png"),
S7	(3 ,7 ,32,"7S.png"),
S8	(3 ,8 ,33,"8S.png"),
S9	(3 ,9 ,34,"9S.png"),
S10	(3 ,10 ,35,"10S.png"),
SJ	(3 ,11 ,36,"JS.png"),
SQ	(3 ,12 ,37,"QS.png"),
SK	(3 ,13 ,38,"KS.png"),
SA	(3, 14, 39,"AS.png"),

//Clubs

C2	(4 ,2 ,40,"2C.png"),
C3	(4 ,3 ,41,"3C.png"),
C4	(4 ,4 ,42,"4C.png"),
C5	(4 ,5 ,43,"5C.png"),
C6	(4 ,6 ,44,"6C.png"),
C7	(4 ,7 ,45,"7C.png"),
C8	(4 ,8 ,46,"8C.png"),
C9	(4 ,9 ,47,"9C.png"),
C10	(4 ,10 ,48,"10C.png"),
CJ	(4 ,11 ,49,"JC.png"),
CQ	(4 ,12 ,50,"QC.png"),
CK	(4 ,13 ,51,"KC.png"),
CA	(4, 14, 52,"AC.png");

private final int color;
private final int rank;
private final int id;
private final String img;

Enum_Card(int color,int rank,int id,String img){
	this.color = color;
	this.rank  = rank;
	this.id	   = id;
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

}
