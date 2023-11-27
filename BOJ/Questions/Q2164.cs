//Question No: 2164
//Title: 카드2
//Tier: Silver IV
namespace Joy
{
    class Q2164
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            Queue<int> cards = new Queue<int>();

            for (int i = 1; i <= n; i++)
            {
                cards.Enqueue(i);
            }

            while (cards.Count > 1)
            {
                cards.Dequeue();
                int cardChanged = cards.Dequeue();
                cards.Enqueue(cardChanged);
            }
            Console.WriteLine(cards.Peek());
        }
    }
}