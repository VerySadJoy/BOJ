//Question No: 26069
//Title: 붙임성 좋은 총총이
//Tier: Silver IV
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> dancingUsers = new HashSet<>();
        dancingUsers.add("ChongChong");

        int logCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < logCount; i++) {
            StringTokenizer userTokens = new StringTokenizer(reader.readLine());
            String userA = userTokens.nextToken();
            String userB = userTokens.nextToken();

            if (dancingUsers.contains(userA) || dancingUsers.contains(userB)) {
                dancingUsers.add(userA);
                dancingUsers.add(userB);
            }
        }

        reader.close();
        writer.write(dancingUsers.size() + "\n");
        writer.flush();
        writer.close();
    }
}