package ru.domodedovo.crud.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.domodedovo.crud.models.Project;
import ru.domodedovo.crud.services.ProjectService;
import ru.domodedovo.crud.services.ProjectServiceImpl;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class ProjectCommand {
    private final ProjectService projectService;

    @Autowired
    public ProjectCommand(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @ShellMethod(value = "Get one project by --id param or users list by --all param")
    public String getProject(@ShellOption({"--id"}) Long id, @ShellOption({"--all"}) boolean all) {

        if (id != null) {
            Project result = projectService.findById(id);
            return result.toString();
        }

        if (all) {
            List<Project> projects = projectService.findAll();
            return projects.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
        }

        throw new NullPointerException();
    }

    @ShellMethod(value = "Create one project by name")
    public String createProject(@ShellOption({"--name", "-n"}) String name) {

        Project newProject = new Project(name, Calendar.getInstance().getTime());
        projectService.save(newProject);
        return newProject.toString();
    }
}
