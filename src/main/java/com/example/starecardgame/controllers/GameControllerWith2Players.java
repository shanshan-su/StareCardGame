package com.example.starecardgame.controllers;

import com.example.starecardgame.daos.CardsRepository;
import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.Card;
import com.example.starecardgame.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GameControllerWith2Players {
    private UsersRepository usersDao;
    private CardsRepository cardsDao;
    private CardService cardService;

    public GameControllerWith2Players(UsersRepository usersDao, CardsRepository cardsDao, CardService cardService) {
        this.usersDao = usersDao;
        this.cardsDao = cardsDao;
        this.cardService = cardService;
    }

    @GetMapping("/two-people-game")
    public String getTwoPeopleGameTable(Model model) {
        // wait another player to join in with sockets


        // after the player joins in, shuffle a deck of cards and one person has 6 cards and the other has 5.
        List<Card> player1Cards = cardService.dealCardsWith2players().get(0);
        List<Card> player2Cards = cardService.dealCardsWith2players().get(1);
        List<Card> cardDeck = cardService.dealCardsWith2players().get(2);

        model.addAttribute("title", "Two People Game");
        model.addAttribute("player1Cards", player1Cards);
        model.addAttribute("player2Cards", player2Cards);
        model.addAttribute("cardDeck", cardDeck);

        return "game/twoPeopleGame";
    }

    @PostMapping("/two-people-game/play")
    public String playCard(Model model) {
        // player1 plays a card(number), two same cards(two same number) or 3 cards(like 3, 4, 5) and player2 can follow with a card(number + 1), two same cards(two number + 1) or 3 cards (like 4, 5, 6), otherwise, pass



        model.addAttribute("title", "Two People Game");
//        model.addAttribute("player1Cards", player1Cards);
//        model.addAttribute("player2Cards", player2Cards);
//        model.addAttribute("cardDeck", cardDeck);

        return "game/twoPeopleGame";
    }
}
