//Question No: 2675
//Title: 문자열 반복
//Tier: Bronze II
namespace Joy
{
    class Q2675
    {
        static void Main()
        {
            int t = int.Parse(Console.ReadLine());
            for (int i = 0; i < t; i++)
            {
                string[] input = Console.ReadLine().Split();
                int r = int.Parse(input[0]);
                string s = input[1];

                char[] repeats = new char[r * s.Length];
                int index = 0;
                for (int j = 0; j < s.Length; j++)
                {
                    for (int _ = 0; _ < r; _++)
                    {
                        repeats[index++] = s[j];
                    }
                }
                Console.WriteLine(repeats);
            }
        }
    }
}