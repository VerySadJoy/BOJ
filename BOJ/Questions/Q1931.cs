//Question No: 1931
//Title: 회의실 배정
//Tier: Silver I
namespace Joy
{
    class Q1931
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            List<(int, int)> meetings = new List<(int, int)>();

            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split();
                int start = int.Parse(input[0]);
                int end = int.Parse(input[1]);
                meetings.Add((start, end));
            }

            meetings = meetings.OrderBy(m => m.Item2).ThenBy(m => m.Item1).ToList();

            int count = 0;
            int endTime = 0;

            foreach (var e in meetings)
            {
                if (e.Item1 >= endTime)
                {
                    endTime = e.Item2;
                    count++;
                }
            }

            Console.WriteLine(count);
        }
    }
}
