//Question No: 1920
//Title: 수 찾기
//Tier: Silver IV
using System.Text;

namespace Joy
{
    class Q1920
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);

            int m = int.Parse(Console.ReadLine());
            int[] targets = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);

            Array.Sort(arr);

            StringBuilder output = new StringBuilder();

            foreach (var target in targets)
            {
                if (Search(arr, target))
                    output.AppendLine("1");
                else
                    output.AppendLine("0");
            }

            Console.Write(output);
        }

        static bool Search(int[] arr, int target)
        {
            int left = 0;
            int right = arr.Length - 1;

            while (left <= right)
            {
                int mid = (left + right) / 2;

                if (arr[mid] == target)
                    return true;
                else if (arr[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }

            return false;
        }
    }
}