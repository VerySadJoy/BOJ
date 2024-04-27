//Question No: 13549
//Title: 숨바꼭질 3
//Tier: Gold V
namespace Joy
{
    class Q13549
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int K = int.Parse(input[1]);
            int[] dist = new int[100001];
            bool[] visited = new bool[100001];
            for (int i = 0; i < 100001; i++)
            {
                dist[i] = int.MaxValue;
            }
            PQ13549<(int, int)> pq = new PQ13549<(int, int)>();
            dist[N] = 0;
            pq.Enqueue((0, N));
            while (pq.Count > 0)
            {
                (int weight, int node) = pq.Dequeue();
                if (visited[node])
                {
                    continue;
                }
                visited[node] = true;
                if (node == K)
                {
                    Console.WriteLine(dist[node]);
                    return;
                }
                if (node * 2 <= 100000 && dist[node * 2] > dist[node])
                {
                    dist[node * 2] = dist[node];
                    pq.Enqueue((dist[node], node * 2));
                }
                if (node + 1 <= 100000 && dist[node + 1] > dist[node] + 1)
                {
                    dist[node + 1] = dist[node] + 1;
                    pq.Enqueue((dist[node] + 1, node + 1));
                }
                if (node - 1 >= 0 && dist[node - 1] > dist[node] + 1)
                {
                    dist[node - 1] = dist[node] + 1;
                    pq.Enqueue((dist[node] + 1, node - 1));
                }
            }
        }
    }
    class PQ13549<T> where T : IComparable<T>
    {
        private List<T> data;
        public PQ13549()
        {
            this.data = new List<T>();
        }
        public int Count
        {
            get { return this.data.Count; }
        }
        public void Enqueue(T item)
        {
            this.data.Add(item);
            int ci = this.data.Count - 1;
            while (ci > 0)
            {
                int pi = (ci - 1) / 2;
                if (this.data[ci].CompareTo(this.data[pi]) >= 0)
                    break;
                T tmp = this.data[ci];
                this.data[ci] = this.data[pi];
                this.data[pi] = tmp;
                ci = pi;
            }
        }
        public T Dequeue()
        {
            int li = this.data.Count - 1;
            T frontItem = this.data[0];
            this.data[0] = this.data[li];
            this.data.RemoveAt(li);
            --li;
            int pi = 0;
            while (true)
            {
                int ci = pi * 2 + 1;
                if (ci > li)
                    break;
                int rc = ci + 1;
                if (rc <= li && this.data[rc].CompareTo(this.data[ci]) < 0)
                    ci = rc;
                if (this.data[pi].CompareTo(this.data[ci]) <= 0)
                    break;
                T tmp = this.data[pi];
                this.data[pi] = this.data[ci];
                this.data[ci] = tmp;
                pi = ci;
            }
            return frontItem;
        }
        public T Peek()
        {
            T frontItem = this.data[0];
            return frontItem;
        }
        public bool IsConsistent()
        {
            if (this.data.Count == 0)
                return true;
            int li = this.data.Count - 1;
            for (int pi = 0; pi < this.data.Count; ++pi)
            {
                int lci = 2 * pi + 1;
                int rci = 2 * pi + 2;

                if (lci <= li && this.data[pi].CompareTo(this.data[lci]) > 0)
                    return false;
                if (rci <= li && this.data[pi].CompareTo(this.data[rci]) > 0)
                    return false;
            }
            return true;
        }
    }
}
