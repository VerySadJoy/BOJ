//Question No: 23309
//Title: 철도 공사
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int totalStations = Integer.parseInt(tokenizer.nextToken());
        int totalCommands = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        int[] previousStation = new int[1000001];
        int[] nextStation = new int[1000001];

        int firstStation = Integer.parseInt(tokenizer.nextToken());
        int lastProcessedStation = firstStation;

        for (int i = 1; i < totalStations - 1; i++) {
            int station = Integer.parseInt(tokenizer.nextToken());
            previousStation[station] = lastProcessedStation;
            nextStation[lastProcessedStation] = station;
            lastProcessedStation = station;
        }

        int lastStation = Integer.parseInt(tokenizer.nextToken());
        nextStation[lastProcessedStation] = lastStation;
        previousStation[lastStation] = lastProcessedStation;
        nextStation[lastStation] = firstStation;
        previousStation[firstStation] = lastStation;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < totalCommands; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            int currentStation = Integer.parseInt(tokenizer.nextToken());

            if (command.equals("BN")) {  
                int newStation = Integer.parseInt(tokenizer.nextToken());
                int next = nextStation[currentStation];
                result.append(next).append("\n");

                nextStation[currentStation] = newStation;
                previousStation[newStation] = currentStation;
                nextStation[newStation] = next;
                previousStation[next] = newStation;

            } else if (command.equals("BP")) {  
                int newStation = Integer.parseInt(tokenizer.nextToken());
                int previous = previousStation[currentStation];
                result.append(previous).append("\n");

                nextStation[previous] = newStation;
                previousStation[newStation] = previous;
                nextStation[newStation] = currentStation;
                previousStation[currentStation] = newStation;

            } else if (command.equals("CN")) {  
                int next = nextStation[currentStation];
                result.append(next).append("\n");

                int nextNext = nextStation[next];
                nextStation[currentStation] = nextNext;
                previousStation[nextNext] = currentStation;

            } else if (command.equals("CP")) {  
                int previous = previousStation[currentStation];
                result.append(previous).append("\n");

                int previousPrevious = previousStation[previous];
                previousStation[currentStation] = previousPrevious;
                nextStation[previousPrevious] = currentStation;
            }
        }

        System.out.println(result);
    }
}