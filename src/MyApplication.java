import controllers.UserController;

import java.util.Scanner;

public class MyApplication {
    private final UserController userCtrl;
    private final Scanner sc;

    public MyApplication(UserController userCtrl) {
        this.userCtrl = userCtrl;
        sc = new Scanner(System.in);
    }

    public void start() {
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
                createUser();
            } else if (option == 2) {
                getUserById();
            } else if (option == 3) {
                getAllUsers();
            } else if (option == 4) {
                removeUserById();
            } else {
                break;
            }
        }
    }

    private void removeUserById() {
        System.out.println("Please enter id:");
        int id = sc.nextInt();
        String resp = userCtrl.deleteById(id);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void getAllUsers() {
        String resp = userCtrl.getAll();
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void getUserById() {
        System.out.println("Please enter id:");
        int id = sc.nextInt();
        String resp = userCtrl.getById(id);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void createUser() {
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter surname: ");
        String surname = sc.next();
        String resp = userCtrl.create(name, surname);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }
}
