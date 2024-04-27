//Question No: 15650
//Title: N과 M (2)
//Tier: Silver II
namespace Joy
{
    class Q15650
    {
        static int N, M;
        static bool[] visited;
        static List<int> sequence;
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);
            visited = new bool[N + 1];
            sequence = new List<int>();
            Backtrack(1, 0);
        }
        static void Backtrack(int start, int depth)
        {
            if (depth == M)
            {
                foreach (int num in sequence)
                {
                    Console.Write(num + " ");
                }
                Console.WriteLine();
                return;
            }
            for (int i = start; i <= N; i++)
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    sequence.Add(i);
                    Backtrack(i + 1, depth + 1);
                    visited[i] = false;
                    sequence.RemoveAt(sequence.Count - 1);
                }
            }
        }
    }
}
