//Question No: 7662
//Title: 이중 우선순위 큐
//Tier: Gold IV
namespace Joy{

    class Q7662
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());

            while (T-- > 0)
            {
                int k = int.Parse(Console.ReadLine());
                SortedSet<int> q = new SortedSet<int>();

                for (int i = 0; i < k; i++)
                {
                    string[] input = Console.ReadLine().Split();
                    char c = input[0][0];
                    int n = int.Parse(input[1]);

                    if (c == 'I')
                    {
                        q.Add(n);
                    }
                    else if (c == 'D')
                    {
                        if (q.Count == 0)
                        {
                            continue;
                        }
                        else if (n == 1)
                        {
                            q.Remove(q.Max);
                        }
                        else if (n == -1)
                        {
                            q.Remove(q.Min);
                        }
                    }
                }

                if (q.Count == 0)
                {
                    Console.WriteLine("EMPTY");
                }
                else
                {
                    Console.WriteLine($"{q.Max} {q.Min}");
                }
            }
        }
    }

}