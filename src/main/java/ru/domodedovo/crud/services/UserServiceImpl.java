package ru.domodedovo.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.User;
import ru.domodedovo.crud.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }
}