//Question No: 10866
//Title: 덱
//Tier: Silver IV
using System.Text;

namespace Joy
{
    class Q10866
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            LinkedList<int> deque = new LinkedList<int>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split();

                switch (input[0])
                {
                    case "push_front":
                        int num1 = int.Parse(input[1]);
                        deque.AddFirst(num1);
                        break;
                    case "push_back":
                        int num2 = int.Parse(input[1]);
                        deque.AddLast(num2);
                        break;
                    case "pop_front":
                        result.Append((deque.Count == 0 ? -1 : deque.First.Value).ToString());
                        result.Append("\n");
                        if (deque.Count > 0)
                        {
                            deque.RemoveFirst();
                        }
                        break;
                    case "pop_back":
                        result.Append((deque.Count == 0 ? -1 : deque.Last.Value).ToString());
                        result.Append("\n");
                        if (deque.Count > 0)
                        {
                            deque.RemoveLast();
                        }
                        break;
                    case "size":
                        result.Append((deque.Count).ToString());
                        result.Append("\n");
                        break;
                    case "empty":
                        result.Append((deque.Count == 0 ? 1 : 0).ToString());
                        result.Append("\n");
                        break;
                    case "front":
                        result.Append((deque.Count == 0 ? -1 : deque.First.Value).ToString());
                        result.Append("\n");
                        break;
                    case "back":
                        result.Append((deque.Count == 0 ? -1 : deque.Last.Value).ToString());
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