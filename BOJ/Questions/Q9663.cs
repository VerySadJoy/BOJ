//Question No: 9663
//Title: N-Queen
//Tier: Gold IV
namespace Joy
{
    class Q9663
    {
        static int N;
        static int count = 0;
        static void Main()
        {
            N = int.Parse(Console.ReadLine());
            bool[,] board = new bool[N, N];
            Solve(board, 0);
            Console.WriteLine(count);
        }
        static bool IsSafe(bool[,] board, int row, int col)
        {
            for (int i = 0; i < row; i++)
            {
                if (board[i, col])
                    return false;
            }
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            {
                if (board[i, j])
                    return false;
            }
            for (int i = row, j = col; i >= 0 && j < N; i--, j++)
            {
                if (board[i, j])
                    return false;
            }
            return true;
        }
        static void Solve(bool[,] board, int row)
        {
            if (row == N)
            {
                count++;
                return;
            }
            for (int col = 0; col < N; col++)
            {
                if (IsSafe(board, row, col))
                {
                    board[row, col] = true;
                    Solve(board, row + 1);
                    board[row, col] = false;
                }
            }
        }
    }
}
