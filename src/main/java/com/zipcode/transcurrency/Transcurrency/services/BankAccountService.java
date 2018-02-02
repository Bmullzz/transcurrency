package com.zipcode.transcurrency.Transcurrency.services;

import com.zipcode.transcurrency.Transcurrency.models.BankAccount;
import com.zipcode.transcurrency.Transcurrency.repositories.BankAccountRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Service
public class BankAccountService {
    private static final Logger logger = LogManager.getLogger(BankAccountService.class);

    private BankAccountRepository bankAccountRepository;



    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        logger.info("Retrieving all bankAccounts.");
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccountRepository.findAll()
                .forEach(bankAccounts::add);
        return bankAccounts;
    }

    public HttpHeaders createBankAccount(BankAccount bankAccount) {
        logger.info("New bankAccount generated.");
        bankAccount = bankAccountRepository.save(bankAccount);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBankAccountURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{bankAccountId}")
                .buildAndExpand(bankAccount.getBankAccountId())
                .toUri();
        responseHeaders.setLocation(newBankAccountURI);

        return responseHeaders;
    }

    public BankAccount getBankAccount(Long bankAccountId){
        logger.info("BankAccount retrieved.");
        return bankAccountRepository.findOne(bankAccountId);
    }

    public BankAccount updateBankAccount(BankAccount bankAccount, Long bankAccountId){
        logger.info("BankAccount info modified.");
        return bankAccountRepository.save(bankAccount);
    }

    public boolean deleteBankAccount(Long bankAccountId){
        logger.info("BankAccount deleted.");
        bankAccountRepository.delete(bankAccountId);
        return true;
    }

}
