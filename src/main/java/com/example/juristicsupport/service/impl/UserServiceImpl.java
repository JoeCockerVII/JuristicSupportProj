package com.example.juristicsupport.service.impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.domain.event.UserCreateEvent;
import com.example.juristicsupport.repository.UserRepository;
import com.example.juristicsupport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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
        return userRepository.update(user.withId(id));
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);
    }
}
