//checkuestion No: 21736
//Title: 헌내기는 친구가 필요해
//Tier: Silver II
namespace Joy
{
    class Q21736
    {
        static void Main()
        {
            int[] inputs = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int n = inputs[0];
            int m = inputs[1];
            char[,] all = new char[n, m];
            Queue<(int, int)> check = new Queue<(int, int)>();
            bool[,] visited = new bool[n, m];
            int[] dx = { 1, 0, -1, 0 };
            int[] dy = { 0, 1, 0, -1 };
            for (int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                for (int j = 0; j < m; j++)
                {
                    all[i, j] = s[j];
                    if (all[i, j] != 'I') continue;
                    check.Enqueue((i, j));
                    visited[i, j] = true;
                }
            }
            int count = 0;
            while (check.Count > 0)
            {
                var cur = check.Dequeue();
                int x = cur.Item1;
                int y = cur.Item2;
                for (int dir = 0; dir < 4; dir++)
                {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (all[nx, ny] == 'X') continue;
                    if (visited[nx, ny] == true) continue;
                    if (all[nx, ny] == 'P') count++;
                    check.Enqueue((nx, ny));
                    visited[nx, ny] = true;
                }
            }
            Console.WriteLine($"{(count == 0 ? "TT" : count)}");
        }
    }
}