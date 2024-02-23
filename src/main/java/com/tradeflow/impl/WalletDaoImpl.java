package com.tradeflow.impl;

import com.tradeflow.config.DbUtility;
import com.tradeflow.dao.WalletDao;
import com.tradeflow.models.Transaction;
import com.tradeflow.models.User;
import com.tradeflow.models.Wallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class WalletDaoImpl implements WalletDao {

    DbUtility dbUtil;
    private static final String SELECT_WALLET_BY_USER_ID = "SELECT * FROM Wallet WHERE userId = ?";


    public WalletDaoImpl() {
        dbUtil = new DbUtility();
    }

    @Override
    public boolean createWallet(Wallet wallet) {
        try (PreparedStatement preparedStatement = dbUtil.getConnection().prepareStatement("INSERT INTO wallets (walletAddress, userId, balance) VALUES (?,?,?)")) {
            preparedStatement.setObject(1, wallet.getWalletAddress());
            preparedStatement.setObject(2, wallet.getUser().getUserId());
            preparedStatement.setDouble(3, wallet.getBalance());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Wallet getWalletByUserId(UUID userId) {
        Wallet wallet = null;
        List<Transaction> transactions = null;

        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement(SELECT_WALLET_BY_USER_ID)) {
            statement.setObject(1, userId); // Set the user ID parameter
            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                // Retrieve wallet details from the result set
                UUID walletAddress = UUID.fromString(resultSet.getString("walletAddress"));
                double balance = resultSet.getDouble("balance");

                User user = new UserDaoImpl().getUserByUserId(userId);
                // Create the wallet object
                transactions = new TransactionDaoImpl().getTransactionsByWalletId(walletAddress);
                wallet = new Wallet(walletAddress, user, balance, transactions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wallet;
    }
}
