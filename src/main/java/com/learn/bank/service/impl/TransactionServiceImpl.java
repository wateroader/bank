package com.learn.bank.service.impl;


import com.learn.bank.entity.Transaction;
import com.learn.bank.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wateroader
 * @date 2021/09/25
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public List<Transaction> findAllByAccountNumber(String accountNumber) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        return transactions;
    }
}
