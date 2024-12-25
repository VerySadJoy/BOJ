//Question No: 7111
//Title: The Strange Sequence
//Tier: Gold II
import java.io.*;
import java.util.*;

class Num {
    String strNum;
    int len;

    Num(String strNum) {
        this.strNum = strNum;
        getDigitsSum(strNum);
        this.len = strNum.length();
    }

    static int getDigitsSum(String strNum) {
        int result = 0;
        for (int i = 0; i < strNum.length(); i++) {
            result += strNum.charAt(i) - '0';
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Num before = new Num(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        for (int r = 2; r <= n; r++) {
            StringBuilder sb = new StringBuilder();
            int len = before.len;
            int reqSum = Num.getDigitsSum(String.valueOf(Long.parseLong(before.strNum) * 4L));
            int subCnt = len * 9 - reqSum;

            if (subCnt >= 0) {
                int spot = len - 1;

                while (spot >= 0) {
                    if (before.strNum.charAt(spot) == '9') {
                        spot--;
                        continue;
                    }

                    int copySubCnt = subCnt;
                    for (int i = 0; i < len; i++) {
                        int subDigMax = 9 - (before.strNum.charAt(i) - '0');
                        if (i == spot) {
                            subDigMax--;
                        } else if (spot + 1 <= i) {
                            subDigMax = 9;
                        }

                        int subDigCnt = Math.min(copySubCnt, subDigMax);
                        copySubCnt -= subDigCnt;
                        sb.append(9 - subDigCnt);
                    }

                    if (copySubCnt == 0) {
                        break;
                    }

                    sb = new StringBuilder();
                    spot--;
                }

                if (spot == -1) {
                    len++;
                }

            } else {
                len++;
            }

            if (before.len + 1 == len) {
                subCnt = len * 9 - reqSum;
                for (int i = 0; i < len; i++) {
                    int subDigMax = 9;
                    if (i == 0) {
                        subDigMax--;
                    }

                    int subDigCnt = Math.min(subCnt, subDigMax);
                    subCnt -= subDigCnt;
                    sb.append(9 - subDigCnt);
                }
            }

            before = new Num(sb.toString());
        }

        System.out.println(before.strNum);
    }
}