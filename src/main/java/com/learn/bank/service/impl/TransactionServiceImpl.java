package com.learn.bank.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.bank.entity.Transaction;
import com.learn.bank.entity.Type;
import com.learn.bank.service.TransactionService;

/**
 * @author wateroader
 * @date 2021/09/25
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<Transaction> findAllByAccountNumber(Integer accountNumber) {
        return List.of(
                Transaction
                        .builder()
                        .type(Type.CHEESE)
                        .date(new Date().toString())
                        .accountNumber(accountNumber)
                        .currency("USD")
                        .amount(100.00)
                        .merchantName("acme")
                        .merchantLogo("images/acme-logo.png")
                        .build()
        );
    }
}
