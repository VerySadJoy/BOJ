//Question No: 11286
//Title: 절댓값 힙
//Tier: Silver I

using System;
using System.Collections.Generic;
namespace Joy{
class Q11286
{
    static void Main(string[] args)
    {
        int N = int.Parse(Console.ReadLine());
        PriorityQueue<int> pq = new PriorityQueue<int>();

        for (int i = 0; i < N; i++)
        {
            int x = int.Parse(Console.ReadLine());

            if (x == 0)
            {
                if (pq.Count == 0)
                    Console.WriteLine(0);
                else
                    Console.WriteLine(pq.Pop());
            }
            else
            {
                pq.Push(x);
            }
        }
    }
}

}
