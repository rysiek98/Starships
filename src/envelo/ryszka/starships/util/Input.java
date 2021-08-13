package envelo.ryszka.starships.util;

import envelo.ryszka.starships.enums.Direction;

public final class  Input {
    public int x;
    public int y;
    public Direction dir;

    public Input(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
