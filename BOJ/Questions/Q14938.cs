//Question No: 15652
//Title: N과 M (4)
//Tier: Silver III
using System;
using System.Text;

namespace Joy {
    class Q15652 {
        static int N, M;
        static StringBuilder sb = new StringBuilder();

        public static void Main (string[] args) {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);

            int[] sequence = new int[M];
            GenerateSequence(1, 0, sequence);
            Console.WriteLine(sb.ToString());
        }

        static void GenerateSequence(int start, int count, int[] sequence) {
            if (count == M) {
                AppendSequence(sequence);
                return;
            }

            for (int i = start; i <= N; i++) {
                sequence[count] = i;
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
