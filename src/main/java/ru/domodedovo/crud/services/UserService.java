package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.User;

import java.util.List;

@Service
public interface UserService {
    User findById(Long id);

    void save(User user);

    List<User> getAll();
}