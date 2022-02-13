package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.domain.mapper.UserMapper;
import com.example.juristicsupport.repository.UserRepository;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * Model level(business logic)
 * * Service to interact with UserRepository
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User get(UUID id) {
        return userRepository.get(id);
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::update)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
