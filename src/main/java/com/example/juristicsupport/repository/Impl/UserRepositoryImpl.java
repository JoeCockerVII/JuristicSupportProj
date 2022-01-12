package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.User;
import com.example.juristicsupport.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * Repository to work with User data storage
 *
 * @author ilyin
 * @since 18.12.2021
 */

@Repository
//@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final ObjectMapper objectMapper;
    private final File file;
    private final Path path;

    @SneakyThrows
    public UserRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        path = Path.of("F:/Dropbox/prog/orion/PetProjects/JuristicSupport/database.json");
        if (!Files.exists(path)) {
            Files.createFile(path);
            Files.writeString(path, "{}");
        }
        this.file = new File(path.toUri());
    }

    public User get(UUID id) {
        return findAll().get(id);
    }

    @SneakyThrows
    public User create(User user) {
        Map<UUID, User> content = findAll();
        UUID id = randomUUID();
        content.put(id, user);
        Files.writeString(path, objectMapper.writeValueAsString(content));
        return findAll().get(id);
    }

    @SneakyThrows
    public User update(User user) {
        Map<UUID, User> content = findAll();
        UUID id = user.getId();
        content.put(id, user);
        Files.writeString(path, objectMapper.writeValueAsString(content));
        return findAll().get(id);
    }

    @SneakyThrows
    public void delete(UUID id) {
        Map<UUID, User> content = findAll();
        content.remove(id);
        Files.writeString(path, objectMapper.writeValueAsString(content));
    }

    @SneakyThrows
    private Map<UUID, User> findAll() {
        return objectMapper.readValue(file, new TypeReference<>() {
        });
    }
}
