
namespace Joy{
    class Q1504
    {
        static List<(int, int)>[] graph;
        static int N, E;
        static int[] specificNodes;

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            E = int.Parse(input[1]);

            graph = new List<(int, int)>[N + 1];
            for (int i = 1; i <= N; i++)
            {
                graph[i] = new List<(int, int)>();
            }

            for (int i = 0; i < E; i++)
            {
                input = Console.ReadLine().Split();
                int a = int.Parse(input[0]);
                int b = int.Parse(input[1]);
                int c = int.Parse(input[2]);
                graph[a].Add((b, c));
                graph[b].Add((a, c));
            }

            specificNodes = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);

            long dist1 = Dijkstra(1, specificNodes[0]) + Dijkstra(specificNodes[0], specificNodes[1]) + Dijkstra(specificNodes[1], N);
            long dist2 = Dijkstra(1, specificNodes[1]) + Dijkstra(specificNodes[1], specificNodes[0]) + Dijkstra(specificNodes[0], N);

            long result = Math.Min(dist1, dist2);

            Console.WriteLine(result >= int.MaxValue ? -1 : result);
        }

        static long Dijkstra(int start, int end)
        {
            long[] distance = new long[N + 1];
            Array.Fill(distance, int.MaxValue);
            bool[] visited = new bool[N + 1];

            PriorityQueue<(long, int)> pq = new PriorityQueue<(long, int)>();
            pq.Enqueue((0, start));
            distance[start] = 0;

            while (pq.Count > 0)
            {
                (long dist, int node) = pq.Dequeue();

                if (visited[node]) continue;
                visited[node] = true;

                foreach ((int neighbor, int weight) in graph[node])
                {
                    if (!visited[neighbor] && distance[neighbor] > distance[node] + weight)
                    {
                        distance[neighbor] = distance[node] + weight;
                        pq.Enqueue((distance[neighbor], neighbor));
                    }
                }
            }

            return distance[end];
        }
        class PriorityQueue<T> where T : IComparable<T>
        {
            List<T> heap;

            public PriorityQueue()
            {
                heap = new List<T>();
            }

            public int Count { get { return heap.Count; } }

            public void Enqueue(T item)
            {
                heap.Add(item);
                int i = Count - 1;
                while (i > 0)
                {
                    int parent = (i - 1) / 2;
                    if (heap[parent].CompareTo(heap[i]) <= 0) break;
                    Swap(parent, i);
                    i = parent;
                }
            }

            public T Dequeue()
            {
                if (Count == 0) throw new InvalidOperationException("Priority queue is empty");
                T top = heap[0];
                heap[0] = heap[Count - 1];
                heap.RemoveAt(Count - 1);
                int i = 0;
                while (true)
                {
                    int leftChild = 2 * i + 1;
                    int rightChild = 2 * i + 2;
                    if (leftChild >= Count) break;
                    int minChild = leftChild;
                    if (rightChild < Count && heap[rightChild].CompareTo(heap[leftChild]) < 0)
                    {
                        minChild = rightChild;
                    }
                    if (heap[i].CompareTo(heap[minChild]) <= 0) break;
                    Swap(i, minChild);
                    i = minChild;
                }
                return top;
            }

            void Swap(int i, int j)
            {
                T temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
            }
        }
    }
}