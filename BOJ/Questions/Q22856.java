//Question No: 22856
//Title: 트리 순회
//Tier: Gold IV
import java.util.Scanner;

class Node {
    int leftChild;
    int rightChild;

    Node(int leftChild, int rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

public class Main {
    static Node[] treeNodes;
    static int[] parentNodes;
    static boolean[] visitedNodes;
    static int numberOfMoves = 0;
    static int numberOfNodes;
    static int endNodeIndex;
    static boolean traversalComplete = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberOfNodes = scanner.nextInt();

        treeNodes = new Node[numberOfNodes + 1];
        parentNodes = new int[numberOfNodes + 1];
        visitedNodes = new boolean[numberOfNodes + 1];

        for (int i = 0; i < numberOfNodes; i++) {
            int nodeIndex = scanner.nextInt();
            int leftChild = scanner.nextInt();
            int rightChild = scanner.nextInt();
            treeNodes[nodeIndex] = new Node(leftChild, rightChild);
            
            if (leftChild != -1) {
                parentNodes[leftChild] = nodeIndex;
            }
            if (rightChild != -1) {
                parentNodes[rightChild] = nodeIndex;
            }
        }

        endNodeIndex = findRightmostNode(1);
        performInorderTraversal(1, true);

        if (numberOfNodes == 1) {
            System.out.println("0");
        } else {
            System.out.println(numberOfMoves);
        }
    }

    static int findRightmostNode(int currentNode) {
        if (treeNodes[currentNode].rightChild == -1) {
            return currentNode;
        }
        return findRightmostNode(treeNodes[currentNode].rightChild);
    }

    static void performInorderTraversal(int currentNode, boolean isRoot) {
        if (traversalComplete) return;

        if (treeNodes[currentNode].leftChild != -1 && !visitedNodes[treeNodes[currentNode].leftChild]) {
            numberOfMoves++;
            performInorderTraversal(treeNodes[currentNode].leftChild, false);
        }
        if (traversalComplete) return;

        if (treeNodes[currentNode].rightChild != -1 && !visitedNodes[treeNodes[currentNode].rightChild]) {
            numberOfMoves++;
            performInorderTraversal(treeNodes[currentNode].rightChild, false);
        }
        if (traversalComplete) return;

        if (currentNode == endNodeIndex) {
            traversalComplete = true;
            return;
        }

        if (!isRoot) numberOfMoves++;
        visitedNodes[currentNode] = true;
    }
}