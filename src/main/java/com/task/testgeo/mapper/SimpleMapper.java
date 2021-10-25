package com.task.testgeo.mapper;

import com.task.testgeo.model.Location;
import org.json.JSONObject;
import org.mapstruct.Mapper;

@Mapper
public interface SimpleMapper {
    Location tranform(JSONObject object);
    JSONObject transform(Location location);
}
