package ru.domodedovo.crud.components;

import org.springframework.shell.standard.ShellComponent;
import ru.domodedovo.crud.services.ProjectService;
import ru.domodedovo.crud.services.ProjectServiceImpl;

@ShellComponent
public class ProjectCommand {
    private final ProjectService projectService;

    public ProjectCommand(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }
}
