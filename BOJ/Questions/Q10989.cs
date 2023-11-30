//Question No: 10989
//Title: 수 정렬하기 3
//Tier: Bronze I
using System.IO;

namespace Joy
{
    class Q10989
    {
        static void Main()
        {   
            int N = int.Parse(Console.ReadLine());
            int[] nums = new int[10001];

            for (int i = 0; i < N; i++)
            {
                int num = int.Parse(Console.ReadLine());
                nums[num]++;
            }
            using (var writer = new StreamWriter(Console.OpenStandardOutput())){
                for (int i = 1; i < nums.Length; i++)
                {
                    for (int j = 0; j < nums[i]; j++)
                    {
                        writer.WriteLine(i);
                    }
                }
            }
        }
    }
}