//Question No: 11723
//Title: 집합
//Tier: Silver V
using System.Collections;
using System.Text;

namespace Joy
{
    class Q11723
    {
        static void Main()
        {
            int m = int.Parse(Console.ReadLine());
            BitArray set = new BitArray(21);
            StringBuilder result = new StringBuilder();
            int num = 0;
            for (int i = 0; i < m; i++)
            {
                string[] input = Console.ReadLine().Split();
                string command = input[0];
                if (!(command == "all" || command == "empty"))
                {
                    num = int.Parse(input[1]);
                }
                

                switch (command)
                {
                    case "add":
                        set.Set(num, true);
                        break;
                    case "remove":
                        set.Set(num, false);
                        break;
                    case "check":
                        int number = set.Get(num) ? 1 : 0;
                        result.Append($"{number}\n");
                        break;
                    case "toggle":
                        set.Set(num, !set.Get(num));
                        break;
                    case "all":
                        set.SetAll(true);
                        break;
                    case "empty":
                        set.SetAll(false);
                        break;
                }
            }
            if (result.Length > 0)
            {
                result.Length--;
            }
            Console.WriteLine(result);
        }
    }
}
