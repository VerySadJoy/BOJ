//Question No: 11724
//Title: 연결 요소의 개수
//Tier: Silver II
using System.Text;

namespace Joy
{
    class Q11724
    {
        static List<int>[] graph;
        static bool[] visited;
        static StringBuilder result;

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);

            graph = new List<int>[n + 1];
            visited = new bool[n + 1];
            result = new StringBuilder();

            for (int i = 1; i <= n; i++)
            {
                graph[i] = new List<int>();
            }

            for (int i = 0; i < m; i++)
            {
                input = Console.ReadLine().Split();
                int u = int.Parse(input[0]);
                int v = int.Parse(input[1]);

                graph[u].Add(v);
                graph[v].Add(u);
            }

            int components = 0;

            for (int i = 1; i <= n; i++)
            {
                if (!visited[i])
                {
                    Search(i);
                    components++;
                }
            }

            result.AppendLine(components.ToString());
            Console.Write(result.ToString());
        }

        static void Search(int node)
        {
            if (visited[node])
            {
                return;
            }
            visited[node] = true;

            foreach (int neighbor in graph[node])
            {
                Search(neighbor);
            }
        }
    }
}
