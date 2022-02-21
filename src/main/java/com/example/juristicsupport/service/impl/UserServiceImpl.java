package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.domain.mapper.UserMapper;
import com.example.juristicsupport.repository.UserRepository;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * Service to work with UserRepository
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Service
@Primary
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User get(UUID id) {
        User result = userRepository.getById(id);
        Hibernate.initialize(result);
        return result;
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::save)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
