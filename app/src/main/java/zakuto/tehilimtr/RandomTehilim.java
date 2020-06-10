package zakuto.tehilimtr;

import java.util.Random;

public class RandomTehilim {
    int randomNumberTemp, min = 1, max = 150;
    int array[];

    public int randomNumber() {
        Random random = new Random();
        randomNumberTemp = random.nextInt(max - min + 1);

        //For Test Purposes
        /*for(int i = 0; i<500; i++){
            randomNumberTemp =  random.nextInt(max-min + 1 );
            Log.i("Random Sayi: ", String.valueOf(randomNumberTemp));
            //Create an array, sort to see all the generated numbers
            Log.d("arr: ","" + Arrays.toString(array));
        }*/
        return randomNumberTemp;
    }
}