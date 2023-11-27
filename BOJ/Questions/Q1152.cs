//Question No: 1152
//Title: 단어의 개수
//Tier: Bronze II
namespace Joy
{
    class Q1152
    {
        static void Main()
        {
            string input = Console.ReadLine();
            input = input.Trim();
            if (input == "")
            {
                Console.WriteLine(0);
                return;
            }
            string[] words = input.Split(' ');
            Console.WriteLine(words.Length);
        }
    }
}