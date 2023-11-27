//Question No: 1259
//Title: 팰린드롬수
//Tier: Bronze I
namespace Joy
{
    class Q1259
    {
        static void Main()
        {
            while (true)
            {
                string number = Console.ReadLine();

                if (number == "0")
                {
                    break;
                }

                bool flag = checkFlag(number);

                if (flag)
                {
                    Console.WriteLine("yes");
                }
                else
                {
                    Console.WriteLine("no");
                }
            }
        }

        static bool checkFlag(string number)
        {
            for (int i = 0; i < number.Length / 2; i++)
            {
                if (number[i] != number[number.Length - i - 1])
                {
                    return false;
                }
            }
            return true;
        }
    }
}