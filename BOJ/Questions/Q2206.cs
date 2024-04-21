//Question No: 2206
//Title: 벽 부수고 이동하기
//Tier: Gold III
namespace Joy
{
    class Q2206
    {
        const int MAX_SIZE = 1001 * 1001 + 10;
        static int n, m;
        static int[,] map = new int[1001, 1001];
        static int[,] temp = new int[1001, 1001];
        static int[, ,] visited = new int[1001, 1001, 2];
        static int[] dx = { -1, 0, 1, 0 };
        static int[] dy = { 0, 1, 0, -1 };

        struct QueueItem
        {
            public int x;
            public int y;
            public int wall;
        }

        static QueueItem[] q = new QueueItem[MAX_SIZE];

        static void BFS()
        {
            int cur = -1, last = 0;
            q[last] = new QueueItem { x = 0, y = 0, wall = 0 };
            last++;

            while (cur < last && temp[n - 1, m - 1] == -1)
            {
                cur++;
                int x = q[cur].x;
                int y = q[cur].y;
                int wall = q[cur].wall;

                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < m && 0 <= ny && ny < n)
                    {
                        if (map[ny, nx] == 1 && wall == 0 && visited[ny, nx, wall + 1] == 0)
                        {
                            temp[ny, nx] = temp[y, x] + 1;
                            q[last] = new QueueItem { x = nx, y = ny, wall = 1 };
                            last++;
                            visited[ny, nx, wall + 1]++;
                        }
                        else if (map[ny, nx] == 0 && visited[ny, nx, wall] == 0)
                        {
                            temp[ny, nx] = temp[y, x] + 1;
                            q[last] = new QueueItem { x = nx, y = ny, wall = wall };
                            last++;
                            visited[ny, nx, wall]++;
                        }
                    }
                }
            }
        }

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            n = int.Parse(input[0]);
            m = int.Parse(input[1]);

            for (int i = 0; i < n; i++)
            {
                string row = Console.ReadLine();
                for (int j = 0; j < m; j++)
                {
                    map[i, j] = row[j] - '0';
                    temp[i, j] = -1;
                }
            }

            temp[0, 0] = 1;
            BFS();

            Console.WriteLine(temp[n - 1, m - 1]);
        }
    }
}
