//Question No: 16953
//Title: A → B
//Tier: Silver II
namespace Joy
{
    class Q16953
    {
        public static void Main () {
            string[] input = Console.ReadLine().Split();
            long A = long.Parse(input[0]);
            long B = long.Parse(input[1]);
            int count = 1;
            while (A < B) {
                if (B % 2 == 0) {
                    B /= 2;
                }
                else if (B % 10 == 1) {
                    B /= 10;
                }
                else {
                    break;
                }
                count++;
            }
            Console.WriteLine(A == B ? count : -1);
        }
    }
}