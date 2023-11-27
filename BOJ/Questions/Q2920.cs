//Question No: 2920
//Title: 음계
//Tier: Bronze II
namespace Joy
{
    class Q2920
    {
        static void Main()
            {
            string[] input = Console.ReadLine().Split();
            int[] melody = Array.ConvertAll(input, int.Parse);
            bool ascending = true;
            bool descending = true;

            for (int i = 1; i < melody.Length; i++)
            {
                if (melody[i] > melody[i - 1])
                {
                    descending = false;
                }
                else if (melody[i] < melody[i - 1])
                {
                    ascending = false;
                }
            }
            string result = "";
            if (ascending)
            {
                result = "ascending";
            }
            else if (descending)
            {
                result = "descending";
            }
            else
            {
                result = "mixed";
            }
            Console.WriteLine(result);
        }
    }
}