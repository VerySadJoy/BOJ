//Question No: 10250
//Title: ACM 호텔
//Tier: Bronze III
namespace Joy
{
    class Q10250
    {
        static void Main()
        {
            int t = int.Parse(Console.ReadLine());

            for (int i = 0; i < t; i++)
            {
                string[] input = Console.ReadLine().Split();
                int h = int.Parse(input[0]);
                int w = int.Parse(input[1]);
                int n = int.Parse(input[2]);
                int floor = n % h == 0 ? h : n % h;
                int room = (n - 1) / h + 1;
        
                int roomNumber = floor * 100 + room;
                Console.WriteLine(roomNumber);
            }
        }
    }
}