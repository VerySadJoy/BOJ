//Question No: 9019
//Title: DSLR
//Tier: Gold IV
using System.Text;

namespace Joy
{
    class Q9019
    {
        static void Main()
        {
            int total = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int t = 0; t < total; t++)
            {
                string[] input = Console.ReadLine().Split();
                int S = int.Parse(input[0]);
                int T = int.Parse(input[1]);

                string dslr = FindOperations(S, T);
                result.Append($"{dslr}\n");
            }
            if (result.Length > 0){
                result.Length--;
            }
            Console.WriteLine(result);
        }

        static string FindOperations(int S, int T)
        {
            bool[] visited = new bool[10000];
            Queue<(int, string)> queue = new Queue<(int, string)>();

            queue.Enqueue((S, ""));

            while (queue.Count > 0)
            {
                (int current, string operations) = queue.Dequeue();

                if (current == T)
                {
                    return operations;
                }
                int nextD = (current * 2) % 10000;
                if (!visited[nextD])
                {
                    visited[nextD] = true;
                    queue.Enqueue((nextD, operations + "D"));
                }
                int nextS = (current == 0) ? 9999 : current - 1;
                if (!visited[nextS])
                {
                    visited[nextS] = true;
                    queue.Enqueue((nextS, operations + "S"));
                }
                int nextL = (current % 1000) * 10 + (current / 1000);
                if (!visited[nextL])
                {
                    visited[nextL] = true;
                    queue.Enqueue((nextL, operations + "L"));
                }
                int nextR = (current % 10) * 1000 + (current / 10);
                if (!visited[nextR])
                {
                    visited[nextR] = true;
                    queue.Enqueue((nextR, operations + "R"));
                }
            }
            return "";
        }      
    }
}

