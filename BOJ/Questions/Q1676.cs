//Question No: 1676
//Title: 팩토리얼 0의 개수
//Tier: Silver V
namespace Joy
{
    class Q1676
    {
        static void Main()
        {
            int input = int.Parse(Console.ReadLine());

            int count = 0;
            for (int i = 5; i <= input; i *= 5)
            {
                count += input / i;
            }
            Console.WriteLine(count);
        }
    }
}