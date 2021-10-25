package com.task.testgeo.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JSONReader {

    private static String readAll(final Reader rd) throws IOException {
        final StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject read(final String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            final BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            final String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }
}
