//Question No: 1916
//Title: 최소비용 구하기
//Tier: Gold V
namespace Joy {
    class Q1916
    {
        static List<(int, int)>[] adj;
        static int[] distances;
        static int INF = int.MaxValue;

        static void Dijkstra(int start, int end)
        {
            distances = new int[adj.Length];
            Array.Fill(distances, INF);

            PriorityQueue1916<(int, int)> pq = new PriorityQueue1916<(int, int)>();
            pq.Enqueue((start, 0));
            distances[start] = 0;

            while (pq.Count > 0)
            {
                var (current, dist) = pq.Dequeue();

                if (distances[current] < dist)
                    continue;

                foreach (var (neighbor, weight) in adj[current])
                {
                    int newDist = dist + weight;
                    if (newDist < distances[neighbor])
                    {
                        distances[neighbor] = newDist;
                        pq.Enqueue((neighbor, newDist));
                    }
                }
            }

            Console.WriteLine(distances[end]);
        }

        static void Main()
        {
            string[] input;
            int N = int.Parse(Console.ReadLine());
            int M = int.Parse(Console.ReadLine());

            adj = new List<(int, int)>[N + 1];
            for (int i = 1; i <= N; i++)
            {
                adj[i] = new List<(int, int)>();
            }

            for (int i = 0; i < M; i++)
            {
                input = Console.ReadLine().Split();
                int from = int.Parse(input[0]);
                int to = int.Parse(input[1]);
                int weight = int.Parse(input[2]);
                adj[from].Add((to, weight));
            }

            input = Console.ReadLine().Split();
            int startVertex = int.Parse(input[0]);
            int endVertex = int.Parse(input[1]);

            Dijkstra(startVertex, endVertex);
        }
    }

    class PriorityQueue1916<T> where T : IComparable<T>
    {
        private List<T> list = new List<T>();

        public int Count => list.Count;

        public void Enqueue(T item)
        {
            list.Add(item);
            int i = list.Count - 1;
            while (i > 0 && list[i].CompareTo(list[(i - 1) / 2]) < 0)
            {
                T temp = list[i];
                list[i] = list[(i - 1) / 2];
                list[(i - 1) / 2] = temp;
                i = (i - 1) / 2;
            }
        }

        public T Dequeue()
        {
            T min = list[0];
            list[0] = list[list.Count - 1];
            list.RemoveAt(list.Count - 1);
            int i = 0;
            while (i * 2 + 1 < list.Count)
            {
                int left = i * 2 + 1;
                int right = i * 2 + 2;
                int j = left;
                if (right < list.Count && list[right].CompareTo(list[left]) < 0)
                {
                    j = right;
                }
                if (list[i].CompareTo(list[j]) <= 0)
                {
                    break;
                }
                T temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i = j;
            }
            return min;
        }
    }
}