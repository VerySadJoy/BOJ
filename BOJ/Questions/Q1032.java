//Question No: 1032
//Title: 명령 프롬프트
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfFiles = Integer.parseInt(reader.readLine());
        String[] fileNames = new String[numberOfFiles];
        
        for (int i = 0; i < numberOfFiles; i++) {
            fileNames[i] = reader.readLine();
        }
        
        int fileNameLength = fileNames[0].length();
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int i = 0; i < fileNameLength; i++) {
            boolean allMatch = true;
            char currentCharacter = fileNames[0].charAt(i);
            
            for (int j = 1; j < numberOfFiles; j++) {
                if (currentCharacter != fileNames[j].charAt(i)) {
                    allMatch = false;
                    break;
                }
            }
            
            if (allMatch) {
                resultBuilder.append(currentCharacter);
            } else {
                resultBuilder.append("?");
            }
        }
        
        System.out.print(resultBuilder);
    }
}