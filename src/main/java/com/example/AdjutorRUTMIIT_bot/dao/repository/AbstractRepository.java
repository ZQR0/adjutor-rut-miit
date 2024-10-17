package com.example.AdjutorRUTMIIT_bot.dao.repository;

import com.example.AdjutorRUTMIIT_bot.dao.entity.AbstractEntity;

import java.util.Optional;

/**
 * Интерфейс, в котором написаны базовые методы для каждого репозитория в будущем.
 * Методы НЕ МЕНЯТЬ, НИЧЕГО БЛЯДЬ ВООБЩЕ НЕ ТРОГАТЬ БЕЗ МОЕГО ВЕДОМА.
 * С уважением, Ярик.
 * */
public interface AbstractRepository<T extends AbstractEntity<ID>, ID> {
    Optional<T> findById(ID id);
    T save(T t);
    T safeDeleteById(ID id);
}
