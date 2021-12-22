package com.example.juristicsupport.domain.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * User event - email (only for example)
 *
 * @author ilyin
 * @since 21.12.2021
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class UserCreateEvent {
    String email;
}
