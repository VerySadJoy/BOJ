//Question No: 10950
//Title: A+B - 3
//Tier: Bronze V
namespace Joy
{
    class Q10950
    {
        static void Main()
        {
            int num = int.Parse(Console.ReadLine());

            for (int i = 0; i < num; i++)
            {
                string[] input = Console.ReadLine().Split();
                int a = int.Parse(input[0]);
                int b = int.Parse(input[1]);
                Console.WriteLine(a + b);
            }
        }
    }
}