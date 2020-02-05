package ru.domodedovo.crud.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.domodedovo.crud.models.Project;
import ru.domodedovo.crud.models.Task;
import ru.domodedovo.crud.models.User;
import ru.domodedovo.crud.services.*;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
public class TaskCommand {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    public TaskCommand(TaskServiceImpl taskService, ProjectServiceImpl projectService, UserServiceImpl userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @ShellMethod(value = "Get one task by --id param or users list by --all param")
    public String getTask(@ShellOption({"--id"}) Long id, @ShellOption({"--all"}) boolean all) {

        if (id != null) {
            Task result = taskService.findById(id);
            return result.toString();
        }

        if (all) {
            List<Task> tasks = taskService.getAll();
            return tasks.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
        }

        throw new NullPointerException();
    }

    @ShellMethod(value = "Create one task by name, responsible Id, project Id")
    public String createTask(
            @ShellOption({"--name", "-n"}) String name,
            @ShellOption({"--responsible_id", "-rid"}) Long responsibleId,
            @ShellOption({"--project_id", "-pid"}) Long projectId
            ) {

        User responsible = null;
        if (responsibleId != null) {
           responsible = userService.findById(responsibleId);
        }

        Project project = null;
        if (projectId != null) {
            project = projectService.findById(projectId);
        }

        Task newTask = new Task(name, Calendar.getInstance().getTime(), project, responsible);
        taskService.save(newTask);

        return newTask.toString();
    }
}
