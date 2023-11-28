//Question No: 2292
//Title: 벌집
//Tier: Bronze II
namespace Joy
{
    class Q2292
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());

            int displacement = 1;
            int distance = 1;

            for (int _ = 1; distance < N; _++)
            {
                distance += 6 * displacement;
                displacement++;
            }

            Console.WriteLine(displacement);
        }
    }
}
