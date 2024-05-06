//Question No: 15686
//Title: 치킨 배달
//Tier: Gold V
namespace Joy
{
    class Q15686 {
        static int N, M;
        static List<(int, int)> houses = new List<(int, int)>();
        static List<(int, int)> chickens = new List<(int, int)>();
        static int minDistanceSum = int.MaxValue;
        public static void Main (string[] args) {
            int[] NM = Console.ReadLine().Split().Select(int.Parse).ToArray();
            N = NM[0];
            M = NM[1];
            for (int i = 0; i < N; i++) {
                int[] row = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int j = 0; j < N; j++) {
                    if (row[j] == 1)
                        houses.Add((i, j));
                    else if (row[j] == 2)
                        chickens.Add((i, j));
                }
            }
            Combination(0, 0, new List<(int, int)>());
            Console.WriteLine(minDistanceSum);
        }
        static void Combination(int start, int depth, List<(int, int)> selected) {
            if (depth == M) {
                minDistanceSum = Math.Min(minDistanceSum, CalculateDistance(selected));
                return;
            }
            for (int i = start; i < chickens.Count; i++) {
                selected.Add(chickens[i]);
                Combination(i + 1, depth + 1, selected);
                selected.RemoveAt(selected.Count - 1);
            }
        }
        static int CalculateDistance(List<(int, int)> selected) {
            int sum = 0;
            foreach (var house in houses) {
                int minDistance = int.MaxValue;
                foreach (var chicken in selected) {
                    int distance = Math.Abs(house.Item1 - chicken.Item1) + Math.Abs(house.Item2 - chicken.Item2);
                    minDistance = Math.Min(minDistance, distance);
                }
                sum += minDistance;
            }
            return sum;
        }
    }
}