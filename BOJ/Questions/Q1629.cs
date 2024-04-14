//Question No: 1629
//Title: 곱셈
//Tier: Silver I
namespace Joy
{
    class Q1629
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            long A = long.Parse(input[0]);
            long B = long.Parse(input[1]);
            long C = long.Parse(input[2]);

            long result = Calc(A, B, C);
            Console.WriteLine(result);
        }

        static long Calc(long A, long B, long C)
        {
            if (B == 0)
            {
                return 1;
            }

            long temp = Calc(A, B / 2, C) % C;
            long result = (temp * temp) % C;
            if (B % 2 == 1)
            {
                result = (result * A) % C;
            }

            return result;
        }
    }

}
