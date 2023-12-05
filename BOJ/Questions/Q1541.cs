//Question No: 1541
//Title: 잃어버린 괄호
//Tier: Silver II
namespace Joy
{
    class Q1541
    {
        static void Main()
        {
            string[] sub = Console.ReadLine().Split('-');
            int total = Adding(sub[0]);

            for (int i = 1; i < sub.Length; i++)
            {
                total -= Adding(sub[i]);
            }
            Console.WriteLine(total);
        }

        static int Adding(string part)
        {
            string[] add = part.Split('+');
            int sum = 0;

            foreach (string e in add)
            {
                sum += int.Parse(e);
            }

            return sum;
        }
    }

}