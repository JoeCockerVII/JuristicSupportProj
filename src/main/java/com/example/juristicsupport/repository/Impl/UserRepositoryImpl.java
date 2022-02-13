package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Override
    public User get(UUID id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        User user = get(id);
        entityManager.remove(user);
    }
}
