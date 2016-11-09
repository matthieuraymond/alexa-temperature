package com.matteo.alexatemperature;

import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Main {

    private static Thermometer thermometer = new Thermometer("28-0316453fdaff");

    public static void main(String[] args) throws Exception {

        get("/temperature/current", (req, res) -> thermometer.getTemperature());

        get("/temperature", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("temperature", FileHandler.readFile("data.txt"));

            return new ModelAndView(attributes, "display.ftl");
        }, new FreeMarkerEngine());
    }
}
