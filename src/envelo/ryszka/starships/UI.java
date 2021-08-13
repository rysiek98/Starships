package envelo.ryszka.starships;

import java.util.Scanner;

public class UI {
    User user1;
    User user2;
    int maxPoints;
    private Scanner in;
    int mapSize;
    private String firstUserName;
    private String secondUserName;

    public UI() {
        in = new Scanner(System.in);
    }

    void start() {

    }

    void view1_userNames() {
        System.out.print("Enter map size: ");
        mapSize = in.nextInt();
        in.nextLine();
        System.out.print("Enter first userName: ");
        firstUserName = in.nextLine();
        System.out.print("Enter second userName: ");
        secondUserName = in.nextLine();
    }
    void view2_randomFirstUser() {
        if (Math.random() < 0.5) {
            user1 = new User(firstUserName, mapSize);
            user2 = new User(secondUserName, mapSize);
        }
        else {
            user2 = new User(firstUserName, mapSize);
            user1 = new User(secondUserName, mapSize);
        }
    }
    void view3_shipsPositioning() {

    }
    void view4_game() {

    }
    void view5_theEnd() {

    }
}
