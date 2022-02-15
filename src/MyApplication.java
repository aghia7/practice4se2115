import controllers.ProductController;
import controllers.UserController;

import java.util.Scanner;

public class MyApplication {
    private final UserController userCtrl;
    private final ProductController productCtrl;
    private final Scanner sc;

    public MyApplication(UserController userCtrl, ProductController productCtrl) {
        this.userCtrl = userCtrl;
        this.productCtrl = productCtrl;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println("Select option:");
            System.out.println("1. User`s menu");
            System.out.println("2. Product`s menu");
            System.out.println("0. Exit");
            int option = sc.nextInt();

            if (option == 1) {
                usersMenu();
            } else if (option == 2) {
                productsMenu();
            } else {
                break;
            }
        }
    }

    private void usersMenu() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println("User`s menu");
            System.out.println("Select option:");
            System.out.println("1. Create user");
            System.out.println("2. Get user by id");
            System.out.println("3. Get all users");
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


    // Products part

    private void productsMenu() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println("Product`s menu");
            System.out.println("Select option:");
            System.out.println("1. Create product");
            System.out.println("2. Get product by id");
            System.out.println("3. Get all products");
            System.out.println("4. Remove product by id");
            System.out.println("5. Get products by category");
            System.out.println("0. Exit");
            int option = sc.nextInt();

            if (option == 1) {
                createProduct();
            } else if (option == 2) {
                getProductById();
            } else if (option == 3) {
                getAllProducts();
            } else if (option == 4) {
                removeProductById();
            } else if (option == 5) {
                getAllProductsByCategory();
            } else {
                break;
            }
        }
    }

    private void removeProductById() {
        System.out.println("Please enter id:");
        int id = sc.nextInt();
        String resp = productCtrl.deleteById(id);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void getAllProducts() {
        String resp = productCtrl.getAll();
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void getProductById() {
        System.out.println("Please enter id:");
        int id = sc.nextInt();
        String resp = productCtrl.getById(id);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void createProduct() {
        System.out.println("Enter name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter category: ");
        String category = sc.next();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        String resp = productCtrl.create(name, category, price);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }

    private void getAllProductsByCategory() {
        System.out.println("Enter category: ");
        String category = sc.next();
        String resp = productCtrl.getAllByCategory(category);
        System.out.println(resp);

        System.out.println("\n0. Exit");
        sc.nextInt();
    }
}
