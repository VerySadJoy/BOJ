//Question No: 1987
//Title: 알파벳
//Tier: Gold IV

namespace Joy
{
    class Q1987
    {
        private static char[,] grid;
        private static bool[] visited = new bool[26];
        private static int maxPathLength = 0;
        private static int rows, cols;

        private struct Direction
        {
            public int X;
            public int Y;
            public Direction(int x, int y)
            {
                X = x;
                Y = y;
            }
        }
        private static Direction[] directions = {
            new Direction(-1, 0),
            new Direction(1, 0),
            new Direction(0, 1),
            new Direction(0, -1)
        };

        private static void Explore(int x, int y, int pathLength)
        {
            maxPathLength = Math.Max(maxPathLength, pathLength);

            foreach (var dir in directions)
            {
                int newX = x + dir.X;
                int newY = y + dir.Y;
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[grid[newX, newY] - 'A'])
                {
                    visited[grid[newX, newY] - 'A'] = true;
                    Explore(newX, newY, pathLength + 1);
                    visited[grid[newX, newY] - 'A'] = false;
                }
            }
        }

        public static void Main()
        {
            string[] inputs = Console.ReadLine().Split();
            rows = int.Parse(inputs[0]);
            cols = int.Parse(inputs[1]);
            grid = new char[rows, cols];

            for (int i = 0; i < rows; i++)
            {
                string line = Console.ReadLine();
                for (int j = 0; j < cols; j++)
                {
                    grid[i, j] = line[j];
                }
            }

            visited[grid[0, 0] - 'A'] = true;
            Explore(0, 0, 1);

            Console.Write(maxPathLength);
        }
    }
}
