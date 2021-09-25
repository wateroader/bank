package com.learn.bank.service;



import java.util.List;

import com.learn.bank.entity.Transaction;

public interface TransactionService {
    List<Transaction> findAllByAccountNumber(Integer accountNumber);
}
