package com.task.testgeo.service;

import com.task.testgeo.model.Location;
import com.task.testgeo.utils.ForwardSearchApi;
import com.task.testgeo.utils.ReverseSearchApi;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocService {

    Location location21 = new Location();
    Map<String, Location> allLoc = new HashMap<>();
    public Location reverseSearch(String location) throws IOException {
        if (allLoc.containsKey(location)){
            location21 = allLoc.get(location);
        }else{
            location21 = ReverseSearchApi.search(location);
            allLoc.put(location, location21);
        }
        return location21;
    }

    public Location forwardSearch(String location) throws IOException {
        if (allLoc.containsKey(location)){
            location21 = allLoc.get(location);
        }else{
            location21 = ForwardSearchApi.search(location);
            allLoc.put(location, location21);
        }
        return location21;
    }
}
