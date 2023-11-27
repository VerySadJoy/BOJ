//Question No: 2884
//Title: 알람 시계
//Tier: Bronze III
namespace Joy
{
    class Q2884
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int hour = int.Parse(input[0]);
            int minute = int.Parse(input[1]);
            minute -= 45;
            if (minute < 0)
            {
                minute += 60;
                hour--;
                if (hour < 0)
                {
                    hour = 23;
                }
            }
            Console.WriteLine($"{hour} {minute}");
        }
    }
}