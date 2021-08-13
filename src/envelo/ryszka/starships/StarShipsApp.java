package envelo.ryszka.starships;

import envelo.ryszka.starships.enums.Field;
import envelo.ryszka.starships.map.Map;

public class StarShipsApp {

    public static void main(String[] args) {
        Map test = new Map(30, Field.WATER);
        test.set(3,2,Field.SHIP);
        test.set(3,6,Field.HIT);
        test.set(5,2,Field.DARK);
        test.show();
    }
}
