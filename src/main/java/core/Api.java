package core;

import org.json.JSONException;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class Api {

    /**
     * Create new email;
     * @param mailAddress - email address name;
     * @return;
     */
    public static String createNewEmail(String mailAddress) {
        try {
            String url = "https://mailsac.com/api/addresses/" + mailAddress;
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Host", "mailsac.com");
            int responseCode = connection.getResponseCode();
            System.out.println("Sending 'Get' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            assert responseCode == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mailAddress + "@mailsac.com";
    }

    /**
     *
     * @param mailAddress - email address name;
     */
    public static void checkSubjectInEmail(String mailAddress) {
        Tools.sleepWait(6000);
        String url = "https://mailsac.com/api/addresses/" + mailAddress + "@mailsac.com/messages";
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String inputLine;

            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine + '\n');
            }
            String jsonLine = stringBuilder.toString();
            org.json.JSONObject jsonObject = new org.json.JSONObject(jsonLine.substring(1));
            String subject = String.valueOf(jsonObject.get("subject"));
            System.out.println(subject);
            assertEquals("Email is empty", subject, "Подтвердите email для дальнейшей работы с Prom.ua");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}


