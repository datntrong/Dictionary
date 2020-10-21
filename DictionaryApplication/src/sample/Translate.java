package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.net.URL;
import java.net.URLEncoder;

public class Translate {

    public static String translate(String langFrom, String langTo, String text) throws IOException {
        String TRANSLATE_URL = "https://script.google.com/macros/s/AKfycbxAQC03N055UzZXNO2luYiQ2nIMPRzVKZFi4Ed3Rqrj_4JqjoVO/exec";
        // INSERT YOU URL HERE
        String urlStr = TRANSLATE_URL +
                "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}