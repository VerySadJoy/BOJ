//Question No: 1697
//Title: 숨바꼭질
//Tier: Silver I
namespace Joy
{
    class Q1697
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int start = int.Parse(input[0]);
            int end = int.Parse(input[1]);
            

            Queue<int> queue = new Queue<int>();
            bool[] visited = new bool[100001];

            queue.Enqueue(start);
            visited[start] = true;

            int time = 0;
            if (start == end)
            {
                Console.WriteLine(time);
                return;
            }

            while (queue.Count > 0)
            {
                int size = queue.Count;

                for (int i = 0; i < size; i++)
                {
                    int current = queue.Dequeue();

                    for (int j = 0; j < 3; j++)
                    {
                        int next;

                        if (j == 0)
                            next = current - 1;
                        else if (j == 1)
                            next = current + 1;
                        else
                            next = current * 2;

                        if (next >= 0 && next <= 100000 && !visited[next])
                        {
                            if (next == end)
                            {
                                time++;
                                Console.WriteLine(time);
                                return;
                            }

                            queue.Enqueue(next);
                            visited[next] = true;
                        }
                    }
                }

                time++;
            };
        }
    }

}