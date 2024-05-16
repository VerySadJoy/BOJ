//Question No: 2263
//Title: 트리의 순회
//Tier: Gold I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] inorder;
    static int[] postorder;
    static int[] inorderIdx;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void buildTree(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        bw.write(root + " ");

        int rootIdx = inorderIdx[root];
        int leftSize = rootIdx - inStart;
        int rightSize = inEnd - rootIdx;

        buildTree(inStart, rootIdx - 1, postStart, postStart + leftSize - 1);
        buildTree(rootIdx + 1, inEnd, postEnd - rightSize, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        inorderIdx = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIdx[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        buildTree(0, n - 1, 0, n - 1);

        br.close();
        bw.flush();
        bw.close();
    }
}
