package com.tradeflow.dao;

import com.tradeflow.dto.TransactionDTO;
import com.tradeflow.models.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionDao {
    boolean createTransaction (TransactionDTO transaction);
    List<Transaction> getTransactionsByWalletId(UUID walletId);

}
