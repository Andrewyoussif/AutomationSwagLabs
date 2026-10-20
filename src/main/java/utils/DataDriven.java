package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class DataDriven {

    public static String jsonReader(String user, String key) {
        try (InputStream is = DataDriven.class
                .getClassLoader()
                .getResourceAsStream("testdata.json")) {

            JsonNode root = new ObjectMapper().readTree(is);
            return root.get(user).get(key).asText();

        } catch (Exception e) {
            throw new RuntimeException("Failed to read testdata.json", e);
        }
    }
}