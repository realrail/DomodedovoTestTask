package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.Task;

import java.util.List;

@Service
public interface TaskService {
    Task findById(Long id);

    List<Task> getAll();

    void save(Task newTask);
}
