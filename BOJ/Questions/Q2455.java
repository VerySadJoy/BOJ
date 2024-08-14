//Question No: 2455
//Title: 지능형 기차
//Tier: Bronze III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxPassengers = 0;
        int currentPassengers = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int passengersOut = Integer.parseInt(tokenizer.nextToken());
            int passengersIn = Integer.parseInt(tokenizer.nextToken());
            currentPassengers -= passengersOut;
            currentPassengers += passengersIn;
            maxPassengers = Math.max(maxPassengers, currentPassengers);
        }

        System.out.print(maxPassengers);
    }
}