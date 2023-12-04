//Question No: 1389
//Title: 케빈 베이컨의 6단계 법칙
//Tier: Silver I

namespace Joy{
    class Q1389
    {
        static int BFS(List<int>[] graph, int start, int n)
        {
            int[] num = new int[n + 1];
            List<int> visited = new List<int>();
            Queue<int> queue = new Queue<int>();

            visited.Add(start);
            queue.Enqueue(start);

            while (queue.Count > 0)
            {
                int a = queue.Dequeue();
                foreach (int i in graph[a])
                {
                    if (!visited.Contains(i))
                    {
                        num[i] = num[a] + 1;
                        visited.Add(i);
                        queue.Enqueue(i);
                    }
                }
            }

            return num.Sum();
        }

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);

            List<int>[] graph = new List<int>[n + 1];
            for (int i = 0; i <= n; i++)
            {
                graph[i] = new List<int>();
            }

            for (int i = 0; i < m; i++)
            {
                input = Console.ReadLine().Split();
                int a = int.Parse(input[0]);
                int b = int.Parse(input[1]);
                graph[a].Add(b);
                graph[b].Add(a);
            }

            List<int> result = new List<int>();
            for (int i = 1; i <= n; i++)
            {
                result.Add(BFS(graph, i, n));
            }

            Console.WriteLine(result.IndexOf(result.Min()) + 1);
        }
    }
}
