package com.task.testgeo.utils;

import com.task.testgeo.model.Location;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

public class ReverseSearchApi {
    static final String baseUrl = "http://api.positionstack.com/v1/reverse";
    static final String accessKey = "?access_key=6099d1ad48b476c802e081bcd41f1a13";

    public static Location search(String locality) throws IOException {

        final String url = baseUrl + accessKey + "&query=" + locality;
        System.out.println(url);
        final JSONObject response = JSONReader.read(url);
        JSONObject location = response.getJSONArray("data").getJSONObject(0);


        Location newLocation= new Location();
        newLocation.setLatitude(String.valueOf(location.getDouble("latitude")));
        newLocation.setLongitude(String.valueOf(location.getDouble("longitude")));
        newLocation.setLabel(location.getString("label"));
        newLocation.setRegion(location.getString("region"));
        newLocation.setName(location.getString("name"));


        return newLocation;
    }



}
