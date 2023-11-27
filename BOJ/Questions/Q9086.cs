//Question No: 9086
//Title: 문자열
//Tier: Bronze V
namespace Joy
{
    class Q9086
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();

                char char1 = input[0];
                char char2 = input[input.Length - 1];
                Console.WriteLine($"{char1}{char2}");
            }
        }
    }
}