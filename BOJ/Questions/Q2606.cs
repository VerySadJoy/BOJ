//Question No: 2606
//Title: 바이러스
//Tier: Silver III
namespace Joy
{
    class Q2606
    {
        static bool[] visited;
        static List<int>[] graph;
        static int count = 0;
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());

            visited = new bool[n + 1];
            graph = new List<int>[n + 1];

            for (int i = 1; i <= n; i++)
            {
                graph[i] = new List<int>();
            }

            for (int i = 0; i < m; i++)
            {
                string[] input = Console.ReadLine().Split();
                int u = int.Parse(input[0]);
                int v = int.Parse(input[1]);
                graph[u].Add(v);
                graph[v].Add(u);
            }

            Recursion(1);

            Console.WriteLine(count - 1);
        }
        static void Recursion(int node)
        {
            visited[node] = true;
            count++;

            foreach (var e in graph[node])
            {
                if (!visited[e])
                {
                    Recursion(e);
                }
            }
        }
    }
}
