package zakuto.tehilimtr;

import java.util.Random;

public class RandomTehilim {
    int randomNumberTemp, min = 1, max = 150;

    public int randomNumber() {
        Random random = new Random();
        randomNumberTemp = random.nextInt(max - min + 1);
        return randomNumberTemp;
    }
}