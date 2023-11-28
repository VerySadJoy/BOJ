//Question No: Q2751
//Title: 수 정렬하기 2
//Tier: Silver V
using System.Text;

namespace Joy
{
    class Q2751
    {
        static void Main()
        {
            int size = int.Parse(Console.ReadLine());
            int[] numbers = new int[size];

            for (int i = 0; i < size; i++)
            {
                numbers[i] = int.Parse(Console.ReadLine());
            }

            Array.Sort(numbers);


            StringBuilder result = new StringBuilder(string.Join("\n", numbers));

            Console.WriteLine(result);
        }
    }
}

