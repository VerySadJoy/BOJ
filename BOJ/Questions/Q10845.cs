//Question No: 10845
//Title: 큐
//Tier: Silver IV
using System.Text;

namespace Joy
{
    class Q10845
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            Queue<int> queue = new Queue<int>();
            StringBuilder result = new StringBuilder();
            int last = -1;

            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split();

                switch (input[0])
                {
                    case "push":
                        last = int.Parse(input[1]);
                        queue.Enqueue(last);
                        break;
                    case "pop":
                        result.Append((queue.Count == 0 ? -1 : queue.Dequeue()).ToString());
                        result.Append("\n");
                        break;
                    case "size":
                        result.Append((queue.Count).ToString());
                        result.Append("\n");
                        break;
                    case "empty":
                        result.Append((queue.Count == 0 ? 1 : 0).ToString());
                        result.Append("\n");
                        break;
                    case "front":
                        result.Append((queue.Count == 0 ? -1 : queue.Peek()).ToString());
                        result.Append("\n");
                        break;
                    case "back":
                        result.Append((queue.Count == 0 ? -1 : last).ToString());
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