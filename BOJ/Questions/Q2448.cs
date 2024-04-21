//Question No: 2448
//Title: 별 찍기 - 11
//Tier: Gold IV
using System.Text;

namespace Joy{
    class Q2448
    {
        static char[,] stars;
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            stars = new char[n, 2 * n - 1];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < 2 * n - 1; j++)
                {
                    stars[i, j] = ' ';
                }
            }

            DrawStars(n, n - 1, 0);
            using (StreamWriter writer = new StreamWriter(Console.OpenStandardOutput()))
            {
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < 2 * n - 1; j++)
                    {
                        writer.Write(stars[i, j]);
                    }
                    writer.WriteLine();
                }
            }
        }
        static void DrawStars(int n, int x, int y)
        {
            if (n == 3)
            {
                stars[y, x] = '*';
                stars[y + 1, x - 1] = '*';
                stars[y + 1, x + 1] = '*';
                stars[y + 2, x - 2] = '*';
                stars[y + 2, x - 1] = '*';
                stars[y + 2, x] = '*';
                stars[y + 2, x + 1] = '*';
                stars[y + 2, x + 2] = '*';
            }
            else
            {
                DrawStars(n / 2, x, y);
                DrawStars(n / 2, x - n / 2, y + n / 2);
                DrawStars(n / 2, x - n / 2 + n, y + n / 2);
            }
            
        }
    }
}