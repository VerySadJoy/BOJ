//Question No: 11866
//Title: 요세푸스 문제 0
//Tier: Silver V
using System.Text;

namespace Joy
{
    class Q11866
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int K = int.Parse(input[1]);
            StringBuilder result = new StringBuilder();

            List<int> people = new List<int>();
            for (int i = 1; i <= N; i++)
            {
                people.Add(i);
            }

            int index = 0;
            result.Append("<");

            while (people.Count > 0)
            {
                index = (index + K - 1) % people.Count;

                result.Append(people[index]);
                people.RemoveAt(index);

                if (people.Count > 0)
                {
                    result.Append(", ");
                }
            }

            result.Append(">");

            Console.WriteLine(result);
        }
    }
}
