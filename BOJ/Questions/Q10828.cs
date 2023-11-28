//Question No: 10828
//Title: 스택
//Tier: Silver IV
using System.Text;
using System.Linq;

namespace Joy
{
    class Q10828
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            Stack<int> stack = new Stack<int>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split();

                switch (input[0])
                {
                    case "push":
                        int num = int.Parse(input[1]);
                        stack.Push(num);
                        break;
                    case "pop":
                        result.Append((stack.Count == 0 ? -1 : stack.Pop()).ToString());
                        result.Append("\n");
                        break;
                    case "size":
                        result.Append((stack.Count).ToString());
                        result.Append("\n");
                        break;
                    case "empty":
                        result.Append((stack.Count == 0 ? 1 : 0).ToString());
                        result.Append("\n");
                        break;
                    case "top":
                        result.Append((stack.Count == 0 ? -1 : stack.Peek()).ToString());
                        result.Append("\n");
                        break;
                }
            }
            if (result.Length > 0)
            {
                result.Length -= 1;
            }
            
            Console.WriteLine(result);
            
        }
    }
}
