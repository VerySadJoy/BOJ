//Question No: 10816
//Title: 숫자 카드 2
//Tier: Silver IV
using System.Text;
using System.Linq;

namespace Joy
{
    class Q10816
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            Dictionary<int, int> count = new Dictionary<int, int>();

            int[] cards = Console.ReadLine().Split().Select(int.Parse).ToArray();

            foreach (int card in cards)
            {
                if (count.ContainsKey(card))
                {
                    count[card]++;
                }
                else
                {
                    count[card] = 1;
                }
            }

            int M = int.Parse(Console.ReadLine());
            int[] targets = Console.ReadLine().Split().Select(int.Parse).ToArray();
            
            StringBuilder result = new StringBuilder();

            foreach (int target in targets)
            {
                if (count.ContainsKey(target))
                {
                    result.Append($"{count[target]} ");
                }
                else
                {
                    result.Append("0 ");
                }
            }

            Console.Write(result);
        }
    }
}
