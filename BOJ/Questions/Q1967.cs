//Question No: 1967
//Title: 트리의 지름
//Tier: Gold IV
namespace Joy
{
    class Q1967
    {
        public static int MaxDistance;
        public int nodeNum;
        public int weight;
        public int distance;
        public List<Q1967> children;

        public Q1967(int nodeNum, int weight)
        {
            this.nodeNum = nodeNum;
            this.weight = weight;
            children = new List<Q1967>();
        }

        public void Insert(Q1967 node)
        {
            children.Add(node);
        }

        public void SetTreeDistance()
        {
            if (children.Count == 0)
            {
                distance = 0;
            }
            else if(children.Count == 1)
            {
                children[0].SetTreeDistance();

                distance = children[0].distance + children[0].weight;
                if (distance >= MaxDistance)
                {
                    MaxDistance = distance;
                }
            }

            else
            {
                children.ForEach(x => x.SetTreeDistance());

                var ordered = children.OrderByDescending(x => x.distance + x.weight)
                    .ToList();

                if (ordered[0].distance + ordered[1].distance + ordered[0].weight + ordered[1].weight > MaxDistance)
                {
                    MaxDistance = ordered[0].distance + ordered[1].distance + ordered[0].weight + ordered[1].weight;
                }
                distance = ordered[0].distance + ordered[0].weight;
            }
        }
        static void Main()
        {
            int count = int.Parse(Console.ReadLine()) - 1;
            MaxDistance = 0;
            Queue<Q1967> nodeQueue = new Queue<Q1967>();

            Q1967 tree = new Q1967(1, 0);
            nodeQueue.Enqueue(tree);

            for(int i = 0; i < count; i++)
            {
                var input = Console.ReadLine().Split(' ').ToList().Select(x => int.Parse(x)).ToList();
                var node = new Q1967(input[1], input[2]);
                nodeQueue.Enqueue(node);
                while (nodeQueue.Peek().nodeNum != input[0])
                {
                    nodeQueue.Dequeue();
                }
                nodeQueue.Peek().Insert(node);
            }
            tree.SetTreeDistance();
            Console.Write(MaxDistance);
        }
    }
}

