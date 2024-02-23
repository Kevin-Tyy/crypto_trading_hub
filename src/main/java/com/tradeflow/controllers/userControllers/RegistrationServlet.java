package com.tradeflow.controllers.userControllers;

import com.tradeflow.dao.UserDao;
import com.tradeflow.dao.WalletDao;
import com.tradeflow.impl.UserDaoImpl;
import com.tradeflow.impl.WalletDaoImpl;
import com.tradeflow.models.Transaction;
import com.tradeflow.models.User;
import com.tradeflow.models.Wallet;
import com.tradeflow.utils.PasswordHasher;
import com.tradeflow.utils.UserUtil;
import com.tradeflow.utils.Validator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userDao = new UserDaoImpl();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve registration form parameters

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = PasswordHasher.hashPassword(request.getParameter("password"));
        String phoneNumber = request.getParameter("phoneNumber");
        int age = UserUtil.calculateAge(LocalDate.parse(request.getParameter("dob")));
        UUID userId = UserUtil.genereteUUID();

        boolean isValidPassword = Validator.isValidPassword(password);
        boolean isEmailValid = Validator.isValidEmail(email);
        boolean isPhoneNumberValid = Validator.isValidPhoneNumber(String.valueOf(phoneNumber));

        if (isEmailValid && isValidPassword && isPhoneNumberValid) {
            String username = UserUtil.generateUsername(firstName, lastName);

            if (!userDao.checkUserExistsById(userId) && !userDao.checkUserExistsByEmail(email) && !userDao.checkUserExistsByUsername(username)) {
                User newUser = new User(userId, firstName, lastName, username, phoneNumber, email, password, age);
                boolean result = userDao.createUser(newUser);
                if (result) {

                    // Create a new wallet for the user
                    Wallet userWallet = new Wallet(UUID.randomUUID(), newUser, 0.0, new ArrayList<>()); // Generate a UUID for the wallet

                    WalletDao walletDao = new WalletDaoImpl();
                    boolean walletCreationSuccess = walletDao.createWallet(userWallet);
                    if (walletCreationSuccess) {
                        request.setAttribute("message", "Your account has been created, you can now login into you account using your credentials");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        response.sendRedirect("login.jsp");
                    } else response.getWriter().println("An error occurred setting up your online wallet. Please try again");
                } else response.getWriter().println("An error occurred. Please try again");
            }

        } else {
            if (!isValidPassword) {
                assert password != null;
                List<String> errorMessages = Validator.validatePassword(password);
                request.setAttribute("errorMessages", errorMessages);
            }
            if (!isPhoneNumberValid) {
                request.setAttribute("phoneNumberError", "Invalid phone number format");
            }
            List<String> emailErrors = new ArrayList<>();
            if (!isEmailValid) emailErrors.add("The email format is Invalid");
            if (this.userDao.checkUserExistsByEmail(email)) emailErrors.add("The email is already taken");
            request.setAttribute("emailErrors", emailErrors);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the registration form JSP page
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
