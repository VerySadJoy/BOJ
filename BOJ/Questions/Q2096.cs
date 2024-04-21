//Question No: 2096
//Title: 내려가기
//Tier: Gold V
namespace Joy{
    class Q2096
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] maxDP = new int[3];
            int[] minDP = new int[3];
            string[] initialInputs = Console.ReadLine().Split();
            maxDP[0] = minDP[0] = int.Parse(initialInputs[0]);
            maxDP[1] = minDP[1] = int.Parse(initialInputs[1]);
            maxDP[2] = minDP[2] = int.Parse(initialInputs[2]);
            for (int i = 1; i < n; i++)
            {
                string[] inputs = Console.ReadLine().Split();
                int[] input = Array.ConvertAll(inputs, int.Parse);
                int temp0 = maxDP[0], temp2 = maxDP[2];
                maxDP[0] = Math.Max(maxDP[0], maxDP[1]) + input[0];
                maxDP[2] = Math.Max(maxDP[1], maxDP[2]) + input[2];
                maxDP[1] = Math.Max(Math.Max(temp0, maxDP[1]), temp2) + input[1];

                temp0 = minDP[0];
                temp2 = minDP[2];
                minDP[0] = Math.Min(minDP[0], minDP[1]) + input[0];
                minDP[2] = Math.Min(minDP[1], minDP[2]) + input[2];
                minDP[1] = Math.Min(Math.Min(temp0, minDP[1]), temp2) + input[1];
            }
            int maxScore = Math.Max(Math.Max(maxDP[0], maxDP[1]), maxDP[2]);
            int minScore = Math.Min(Math.Min(minDP[0], minDP[1]), minDP[2]);
            Console.WriteLine($"{maxScore} {minScore}");
        }
    }
}