//Question No: 1055
//Title: 끝이없음
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] text = reader.readLine().toCharArray();
        char[] pattern = reader.readLine().toCharArray();

        int repeatCount = Integer.parseInt(reader.readLine());
        String[] range = reader.readLine().split(" ");
        int startIdx = Integer.parseInt(range[0]);
        int endIdx = Integer.parseInt(range[1]);
        int dollarCount = 0;

        for (char c : pattern) {
            if (c == '$') {
                dollarCount++;
            }
        }

        StringBuilder result = new StringBuilder();
        if (dollarCount == 1) {
            for (int i = startIdx; i <= endIdx; i++) {
                if ((long) i > text.length + (long) repeatCount * (pattern.length - 1)) {
                    result.append('-');
                }
                else {
                    if (i <= text.length) {
                        result.append(text[i - 1]);
                    }
                    else {
                        result.append(pattern[(i - text.length - 1) % (pattern.length - 1) + 1]);
                    }
                }
            }
        }
        else {
            repeatCount = Math.min(repeatCount, 100);
            outerLoop:
            for (int i = startIdx; i <= endIdx; i++) {
                int index = i;
                int sum = 0;
                int currentLength = text.length;
                repeatLoop:
                for (int r = 0; r < repeatCount; r++) {
                    for (int j = 0; j < pattern.length; j++) {
                        if (index <= text.length) {
                            result.append(text[index - 1]);
                            continue outerLoop;
                        }
                        if (pattern[j] == '$') {
                            if (index <= sum + currentLength) {
                                index -= sum;
                                r = 0;
                                sum = 0;
                                currentLength = text.length;
                                continue repeatLoop;
                            }
                            sum += currentLength;
                        }
                        else {
                            sum++;
                            if (index == sum) {
                                result.append(pattern[j]);
                                continue outerLoop;
                            }
                        }
                    }
                    currentLength = sum;
                    sum = 0;
                }
                result.append('-');
            }
        }
        System.out.println(result);
    }
}
