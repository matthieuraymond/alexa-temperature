package com.matteo.alexatemperature;

import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static String readFile(String path) throws IOException {
        Scanner sc = new Scanner(new File(path));
        StringBuilder sb = new StringBuilder();
        
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine());
	    sb.append("\n");
        }
        
        sc.close();

        return sb.toString();
    }
}


