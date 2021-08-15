package test.envelo.ryszka.starships;

import envelo.ryszka.starships.User;
import envelo.ryszka.starships.enums.Direction;
import envelo.ryszka.starships.ship.Ship;
import envelo.ryszka.starships.util.Collider;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ColliderTest {

    @org.junit.jupiter.api.Test
    void isPlaceAvailable_add_ship_in_the_same_place() {
        int x = 0;
        int y = 0;
        int mapSize = 10;
        int length = 4;
        String name = "Test";
        Direction dir = Direction.RIGHT;
        Ship ship = new Ship(x, y, dir, length);
        User user = new User(name, mapSize);
        ship.render(user.ownMap);
        user.shipList.add(ship);
        Ship newShip = new Ship(x, y, dir, length);
        Assertions.assertFalse(Collider.isPlaceAvailable(newShip, user.ownMap));
    }

    @org.junit.jupiter.api.Test
    void isPlaceAvailable_ships_intersect() {
        int x = 3;
        int y = 3;
        int mapSize = 10;
        int length = 4;
        String name = "Test";
        Direction dir = Direction.RIGHT;
        Ship ship = new Ship(x, y, dir, length);
        User user = new User(name, mapSize);
        ship.render(user.ownMap);
        user.shipList.add(ship);
        dir = Direction.DOWN;
        x = 4;
        y = 1;
        Ship newShip = new Ship(x, y, dir, length);
        assertFalse(Collider.isPlaceAvailable(newShip, user.ownMap));
    }

    @org.junit.jupiter.api.Test
    void isPlaceAvailable_add_ships_correctly() {
        int x = 3;
        int y = 3;
        int mapSize = 10;
        int length = 4;
        String name = "Test";
        Direction dir = Direction.RIGHT;
        Ship ship = new Ship(x, y, dir, length);
        User user = new User(name, mapSize);
        ship.render(user.ownMap);
        user.shipList.add(ship);
        dir = Direction.RIGHT;
        x = 3;
        y = 5;
        Ship newShip = new Ship(x, y, dir, length);
        assertTrue(Collider.isPlaceAvailable(newShip, user.ownMap));
        newShip.render(user.ownMap);
        user.ownMap.show();
    }
}