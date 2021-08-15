package envelo.ryszka.starships;

import envelo.ryszka.starships.enums.Direction;
import envelo.ryszka.starships.ship.Ship;
import envelo.ryszka.starships.util.Collider;
import envelo.ryszka.starships.util.Distributor;
import envelo.ryszka.starships.util.Input;

import java.util.Locale;
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
        } else {
            user2 = new User(firstUserName, mapSize);
            user1 = new User(secondUserName, mapSize);
        }
    }

    void view3_shipsPositioning() {
        System.out.println("-------------------------------------------------------");
        System.out.println("Player: " + user1.name + " turn to place his/her ships");
        System.out.println("-------------------------------------------------------");
        int[] shipsToPlace = Distributor.getShips(mapSize);
        for (int length = 4; length >= 1; length--) {
            for (int j = 0; j < shipsToPlace[length - 1]; j++) {
                Ship newShip;
                do {
                    user1.ownMap.show();
                    System.out.print("Input format: <x> <y> <dir>");
                    System.out.print("\nPlace your " + length + "x1 ship: ");
                    Input input = validateInput(mapSize, length);
                    newShip = new Ship(input.x, input.y, input.dir, length);
                } while (!Collider.isPlaceAvailable(newShip, user1.ownMap));
                newShip.render(user1.ownMap); // should be: user1.ownMap.addShip(newShip) in the future
                user1.shipList.add(newShip);
            }
        }
    }

    void view4_game() {

    }

    void view5_theEnd() {

    }

    private Input parseInput(int mapSize) {
        String input = in.nextLine();
        String[] words = input.split(" ");
        int x = Integer.parseInt(words[0]);
        int y = Integer.parseInt(words[1]);
        Direction dir = words[2].toLowerCase(Locale.ROOT).charAt(0) == 'd' ? Direction.DOWN : Direction.RIGHT;
        return new Input(x, y, dir);
    }

    private Input validateInput(int mapSize, int length){
        Input input = parseInput(mapSize);
        while (!shipPlacementConditions(input.x, input.y, mapSize, length, input.dir)) {
            System.out.print("Wrong input place x and y between 0 and " + mapSize+ " and");
            System.out.println("your ships must not cross map border :");
            input = parseInput(mapSize);
        }
        return input;
    }

    private boolean shipPlacementConditions(int x, int y, int mapSize, int length, Direction dir){
        if(x >= 0 && y >= 0 && x < mapSize && y < mapSize ) {
            if((dir == Direction.RIGHT && x+length <= mapSize) || (dir == Direction.DOWN && y+length <= mapSize))
                return true;
            else
                return false;
        }else
            return false;
    }
}
