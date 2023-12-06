//Question No: 2667
//Title: 단지번호붙이기
//Tier: Silver I
namespace Joy
{
    class Q2667
    {
        static int[,] map;
        static bool[,] visited;
        static int n;
        static List<int> sizes;

        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        static void Main()
        {
            n = int.Parse(Console.ReadLine());
            map = new int[n, n];
            visited = new bool[n, n];
            sizes = new List<int>();

            for (int i = 0; i < n; i++)
            {
                string row = Console.ReadLine();
                for (int j = 0; j < n; j++)
                {
                    map[i, j] = int.Parse(row[j].ToString());
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (map[i, j] == 1 && !visited[i, j])
                    {
                        sizes.Add(1);
                        DFS(i, j);
                    }
                }
            }

            sizes.Sort();

            Console.WriteLine(sizes.Count);
            foreach (var e in sizes)
            {
                Console.WriteLine(e);
            }
        }
        
        static void DFS(int x, int y)
        {
            visited[x, y] = true;

            for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n)
                {
                    if (map[nx, ny] == 1 && !visited[nx, ny])
                    {
                        sizes[sizes.Count - 1]++;
                        DFS(nx, ny);
                    }
                }
            }
        }
    }
}
