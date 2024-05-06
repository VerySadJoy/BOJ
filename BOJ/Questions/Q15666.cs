//Question No: 15666
//Title: N과 M (12)
//Tier: Silver II
using System.Text;
namespace Joy
{
    class Q15666 {
        static int N, M;
        static List<int> nums;
        static StringBuilder sb = new StringBuilder();
        public static void Main (string[] args) {
            int[] input = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            N = input[0];
            M = input[1];
            nums = Console.ReadLine().Split().Select(int.Parse).Distinct().OrderBy(x => x).ToList();

            int[] sequence = new int[M];
            GenerateSequence(0, 0, sequence);
            Console.WriteLine(sb.ToString());
        }
        static void GenerateSequence(int index, int count, int[] sequence) {
            if (count == M) {
                AppendSequence(sequence);
                return;
            }

            for (int i = index; i < nums.Count; i++) {
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