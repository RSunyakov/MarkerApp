package com.example.myapplication.repositories;

import com.example.myapplication.models.User;

public interface UsersRepository extends CrudRepository<User> {
    User find(String login, String password);
}
