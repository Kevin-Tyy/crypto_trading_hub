package com.tradeflow.utils;

import com.tradeflow.impl.UserDaoImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class UserUtil {
    // Static method to generate a username
    public static String generateUsername(String firstName, String lastName) {
        // Convert first name and last name to lowercase and concatenate with '_'
        String baseUsername = (firstName.toLowerCase() + "_" + lastName.toLowerCase()).replaceAll("\\s+", "_");

        // Generate a random 3-digit number
        Random rand = new Random();
        int randomDigits = rand.nextInt(900) + 100;

        // Append the random number to the username
        String username = baseUsername + randomDigits;

        // Check if the generated username already exists in the database
        // If it does, append incremental numbers until a unique username is found
        int counter = 1;
        while (new UserDaoImpl().checkUserExistsByUsername(username)) {
            username = baseUsername + randomDigits + counter;
            counter++;
        }

        return username;
    }

    public static int calculateAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dob, currentDate).getYears();
    }

    public static UUID genereteUUID() {
        return UUID.randomUUID();
    }

}
