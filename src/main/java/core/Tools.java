package core;

import com.codeborne.selenide.Selenide;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * @return current time and date e.g "01-28-35(16.12.2015)"
     */
    public static String getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss(dd.MM.yyyy)");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
