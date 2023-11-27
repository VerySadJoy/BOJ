//Question No: 2609
//Title: 최대공약수와 최소공배수
//Tier: Bronze I
namespace Joy
{
    class Q2609
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int a = int.Parse(input[0]);
            int b = int.Parse(input[1]);

            int gcd = GCD(a, b);
            int lcm = LCM(a, b, gcd);

            Console.WriteLine(gcd);
            Console.WriteLine(lcm);
        }

        static int GCD(int a, int b)
        {
            while (b != 0)
            {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        static int LCM(int a, int b, int gcd)
        {
            return a * b / gcd;
        }
    }
}