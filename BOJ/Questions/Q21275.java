//Question No: 21275
//Title: 폰 호석만
//Tier: Silver II
import java.io.*;
import java.util.*;

public class Main {
    static String numStr1;
    static String numStr2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numStr1 = tokenizer.nextToken();
        numStr2 = tokenizer.nextToken();

        ArrayList<BasePair> resultList = new ArrayList<>();
        for (long base1 = 2; base1 <= 36; base1++) {
            long value1 = convertToBase(numStr1, base1);
            if (value1 == -1 || value1 >= Long.MAX_VALUE) {
                continue;
            }
            for (long base2 = 2; base2 <= 36; base2++) {
                long value2 = convertToBase(numStr2, base2);
                if (value2 == -1 || value2 >= Long.MAX_VALUE) {
                    continue;
                }
                if (value1 == value2 && base1 != base2) {
                    resultList.add(new BasePair(base1, base2, value1));
                }
            }
        }

        if (resultList.size() == 0) {
            System.out.println("Impossible");
        } else if (resultList.size() == 1) {
            BasePair pair = resultList.get(0);
            System.out.println(pair.decimalValue + " " + pair.base1 + " " + pair.base2);
        } else {
            System.out.println("Multiple");
        }
    }

    static long convertToBase(String num, long base) {
        long result = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i);
            if ('0' <= digit && digit <= '9') {
                digit -= '0';
                if (digit >= base) {
                    return -1;
                }
            } else if ('a' <= digit && digit <= 'z') {
                digit -= ('a' - 10);
                if (digit >= base) {
                    return -1;
                }
            }
            result += digit * Math.pow(base, num.length() - i - 1);
        }
        return result;
    }

    static class BasePair {
        long base1;
        long base2;
        long decimalValue;

        public BasePair(long base1, long base2, long decimalValue) {
            this.base1 = base1;
            this.base2 = base2;
            this.decimalValue = decimalValue;
        }

        @Override
        public String toString() {
            return base1 + "," + base2 + ":" + decimalValue;
        }
    }
}