//Question No: 22861
//Title: 폴더 정리 (large)
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    private static final int FILE = 0, FOLDER = 1;
    private static Map<String, Set<String>> filesMap = new HashMap<>();
    private static Map<String, Set<String>> foldersMap = new HashMap<>();
    private static StringBuilder output = new StringBuilder();
    private static Set<String> uniqueFiles;
    private static int fileCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n + m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String parent = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            int type = Integer.parseInt(tokenizer.nextToken());
            addEntry(parent, name, type);
        }

        int moveCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < moveCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            String[] sourcePath = tokenizer.nextToken().split("/");
            String[] destPath = tokenizer.nextToken().split("/");
            moveFolder(sourcePath, destPath);
        }

        int queryCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < queryCount; i++) {
            String[] queryPath = reader.readLine().split("/");
            queryFolder(queryPath);
        }

        System.out.print(output);
    }

    private static void addEntry(String parent, String name, int type) {
        if (type == FOLDER) {
            foldersMap.computeIfAbsent(parent, k -> new HashSet<>()).add(name);
        } else if (type == FILE) {
            filesMap.computeIfAbsent(parent, k -> new HashSet<>()).add(name);
        }
    }

    private static void moveFolder(String[] sourcePath, String[] destPath) {
        String source = sourcePath[sourcePath.length - 1];
        String destination = destPath[destPath.length - 1];
        String parent = sourcePath[sourcePath.length - 2];

        if (foldersMap.containsKey(source)) {
            foldersMap.computeIfAbsent(destination, k -> new HashSet<>()).addAll(foldersMap.get(source));
            foldersMap.remove(source);
        }

        if (filesMap.containsKey(source)) {
            filesMap.computeIfAbsent(destination, k -> new HashSet<>()).addAll(filesMap.get(source));
            filesMap.remove(source);
        }

        foldersMap.get(parent).remove(source);
    }

    private static void queryFolder(String[] queryPath) {
        String target = queryPath[queryPath.length - 1];
        fileCount = 0;
        uniqueFiles = new HashSet<>();
        traverseFolder(target);

        output.append(fileCount).append(" ").append(uniqueFiles.size()).append("\n");
    }

    private static void traverseFolder(String folder) {
        if (foldersMap.containsKey(folder)) {
            for (String subFolder : foldersMap.get(folder)) {
                traverseFolder(subFolder);
            }
        }

        if (filesMap.containsKey(folder)) {
            for (String file : filesMap.get(folder)) {
                uniqueFiles.add(file);
                fileCount++;
            }
        }
    }
}