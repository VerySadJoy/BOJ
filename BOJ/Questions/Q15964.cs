//Question No: 15964
//Title: 이상한 기호
//Tier: Bronze V
namespace Joy
{
    class Q15964
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();

            long a = long.Parse(input[0]);
            long b = long.Parse(input[1]);
            long result = (a + b) * (a - b);
            Console.WriteLine(result);
        }
    }
}