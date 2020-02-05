package ru.domodedovo.crud.components;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.domodedovo.crud.models.User;
import ru.domodedovo.crud.services.UserService;
import ru.domodedovo.crud.services.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent()
public class UserCommand {

    private final UserService userService;

    public UserCommand(UserServiceImpl userService) {
        this.userService = userService;
    }

    @ShellMethod(value = "Get one user by --id param or users list by --all param")
    public String getUser(@ShellOption({"--id"}) Long id, @ShellOption({"--all"}) boolean all) {

        if (id != null) {
            User result = userService.findById(id);
            return result.toString();
        }

        if (all) {
            List<User> users = userService.getAll();
            return users.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));
        }

        throw new NullPointerException();
    }

    @ShellMethod(value = "Create one user by name and surname")
    public String createUser(@ShellOption({"--name", "-n"}) String name, @ShellOption({"--surname", "-s"}) String surname) {

        User newUser = new User(name, surname);
        userService.save(newUser);

        return newUser.toString();
    }
}