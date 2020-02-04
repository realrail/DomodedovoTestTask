package ru.domodedovo.crud.services;

import ru.domodedovo.crud.repositories.TaskRepository;

public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }
}
