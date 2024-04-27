//Question No: 11725
//Title: 트리의 부모 찾기
//Tier: Silver II
namespace Joy
{
    class Node11725
    {
        public int number;
        public List<int> children;
        public int parent;

        public Node11725(int num)
        {
            number = num;
            children = new List<int>();
            parent = 0;
        }
    }
    class Q11725
    {
        static void Main()
        {
            StreamReader reader = new StreamReader(Console.OpenStandardInput());
            StreamWriter writer = new StreamWriter(Console.OpenStandardOutput())
            {
                AutoFlush = false
            };
            int N = int.Parse(reader.ReadLine());
            Node11725[] nodes = new Node11725[N + 1];
            for (int i = 1; i <= N; i++)
            {
                nodes[i] = new Node11725(i);
            }
            for (int i = 0; i < N - 1; i++)
            {
                string[] input = reader.ReadLine().Split();
                int u = int.Parse(input[0]);
                int v = int.Parse(input[1]);
                nodes[u].children.Add(v);
                nodes[v].children.Add(u);
            }

            DFS(nodes, 1, 0);
            for (int i = 2; i <= N; i++)
            {
                writer.WriteLine(nodes[i].parent);
            }
            writer.Flush();
        }
        static void DFS(Node11725[] nodes, int currentNode, int parentNode)
        {
            nodes[currentNode].parent = parentNode;
            foreach (int childNode in nodes[currentNode].children)
            {
                if (childNode != parentNode)
                {
                    DFS(nodes, childNode, currentNode);
                }
            }
        }
    }
}
