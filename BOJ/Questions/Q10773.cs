//Question No: 10773
//Title: 제로
//Tier: Silver IV
namespace Joy
{
    class Q10773
    {
        static void Main()
        {
            int K = int.Parse(Console.ReadLine());

            Stack<int> stack = new Stack<int>();

            for (int i = 0; i < K; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num == 0)
                {
                    stack.Pop();                  
                }
                else
                {
                    stack.Push(num);
                }
            }

            int sum = 0;
            foreach (int value in stack)
            {
                sum += value;
            }

            Console.WriteLine(sum);
        }
    }
}
