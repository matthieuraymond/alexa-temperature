package com.matteo.alexatemperature;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Main {

    private static Thermometer thermometer = new Thermometer("28-0316453fdaff");

    public static void main(String[] args) {
        get("/temperature/current", (req, res) -> thermometer.getTemperature());

        get("/temperature", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("temperature", FileHandler.readFile("../../../../../../data.txt"));

            // The display.ftl file is located in directory:
            // src/test/resources/spark/template/freemarker
            return new ModelAndView(attributes, "display.ftl");
        }, new FreeMarkerEngine());
    }
}
