package ru.domodedovo.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.domodedovo.crud.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User getById(Long id);
}
