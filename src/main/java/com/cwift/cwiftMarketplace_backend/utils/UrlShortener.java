package com.cwift.cwiftMarketplace_backend.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlShortener {

    public static String shortenUrl(String longUrl) {
        try {
            // URL of the URL shortening service
            URL url = new URL("http://tinyurl.com/api-create.php?url=" + longUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Reading the response
            BufferedReader reader = new BufferedReader(new InputStreamReader (connection.getInputStream()));
            String shortenedUrl = reader.readLine();
            reader.close();

            return shortenedUrl;

        } catch (Exception e) {
            e.printStackTrace();
            return longUrl;
        }
    }
}
