//Question No: 18870
//Title: 좌표 압축
//Tier: Silver II
using System.Text;

namespace Joy
{
    class Q18870
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] numbers = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            SortedSet<int> sortedSet = new SortedSet<int>(numbers);
            List<int> ranks = new List<int>(sortedSet.Count);
            Dictionary<int, int> numberToRank = new Dictionary<int, int>();

            int rank = 0;
            foreach (int num in sortedSet)
            {
                numberToRank[num] = rank++;
                ranks.Add(num);
            }
            StringBuilder result = new StringBuilder();
            foreach (int num in numbers)
            {
                result.Append($"{numberToRank[num]} ");
            }
            if (result.Length > 0)
            {
                result.Length -= 1;
            }

            Console.WriteLine(result);
        }
    }
}
