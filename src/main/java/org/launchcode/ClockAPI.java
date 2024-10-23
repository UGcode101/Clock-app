package org.launchcode;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class ClockAPI {

    // Base URL of the WorldTimeAPI
    private static final String BASE_URL = "http://worldtimeapi.org/api/timezone/";

    /**
     * Fetches the current time for a specific timezone using the WorldTimeAPI.
     *
     * @param timezone The name of the timezone (e.g., "America/New_York").
     * @return The current time in the specified timezone in ISO format.
     * @throws IOException If the API request fails.
     */
    public static String getTime(String timezone) throws IOException {
        OkHttpClient client = new OkHttpClient();  // Create an OkHttpClient instance
        String url = BASE_URL + timezone;  // Build the API endpoint URL

        // Build the HTTP request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Execute the request and handle the response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Parse the JSON response
            JSONObject json = new JSONObject(response.body().string());
            return json.getString("datetime");  // Extract the "datetime" field
        }
    }
}