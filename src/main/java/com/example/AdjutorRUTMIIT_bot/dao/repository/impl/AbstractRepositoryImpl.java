package com.example.AdjutorRUTMIIT_bot.dao.repository.impl;

import com.example.AdjutorRUTMIIT_bot.dao.entity.AbstractEntity;
import com.example.AdjutorRUTMIIT_bot.dao.repository.AbstractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@NoRepositoryBean
public class AbstractRepositoryImpl<T extends AbstractEntity<ID>, ID> implements AbstractRepository<T, ID> {


    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public AbstractRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Optional<T> findById(ID id) {
        T entity = entityManager.find(entityClass, id);
        if (entity == null) {
            return Optional.empty();
        }

        return Optional.of(entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED) // не менять
    public T save(T entity) {
        if (!this.entityManager.contains(entity)) {
            this.entityManager.persist(entity);
            return entity;
        } else {
            return this.entityManager.merge(entity);
        }
    }

    @Override
    public T safeDeleteById(ID id) {
        Optional<T> optEntity = this.findById(id);
        if (optEntity.isPresent()) {
            T entity = optEntity.get();
            if (!entity.isDeleted()) {
                entity.setIsDeleted(true);
                entityManager.merge(entity);
            }
        }

        return optEntity.get();
    }
}
