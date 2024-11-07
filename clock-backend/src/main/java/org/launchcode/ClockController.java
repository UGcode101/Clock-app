package org.launchcode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ClockController {

    @GetMapping("/api/time")
    public Map<String, String> getTime() {
        Map<String, String> response = new HashMap<>();
        try {
            String currentTime = ClockAPI.getTime("America/New_York");
            response.put("time", currentTime);
        } catch (IOException e) {
            response.put("error", "Failed to fetch time");
        }
        return response;
    }
}