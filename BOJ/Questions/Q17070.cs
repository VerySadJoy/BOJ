//Question No: 17070
//Title: 파이프 옮기기 1
//Tier: Gold V
namespace Joy
{
    class Q17070
    {
        static int N;
        static int[][] board;
        static int count = 0;
        public static void Main () {
            N = int.Parse(Console.ReadLine());
            board = new int[N][];
            for (int i = 0; i < N; i++) {
                board[i] = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
            }
            Move(0, 1, 0);
            Console.WriteLine(count);
        }
        static void Move(int x, int y, int direction) {
            if (x == N - 1 && y == N - 1) {
                count++;
                return;
            }
            switch (direction) {
                case 0:
                    if (x + 1 < N && board[x + 1][y] == 0)
                        Move(x + 1, y, 0);
                    if (x + 1 < N && y + 1 < N && board[x + 1][y + 1] == 0 && board[x + 1][y] == 0 && board[x][y + 1] == 0)
                        Move(x + 1, y + 1, 2);
                    break;
                case 1:
                    if (y + 1 < N && board[x][y + 1] == 0)
                        Move(x, y + 1, 1);
                    if (x + 1 < N && y + 1 < N && board[x + 1][y + 1] == 0 && board[x + 1][y] == 0 && board[x][y + 1] == 0)
                        Move(x + 1, y + 1, 2);
                    break;
                case 2:
                    if (x + 1 < N && board[x + 1][y] == 0)
                        Move(x + 1, y, 0);
                    if (y + 1 < N && board[x][y + 1] == 0)
                        Move(x, y + 1, 1);
                    if (x + 1 < N && y + 1 < N && board[x + 1][y + 1] == 0 && board[x + 1][y] == 0 && board[x][y + 1] == 0)
                        Move(x + 1, y + 1, 2);
                    break;
            }
        }
    }
}