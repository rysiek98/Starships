package envelo.ryszka.starships;

import envelo.ryszka.starships.enums.Field;
import envelo.ryszka.starships.map.Map;
import envelo.ryszka.starships.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public Map ownMap;
    public Map enemyMap;
    public int points;
    public List<Ship> shipList;

    public User(String name, int mapSize) {
        ownMap = new Map(mapSize, Field.WATER);
        enemyMap = new Map(mapSize, Field.DARK);
        shipList = new ArrayList<>();
        this.name = name;
        points = 0;
    }
}
