package com.zipcode.transcurrency.Transcurrency.controllers;


import com.zipcode.transcurrency.Transcurrency.models.CreditCard;
import com.zipcode.transcurrency.Transcurrency.services.CreditCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CreditCardController {
    private final Logger LOG = LoggerFactory.getLogger(CreditCardController.class);

    private CreditCardService creditCardService;

    public CreditCardController() {

    }

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    //gets all the credit cards
    @RequestMapping(value = "/creditCards", method = RequestMethod.GET)
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        LOG.info("gets all the credit cards");
        return new ResponseEntity<>(creditCardService.getAllCreditCards(), HttpStatus.OK);
    }

    //creates credit cards
    @RequestMapping(value = "/creditCards", method = RequestMethod.POST)
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCard creditCard) {
        LOG.info("creates credit cards");
        return new ResponseEntity<>(null, creditCardService.createCreditCard(creditCard), HttpStatus.CREATED);
    }

    //gets a credit card
    @RequestMapping(value = "/creditCards/{creditCardId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCreditCard(@PathVariable Long creditCardId) {
        LOG.info("gets a credit card");
        return new ResponseEntity<>(creditCardService.getCreditCard(creditCardId), HttpStatus.OK);
    }

    //update a credit card. May not be needed
    @RequestMapping(value = "/creditCards/{creditCardId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable Long creditCardId) {
        LOG.info("update a credit card.");
        return new ResponseEntity<>(creditCardService.updateCreditCard(creditCard, creditCardId), HttpStatus.OK);
    }

    //delete a credit card
    @RequestMapping(value = "/creditCards/{creditCardId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCreditCard(@PathVariable Long creditCardId) {
        LOG.info("delete a credit card");
        return new ResponseEntity<>(creditCardService.deleteCreditCard(creditCardId), HttpStatus.OK);
    }

}
