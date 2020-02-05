package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.Project;
import ru.domodedovo.crud.repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Project findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Project> findAll() {
        return (List<Project>) repository.findAll();
    }

    @Override
    public void save(Project newProject) {
        repository.save(newProject);
    }
}
