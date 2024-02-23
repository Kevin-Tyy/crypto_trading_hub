package com.tradeflow.impl;

import com.tradeflow.dao.TransactionDao;
import com.tradeflow.dto.TransactionDTO;
import com.tradeflow.models.Transaction;

import java.util.List;
import java.util.UUID;

public class TransactionDaoImpl implements TransactionDao {

    @Override
    public boolean createTransaction(TransactionDTO transaction) {
        return false;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(UUID walletId) {
        return null;
    }
}
