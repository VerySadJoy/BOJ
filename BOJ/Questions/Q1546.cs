//Question No: 1546
//Title: 평균
//Tier: Bronze I
namespace Joy
{
    class Q1546
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            double[] scores = Console.ReadLine().Split().Select(double.Parse).ToArray();

            double maxScore = scores.Max();

            double sum = scores.Sum();

            double av = sum / maxScore * 100 / n;
            Console.WriteLine(av);
        }
    }
}