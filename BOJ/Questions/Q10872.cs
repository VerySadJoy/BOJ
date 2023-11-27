//Question No: 10872
//Title: 팩토리얼
//Tier: Bronze V
namespace Joy
{
    class Q10872
    {
        static void Main()
        {
            int num = int.Parse(Console.ReadLine());
            int result = 1;

            for (int i = 2; i <= num; i++)
            {
                result *= i;
            }

            Console.WriteLine(result);
        }
    }
}