//Question No: 1074
//Title: Z
//Tier: Silver I
namespace Joy
{
    class Q1074
    {
        static int N, r, c;
        static int result = 0;

        static void Main()
        {
            int[] input = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            N = input[0];
            r = input[1];
            c = input[2];

            Solve(0, 0, (int)Math.Pow(2, N));
            Console.WriteLine(result);
        }

        static void Solve(int x, int y, int size)
        {
            if (size == 1)
            {
                return;
            }

            int newSize = size / 2;
            int midX = x + newSize;
            int midY = y + newSize;

            if (r < midX && c < midY)
            {
                Solve(x, y, newSize);
            }
            else if (r < midX && c >= midY)
            {
                result += newSize * newSize;
                Solve(x, midY, newSize);
            }
            else if (r >= midX && c < midY)
            {
                result += 2 * newSize * newSize;
                Solve(midX, y, newSize);
            }
            else
            {
                result += 3 * newSize * newSize;
                Solve(midX, midY, newSize);
            }
        }
    }
}
