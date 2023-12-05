//Question No: 1620
//Title: 나는야 포켓몬 마스터 이다솜
//Tier: Silver IV
using System.Text;

namespace Joy
{
    class Q1620
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            
            Dictionary<int, string> numberToName = new Dictionary<int, string>();
            Dictionary<string, int> nameToNumber = new Dictionary<string, int>();

            for (int i = 1; i <= n; i++)
            {
                string name = Console.ReadLine();
                nameToNumber[name] = i;
                numberToName[i] = name;
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m; i++)
            {
                string query = Console.ReadLine();

                if (char.IsDigit(query[0]))
                {
                    int number = int.Parse(query);
                    result.Append($"{numberToName[number]}\n");
                }
                else
                {
                    result.Append($"{nameToNumber[query]}\n");
                }
            }

            if (result.Length > 0)
            {
                result.Length--;
            }

            Console.WriteLine(result);
        }
    }
}
