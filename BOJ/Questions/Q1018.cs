//Question No: 1018
//Title: 체스판 다시 칠하기
//Tier: Silver IV
namespace Joy
{
    class Q1018
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);

            char[][] board = new char[n][];
            for (int i = 0; i < n; i++)
            {
                board[i] = Console.ReadLine().ToCharArray();
            }

            const int SIZE = 8;

            int min = int.MaxValue;

            for (int i = 0; i <= n - SIZE; i++)
            {
                for (int j = 0; j <= m - SIZE; j++)
                {
                    int count1 = 0;
                    int count2 = 0;

                    for (int k = 0; k < SIZE; k++)
                    {
                        for (int l = 0; l < SIZE; l++)
                        {
                            if ((k + l) % 2 == 0)
                            {
                                if (board[i + k][j + l] != 'W')
                                {
                                    count1++;
                                }
                                else
                                {
                                    count2++;
                                }
                            }
                            else
                            {
                                if (board[i + k][j + l] != 'B')
                                {
                                    count1++;
                                }
                                else
                                {
                                    count2++;
                                }
                            }
                        }
                    }

                    min = Math.Min(min, Math.Min(count1, count2));
                }
            }
            Console.WriteLine(min);
        }
    }
}