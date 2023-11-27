//Question No: 8958
//Title: OX퀴즈
//Tier: Bronze II
namespace Joy
{
    class Q8958
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string result = Console.ReadLine();
                int score = 0;
                int count = 0;
        
                foreach (char answer in result)
                {
                    if (answer == 'O')
                    {
                        count++;
                        score += count;
                    }
                    else
                    {
                        count = 0;
                    }
                }
                Console.WriteLine(score);
            }
        }
    }
}