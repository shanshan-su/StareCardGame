package com.example.starecardgame.controllers;

import com.example.starecardgame.daos.CardsRepository;
import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.Card;
import com.example.starecardgame.services.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameControllerWith3Players {
    private UsersRepository usersDao;
    private CardsRepository cardsDao;
    private CardService cardService;

    public GameControllerWith3Players(UsersRepository usersDao, CardsRepository cardsDao, CardService cardService) {
        this.usersDao = usersDao;
        this.cardsDao = cardsDao;
        this.cardService = cardService;
    }

    @GetMapping("/three-people-game")
    public String getThreePeopleGameTable(Model model) {
        // wait another player to join in with sockets


        // after the player joins in, shuffle a deck of cards and one person has 6 cards and the other has 5.
        List<Card> player1Cards = cardService.dealCardsWith3players().get(0);
        List<Card> player2Cards = cardService.dealCardsWith3players().get(1);
        List<Card> player3Cards = cardService.dealCardsWith3players().get(2);
        List<Card> cardDeck = cardService.dealCardsWith3players().get(3);

        System.out.println("player1");
        System.out.println("player1" + player1Cards.size());


        System.out.println("player2");
        System.out.println("player2" + player2Cards.size());


        System.out.println("player3");
        System.out.println("player3" + player3Cards.size());

        System.out.println("the rest");
        System.out.println("the rest" + cardDeck.size());







        model.addAttribute("title", "Three People Game");
        return "game/threePeopleGame";
    }
}
