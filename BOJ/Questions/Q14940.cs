//Question No: 14940
//Title: 쉬운 최단거리
//Tier: Silver I
namespace Joy
{
    class Q14940
    {
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        static void Main()
        {
            string[] nm = Console.ReadLine().Split();
            int n = int.Parse(nm[0]);
            int m = int.Parse(nm[1]);

            int[,] graph = new int[n, m];

            for (int i = 0; i < n; i++)
            {
                string[] row = Console.ReadLine().Split();
                for (int j = 0; j < m; j++)
                {
                    graph[i, j] = int.Parse(row[j]);
                }
            }

            int[] targetLocation = Find(graph, n, m);
            int[,] distances = BFS(targetLocation, graph, n, m);

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (graph[i, j] == 0)
                    {
                        Console.Write(0 + " ");
                    }
                    else if (distances[i, j] == 0)
                    {
                        Console.Write(-1 + " ");
                    }
                    else
                    {
                        Console.Write(distances[i, j] + " ");
                    }
                }
                Console.WriteLine();
            }
        }
        static int[,] BFS(int[] start, int[,] graph, int n, int m)
        {
            bool[,] visited = new bool[n, m];
            int[,] distance = new int[n, m];

            Queue<int[]> queue = new Queue<int[]>();
            queue.Enqueue(new int[] {start[0], start[1]});
            visited[start[0], start[1]] = true;

            while (queue.Count > 0)
            {
                int[] current = queue.Dequeue();
                int x = current[0];
                int y = current[1];

                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx, ny] && graph[nx, ny] == 1)
                    {
                        visited[nx, ny] = true;
                        distance[nx, ny] = distance[x, y] + 1;
                        queue.Enqueue(new int[] {nx, ny});
                    }
                }
            }

            return distance;
        }

        static int[] Find(int[,] graph, int n, int m)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (graph[i, j] == 2)
                    {
                        return new int[] {i, j};
                    }
                }
            }
            return null;
        }

        
    }

}
