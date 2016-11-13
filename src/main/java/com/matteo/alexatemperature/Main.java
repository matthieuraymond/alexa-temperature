package com.matteo.alexatemperature;

import spark.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Main {

    private static Thermometer thermometer = new Thermometer("28-0316453fdaff");

    public static void main(String[] args) throws Exception {

        get("/temperature/current", (req, res) -> thermometer.getTemperature());

        get("/temperature", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("temperatures", retrieveFormattedData());

            return new ModelAndView(attributes, "display.ftl");
        }, new FreeMarkerEngine());
    }

    private static Temperature[] retrieveFormattedData()  {
        try {
            String[] data = retrieveData();
            Temperature[] res = new Temperature[data.length];

            for (int i = 0; i < data.length; i++) {
                res[i] = Temperature.createFromString(data[i]);
            }

            return res;
        } catch (IOException e) {
            return new Temperature[]{};
        }
    }
    private static String[] retrieveData() throws IOException {
        String rawData = FileHandler.readFile("data.txt");
        String[] res = rawData.split("\n");

        return res;
    }
}
