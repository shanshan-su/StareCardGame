package com.example.starecardgame.services;

import com.example.starecardgame.daos.CardsRepository;
import com.example.starecardgame.models.Card;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

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

    public List<List<Card>> dealCardsWith2players() {
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

    public List<List<Card>> dealCardsWith3players() {
        // get the cards from db and shuffle
        List<Card> cardDeck = cardsDao.findAll();
        cardDeck.addAll(cardsDao.findAll());
        Collections.shuffle(cardDeck);
        System.out.println("cardDeck.size() = " + cardDeck.size());

        List<Card> playerCardsDeck1 = new ArrayList<>();
        List<Card> playerCardsDeck2 = new ArrayList<>();
        List<Card> playerCardsDeck3 = new ArrayList<>();

        // pass 6 cards to player1 and 5 cards to player2 and player3 and remove the 16 cards from cardDeck
        for (int i = 15; i >= 0; i--) {
            if (i % 3 == 0) {
                playerCardsDeck1.add(cardDeck.get(i));
            } else if (i % 3 == 1) {
                playerCardsDeck2.add(cardDeck.get(i));
            } else {
                playerCardsDeck3.add(cardDeck.get(i));
            }
            cardDeck.remove(i);
        }

        return new ArrayList<>(Arrays.asList(
                playerCardsDeck1, playerCardsDeck2, playerCardsDeck3, cardDeck
        ));
    }

    public List<List<Card>> playOneHand(List<String> playedCards, List<Card> player1Cards) {
        // player1 plays a card(number), two same cards(two same number) or 3 cards(like 3, 4, 5) and player2 can follow with a card(number + 1), two same cards(two number + 1) or 3 cards (like 4, 5, 6), otherwise, pass
        List<Card> playedCardsList = new ArrayList<>();
        for (String playedCard : playedCards) {
            playedCardsList.add(cardsDao.getByCardName(playedCard));

            player1Cards.remove(cardsDao.getByCardName(playedCard));
        }


        return new ArrayList<>(Arrays.asList(playedCardsList, player1Cards));
    }






}
