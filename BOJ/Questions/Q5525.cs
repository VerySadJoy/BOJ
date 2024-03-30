//Question No: 5525
//Title: IOIOI
//Tier: Silver I

namespace Joy
{
    class Q5525
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int M = int.Parse(Console.ReadLine());
            string S = Console.ReadLine();

            int count = 0;
            int patternCount = 0;

            for (int i = 0; i < M - 2; i++)
            {
                if (S[i] == 'I' && S[i + 1] == 'O' && S[i + 2] == 'I')
                {
                    patternCount++;

                    if (patternCount >= N)
                    {
                        count++;
                    }

                    if (patternCount > N)
                    {
                        patternCount--;
                    }

                    i++;
                }
                else
                {
                    patternCount = 0;
                }
            }

            Console.WriteLine(count);
        }
    }
}