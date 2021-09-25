package com.learn.bank;


import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.learn.bank.entity.Transaction;
import com.learn.bank.entity.TransactionDTO;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoUnitTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    void whenConvertTransactionEntityToTransactionDTO_thenCorrect() {
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(randomAlphabetic(6));
        transaction.setMerchantName("www.test.com");

        TransactionDTO transactionDto = modelMapper.map(transaction, TransactionDTO.class);
        assertEquals(transaction.getAccountNumber(), transactionDto.getAccountNumber());
        assertEquals(transaction.getMerchantName(), transactionDto.getMerchantName());
    }

    @Test
    void whenConvertTransactionDTOToTransactionEntity_thenCorrect() {
        TransactionDTO transactionDto = new TransactionDTO();
        transactionDto.setAccountNumber(randomAlphabetic(6));
        transactionDto.setMerchantName("www.test.com");

        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        assertEquals(transactionDto.getAccountNumber(), transaction.getAccountNumber());
        assertEquals(transactionDto.getMerchantName(), transaction.getMerchantName());
    }
}
