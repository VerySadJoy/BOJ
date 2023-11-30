//Question No: 18110
//Title:solved.ac
//Tier: Silver IV
namespace Joy
{
    class Q18110
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            if (n == 0)
            {
                Console.WriteLine(0);
                return;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            Array.Sort(arr);

            double num = n * 0.15;
            num = (int)(num * 10) % 10 >= 5 ? Math.Ceiling(num) : Math.Floor(num);

            double sum = 0;
            for (int i = (int)num; i < n - num; i++)
            {
                sum += arr[i];
            }
            sum /= n - num * 2;

            sum = (int)(sum * 10) % 10 >= 5 ? Math.Ceiling(sum) : Math.Floor(sum);

            Console.WriteLine(sum);
        }
    }


}