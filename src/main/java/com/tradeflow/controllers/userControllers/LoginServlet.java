package com.tradeflow.controllers.userControllers;

import com.tradeflow.dao.UserDao;
import com.tradeflow.impl.TransactionDaoImpl;
import com.tradeflow.impl.UserDaoImpl;
import com.tradeflow.impl.WalletDaoImpl;
import com.tradeflow.models.Transaction;
import com.tradeflow.models.User;
import com.tradeflow.models.Wallet;
import com.tradeflow.utils.PasswordHasher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.getUserByEmail(email);

            if (user != null) {
                if (PasswordHasher.verifyPassword(password, user.getPassword())) {

                    Wallet wallet = new WalletDaoImpl().getWalletByUserId(user.getUserId());
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("wallet", wallet);
                    System.out.println("Boom");
                    response.sendRedirect("dashboard.jsp");

                } else {
                    String message = "Invalid username or password";
                    request.setAttribute("error", message);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else {
                String message = "User not found, Create a new account instead";
                request.setAttribute("error", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.removeAttribute("error");
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
