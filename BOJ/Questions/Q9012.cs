//Question No: 9012
//Title: 괄호
//Tier: Silver IV
using System;
using System.Collections.Generic;

namespace Joy
{
    class _9012
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());

            for (int i = 0; i < T; i++)
            {
                string input = Console.ReadLine();

                if (Valid(input))
                {
                    Console.WriteLine("YES");
                }
                else
                {
                    Console.WriteLine("NO");
                }
            }
        }

        static bool Valid(string input)
        {
            Stack<char> stack = new Stack<char>();

            foreach (char bracket in input)
            {
                if (bracket == '(')
                {
                    stack.Push(bracket);
                }
                else
                {
                    if (stack.Count == 0)
                    {
                        return false;
                    }

                    stack.Pop();
                }
            }

            return stack.Count == 0;
        }
    }
}
