//Question No: 14653
//Title: 너의 이름은
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int numPeople, numMessages, queryMessage;

    static class Message {
        int unreadCount;
        char sender;

        public Message(int unreadCount, char sender) {
            this.unreadCount = unreadCount;
            this.sender = sender;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        numPeople = Integer.parseInt(tokenizer.nextToken());
        numMessages = Integer.parseInt(tokenizer.nextToken());
        queryMessage = Integer.parseInt(tokenizer.nextToken());

        Map<Character, Integer> readIndexMap = new HashMap<>();
        Message[] messageList = new Message[numMessages];

        for (int i = 0; i < numMessages; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int unreadCount = Integer.parseInt(tokenizer.nextToken());
            char sender = tokenizer.nextToken().charAt(0);

            messageList[i] = new Message(unreadCount, sender);

            readIndexMap.put(sender, i);

            if (unreadCount == 0) {
                for (int j = 0; j < numPeople; j++) {
                    readIndexMap.put((char) (j + 'A'), i);
                }
            }

            if (i > 0 && messageList[i - 1].unreadCount == unreadCount) {
                readIndexMap.put(messageList[i - 1].sender, i);
            }
        }

        readIndexMap.put('A', numMessages + 1);

        TreeSet<Character> result = new TreeSet<>();

        for (char i = 'A'; i < numPeople + 'A'; i++) {
            if (readIndexMap.getOrDefault(i, -1) < queryMessage - 1) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (char person : result) {
                System.out.print(person + " ");
            }
            System.out.println();
        }

        bufferedReader.close();
    }
}