//Question No: 10814
//Title: 나이순 정렬
//Tier: Silver V
using System.Text;

namespace Joy
{
    class Q10814
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            List<List<string>> people = new List<List<string>>();

            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split();
                int age = int.Parse(input[0]);
                string name = input[1];

                people.Add(new List<string> {age.ToString(), name, i.ToString()});
            }

            people.Sort((x, y) =>
            {
                if (Convert.ToInt32(x[0]) != Convert.ToInt32(y[0]))
                    return Convert.ToInt32(x[0]).CompareTo(Convert.ToInt32(y[0]));
                else
                    return Convert.ToInt32(x[2]).CompareTo(Convert.ToInt32(y[2]));
            });

            StringBuilder result = new StringBuilder();

            foreach (var person in people)
            {
                result.Append($"{person[0]} {person[1]}\n");
            }

            Console.Write(result);
        }
    }
}

