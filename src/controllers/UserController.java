package controllers;

import models.User;
import repositories.users.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository userRepo;

    public UserController(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public String getById(int id) {
        User user = userRepo.get(id);

        if (user == null)
            return "User with id = " + id + " does not exist!";

        return user.toString();
    }

    public String getAll() {
        List<User> users = userRepo.getAll();
        String resp = "";
        for (User user : users)
            resp += user + "\n";

        return resp;
    }

    public String create(String name, String surname) {
        User user = new User(name, surname);
        boolean created = userRepo.create(user);
        if (created)
            return "A new user " + name + " " + surname + " was added!";

        return "A user cannot be created!";
    }

    public String deleteById(int id) {
        User user = userRepo.delete(id);

        if (user != null) {
            return "A user " + user.getName() + " " + user.getSurname() + " was removed!";
        }

        return "A user with id = " + id + " does not exist!";
    }
}
