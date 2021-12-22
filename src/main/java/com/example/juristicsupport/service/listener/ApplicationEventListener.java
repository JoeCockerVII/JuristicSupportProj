package com.example.juristicsupport.service.listener;

import com.example.juristicsupport.domain.event.UserCreateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Application listener (only for example)
 *
 * @author ilyin
 * @since 21.12.2021
 */
@Component
public class ApplicationEventListener {

    @EventListener
    public void onEvent(final UserCreateEvent event) {
        System.out.println(event.getEmail());
    }
}
