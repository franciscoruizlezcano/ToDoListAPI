package com.laikacode.todo.service;

import com.laikacode.todo.domain.Task;
import com.laikacode.todo.repository.TaskRepository;
import com.laikacode.todo.service.util.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <h3>Class for defence services of {@link Task} Entity</h3>
 * <p>Implements {@link CrudService}</p>
 * @author Francisco
 */

@Service
@Transactional(readOnly = true)
public class TaskService implements CrudService<Task, Integer> {

    @Autowired
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    /**
     * @return List<{@link Task}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    public List<Task> findAll() { return this.repository.findAll(); }

    /**
     * @param id
     * @return Optional<{@link Task}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    public Optional<Task> findById(Integer id)
    {
        return this.repository.findById(id);
    }

    /**
     * @param id
     * @return {@link boolean}
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    public boolean existsById(Integer id)
    {
        return this.repository.existsById(id);
    }

    /**
     * @return {@link long}
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    public long count()
    {
        return this.repository.count();
    }

    /**
     * @implNote Method Transactional
     * @param task of the {@link Task}
     * @return {@link Task}
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public Task save(Task task)
    {
        return this.repository.save(task);
    }

    /**
     * @implNote Method Transactional
     * @param list of the List<{@link Task}>
     * @return List<{@link Task}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public List<Task> saveAll(List<Task> list)
    {
        return this.repository.saveAll(list);
    }

    /**
     * @implNote Method Transactional
     * @param id
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public void deleteById(Integer id) { this.repository.deleteById(id); }

    /**
     * @implNote Method Transactional
     * @param task of the {@link Task}
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public void delete(Task task)
    {
        this.repository.delete(task);
    }

    /**
     * @implNote Method Transactional
     * @param list of the List<{@link Task}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public void deleteAll(List<Task> list)
    {
        this.repository.deleteAll(list);
    }

    /**
     * @implNote Method Transactional
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public void deleteAll()
    {
        this.repository.deleteAll();
    }
}
