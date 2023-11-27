//Question No: 1978
//Title: 소수 찾기
//Tier: Bronze II
namespace Joy{
    class Q1978
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] numbers = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);

            int count = 0;
            foreach (var num in numbers)
            {
                if (Check(num))
                {
                    count++;
                }
            }

            Console.WriteLine(count);
        }

        static bool Check(int num)
        {
            if (num < 2)
                return false;

            int sqrt = (int)Math.Sqrt(num);

            for (int i = 2; i <= sqrt; i++)
            {
                if (num % i == 0)
                    return false;
            }

            return true;
        }
    }
}
