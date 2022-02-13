package com.example.juristicsupport.repository.Impl;

import com.example.juristicsupport.domain.entity.Support;
import com.example.juristicsupport.repository.SupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SupportRepositoryImpl implements SupportRepository {

    private final EntityManager entityManager;

    /**
     * Get Support by id
     *
     * @param supportId
     * @return Support Entity
     */
    @Override
    public Support get(Integer supportId) {
        TypedQuery<Support> query = entityManager.createQuery("SELECT s FROM Support s WHERE s.supportId=:supportId", Support.class);
        return query.setParameter("supportId", supportId).getSingleResult();
    }

    /**
     * Get Support by UUID
     *
     * @param id
     * @return Support Entity
     */
    public Support get(UUID id) {
        return entityManager.find(Support.class, id);
    }

    @Override
    @Transactional
    public Support create(Support support) {
        entityManager.persist(support);
        //поле supportID пустое!!!
        return support;
    }

    @Override
    @Transactional
    public Support update(Support support) {
        return entityManager.merge(support);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Support support = get(id);
        entityManager.remove(support);
    }

    //Get all (later)
}
