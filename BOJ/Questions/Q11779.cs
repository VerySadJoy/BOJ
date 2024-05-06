//Question No: 11779
//Title: 최소비용 구하기 2
//Tier: Gold III
namespace Joy
{
    class Q11779
    {
        static int[] backward = new int[1001];
        static Stack<int> res = new Stack<int>();
        public static void Main()
        {
            int v, e;
            v = int.Parse(Console.ReadLine());
            e = int.Parse(Console.ReadLine());
            List<List<Tuple<int, int>>> adj = new List<List<Tuple<int, int>>>();
            for (int i = 0; i < v; i++)
            {
                adj.Add(new List<Tuple<int, int>>());
            }

            for (int i = 0; i < e; i++)
            {
                string[] inputs = Console.ReadLine().Split();
                int from = int.Parse(inputs[0]);
                int to = int.Parse(inputs[1]);
                int weight = int.Parse(inputs[2]);

                adj[from - 1].Add(new Tuple<int, int>(weight, to));
            }
            string[] inputss = Console.ReadLine().Split();
            int start = int.Parse(inputss[0]);
            int dest = int.Parse(inputss[0]);
            Console.WriteLine(Dijkstra(adj, start, dest));
            int cnt = 0;
            int pntr = dest;
            while (pntr != 0)
            {
                cnt++;
                res.Push(pntr);
                pntr = backward[pntr];
            }
            Console.WriteLine(cnt);
            while (res.Count > 0)
            {
                Console.Write(res.Pop() + " ");
            }
        }
        public static long Dijkstra(List<List<Tuple<int, int>>> adj, int start, int goal)
        {
            long[] dist = new long[adj.Count];
            Array.Fill(dist, long.MaxValue);
            dist[start - 1] = 0;
            var pq = new SortedSet<Tuple<long, int>>(Comparer<Tuple<long, int>>.Create((x, y) =>
            {
                int result = x.Item1.CompareTo(y.Item1);
                if (result == 0) result = x.Item2.CompareTo(y.Item2);
                return result;
            }));
            pq.Add(new Tuple<long, int>(0, start));
            while (pq.Count != 0)
            {
                var cur = pq.Min;
                pq.Remove(cur);
                if (cur.Item1 > dist[cur.Item2 - 1])
                    continue;
                foreach (var item in adj[cur.Item2 - 1])
                {
                    long nextPay = cur.Item1 + item.Item1;
                    if (dist[item.Item2 - 1] > nextPay)
                    {
                        if (pq.Contains(new Tuple<long, int>(dist[item.Item2 - 1], item.Item2)))
                            pq.Remove(new Tuple<long, int>(dist[item.Item2 - 1], item.Item2));

                        dist[item.Item2 - 1] = nextPay;
                        backward[item.Item2] = cur.Item2;
                        pq.Add(new Tuple<long, int>(nextPay, item.Item2));
                    }
                }
            }
            return dist[goal - 1];
        }
    }
}
