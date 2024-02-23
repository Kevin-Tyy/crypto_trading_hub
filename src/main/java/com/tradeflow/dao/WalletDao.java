package com.tradeflow.dao;

import com.tradeflow.models.Wallet;

import java.util.UUID;

public interface WalletDao {
    boolean createWallet (Wallet wallet);

    Wallet getWalletByUserId (UUID userId);
}
