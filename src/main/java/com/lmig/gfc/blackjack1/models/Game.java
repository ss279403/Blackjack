package com.lmig.gfc.blackjack1.models;

public class Game {

	private int playerBet;
	private Deck deck;
	private Player player;
	private Dealer dealer;
	private Chips chips;

	public Game() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		chips = new Chips();

		deck.createDeck();
		deck.shuffle();

	}

	public void hitPlayer() {
		Card newCardFromDeck = deck.draw();
		player.accept(newCardFromDeck);
	}

	public void hitDealer() {
		Card newCardFromDeck = deck.draw();
		dealer.accept(newCardFromDeck);

	}


	public void playerStands() {
		while (dealer.getHandTotal() < 17) {
			this.hitDealer();
		}

	}

	public void setUpGame() {
		player.newHand();
		dealer.newHand();
		this.hitPlayer();
		this.hitPlayer();
		this.hitDealer();

	}

	public boolean didPlayerLose() {
		if (player.getHandTotal() > 21 || dealer.getHandTotal() > player.getHandTotal() || player.getHandSize() > 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean didPlayerWin() {
		if (dealer.getHandSize() > 1 && (dealer.getHandTotal() > 21 || player.getHandTotal() > dealer.getHandTotal())) {
			return true;
		} else {
			return false;
		}
	}
	

//	public void payout(int bet) {
//		chips += bet;
		// if (didPlayerLose() == true) {
		// return (chips.getMoney() - playerBet);
		// } else {
		// return (chips.getMoney() + playerBet);
		// }
	

	public void makePlayerBet(int bet) {
		playerBet = bet;
	}

	public int getPlayerBet() {
		return playerBet;
	}

	public void resetGame() {
		player.newHand();
		dealer.newHand();
		this.setUpGame();

	}

}
