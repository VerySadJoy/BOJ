//Question No: 11399
//Title: ATM
//Tier: Silver IV
namespace Joy
{
    class Q11399
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] times = Console.ReadLine().Split().Select(int.Parse).ToArray();

            Array.Sort(times);

            int result = 0;
            int time = 0;

            for (int i = 0; i < n; i++)
            {
                time += times[i];
                result += time;
            }

            Console.WriteLine(result);
        }
    }
}
