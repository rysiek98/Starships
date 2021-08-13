package envelo.ryszka.starships.util;

// klasa na podstawie rozmiaru tablicy wyznacza ile oraz jakich statków (rozmiar 4x1, 3x1, 2x1, 1x1) user może przydzelić
public class Distributor {
    public static int[] getShips(int n) {
        if (n > 3) {
            int[] ships = new int[4];
            int shipsSurface = (int) (n * n * 0.2);
            int currentSurface = 0;

            ships[0] = (int) (shipsSurface * 0.2);
            ships[1] = (int) (shipsSurface * 0.15);
            if (n > 6)
                ships[2] = (int) (shipsSurface * 0.1);
            if (n > 8)
                ships[3] = (int) (shipsSurface * 0.05);

            for (int i = 0; i < 4; i++) {
                currentSurface += ships[i] * (i + 1);
            }

            while (currentSurface < shipsSurface && n < 9) {
                if (shipsSurface - currentSurface == 1) {
                    ships[0]++;
                    currentSurface++;
                    break;
                }
                ships[0]++;
                currentSurface++;
                if (shipsSurface - currentSurface - 2 >= 0) {
                    ships[1]++;
                    currentSurface += 2;
                }
            }
            while ((currentSurface < shipsSurface) && n > 8) {
                if (shipsSurface - currentSurface == 1) {
                    ships[0]++;
                    currentSurface++;
                    break;
                }
                if ((shipsSurface - currentSurface) % 4 == 0) {
                    ships[3]++;
                    currentSurface += 4;
                } else {
                    ships[(shipsSurface - currentSurface) % 4]++;
                    currentSurface += (shipsSurface - currentSurface) % 4;
                }
            }

            return ships;
        } else {
            return new int[0];
        }
    }
    // 1x1, 2x1, 3x1, 4x1
}
