package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }
}
