package ru.domodedovo.crud.services;

import org.springframework.stereotype.Service;
import ru.domodedovo.crud.models.Project;

import java.util.List;

@Service
public interface ProjectService {
    Project findById(Long id);

    List<Project> findAll();

    void save(Project newProject);
}
