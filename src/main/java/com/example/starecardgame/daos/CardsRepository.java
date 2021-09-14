package com.example.starecardgame.daos;

import com.example.starecardgame.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Card, Long> {
    Card getByCardName(String playedCard);
}
