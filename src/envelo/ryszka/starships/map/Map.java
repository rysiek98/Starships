package envelo.ryszka.starships.map;

import envelo.ryszka.starships.enums.Field;

import java.util.Arrays;
import java.util.Locale;

public class Map {
    private Field[][] mapArray;
    private int n;

    public Map(int n, Field field) {
        this.n = n;
        mapArray = new Field[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                mapArray[x][y] = field;
            }
        }
    }

    public Map(Map map) {
        this.n = map.getSize();
        this.mapArray = new Field[this.n][this.n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                this.mapArray[x][y] = map.getMapArray()[x][y];
            }
        }
    }

    public void set(int x, int y, Field field) {
        mapArray[x][y] = field;
    }

    public Field get(int x, int y) {
        return mapArray[x][y];
    }

    public void show() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT).toCharArray();
        int pos = 0;

        System.out.print("  ");
        for(int i =0; i < n; i++){
            if(pos == alphabet.length){
                pos = 0;
            }
            System.out.print(alphabet[pos++]);
        }
        System.out.println();
        for (int y = 0; y < n; y++) {
            System.out.print(y > 9 ? y : " " + y);
            for (int x = 0; x < n; x++) {
                switch (mapArray[x][y]) {
                    case HIT -> System.out.print(Colors.BG_WHITE + Colors.RED + "X" + Colors.RESET);

                    case DARK -> System.out.print(Colors.BG_BLACK + " " + Colors.RESET);

                    case SHIP -> System.out.print(Colors.BG_WHITE + " " + Colors.RESET);

                    case LOCKED_AREA -> System.out.print(Colors.BG_YELLOW + " " + Colors.RESET);
                    //WATER
                    default -> System.out.print(Colors.BG_BLUE + " " + Colors.RESET);
                }
            }
            System.out.println();
        }
    }

    public Field [][] getMapArray(){
        return mapArray;
    }

    public int getSize() {
        return n;
    }
}
