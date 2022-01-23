package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.Jurist;
import com.example.juristicsupport.repository.JuristReporsitory;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository of Jurists
 * <p>
 * (Temporarily DB realization is Map)
 *
 * @author ilyin
 * @since 22.01.2022
 */

@Repository
public class JuristRepositoryImpl implements JuristReporsitory {

    private static int supportsCount;
    private Map<Jurist, Integer> support;

    {
        support = new HashMap<>();
        support.put(new Jurist("Alex", "Jones", 5), 1);
        support.put(new Jurist("Bruce", "Willis", 15), 0);
        support.put(new Jurist("Thomas", "Jefferson", 7), 0);
    }

    @SneakyThrows
    public Jurist get() {
        for (Map.Entry<Jurist, Integer> jurist : support.entrySet()) {
            if (jurist.getValue() == 0) {
                jurist.setValue(1);
                return jurist.getKey();
            }
        }
        return null;
    }
}

