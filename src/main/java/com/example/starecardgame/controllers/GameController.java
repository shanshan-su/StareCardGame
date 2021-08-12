package com.example.starecardgame.controllers;

import com.example.starecardgame.daos.CardsRepository;
import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.Card;
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

    public GameController(UsersRepository usersDao, CardsRepository cardsDao) {
        this.usersDao = usersDao;
        this.cardsDao = cardsDao;
    }

    @GetMapping("/two-people-game")
    public String getTwoPeopleGameTable(Model model) {
        List<Card> cardDeck = cardsDao.findAll();
        Collections.shuffle(cardDeck);

        for (Card card : cardDeck) {
            System.out.println("card.getCardName() = " + card.getCardName());
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
