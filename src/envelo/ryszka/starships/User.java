package envelo.ryszka.starships;

import envelo.ryszka.starships.map.Map;
import envelo.ryszka.starships.ship.Ship;

import java.util.List;

public class User {
    public String name;
    public Map ownMap;
    public Map enemyMap;
    public int points = 0;
    public List<Ship> shipList;
}
