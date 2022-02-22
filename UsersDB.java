package net.integrio.test.db;

import net.integrio.test.db.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDB {

    private User readFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        return user;
    }

    public User getOne(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return readFromResultSet(resultSet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();

            ConnectionPool.closeConnection(connection);

        }
    }


    public List<User> findUsers(String keyword) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login like ?");
            preparedStatement.setString(1, keyword);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                users.add(readFromResultSet(resultSet));
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();

            ConnectionPool.closeConnection(connection);
        }
    }




}
