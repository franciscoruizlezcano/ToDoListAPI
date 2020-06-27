package com.laikacode.todo.service.util;

import java.util.List;
import java.util.Optional;

/**
 * <h3>Interface with crud methods</h3>
 * @param <T> extension of {@link Object}
 * @param <ID> extension of {@link Object}
 * @author Francisco
 * @Since 2020/06/27
 * */

public interface CrudService<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    long count();

    T save(T t);

    List<T> saveAll(List<T> list);

    void deleteById(ID id);

    void delete(T t);

    void deleteAll(List<T> list);

    void deleteAll();

}
