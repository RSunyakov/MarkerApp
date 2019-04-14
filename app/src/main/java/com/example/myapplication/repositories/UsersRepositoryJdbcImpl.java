package com.example.myapplication.repositories;

import com.example.myapplication.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs) throws SQLException {
            return new User(rs.getString("login"), rs.getString("password"));
        }
    };
    private Connection connection;


    public UsersRepositoryJdbcImpl() {
        String url = "jdbc:postgresql://localhost:5432/markerapp_users";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","postgres");
        try {
            this.connection = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User find(String login, String password) {
        User user = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM users WHERE login = '" + login + "' AND password = '" + password + "'");
            if (resultSet.next()) {
                user = userRowMapper.mapRow(resultSet);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return user;
    }

    @Override
    public User find(Integer id) {return null;}

    @Override
    public void save(User user) {}

    @Override
    public void update(User user) {}

    @Override
    public void delete(User user) {}

    @Override
    public List<User> findAll() {return null;}
}
