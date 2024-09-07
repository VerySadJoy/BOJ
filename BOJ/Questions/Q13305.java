//Question No: 13305
//Title: 주유소
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCities = Integer.parseInt(reader.readLine());

        long[] distances = new long[numberOfCities - 1];
        long[] fuelCosts = new long[numberOfCities];

        StringTokenizer distanceTokens = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < numberOfCities - 1; i++) {
            distances[i] = Long.parseLong(distanceTokens.nextToken());
        }

        StringTokenizer fuelCostTokens = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < numberOfCities; i++) {
            fuelCosts[i] = Long.parseLong(fuelCostTokens.nextToken());
        }

        long totalCost = 0;
        long minimumFuelCost = fuelCosts[0];

        for (int i = 0; i < numberOfCities - 1; i++) {
            if (fuelCosts[i] < minimumFuelCost) {
                minimumFuelCost = fuelCosts[i];
            }
            totalCost += (minimumFuelCost * distances[i]);
        }

        System.out.println(totalCost);
    }
}