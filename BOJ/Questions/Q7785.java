//Question No: 7785
//Title: 회사에 있는 사람
//Tier: Silver V
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalEntries = scanner.nextInt();
        HashMap<String, String> employeeStatusMap = new HashMap<>();

        for (int i = 0; i < totalEntries; i++) {
            String name = scanner.next();
            String status = scanner.next();

            if (employeeStatusMap.containsKey(name)) {
                employeeStatusMap.remove(name);
            } else {
                employeeStatusMap.put(name, status);
            }
        }

        ArrayList<String> employeeList = new ArrayList<>(employeeStatusMap.keySet());
        Collections.sort(employeeList, Collections.reverseOrder());

        for (String employeeName : employeeList) {
            System.out.print(employeeName + " ");
        }
    }
}