//Question No: 11279
//Title: 최대 힙
//Tier: Silver II
using System;
using System.Collections.Generic;

namespace Joy{
class Q11279
{
    static void Main(string[] args)
    {
        int N = int.Parse(Console.ReadLine());
        var pq = new PriorityQueue<int>();

        for (int i = 0; i < N; i++)
        {
            int k = int.Parse(Console.ReadLine());
            if (k == 0)
                popPQ(pq);
            else
                pushPQ(pq, k);
        }
    }

    static void pushPQ(PriorityQueue<int> pq, int v)
    {
        pq.Push(v);
    }

    static void popPQ(PriorityQueue<int> pq)
    {
        if (pq.Count == 0)
            Console.WriteLine(0);
        else
            Console.WriteLine(pq.Pop());
    }
}

public class PriorityQueue<T> where T : IComparable<T>
{
    private List<T> data;

    public PriorityQueue()
    {
        this.data = new List<T>();
    }

    public void Push(T item)
    {
        data.Add(item);
        int ci = data.Count - 1; // child index; start at end
        while (ci > 0)
        {
            int pi = (ci - 1) / 2; // parent index
            if (data[ci].CompareTo(data[pi]) >= 0) break; // child item is larger than (or equal) parent so we're done
            T tmp = data[ci]; data[ci] = data[pi]; data[pi] = tmp;
            ci = pi;
        }
    }

    public T Pop()
    {
        // assumes pq is not empty; up to calling code
        int li = data.Count - 1; // last index (before removal)
        T frontItem = data[0];   // fetch the front
        data[0] = data[li];
        data.RemoveAt(li);

        --li; // last index (after removal)
        int pi = 0; // parent index. start at front of pq
        while (true)
        {
            int ci = pi * 2 + 1; // left child index of parent
            if (ci > li) break;  // no children so done
            int rc = ci + 1;     // right child
            if (rc <= li && data[rc].CompareTo(data[ci]) < 0) // if there is a rc (ci + 1), and it is smaller than left child, use the rc instead
                ci = rc;
            if (data[pi].CompareTo(data[ci]) <= 0) break; // parent is smaller than (or equal to) smallest child so done
            T tmp = data[pi]; data[pi] = data[ci]; data[ci] = tmp; // swap parent and child
            pi = ci;
        }
        return frontItem;
    }

    public int Count => data.Count;
}
}

