package core;

import java.math.BigInteger;
import java.util.Random;

public class Tools {

    /**
     * @param numberSize number of digits;
     * @return random number with specified number of digits;
     */
    public static String generateRandomNumberWithSize(int numberSize) {

        int n = 100;
        Random random = new Random();
        byte[] b = new byte[n];
        random.nextBytes(b);
        BigInteger i = new BigInteger(b);
        String target = String.valueOf(i);
        target = target.substring(1, numberSize + 1);

        return target;
    }

    public static void sleepWait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
