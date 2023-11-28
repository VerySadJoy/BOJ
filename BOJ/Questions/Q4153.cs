//Question No: 4153
//Title: 직각삼각형
//Tier: Bronze III
namespace Joy
{
    class Q4153
    {
        static void Main()
        {
            while (true)
            {
                string[] sides = Console.ReadLine().Split();

                int a = int.Parse(sides[0]);
                int b = int.Parse(sides[1]);
                int c = int.Parse(sides[2]);

                if (a == 0 && b == 0 && c == 0)
                {
                    break;
                }

                if (((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)))
                {
                    Console.WriteLine("right");
                }
                else
                {
                    Console.WriteLine("wrong");
                }
            }
        }
    }
}
