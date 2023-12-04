//Question No: 1107
//Title: 리모컨
//Tier: Gold V
using System;

namespace Joy
{
    class Q1107
    {
        static void Main()
        {
            int target = int.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());

            bool [] broken = new bool[10];

            if (n > 0)
            {
                string[] brokenButtons = Console.ReadLine().Split();
                foreach (var button in brokenButtons)
                {
                    int brokenButton = int.Parse(button);
                    broken[brokenButton] = true;
                }
            }

            int result = Math.Abs(target - 100);

            for (int i = 0; i <= 1000000; i++)
            {
                if (IsPossible(broken, i))
                {
                    int pressCount = GetPressCount(target, i);
                    result = Math.Min(result, pressCount);
                }
            }

            Console.WriteLine(result);
        }

        static bool IsPossible(bool[] broken, int channel)
        {
            if (channel == 0){
                return broken[0] ? false : true;
            }

            while (channel > 0)
            {
                int digit = channel % 10;
                if (broken[digit])
                {
                    return false;
                }
                channel /= 10;
            }

            return true;
        }

        static int GetPressCount(int target, int channel)
        {
            int pressCount = Math.Abs(target - channel);

            if (channel != 0)
            {
                while (channel > 0)
                {
                    pressCount++;
                    channel /= 10;
                }
            }
            else
            {
                pressCount++;
            }

            return pressCount;
        }
    }
}
