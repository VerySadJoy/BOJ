//Question No: 15663
//Title: N과 M (9)
//Tier: Silver II
namespace Joy
{
    class Q15663
    {
        static int N, M;
        static int[] numbers;
        static bool[] visited;
        static List<int> permutation;
        static HashSet<string> set;
        static void Main()
        {
            string[] input1 = Console.ReadLine().Split();
            N = int.Parse(input1[0]);
            M = int.Parse(input1[1]);
            numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Array.Sort(numbers);
            visited = new bool[N];
            permutation = new List<int>();
            set = new HashSet<string>();
            dfs(0);
        }
        static void dfs(int depth)
        {
            if (depth == M)
            {
                string key = string.Join(" ", permutation);
                if (!set.Contains(key))
                {
                    Console.WriteLine(key);
                    set.Add(key);
                }
                return;
            }
            for (int i = 0; i < N; i++)
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    permutation.Add(numbers[i]);
                    dfs(depth + 1);
                    visited[i] = false;
                    permutation.RemoveAt(permutation.Count - 1);
                }
            }
        }
    }
}
