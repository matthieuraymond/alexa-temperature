package com.matteo.alexatemperature;

public class Temperature {
    public String date;
    public String value;

    public static Temperature createFromString(String s) {
        String[] fields = s.split(" ");
        Temperature res = new Temperature();

        res.date = fields[0];

        if (fields.length > 1) {
            res.value = fields[1];
        }

        return res;
    }
}
