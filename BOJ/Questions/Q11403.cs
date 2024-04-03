//Question No: 11403
//Title: 경로 찾기
//Tier: Silver I

namespace Joy{
    class Q11403
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[,] graph = new int[101, 101];
            for (int i = 0; i < n; i++)
            {
                string[] row = Console.ReadLine().Split();
                for (int j = 0; j < n; j++)
                {
                    graph[i, j] = int.Parse(row[j]);
                }
            }
            for (int k = 0; k < n; k++)
            {
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < n; j++)
                    {
                        if (graph[i, k] == 1 && graph[k, j] == 1)
                        {
                            graph[i, j] = 1;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Console.Write(graph[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}