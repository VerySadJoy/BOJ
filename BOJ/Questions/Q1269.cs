//Question No: 1269
//Title: 대칭 차집합
//Tier: Silver IV
namespace Joy
{
    class Q1269
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int sizeA = int.Parse(input[0]);
            int sizeB = int.Parse(input[1]);
            int[] setA = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int[] setB = Console.ReadLine().Split().Select(int.Parse).ToArray();
            HashSet<int> symmetricDifference = new HashSet<int>(setA);
            symmetricDifference.SymmetricExceptWith(setB);
            int symmetricDifferenceCount = symmetricDifference.Count;
            Console.WriteLine(symmetricDifferenceCount);
        }
    }
}