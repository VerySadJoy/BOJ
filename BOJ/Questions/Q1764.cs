//Question No: 1764
//Title: 듣보잡
//Tier: Silver IV
namespace Joy
{
    class Q1764
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int M = int.Parse(input[1]);

            HashSet<string> unheard = new HashSet<string>();
            List<string> answer = new List<string>();

            for (int i = 0; i < N; i++)
            {
                unheard.Add(Console.ReadLine());
            }

            for (int i = 0; i < M; i++)
            {
                string name = Console.ReadLine();
                if (unheard.Contains(name))
                {
                    answer.Add(name);
                }
            }

            Console.WriteLine(answer.Count);
            answer.Sort();
            foreach (string name in answer)
            {
                Console.WriteLine(name);
            }
        }
    }
}
