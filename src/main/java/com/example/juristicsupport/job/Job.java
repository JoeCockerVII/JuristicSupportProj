package com.example.juristicsupport.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ilyin
 * @since 03.01.2022
 */
@Component
public class Job {

    @Scheduled(cron = "*/10 * * * * *")
    public void job() {
        System.out.println(LocalDateTime.now() + "Test_Message");
    }
}
