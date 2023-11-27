//Question No: 1000
//Title: A+B
//Tier: Bronze V
namespace Joy
{
    class Q1000
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split(' ');
            int sum = Convert.ToInt32(input[0]) + Convert.ToInt32(input[1]);
            Console.WriteLine(sum);
        }
    }
}