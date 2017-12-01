package com.lmig.gfc.blackjack1.models;

public class AceCard extends Card {


	public AceCard(Suit suit) {
		super(suit);

	}
  
	@Override
	public String getRank() {

		return "ACE";
	}
 
	@Override 
	public int getValue() {

		return 11;
	}

}
