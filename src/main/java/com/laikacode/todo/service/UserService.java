package com.laikacode.todo.service;

import com.laikacode.todo.domain.User;
import com.laikacode.todo.repository.UserRepository;
import com.laikacode.todo.service.util.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * <h3>Class for defence services of {@link User} Entity</h3>
 * <p>Implements {@link CrudService}</p>
 * @author Francisco
 */

@Service
@Transactional(readOnly = true)
public class UserService implements CrudService<User, Integer> {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * @param username
     * @param password
     * @return Boolean
     */
    public Boolean login(String username, String password){
        Boolean response = false;
        User user = this.repository.findByUsername(username).orElse(null);

        if(user != null){
            if(user.getPassword().equals(password)){
                response = true;
            }
        }
        return response;
    }

    /**
     * @return List<{@link User}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    public List<User> findAll() { return this.repository.findAll(); }

    /**
     * @param id
     * @return Optional<{@link User}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    public Optional<User> findById(Integer id)
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
     * @param user of the {@link User}
     * @return {@link User}
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public User save(User user)
    {
        return this.repository.save(user);
    }

    /**
     * @implNote Method Transactional
     * @param list of the List<{@link User}>
     * @return List<{@link User}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public List<User> saveAll(List<User> list)
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
     * @param user of the {@link User}
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public void delete(User user)
    {
        this.repository.delete(user);
    }

    /**
     * @implNote Method Transactional
     * @param list of the List<{@link User}>
     * @author Francisco
     * @since 2020/06/27
     */
    @Override
    @Transactional
    public void deleteAll(List<User> list)
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
