//Question No: 25192
//Title: 인사성 밝은 곰곰이
//Tier: Silver IV
import java.io.*;
import java.util.HashSet;

public class Main {
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> currentUsers = new HashSet<>();
        int chatLogs = Integer.parseInt(reader.readLine());
        int gomgomCount = 0;

        while (chatLogs-- > 0) {
            String inputLine = reader.readLine();

            if (inputLine.equals("ENTER")) {
                gomgomCount += currentUsers.size();
                currentUsers.clear();
            } else {
                currentUsers.add(inputLine);
            }
        }

        gomgomCount += currentUsers.size();

        writer.write(gomgomCount + "\n");

        reader.close();
        writer.flush();
        writer.close();
    }
}