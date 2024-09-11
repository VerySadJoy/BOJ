//Question No: 16903
//Title: 수열과 쿼리 20
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
class Node {
    int count;
    Node left;
    Node right;

    public Node(int count) {
        this.count = count;
    }
}

class Trie {

    Node head;

    public Trie() {
        head = new Node(0);
        insert(0);
    }

    public void insert(int value) {
        Node currentNode = head;
        for (int i = 30; i >= 0; i--) {
            if ((value & (1 << i)) > 0) {
                if (currentNode.left != null) {
                    currentNode.left.count++;
                } else {
                    currentNode.left = new Node(0);
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right != null) {
                    currentNode.right.count++;
                } else {
                    currentNode.right = new Node(0);
                }
                currentNode = currentNode.right;
            }
        }
    }

    public void delete(int value) {
        Node currentNode = head;
        for (int i = 30; i >= 0; i--) {
            if ((value & (1 << i)) > 0) {
                if (currentNode.left.count > 0) {
                    currentNode.left.count--;
                } else {
                    currentNode.left = null;
                    break;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right.count > 0) {
                    currentNode.right.count--;
                } else {
                    currentNode.right = null;
                    break;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public int query(int value) {
        Node currentNode = head;
        int result = 0;
        for (int i = 30; i >= 0; i--) {
            if ((value & (1 << i)) > 0) {
                if (currentNode.right != null) {
                    result = result << 1;
                    result += 1;
                    currentNode = currentNode.right;
                } else {
                    result = result << 1;
                    result += 0;
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.left != null) {
                    result = result << 1;
                    result += 1;
                    currentNode = currentNode.left;
                } else {
                    result = result << 1;
                    result += 0;
                    currentNode = currentNode.right;
                }
            }
        }
        return result;
    }
}

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int numberOfOperations;
    private static Trie trie;

    public static void main(String[] args) throws IOException {
        initialize();
        printResult(computeResult());
    }

    private static void initialize() throws IOException {
        numberOfOperations = Integer.parseInt(bufferedReader.readLine());
        trie = new Trie();
    }

    private static String computeResult() throws IOException {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numberOfOperations; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            switch (command) {
                case 1:
                    trie.insert(value);
                    break;
                case 2:
                    trie.delete(value);
                    break;
                default:
                    resultBuilder.append(trie.query(value)).append("\n");
                    break;
            }
        }
        return resultBuilder.toString();
    }

    private static void printResult(String result) throws IOException {
        bufferedWriter.write(result);
        bufferedWriter.flush();
    }
}