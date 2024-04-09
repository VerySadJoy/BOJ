//Question No: 16928
//Title: 뱀과 사다리 게임
//Tier: Gold V
namespace Joy
{
    class Q16928
    {
        static int[] board = new int[101];
        static int[] moves = new int[101];
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int M = int.Parse(input[1]);
            for (int i = 1; i <= 100; i++)
            {
                board[i] = i;
                moves[i] = int.MaxValue;
            }
            for (int i = 0; i < N; i++)
            {
                input = Console.ReadLine().Split();
                int start = int.Parse(input[0]);
                int end = int.Parse(input[1]);
                board[start] = end;
            }
            for (int i = 0; i < M; i++)
            {
                input = Console.ReadLine().Split();
                int start = int.Parse(input[0]);
                int end = int.Parse(input[1]);
                board[start] = end;
            }
            int result = BFS();
            Console.WriteLine(result);
        }

        static int BFS()
        {
            Queue<int> queue = new Queue<int>();
            queue.Enqueue(1);
            moves[1] = 0;
            while (queue.Count > 0)
            {
                int current = queue.Dequeue();
                for (int i = 1; i <= 6; i++)
                {
                    int next = current + i;
                    if (next <= 100)
                    {
                        next = board[next];
                        if (moves[next] > moves[current] + 1)
                        {
                            moves[next] = moves[current] + 1;
                            queue.Enqueue(next);
                        }
                    }
                }
            }
        return moves[100];
        }
    }
}