package com.example.starecardgame.services;

import com.example.starecardgame.daos.CardsRepository;
import com.example.starecardgame.models.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CardService {
    private final CardsRepository cardsDao;

    public CardService(CardsRepository cardsDao) {
        this.cardsDao = cardsDao;
    }

    public List<List<Card>> givePlayersCards (){
        // get the cards from db and shuffle
        List<Card> cardDeck = cardsDao.findAll();
        Collections.shuffle(cardDeck);

        List<Card> playerCardsDeck1 = new ArrayList<>();
        List<Card> playerCardsDeck2 = new ArrayList<>();

        // pass 6 cards to player1 and 5 cards to player2 and remove the 11 cards from cardDeck
        for (int i = 10; i >= 0; i--) {
            if (i % 2 == 0) {
                playerCardsDeck1.add(cardDeck.get(i));
            } else {
                playerCardsDeck2.add(cardDeck.get(i));
            }

            cardDeck.remove(i);
        }

        // return player1 with 6 cards, player2 with 5 cards and the rest of the cards
        return new ArrayList<>(Arrays.asList(
                playerCardsDeck1, playerCardsDeck2, cardDeck
        ));

    }
}
