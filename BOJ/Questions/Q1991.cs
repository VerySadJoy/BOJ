//Question No: 1991
//Title: 트리 순회
//Tier: Silver I

namespace Joy
{
    struct Node
    {
        public char Data;
        public int? Left;
        public int? Right;

        public Node(char data)
        {
            Data = data;
            Left = Right = null;
        }
    }

    class Q1991
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            Node[] tree = new Node[26]; // Array to hold nodes to reference by character

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split();
                char data = input[0][0];
                char leftData = input[1][0];
                char rightData = input[2][0];
                int dataIndex = data - 'A';

                tree[dataIndex] = new Node(data);

                if (leftData != '.')
                {
                    int leftIndex = leftData - 'A';
                    tree[dataIndex].Left = leftIndex;
                }

                if (rightData != '.')
                {
                    int rightIndex = rightData - 'A';
                    tree[dataIndex].Right = rightIndex;
                }
            }

            Preorder(tree, 0);
            Console.WriteLine();
            Inorder(tree, 0);
            Console.WriteLine();
            Postorder(tree, 0);
            Console.WriteLine();
        }

        static void Preorder(Node[] tree, int? index)
        {
            if (!index.HasValue) return;
            Console.Write(tree[index.Value].Data);
            Preorder(tree, tree[index.Value].Left);
            Preorder(tree, tree[index.Value].Right);
        }

        static void Inorder(Node[] tree, int? index)
        {
            if (!index.HasValue) return;
            Inorder(tree, tree[index.Value].Left);
            Console.Write(tree[index.Value].Data);
            Inorder(tree, tree[index.Value].Right);
        }

        static void Postorder(Node[] tree, int? index)
        {
            if (!index.HasValue) return;
            Postorder(tree, tree[index.Value].Left);
            Postorder(tree, tree[index.Value].Right);
            Console.Write(tree[index.Value].Data);
        }
    }
}
