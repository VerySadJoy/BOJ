//Question No: 2798
//Title: 블랙잭
//Tier: Bronze II
namespace Joy
{
    class Q2798
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int M = int.Parse(input[1]);

            string[] cardsStr = Console.ReadLine().Split();
            int[] cards = new int[N];

            for (int i = 0; i < N; i++)
            {
                cards[i] = int.Parse(cardsStr[i]);
            }

            int result = Find(cards, N, M);
            Console.WriteLine(result);
        }

        static int Find(int[] cards, int N, int M)
        {
            int closest = 0;

            for (int i = 0; i < N - 2; i++)
            {
                for (int j = i + 1; j < N - 1; j++)
                {
                    for (int k = j + 1; k < N; k++)
                    {
                        int current = cards[i] + cards[j] + cards[k];
                        
                        if (current <= M && current > closest)
                        {
                            closest = current;
                        }
                    }
                }
            }

            return closest;
        }
    }
}
