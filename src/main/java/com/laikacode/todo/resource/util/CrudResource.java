package com.laikacode.todo.resource.util;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * <h3>Interface with crud methods</h3>
 * @param <D> extension of {@link Object} and is DTO
 * @param <ID> extension of {@link Object}
 * @author Francisco
 * @Since 2020/06/27
 * */

public interface CrudResource<D, ID> {
    ResponseEntity<List<D>> findAll();

    ResponseEntity<D> findById(ID id);

    ResponseEntity<D> save(D d);

    ResponseEntity<D> update(ID id, D d);

    ResponseEntity<HashMap<String, Boolean>> delete(ID id);

}
