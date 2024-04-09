//Question No: 17219
//Title: 비밀번호 찾기
//Tier: Silver IV
namespace Joy
{
    class Q17219
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int M = int.Parse(input[1]);
            Dictionary<string, string> passwords = new Dictionary<string, string>();
            for (int i = 0; i < N; i++)
            {
                input = Console.ReadLine().Split();
                string url = input[0];
                string password = input[1];
                passwords[url] = password;
            }
            for (int i = 0; i < M; i++)
            {
                string query = Console.ReadLine();
                Console.WriteLine(passwords[query]);
            }
        }
    }
}