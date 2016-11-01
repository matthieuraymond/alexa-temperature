package com.matteo.alexatemperature;

import java.io.File;
import java.util.Scanner;

import static spark.Spark.get;

public class Main {

    private static String THERM_ADDRESS = "28-0316453fdaff";

    public static void main(String[] args) {
        get("temperature/current", (req, res) -> getTemperature());
    }

    private static float getTemperature() {
        String data = getThermometerData();
        int temperature = Integer.parseInt(data.substring(data.indexOf("t=") + 2)) / 100; // To delete irrelevant numbers

        return temperature/10f; // /1000 to convert in celsius
    }

    private static String getThermometerData() {
        try {
            Scanner sc = new Scanner(new File("/sys/bus/w1/devices/" + THERM_ADDRESS + "/w1_slave"));
            StringBuilder sb = new StringBuilder();
            while(sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            sc.close();

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "t=0";
        }
    }
}