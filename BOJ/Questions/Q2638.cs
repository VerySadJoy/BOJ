//Question No: 2638
//Title: 치즈
//Tier: Gold III
namespace Joy
{
    class Q2638
    {
        static int[,] map;
        static int n, m;
        static int[] dx = { 1, -1, 0, 0 };
        static int[] dy = { 0, 0, 1, -1 };

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            n = int.Parse(input[0]);
            m = int.Parse(input[1]);

            map = new int[n, m];

            for (int i = 0; i < n; i++)
            {
                string[] row = Console.ReadLine().Split();
                for (int j = 0; j < m; j++)
                {
                    map[i, j] = int.Parse(row[j]);
                }
            }

            int answer = 0;
            while (true)
            {
                List<(int, int)> toBeMelted = FindToBeMelted();
                if (toBeMelted.Count == 0)
                {
                    break;
                }
                foreach (var pos in toBeMelted)
                    map[pos.Item1, pos.Item2] = 0;
                answer++;
            }

            Console.WriteLine(answer);
        }

        static List<(int, int)> FindToBeMelted()
        {
            List<(int, int)> toBeMelted = new List<(int, int)>();
            int[,] visited = new int[n, m];

            Queue<(int, int)> queue = new Queue<(int, int)>();
            queue.Enqueue((0, 0));
            visited[0, 0] = 1;

            while (queue.Count > 0)
            {
                var current = queue.Dequeue();
                int x = current.Item1;
                int y = current.Item2;

                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (map[nx, ny] == 0 && visited[nx, ny] == 0)
                    {
                        visited[nx, ny] = 1;
                        queue.Enqueue((nx, ny));
                    }
                    if (map[nx, ny] == 1 && visited[nx, ny] == 0)
                    {
                        int count = 0;
                        for (int j = 0; j < 4; j++)
                        {
                            int cx = nx + dx[j];
                            int cy = ny + dy[j];
                            if (cx < 0 || cx >= n || cy < 0 || cy >= m)
                                continue;
                            if (map[cx, cy] == 0 && visited[cx, cy] == 1)
                                count++;
                        }
                        if (count >= 2)
                        {
                            toBeMelted.Add((nx, ny));
                            visited[nx, ny] = 1;
                        }
                    }
                }
            }
            return toBeMelted;
        }
    }

}
