//Question No: 1238
//Title: 파티
//Tier: Gold III
namespace Joy
{

    class Q1238
    {
        static List<(int, int)>[] graph;
        static int N, M, X;

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);
            X = int.Parse(input[2]);
            graph = new List<(int, int)>[N + 1];
            for (int i = 1; i <= N; i++)
            {
                graph[i] = new List<(int, int)>();
            }
            for (int i = 0; i < M; i++)
            {
                input = Console.ReadLine().Split();
                int start = int.Parse(input[0]);
                int end = int.Parse(input[1]);
                int time = int.Parse(input[2]);
                graph[start].Add((end, time));
            }
            int maxTime = 0;
            for (int i = 1; i <= N; i++)
            {
                int timeToParty = Dijkstra(i, X);
                int timeToReturn = Dijkstra(X, i);
                int totalTime = timeToParty + timeToReturn;
                maxTime = Math.Max(maxTime, totalTime);
            }
            Console.WriteLine(maxTime);
        }
        static int Dijkstra(int start, int end)
        {
            int[] distance = new int[N + 1];
            bool[] visited = new bool[N + 1];
            Array.Fill(distance, int.MaxValue);
            PriorityQueue<(int, int)> pq = new PriorityQueue<(int, int)>();
            pq.Enqueue((0, start));
            distance[start] = 0;
            while (pq.Count > 0)
            {
                (int dist, int node) = pq.Dequeue();

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
