package com.tradeflow.controllers.transactionControllers;

import com.tradeflow.dao.TransactionDao;
import com.tradeflow.impl.TransactionDaoImpl;
import com.tradeflow.models.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/walletTransactions")
public class TransactionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId"); // Assuming userId is passed as a request parameter

        if (userId != null && !userId.isEmpty()) {
            try {
                // Call your DAO method to retrieve transactions for the user
                TransactionDao transactionDao = new TransactionDaoImpl(); // Initialize your TransactionDao
                List<Transaction> transactions = transactionDao.getTransactionsByWalletId(UUID.fromString(userId));

                // Set transactions as an attribute in the request to be accessed in JSP
                request.setAttribute("transactions", transactions);

                // Forward the request to a JSP to display the transactions
                request.getRequestDispatcher("wallet.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace(); // Handle exceptions appropriately
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to retrieve transactions");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing userId parameter");
        }
    }
}
