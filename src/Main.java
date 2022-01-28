import db.DB;
import db.postgres.Postgres;
import models.User;
import repositories.EntityRepository;
import repositories.user.UserRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DB db = new Postgres();
        EntityRepository<User> userRepo = new UserRepository(db);

        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println("Select option:");
            System.out.println("1. Create user");
            System.out.println("2. Get user by id");
            System.out.println("3. Get all");
            System.out.println("4. Remove user by id");
            System.out.println("0. Exit");
            int option = sc.nextInt();

            if (option == 1) {
                createUser(userRepo);
            } else if (option == 2) {
                getUserById(userRepo);
            } else if (option == 3) {
                getAllUsers(userRepo);
            } else if (option == 4) {
                removeUserById(userRepo);
            } else {
                break;
            }
        }

        db.close();
    }

    private static void removeUserById(EntityRepository<User> userRepo) {
        System.out.println("Please enter id:");
        int id = sc.nextInt();

        User user = userRepo.delete(id);

        if (user != null) {
            System.out.println("A user " + user.getName() + " " + user.getSurname() + " was removed!");
        } else {
            System.out.println("A user with id = " + id + " does not exist!");
        }

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private static void getAllUsers(EntityRepository<User> userRepo) {
        List<User> users = userRepo.getAll();
        for (User user : users)
            System.out.println(user);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private static void getUserById(EntityRepository<User> userRepo) {
        System.out.println("Please enter id:");
        int id = sc.nextInt();
        User user = userRepo.get(id);

        if (user == null)
            System.out.println("User with id = " + id + " does not exist!");
        else
            System.out.println(user);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private static void createUser(EntityRepository<User> userRepo) {
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter surname: ");
        String surname = sc.next();
        User user = new User(name, surname);
        boolean created = userRepo.create(user);
        if (created) {
            System.out.println("A new user " + name + " " + surname + " was added!");
        } else {
            System.out.println("A user cannot be created!");
        }

        System.out.println("\n0. Exit");
        sc.nextInt();
    }
}
