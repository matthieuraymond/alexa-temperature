package com.matteo.alexatemperature;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("temperature", (req, res) -> getTemperature());
    }

    private static int getTemperature() {
        return 21;
    }
}