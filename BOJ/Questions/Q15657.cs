//Question No: 15657
//Title: N과 M (8)
//Tier: Silver III
using System.Text;
namespace Joy
{
    class Q15657 {
        static int N, M;
        static int[] nums;
        static StringBuilder sb = new StringBuilder();
        public static void Main (string[] args) {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);
            nums = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            Array.Sort(nums);

            int[] sequence = new int[M];
            GenerateSequence(0, 0, sequence);
            Console.WriteLine(sb.ToString());
        }
        static void GenerateSequence(int index, int count, int[] sequence) {
            if (count == M) {
                AppendSequence(sequence);
                return;
            }

            for (int i = index; i < N; i++) {
                sequence[count] = nums[i];
                GenerateSequence(i, count + 1, sequence);
            }
        }
        static void AppendSequence(int[] sequence) {
            foreach (int num in sequence) {
                sb.Append(num).Append(' ');
            }
            sb.AppendLine();
        }
    }
}