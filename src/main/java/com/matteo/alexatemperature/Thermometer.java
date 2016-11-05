package com.matteo.alexatemperature;

import java.io.*;

public class Thermometer {
	private final String address;

	public Thermometer(String address) {
		this.address = address;
	}

	public float getTemperature() {
		String data = readData();
		int temperature = Integer.parseInt(data.substring(data.indexOf("t=") + 2)) / 100; // To delete irrelevant numbers

		return temperature/10f; // /1000 to convert in celsius
	}

	private String readData(){
		try {
			return FileHandler.readFile("/sys/bus/w1/devices/" + address + "/w1_slave");
		} catch (IOException e) {
			e.printStackTrace();
			return "t=404000"; // Error code to avoid server crashing
		}
	}

}
