package com.learn.bank.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bank.entity.Transaction;
import com.learn.bank.entity.TransactionDTO;
import com.learn.bank.service.TransactionService;

/**
 * transactionController
 *
 * @author wateroader
 * @date 2021/09/25
 */
@RestController
@RequestMapping(path = "/transactions", produces = "application/json")
@CrossOrigin(origins = "*")
public class TransactionController {
    final TransactionService transactionService;

    private final ModelMapper modelMapper;

    public TransactionController(TransactionService transactionService, ModelMapper modelMapper) {
        this.transactionService = transactionService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{accountNumber}")
    public List<TransactionDTO> listTransaction(@PathVariable("accountNumber") String accountNumber) {
        List<Transaction> transactions = transactionService.findAllByAccountNumber(accountNumber);
        return transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
        return transactionDTO;
    }

    private Transaction convertToEntity(TransactionDTO transactionDTO) {
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
        return transaction;

    }

}
