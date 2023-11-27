//Question No: 1016
//Title: 제곱 ㄴㄴ 수
//Tier: Gold I
namespace Joy
{
    class Q1016
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            long min = long.Parse(input[0]);
            long max = long.Parse(input[1]);

            int count = CountNumbers(min, max);
            Console.WriteLine(count);
        }

        static int CountNumbers(long min, long max)
        {
            bool[] isSquare = new bool[max - min + 1];
            long sqrtMax = (long)Math.Sqrt(max);

            for (long i = 2; i <= sqrtMax; i++)
            {
                long square = i * i;
                long start = min % square == 0 ? min : min + (square - min % square);
                
                for (long j = start; j <= max; j += square)
                {
                    isSquare[j - min] = true;
                }
            }

            int count = 0;
            for (int i = 0; i <= max - min; i++)
            {
                if (!isSquare[i])
                {
                    count++;
                }
            }

            return count;
        }
    }
}