//Question No: 1260
//Title: DFS와 BFS
//Tier: Silver II
using System.Text;

namespace Joy
{
    class Q1260
    {
        static List<int>[] graph;
        static bool[] visited;
        static StringBuilder result = new StringBuilder();

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            int v = int.Parse(input[2]);

            graph = new List<int>[n + 1];
            visited = new bool[n + 1];

            for (int i = 1; i <= n; i++)
            {
                graph[i] = new List<int>();
            }

            for (int i = 0; i < m; i++)
            {
                string[] edge = Console.ReadLine().Split();
                int a = int.Parse(edge[0]);
                int b = int.Parse(edge[1]);

                graph[a].Add(b);
                graph[b].Add(a);
            }

            for (int i = 1; i <= n; i++)
            {
                graph[i].Sort();
            }

            DFS(v);
            result.Append("\n");
            visited = new bool[n + 1];
            BFS(v);
            Console.WriteLine(result);
        }

        static void DFS(int node)
        {
            visited[node] = true;
            result.Append(node + " ");

            foreach (int neighbor in graph[node])
            {
                if (!visited[neighbor])
                {
                    DFS(neighbor);
                }
            }
        }

        static void BFS(int start)
        {
            Queue<int> queue = new Queue<int>();
            queue.Enqueue(start);
            visited[start] = true;

            while (queue.Count > 0)
            {
                int current = queue.Dequeue();
                result.Append(current + " ");

                foreach (int neighbor in graph[current])
                {
                    if (!visited[neighbor])
                    {
                        queue.Enqueue(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }
}
