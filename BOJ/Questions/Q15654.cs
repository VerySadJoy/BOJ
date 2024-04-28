//Question No: 15654
//Title: N과 M (5)
//Tier: Silver III
namespace Joy
{
    class Q15654
    {
        static int N, M;
        static int[] numbers;
        static bool[] visited;
        static List<int> permutation;
        static void Main()
        {
            string[] input1 = Console.ReadLine().Split();
            N = int.Parse(input1[0]);
            M = int.Parse(input1[1]);
            numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            Array.Sort(numbers);
            visited = new bool[N];
            permutation = new List<int>();
            GeneratePermutations(0);
        }
        static void GeneratePermutations(int depth)
        {
            if (depth == M)
            {
                Console.WriteLine(string.Join(" ", permutation));
                return;
            }
            for (int i = 0; i < N; i++)
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    permutation.Add(numbers[i]);
                    GeneratePermutations(depth + 1);
                    visited[i] = false;
                    permutation.RemoveAt(permutation.Count - 1);
                }
            }
        }
    }
}
