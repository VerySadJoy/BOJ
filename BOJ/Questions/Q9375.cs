//Question No: 9375
//Title: 패션왕 신해빈
//Tier: Silver III
namespace Joy
{
    class Q9375
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());

            for (int t = 0; t < T; t++)
            {
                int N = int.Parse(Console.ReadLine());
                Dictionary<string, int> types = new Dictionary<string, int>();

                for (int i = 0; i < N; i++)
                {
                    string[] input = Console.ReadLine().Split();
                    string type = input[1];

                    if (types.ContainsKey(type))
                    {
                        types[type]++;
                    }
                    else
                    {
                        types[type] = 1;
                    }
                }

                long result = 1;
                foreach (var e in types.Values)
                {
                    result *= (e + 1);
                }
                Console.WriteLine(result - 1);
            }
        }
    }

}
