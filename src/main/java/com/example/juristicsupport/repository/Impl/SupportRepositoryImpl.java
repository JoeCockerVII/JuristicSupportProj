package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.repository.SupportRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository to work with Support Types
 * <p>
 * (Temporarily DB realization is Map)
 *
 * @author ilyin
 * @since 14.01.2022
 */

@Repository
//@RequiredArgsConstructor
public class SupportRepositoryImpl implements SupportRepository {
    private static int supportsCount;
    private final Map<Integer, Support> support;

    {
        support = new HashMap<>();
        support.put(++supportsCount, new Support(
                supportsCount, "Various documents prepeartion assistance", 800));
        support.put(++supportsCount, new Support(
                supportsCount, "Сonsultation in various areas of law", 800));
        support.put(++supportsCount, new Support(
                supportsCount, "Juristic representation in court", 2500));
        support.put(++supportsCount, new Support(
                supportsCount, "Registration of individual entrepreneurs and LLC", 1000));
        support.put(++supportsCount, new Support(
                supportsCount, "Juristic support of the client's business", 1500));
        support.put(++supportsCount, new Support(
                supportsCount, "Juristic support of immovable transactions", 1500));
    }

    public Support get(Integer id) {
        return support.get(id);
    }

    public Map<Integer, Support> getAll() {
        return support;
    }
}

