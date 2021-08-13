package envelo.ryszka.starships;

import envelo.ryszka.starships.map.Map;
import envelo.ryszka.starships.ship.Ship;

import java.util.List;

public class User {
    public String name;
    public Map ownMap;
    public Map enemyMap;
    public int points;
    public List<Ship> shipList;

    public User(String name) {
        this.name = name;
        points = 0;
    }
}
