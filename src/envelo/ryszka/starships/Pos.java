package envelo.ryszka.starships;

public class Pos {
    private int x;
    private int y;
    boolean isHit;

    public Pos(int x, int y){
        this.x = x;
        this.y = y;
        isHit = false;
    }

    public void hit(){
        isHit = true;
    }

    public boolean isHit(){
        return isHit;
    }
}
