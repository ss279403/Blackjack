package com.lmig.gfc.blackjack1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack1.models.Game;


@Controller
public class HomeController {

	private Game game;
	

	public HomeController() {
		game = new Game();

	}

	@GetMapping("/")
	public ModelAndView showBetScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");

		mv.addObject("game", game);
		return mv;
	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {
		game.makePlayerBet(bet);

		game.setUpGame();

		// chips.setMoney(chips.getMoney() - bet);

		ModelAndView mv = new ModelAndView();

		mv.addObject("game", game);
		mv.setViewName("redirect:/play");

		return mv; 
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		
		mv.addObject("game", game);

		return mv;
	}

	@PostMapping("/hit")
	public ModelAndView hitPlayerScreen() {
		ModelAndView mv = new ModelAndView();

		game.hitPlayer();
//		game.payout();

		mv.setViewName("redirect:/play");
		return mv;
	}

	@PostMapping("/stand")
	public ModelAndView hitDealerScreen() {
		ModelAndView mv = new ModelAndView();

		game.playerStands();
	//	game.payout();
		// if game.playerWon()
			// mv.setViewName(playerWON)
			// else { mv.setViewName(playerLost)

		mv.setViewName("redirect:/play");
		return mv;
	}
	
	@PostMapping("/reBet")
	public ModelAndView nextHandScreen() {
		ModelAndView mv = new ModelAndView();
		
		game.resetGame();
	//	game.payout();
		// if game.playerWon()
			// mv.setViewName(playerWON)
			// else { mv.setViewName(playerLost)

		mv.setViewName("redirect:/play");
		return mv;
	}

}
