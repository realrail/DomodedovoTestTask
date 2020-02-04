package ru.domodedovo.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.domodedovo.crud.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
