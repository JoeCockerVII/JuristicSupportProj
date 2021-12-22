package com.example.juristicsupport.repository;

import com.example.juristicsupport.domain.entity.User;

import java.util.UUID;

public interface UserRepository {
    User get(UUID id);

    User create(User user);

    User update(User user);

    void delete(UUID id);
}
