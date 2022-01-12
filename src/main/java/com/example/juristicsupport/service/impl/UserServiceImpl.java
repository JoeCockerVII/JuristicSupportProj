package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.domain.event.UserCreateEvent;
import com.example.juristicsupport.domain.mapper.UserMapper;
import com.example.juristicsupport.repository.UserRepository;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final UserMapper userMapper;

    @Override
    public User get(UUID id) {
        return userRepository.get(id);
    }

    @Override
    public User create(User user) {
        User created = userRepository.create(user);
        //eventPublisher.publishEvent(UserCreateEvent.builder().email(user.getEmail()).build()); //example
        return created;
    }

    @Override
    public User update(UUID id, User user) {
        return Optional.of(id)
                .map(this::get)
                .map(current -> userMapper.merge(current, user))
                .map(userRepository::create)
                .orElseThrow();
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
