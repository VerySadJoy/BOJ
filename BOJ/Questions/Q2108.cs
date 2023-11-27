//Question No: 2108
//Title: 통계학
//Tier: Silver III
namespace Joy
{
    class Q2108
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            List<int> numbers = new List<int>();
            for (int i = 0; i < n; i++)
            {
                numbers.Add(int.Parse(Console.ReadLine()));
            }

            double average = numbers.Average();


            numbers.Sort();

            int median = numbers[n / 2];
            Dictionary<int, int> dict = new Dictionary<int, int>();

            foreach (var num in numbers)
            {
                if (dict.ContainsKey(num))
                {
                    dict[num]++;
                }
                else
                {
                    dict[num] = 1;
                }
            }

            int maxCount = dict.Values.Max();
            List<int> modes = dict.Where(kv => kv.Value == maxCount).Select(kv => kv.Key).ToList();
            int mode = modes.Count == 1 ? modes[0] : modes.OrderBy(m => m).ElementAt(1);
            int range = numbers.Max() - numbers.Min();

            if (Math.Round(average) == -0)
            {
                Console.WriteLine(0);
            }
            else
            {
                Console.WriteLine(Math.Round(average));
            }
            
            Console.WriteLine(median);
            Console.WriteLine(mode);
            Console.WriteLine(range);
        }
    }
}