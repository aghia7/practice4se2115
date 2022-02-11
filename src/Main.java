import controllers.UserController;
import db.DB;
import db.postgres.Postgres;
import models.User;
import repositories.EntityRepository;
import repositories.users.IUserRepository;
import repositories.users.UserRepository;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DB db = new Postgres();
        IUserRepository userRepo = new UserRepository(db);
        UserController userCtrl = new UserController(userRepo);
        MyApplication app = new MyApplication(userCtrl);

        app.start();

        db.close();
    }
}
