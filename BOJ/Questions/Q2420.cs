//Question No: 2420
//Title: 사파리월드
//Tier: Bronze V
namespace Joy
{
    class Q2420
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            long n = long.Parse(input[0]);
            long m = long.Parse(input[1]);

            long result = n - m;

            if (result < 0)
            {
                result = -result;
            }

            Console.WriteLine(result);
        }
    }
}