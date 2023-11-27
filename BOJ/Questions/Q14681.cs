//Question No: 14681
//Title: 사분면 고르기
//Tier: Bronze V
namespace Joy
{
    class Q14681
    {
        static void Main()
        {
            int x = int.Parse(Console.ReadLine());
            int y = int.Parse(Console.ReadLine());

            if (x > 0 && y > 0)
            {
                Console.WriteLine("1");
            }
            else if (x < 0 && y > 0)
            {
                Console.WriteLine("2");
            }
            else if (x < 0 && y < 0)
            {
                Console.WriteLine("3");
            }
            else if (x > 0 && y < 0)
            {
                Console.WriteLine("4");
            }
        }
    }
}