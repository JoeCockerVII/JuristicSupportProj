package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Test empty Service(do Nothing)
 *
 * @author ilyin
 * @since 20.12.2021
 */

@Service
public class UserServiceStub implements UserService {

    @Override
    public User get(UUID id) {
        return null;
    }

    @Override
    public User create(User userJson) {
        return null;
    }

    @Override
    public User update(UUID id, User userJson) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
