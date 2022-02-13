package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.Jurist;
import com.example.juristicsupport.repository.JuristReporsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Repository of Jurists
 * <p>
 * (Temporarily DB realization is Map)
 *
 * @author ilyin
 * @since 22.01.2022
 */
@Repository
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class JuristRepositoryImpl implements JuristReporsitory {

    private final EntityManager entityManager;

    @Override
    public Jurist get(UUID id) {
        return entityManager.find(Jurist.class, id);
    }

    @Override
    @Transactional
    public Jurist create(Jurist jurist) {
        entityManager.persist(jurist);
        return jurist;
    }

    @Override
    @Transactional
    public Jurist update(Jurist jurist) {
        return entityManager.merge(jurist);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Jurist jurist = get(id);
        entityManager.remove(jurist);
    }

    public Set<Jurist> getAll() {
        TypedQuery<Jurist> query = entityManager.createQuery("Select j from Jurist j", Jurist.class);
        return new HashSet<>(query.getResultList());
    }

    /*
    // get SQL query (Later)
    // 1 get and 1 merge with status change
    @Transactional
    public Jurist getFreeJurist() {
        List<Jurist> juristList = entityManager.createQuery("Select j from Jurist j", Jurist.class).getResultList();

        for (Jurist jurist : juristList) {
            if (jurist.getBusyStatus() == 0) {
                jurist.setBusyStatus(1);
                entityManager.persist(jurist);
                return jurist;
            }
        }
        return null;
    }
    */
}

