package com.zipcode.transcurrency.Transcurrency;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Transfer {
    private static final Logger logger = LoggerFactory.getLogger(Transfer.class);

    private BankAccount toBankAccount; //field for instantiating bank account object
    private BigDecimal amount;

    public Transfer(BankAccount toBankAccount, BigDecimal amount) {
        logger.info("Committing transfer to memory.");
        this.toBankAccount = toBankAccount;
        this.amount = amount;
    }

    public void withdraw(BankAccount fromBankAccount) {
        logger.info("withdraw from bank account.");
//        toBankAccount.withdrawal(amount)
        //request money from bank account, or credit card
        //update balance accordingly
    }

    public void deposit() {
        logger.info("deposit to bank account.");
//        toBankAccount.deposit(amount)
        //send money from app to bank account
        //uodate balance
    }

}
