package com.example.juristicsupport.service;

import com.example.juristicsupport.domain.entity.User;

import java.util.UUID;

public interface UserService {

    User get(UUID id);

    User create(User userJson);

    User update(UUID id, User userJson);

    void delete(UUID id);
}
