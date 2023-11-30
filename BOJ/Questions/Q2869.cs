//Question No: 2869
//Title: 달팽이는 올라가고 싶다
//Tier: Bronze I
namespace Joy
{
    class Q2869
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int A = int.Parse(input[0]);
            int B = int.Parse(input[1]);
            int V = int.Parse(input[2]);
            Console.WriteLine((V - B - 1) / (A - B) + 1);
        }
    }
}
