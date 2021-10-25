package com.task.testgeo.controller;

import com.task.testgeo.model.Location;
import com.task.testgeo.service.LocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MainController {

    private final LocService locService;

    public MainController(LocService locService) {
        this.locService = locService;
    }

    @PostMapping("/geolocation/reverse")
    public ResponseEntity<Location> getReverseLocation(@RequestParam (value = "location") String location) throws IOException {
        return new ResponseEntity<>(locService.reverseSearch(location), HttpStatus.CREATED);
    }

    @PostMapping("/geolocation/forward")
    public ResponseEntity<Location> getFotwardLocation(@RequestParam (value = "location")String location) throws IOException {
        return new ResponseEntity<>(locService.forwardSearch(location), HttpStatus.CREATED);

    }

}

