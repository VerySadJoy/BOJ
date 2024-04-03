
namespace Joy{
    class Q2162
    {
        static int[] parent;

        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            List<Line> lines = new List<Line>();

            parent = new int[N];
            for (int i = 0; i < N; i++)
            {
                parent[i] = i;
            }

            for (int i = 0; i < N; i++)
            {
                int[] points = Console.ReadLine().Split().Select(int.Parse).ToArray();
                lines.Add(new Line(new Point(points[0], points[1]), new Point(points[2], points[3]), i));
            }

            int groups = N;
            int maxGroupSize = 1;

            for (int i = 0; i < N; i++)
            {
                for (int j = i + 1; j < N; j++)
                {
                    if (lines[i].Intersect(lines[j]))
                    {
                        int root1 = Find(i);
                        int root2 = Find(j);

                        if (root1 != root2)
                        {
                            parent[root2] = root1;
                            groups--;
                        }
                    }
                }
                maxGroupSize = Math.Max(maxGroupSize, GetGroupSize(i));
            }

            Console.WriteLine(groups);
            Console.WriteLine(maxGroupSize);
        }

        static int Find(int x)
        {
            if (parent[x] != x)
            {
                parent[x] = Find(parent[x]);
            }
            return parent[x];
        }

        static int GetGroupSize(int x)
        {
            int root = Find(x);
            int size = 0;
            for (int i = 0; i < parent.Length; i++)
            {
                if (Find(i) == root)
                {
                    size++;
                }
            }
            return size;
        }
    }

    class Point
    {
        public int X { get; }
        public int Y { get; }

        public Point(int x, int y)
        {
            X = x;
            Y = y;
        }
    }

    class Line
    {
        public Point Start { get; }
        public Point End { get; }
        public int Index { get; }

        public Line(Point start, Point end, int index)
        {
            Start = start;
            End = end;
            Index = index;
        }

        public bool Intersect(Line other)
        {
            Point newStart = Start;
            Point newEnd = End;
            Point otherStart = other.Start;
            Point otherEnd = other.End;
            int ccw1 = CCW(newStart, newEnd, otherStart) * CCW(newStart, newEnd, otherEnd);
            int ccw2 = CCW(otherStart, otherEnd, newStart) * CCW(otherStart, otherEnd, newEnd);

            if (ccw1 == 0 && ccw2 == 0)
            {
                if (Start.X > End.X)
                {
                    Swap(ref newStart, ref newEnd);
                }
                if (other.Start.X > other.End.X)
                {
                    Swap(ref otherStart, ref otherEnd);
                }
                return otherStart.X <= End.X && Start.X <= otherEnd.X;
            }

            return ccw1 <= 0 && ccw2 <= 0;
        }

        static int CCW(Point p1, Point p2, Point p3)
        {
            int temp = (p1.X * p2.Y + p2.X * p3.Y + p3.X * p1.Y) - (p1.Y * p2.X + p2.Y * p3.X + p3.Y * p1.X);
            if (temp > 0)
            {
                return 1;
            }
            else if (temp < 0)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        static void Swap<T>(ref T a, ref T b)
        {
            T temp = a;
            a = b;
            b = temp;
        }
    }
}