package envelo.ryszka.starships.util;

import envelo.ryszka.starships.enums.Field;
import envelo.ryszka.starships.map.Map;
import envelo.ryszka.starships.ship.Pos;
import envelo.ryszka.starships.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Collider {
    public static boolean isPlaceAvailable(Ship ship, Map map) {
        // jeśli statek znajduje się poza mapą to odrzucamy
        if (!ship.isOnMap(map.getSize())) {
            return false;
        }

        Map copy = new Map(map);
        List<Pos> shipFields = new ArrayList<Pos>();
        for (int y = 0; y < copy.getSize(); y++) {
            for (int x = 0; x < copy.getSize(); x++) {
                if (copy.getMapArray()[x][y] == Field.SHIP) {
                    shipFields.add(new Pos(x, y));
                }
            }
        }
        for (Pos p : shipFields) {
            blockAround(copy, p);
        }
        copy.show();
        for (int y = 0; y < copy.getSize(); y++) {
            for (int x = 0; x < copy.getSize(); x++) {
                if (copy.getMapArray()[x][y] == Field.SHIP || copy.getMapArray()[x][y] == Field.LOCKED_AREA) {
                    if (ship.isHere(x, y)) return false;
                }
            }
        }
        return true;
    }

    private static void blockAround(Map map, Pos p) {
        int x = p.getX();
        int y = p.getY();
        // up row
        if (x > 0 && y > 0 && map.getMapArray()[x - 1][y - 1] != Field.SHIP)
            map.getMapArray()[x - 1][y - 1] = Field.LOCKED_AREA;
        if (x >= 0 && y > 0 && map.getMapArray()[x][y - 1] != Field.SHIP)
            map.getMapArray()[x][y - 1] = Field.LOCKED_AREA;
        if (x >= 0 && x < map.getSize() - 1 && y > 0 && y < map.getSize() && map.getMapArray()[x + 1][y - 1] != Field.SHIP)
            map.getMapArray()[x + 1][y - 1] = Field.LOCKED_AREA;
        // middle row
        if (x > 0 && x < map.getSize() && map.getMapArray()[x - 1][y] != Field.SHIP)
            map.getMapArray()[x - 1][y] = Field.LOCKED_AREA;
        if (x >= 0 && x < map.getSize() - 1 && map.getMapArray()[x + 1][y] != Field.SHIP)
            map.getMapArray()[x + 1][y] = Field.LOCKED_AREA;
        // bottom row
        if (x > 0 && x < map.getSize() && y >= 0 && y < map.getSize() - 1 && map.getMapArray()[x - 1][y + 1] != Field.SHIP)
            map.getMapArray()[x - 1][y + 1] = Field.LOCKED_AREA;
        if (x >= 0 && y >= 0 && y < map.getSize() - 1 && map.getMapArray()[x][y + 1] != Field.SHIP)
            map.getMapArray()[x][y + 1] = Field.LOCKED_AREA;
        if (x >= 0 && x < map.getSize() - 1 && y >= 0 && y < map.getSize() - 1 && map.getMapArray()[x + 1][y + 1] != Field.SHIP)
            map.getMapArray()[x + 1][y + 1] = Field.LOCKED_AREA;
    }
}
