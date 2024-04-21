//Question No: 5639
//Title: 이진 검색 트리
//Tier: Gold IVusing System;
namespace Joy
{
    struct Node5639
    {
        public int Value;
        public int Left;
        public int Right;

        public Node5639(int value)
        {
            Value = value;
            Left = -1;
            Right = -1;
        }
    }
    class Q5639
    {
        static List<Node5639> nodes = new List<Node5639>();
        static void Insert(int value)
        {
            if (nodes.Count == 0)
            {
                nodes.Add(new Node5639(value));
                return;
            }
            int currentIndex = 0;
            while (true)
            {
                Node5639 currentNode = nodes[currentIndex];
                if (value < currentNode.Value)
                {
                    if (currentNode.Left == -1)
                    {
                        currentNode.Left = nodes.Count;
                        nodes[currentIndex] = currentNode;
                        nodes.Add(new Node5639(value));
                        return;
                    }
                    else
                    {
                        currentIndex = currentNode.Left;
                    }
                }
                else
                {
                    if (currentNode.Right == -1)
                    {
                        currentNode.Right = nodes.Count;
                        nodes[currentIndex] = currentNode;
                        nodes.Add(new Node5639(value));
                        return;
                    }
                    else
                    {
                        currentIndex = currentNode.Right;
                    }
                }
            }
        }
        static void Postorder(int index)
        {
            if (index == -1)
                return;
            Postorder(nodes[index].Left);
            Postorder(nodes[index].Right);
            Console.WriteLine(nodes[index].Value);
        }
        static void Main()
        {
            string line;
            while ((line = Console.ReadLine()) != null || (line = Console.ReadLine()) == "")
            {
                int value = int.Parse(line);
                Insert(value);
            }
            Postorder(0);
        }
    }
}
