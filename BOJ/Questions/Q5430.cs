//Question No: 5430
//Title: AC
//Tier: Gold V
using System.Text;

namespace Joy
{
    class Q5430
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int t = 0; t < T; t++)
            {
                string instructions = Console.ReadLine();
                int N = int.Parse(Console.ReadLine());
                string input = Console.ReadLine();
                string[] arr = input.Length > 2 ? input.Substring(1, input.Length - 2).Split(',') : new string[0];
                bool reverse = false;
                int start = 0;
                int end = arr.Length;
                bool error = false;

                foreach (char cmd in instructions)
                {
                    if (cmd == 'R')
                    {
                        reverse = !reverse;
                    }
                    else if (cmd == 'D')
                    {
                        if (start >= end)
                        {
                            error = true;
                            break;
                        }
                        if (reverse)
                        {
                            end--;
                        }
                        else
                        {
                            start++;
                        }
                    }
                }

                if (error)
                {
                    result.Append("error\n");
                }
                else
                {
                    if (reverse)
                    {
                        arr = arr.Skip(start).Take(end - start).Reverse().ToArray();
                    }
                    else
                    {
                        arr = arr.Skip(start).Take(end - start).ToArray();
                    }
                    result.Append("[" + string.Join(",", arr) + "]\n");
                }
            }
            if (result.Length > 0)
            {
                result.Length -= 1;
            }

            Console.WriteLine(result);
        }
    }
}