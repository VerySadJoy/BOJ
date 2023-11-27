//Question No: 1966
//Title: 프린터 큐
//Tier: Silver III
namespace Joy{
    class Q1966
    {
        static void Main()
        {
            int inputNumber = int.Parse(Console.ReadLine());
            List<int> finalList = new List<int>();
            for (int i = 0; i < inputNumber; i++)
            {
                int[] inputs = Console.ReadLine().Split().Select(int.Parse).ToArray();
                int n = inputs[0];
                int m = inputs[1];

                int[] priorities = Console.ReadLine().Split().Select(int.Parse).ToArray();

                Queue<(int Priority, int Index)> queue = new Queue<(int, int)>();
                for (int j = 0; j < priorities.Length; j++)
                {
                    queue.Enqueue((priorities[j], j));
                }

                int order = 1;

                while (queue.Count > 0)
                {
                    (int priority, int index) current = queue.Dequeue();

                    if (queue.Any(job => job.Priority > current.priority))
                    {
                        queue.Enqueue(current);
                    }
                    else
                    {
                        if (current.index == m)
                        {
                            finalList.Add(order);
                        }

                        order++;
                    }
            }
            }
            for (int i = 0; i < finalList.Count; i++)
            {
                Console.WriteLine(finalList[i]);
            }
        }
    }
}
