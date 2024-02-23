package com.tradeflow.impl;

import com.tradeflow.config.DbUtility;
import com.tradeflow.dao.UserDao;
import com.tradeflow.dto.UserDTO;
import com.tradeflow.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    DbUtility dbUtil;

    public UserDaoImpl() {
        dbUtil = new DbUtility();
    }

    @Override
    public boolean createUser(User user) {
        try (PreparedStatement preparedStatement = dbUtil.getConnection().prepareStatement("INSERT INTO users (userId, firstName, lastName, username, phoneNumber, email, password, age) VALUES (?,?,?,?,?,?,?,?)")) {
            preparedStatement.setObject(1, user.getUserId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setInt(8, user.getAge());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public User getUserByUserId(UUID userToSearchId) {
        User user = null;
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement("SELECT * FROM users WHERE userId = ?")) {
            statement.setString(1, String.valueOf(userToSearchId));
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                UUID userId = (UUID) result.getObject("userId");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String username = result.getString("username");
                String email = result.getString("email");
                String phoneNumber = result.getString("phoneNumber");
                String password = result.getString("password");
                int age = result.getInt("age");

                user = new User(userId, firstName, lastName, username, phoneNumber, email, password, age);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;    }

    @Override
    public User getUserByEmail(String userEmail) {
        User user = null;
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement("SELECT * FROM users WHERE email = ?")) {
            statement.setString(1, userEmail);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                UUID userId = (UUID) result.getObject("userId");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String username = result.getString("username");
                String email = result.getString("email");
                String phoneNumber = result.getString("phoneNumber");
                String password = result.getString("password");
                int age = result.getInt("age");

                user = new User(userId, firstName, lastName, username, phoneNumber, email, password, age);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public User getUserByUsername(String userToSearchUsername) {
        User user = null;
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement("SELECT * FROM users WHERE username = ?")) {
            statement.setString(1, userToSearchUsername);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                UUID userId = (UUID) result.getObject("userId");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String username = result.getString("username");
                String email = result.getString("email");
                String phoneNumber = result.getString("phoneNumber");
                String password = result.getString("password");
                int age = result.getInt("age");

                user = new User(userId, firstName, lastName, username, phoneNumber, email, password, age);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public boolean checkUserExistsByUsername(String username) {
        boolean result = false;
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement("SELECT * FROM users WHERE username = ?")) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public boolean checkUserExistsByEmail(String email) {
        boolean result = false;
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement("SELECT * FROM users WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public boolean checkUserExistsById(UUID userId) {
        boolean result = false;
        try (PreparedStatement statement = dbUtil.getConnection().prepareStatement("SELECT * FROM users WHERE userId = ?")) {
            statement.setString(1, String.valueOf(userId));
            ResultSet rs = statement.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

}
