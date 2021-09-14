package com.example.starecardgame.models;

import javax.persistence.*;

@Entity
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String cardValue;

    @Column
    private String imgUrl;

    public Card() {
    }

    public Card(long id, String cardName, String cardValue, String imgUrl) {
        this.id = id;
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.imgUrl = imgUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
