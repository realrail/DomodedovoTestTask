package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.User;

@Service
public interface UserService {
    User getById(Long id);

    void save(User user);
}