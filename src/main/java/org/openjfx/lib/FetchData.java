package org.openjfx.lib;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import com.google.gson.Gson;

public class FetchData {

    public static <T> T readJsonFromUrl(String link, Class<T> type) throws IOException {
        Gson gson = new Gson();
        String owm_key = System.getenv("OWM_KEY");
        InputStream input = new URL(link + "&appid=" + owm_key + "&units=imperial").openStream();
        try {
            BufferedReader re = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            T json = gson.fromJson(re, type); // Creating A JSON
            return json; // Returning JSON
        } catch (Exception e) {
            throw e;
        } finally {
            input.close();
        }
    }

}
