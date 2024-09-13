//Question No: 2141
//Title: 우체국
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class House implements Comparable<House> {
        long position, population;

        public House(long position, long population) {
            this.position = position;
            this.population = population;
        }

        @Override
        public int compareTo(House other) {
            return Long.compare(this.position, other.position);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfHouses = Integer.parseInt(bufferedReader.readLine());
        List<House> houseList = new ArrayList<>();
        long totalPopulation = 0;

        for (int i = 0; i < numberOfHouses; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            long position = Long.parseLong(tokenizer.nextToken());
            long population = Long.parseLong(tokenizer.nextToken());
            houseList.add(new House(position, population));
            totalPopulation += population;
        }

        Collections.sort(houseList);
        long cumulativePopulation = 0;

        for (House house : houseList) {
            cumulativePopulation += house.population;
            if (cumulativePopulation >= (totalPopulation + 1) / 2) {
                bufferedWriter.write(String.valueOf(house.position));
                break;
            }
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}