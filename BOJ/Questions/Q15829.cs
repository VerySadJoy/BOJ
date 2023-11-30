//Question No: 15829
//Title: Hashing
//Tier: Bronze II
namespace Joy
{
    using System;

    class Q15829
    {
        static void Main()
        {
            int L = int.Parse(Console.ReadLine());
            string str = Console.ReadLine();
            long hash = 0;
            long exp = 1;

            for (int i = 0; i < L; i++)
            {
                long charValue = str[i] - 'a' + 1;
                hash = (hash + charValue * exp) % 1234567891;
                exp = exp * 31 % 1234567891;
            }
            Console.WriteLine(hash);
        }
    }

}