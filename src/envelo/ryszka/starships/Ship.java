package envelo.ryszka.starships;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<Pos> posList;
    private int hitCounter;

    public Ship(int x, int y, Direction dir, int length) {
        if (length > 4) {
            length = 4;
        }
        posList = new ArrayList<>();
        posList.add(new Pos(x, y));
        for (int i = 0; i < length; i++) {
            switch (dir) {
                case RIGHT:
                    x++;
                case DOWN:
                    y++;
            }
            posList.add(new Pos(x, y));
        }
    }

    public boolean isHere(int x, int y){
        for (Pos p : posList) {
            if (p.isHere(x, y)) {
                return true;
            }
        }
        return false;
    }

    public boolean isHit(int x, int y) {
        for (Pos p : posList) {
            if (p.isHere(x, y)) {
                if (!p.getIsHit()) {
                    hitCounter++;
                }
                p.hit();
                return true;
            }
        }
        return false;
    }

    public boolean isDead(){
        for (Pos p : posList) {
            if(!p.getIsHit()){
                return false;
            }
        }
        return true;
    }

    public void render(Map map){
        for (Pos p : posList) {
            map.getMapArray()[p.getX()][p.getY()] = Field.SHIP;
        }
    }

}
