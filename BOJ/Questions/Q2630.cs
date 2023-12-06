//Question No: 2630
//Title: 색종이 만들기
//Tier: Silver II
namespace Joy
{
    class Q2630
    {
        static int[,] paper;
        static int whiteCount = 0;
        static int blueCount = 0;

        static void Recursion(int startX, int startY, int size)
        {
            int color = paper[startX, startY];

            for (int i = startX; i < startX + size; i++)
            {
                for (int j = startY; j < startY + size; j++)
                {
                    if (paper[i, j] != color)
                    {
                        int halfSize = size / 2;
                        Recursion(startX, startY, halfSize);
                        Recursion(startX + halfSize, startY, halfSize);
                        Recursion(startX, startY + halfSize, halfSize);
                        Recursion(startX + halfSize, startY + halfSize, halfSize);
                        return;
                    }
                }
            }

            if (color == 0)
                whiteCount++;
            else
                blueCount++;
        }

        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            paper = new int[n, n];

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split();
                for (int j = 0; j < n; j++)
                {
                    paper[i, j] = int.Parse(input[j]);
                }
            }

            Recursion(0, 0, n);

            Console.WriteLine(whiteCount);
            Console.WriteLine(blueCount);
        }
    }
}
