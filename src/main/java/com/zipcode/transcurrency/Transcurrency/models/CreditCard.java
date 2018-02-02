package com.zipcode.transcurrency.Transcurrency.models;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
public class CreditCard {
    private static final Logger logger = LoggerFactory.getLogger(CreditCard.class);



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CREDIT_CARD_ID")
    private Long creditCardId;

    @JoinColumn(name = "CARD_NAME")
    private String cardName;
    private int cardNumber;
    private String expDate;
    private int cvv;

    @ManyToOne
    private User user;

    public CreditCard(){

    }

    public CreditCard(String cardName, int cardNumber, String expDate, int cvv){
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;

    }

    public Long getCreditCardId() {
        logger.info("Retrieving CreditCardId.");
        return creditCardId;
    }

    public void setCreditCardId(Long CreditCardId) {
        logger.info("Committing CreditCardId to memory.");
        this.creditCardId = CreditCardId;
    }

    public String getCardName() {
        logger.info("Retrieving cardName.");
        return cardName;
    }

    public void setCardName(String cardName) {
        logger.info("Committing cardName to memory.");
        this.cardName = cardName;
    }

    public int getCardNumber() {
        logger.info("Retrieving cardNumber.");
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        logger.info("Committing cardNumber to memory.");
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        logger.info("Retrieving expDate.");
        return expDate;
    }

    public void setExpDate(String expDate) {
        logger.info("Committing cardNumber to memory.");
        this.expDate = expDate;
    }

    public int getCvv() {
        logger.info("Retrieving cvv.");
        return cvv;
    }

    public void setCvv(int cvv) {
        logger.info("Committing cardNumber to memory.");
        this.cvv = cvv;
    }

    public User getUser() {
        logger.info("Retrieve user.");
        return user;
    }

    public void setUser(User user) {
        logger.info("Committing user to memory.");
        this.user = user;
    }
}
