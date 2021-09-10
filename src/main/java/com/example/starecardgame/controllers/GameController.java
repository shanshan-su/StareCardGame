package com.example.starecardgame.controllers;

import com.example.starecardgame.daos.CardsRepository;
import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.Card;
import com.example.starecardgame.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class GameController {
    private UsersRepository usersDao;
    private CardsRepository cardsDao;
    private CardService cardService;

    public GameController(UsersRepository usersDao, CardsRepository cardsDao, CardService cardService) {
        this.usersDao = usersDao;
        this.cardsDao = cardsDao;
        this.cardService = cardService;
    }

    @GetMapping("/two-people-game")
    public String getTwoPeopleGameTable(Model model) {
        // wait another player to join in with sockets


        // after the player joins in, shuffle a deck of cards and one person has 6 cards and the other has 5.
        List<Card> player1Cards = cardService.givePlayersCards().get(0);
        List<Card> player2Cards = cardService.givePlayersCards().get(1);
        List<Card> cardDeck = cardService.givePlayersCards().get(2);

        System.out.println("player1");
        System.out.println("player1" + player1Cards.size());
        for (Card card : player1Cards) {
            System.out.println(card.getCardName());
        }

        System.out.println("player2");
        System.out.println("player2" + player2Cards.size());
        for (Card card : player2Cards) {
            System.out.println(card.getCardName());
        }

        System.out.println("the rest");
        System.out.println("the rest" + cardDeck.size());
        for (Card card : cardDeck) {
            System.out.println(card.getCardName());
        }




        model.addAttribute("title", "Two People Game");






        return "game/twoPeopleGame";
    }


    @GetMapping("/three-people-game")
    public String getThreePeopleGameTable(Model model) {
        model.addAttribute("title", "Three People Game");
        return "game/threePeopleGame";
    }
}
