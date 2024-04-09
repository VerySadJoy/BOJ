//Question No: 1043
//Title: 거짓말
//Tier: Gold IV
namespace Joy
{
    class Q1043
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int M = int.Parse(input[1]);

            input = Console.ReadLine().Split();
            int truthCount = int.Parse(input[0]);

            HashSet<int> truthMembers = new HashSet<int>();
            for (int i = 1; i <= truthCount; i++)
            {
                truthMembers.Add(int.Parse(input[i]));
            }

            List<int>[] parties = new List<int>[M];
            for (int i = 0; i < M; i++)
            {
                input = Console.ReadLine().Split();
                int partySize = int.Parse(input[0]);
                parties[i] = new List<int>();

                for (int j = 1; j <= partySize; j++)
                {
                    int member = int.Parse(input[j]);
                    parties[i].Add(member);
                }
            }

            bool[] isLie = new bool[M];
            foreach (var party in parties)
            {
                foreach (var member in party)
                {
                    if (truthMembers.Contains(member))
                    {
                        foreach (var m in party)
                        {
                            truthMembers.Add(m);
                        }
                        isLie[Array.IndexOf(parties, party)] = true;
                        break;
                    }
                }
            }

            int answer = M;
            foreach (var lie in isLie)
            {
                if (lie)
                {
                    answer--;
                }
            }

            Console.WriteLine(answer);
        }
    }
}
