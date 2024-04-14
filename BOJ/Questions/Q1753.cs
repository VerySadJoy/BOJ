//Question No: 1753
//Title: 최단경로
//Tier: Gold IV
namespace Joy
{
    class Q1753
    {
        static List<(int, int)>[] graph;
        static int[] distances;
        static int V, E, K;
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            V = int.Parse(input[0]);
            E = int.Parse(input[1]);
            K = int.Parse(Console.ReadLine());

            graph = new List<(int, int)>[V + 1];
            distances = new int[V + 1];
            Array.Fill(distances, int.MaxValue);

            for (int i = 1; i <= V; i++)
            {
                graph[i] = new List<(int, int)>();
            }

            for (int i = 0; i < E; i++)
            {
                input = Console.ReadLine().Split();
                int u = int.Parse(input[0]);
                int v = int.Parse(input[1]);
                int w = int.Parse(input[2]);
                graph[u].Add((v, w));
            }

            Dijkstra();

            for (int i = 1; i <= V; i++)
            {
                if (distances[i] == int.MaxValue)
                {
                    Console.WriteLine("INF");
                }
                else
                {
                    Console.WriteLine(distances[i]);
                }
            }
        }

        static void Dijkstra()
        {
            PriorityQueue<(int, int)> pq = new PriorityQueue<(int, int)>();
            pq.Enqueue((0, K));
            distances[K] = 0;

            while (pq.Count > 0)
            {
                (int dist, int node) = pq.Dequeue();

                if (distances[node] < dist) continue;

                foreach ((int neighbor, int weight) in graph[node])
                {
                    int newDist = distances[node] + weight;
                    if (newDist < distances[neighbor])
                    {
                        distances[neighbor] = newDist;
                        pq.Enqueue((newDist, neighbor));
                    }
                }
            }
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
