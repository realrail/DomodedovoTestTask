package ru.domodedovo.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.domodedovo.crud.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
