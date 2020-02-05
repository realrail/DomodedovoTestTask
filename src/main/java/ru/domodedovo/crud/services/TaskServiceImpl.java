package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.Task;
import ru.domodedovo.crud.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Task> getAll() {
        return (List<Task>) repository.findAll();
    }

    @Override
    public void save(Task newTask) {
        repository.save(newTask);
    }
}
