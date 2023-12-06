//Question No: 1927
//Title: 최소 힙
//Tier: Silver IIusing System;

namespace Joy
{
    class MinHeap
    {
        private const int MAX_SIZE = 100001;
        private int[] heap;
        private int size;

        public MinHeap()
        {
            heap = new int[MAX_SIZE];
            size = 0;
        }

        public void Push(int value)
        {
            heap[++size] = value;
            AdjustHeapUp();
        }

        public int Pop()
        {
            if (size == 0)
                return 0;

            int root = heap[1];
            heap[1] = heap[size--];
            AdjustHeapDown();
            return root;
        }

        private void AdjustHeapUp()
        {
            int current = size;

            while (current > 1 && heap[current] < heap[current / 2])
            {
                Swap(current, current / 2);
                current /= 2;
            }
        }

        private void AdjustHeapDown()
        {
            int current = 1;
            int child;

            while (current * 2 <= size)
            {
                child = current * 2;

                if (child + 1 <= size && heap[child] > heap[child + 1])
                    child++;

                if (heap[current] > heap[child])
                {
                    Swap(current, child);
                    current = child;
                }
                else
                {
                    break;
                }
            }
        }

        private void Swap(int a, int b)
        {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }
    }

    class Q1927
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            MinHeap minHeap = new MinHeap();

            for (int i = 0; i < n; i++)
            {
                int x = int.Parse(Console.ReadLine());

                if (x == 0)
                {
                    int result = minHeap.Pop();
                    Console.WriteLine(result);
                }
                else
                {
                    minHeap.Push(x);
                }
            }
        }
    }
}
