//Question No: 1167
//Title: 트리의 지름
//Tier: Gold II
namespace Joy
{
    class Q1167
    {
        static List<(int, int)>[] tree;
        static bool[] visited;
        static int far;
        static int maxDistance;
        static void Main()
        {
            int V = int.Parse(Console.ReadLine());
            tree = new List<(int, int)>[V + 1];
            for (int i = 1; i <= V; i++)
            {
                tree[i] = new List<(int, int)>();
            }
            for (int i = 0; i < V; i++)
            {
                string[] input = Console.ReadLine().Split();
                int node = int.Parse(input[0]);
                int neighborCount = input.Length - 2;
                for (int j = 0; j < neighborCount; j += 2)
                {
                    int neighbor = int.Parse(input[j + 1]);
                    int distance = int.Parse(input[j + 2]);
                    tree[node].Add((neighbor, distance));
                }
            }
            visited = new bool[V + 1];
            far = -1;
            maxDistance = int.MinValue;
            DFS(1, 0);
            visited = new bool[V + 1];
            maxDistance = int.MinValue;
            DFS(far, 0);
            Console.WriteLine(maxDistance);
        }

        static void DFS(int node, int distance)
        {
            visited[node] = true;
            if (distance > maxDistance)
            {
                maxDistance = distance;
                far = node;
            }
            foreach ((int neighbor, int neighborDistance) in tree[node])
            {
                if (!visited[neighbor])
                {
                    DFS(neighbor, distance + neighborDistance);
                }
            }
        }
    }

}
