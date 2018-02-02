package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.repositories.CreditCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Service
public class CreditCardService {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardService.class);


    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        logger.info("Committing creditCardRepository to memory.");
        this.creditCardRepository = creditCardRepository;
    }


    public List<CreditCard> getAllCreditCards() {
        logger.info("Retrieving all creditCards.");
        List<CreditCard> creditCards = new ArrayList<>();
        creditCardRepository.findAll()
                .forEach(creditCards::add);
        return creditCards;
    }

    //creates a credit card
    public HttpHeaders createCreditCard(CreditCard creditCard) {
        logger.info("New creditCard generated.");
        creditCard = creditCardRepository.save(creditCard);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCreditCardURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{creditCardId}")
                .buildAndExpand(creditCard.getCreditCardId())
                .toUri();
        responseHeaders.setLocation(newCreditCardURI);

        return responseHeaders;
    }

    //gets a single credit card
    public CreditCard getCreditCard(Long creditCardId) {
        logger.info("CreditCard retrieved.");
        return creditCardRepository.findOne(creditCardId);
    }

    //updates credit card info
    public CreditCard updateCreditCard(CreditCard creditCard, Long creditCardId) {
        logger.info("CreditCard info modified.");
        return creditCardRepository.save(creditCard);
    }

    //deletes a credit card
    public Boolean deleteCreditCard(Long creditCardId) {
        logger.info("CreditCard deleted.");
        creditCardRepository.delete(creditCardId);
        return true;
    }

}
