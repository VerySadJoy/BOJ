//Question No: 2002
//Title: 추월
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int carCount = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Integer> entryOrder = new LinkedHashMap<>();

        for (int i = 1; i <= carCount; i++) {
            entryOrder.put(reader.readLine(), i);
        }

        int overtakeCount = 0;
        for (int i = 1; i <= carCount; i++) {
            String exitedCar = reader.readLine();

            Iterator<String> iterator = entryOrder.keySet().iterator();
            while (iterator.hasNext()) {
                if (entryOrder.get(exitedCar) > entryOrder.get(iterator.next())) {
                    overtakeCount++;
                    break;
                }
            }

            entryOrder.remove(exitedCar);
        }

        System.out.println(overtakeCount);
    }
}