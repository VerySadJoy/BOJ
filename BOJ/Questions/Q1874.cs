//Question No: 1874
//Title: 스택 수열
//Tier: Silver II
using System.Text;

namespace Joy
{
    class Q1874
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int[] sequence = new int[n];
            for (int i = 0; i < n; i++)
            {
                sequence[i] = int.Parse(Console.ReadLine());
            }

            StringBuilder result = new StringBuilder();
            Stack<int> stack = new Stack<int>();
            int current = 1;

            foreach (var target in sequence)
            {
                while (current <= target)
                {
                    stack.Push(current);
                    result.Append('+').Append('\n');
                    current++;
                }

                if (stack.Peek() == target)
                {
                    stack.Pop();
                    result.Append('-').Append('\n');
                }
                else
                {
                    Console.WriteLine("NO");
                    return;
                }
            }

            Console.WriteLine(result.ToString());
        }
    }
}