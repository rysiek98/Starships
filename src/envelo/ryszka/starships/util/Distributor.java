package envelo.ryszka.starships.util;

// klasa na podstawie rozmiaru tablicy wyznacza ile oraz jakich statków (rozmiar 4x1, 3x1, 2x1, 1x1) user może przydzelić
public  class Distributor {
    public static int[] getShips() {
                        // 1x1, 2x1, 3x1, 4x1
        return new int[] { 2, 1, 3, 1};
    }
}
