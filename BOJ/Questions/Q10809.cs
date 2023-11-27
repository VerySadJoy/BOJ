//Question No: 10809
//Title: 알파벳 찾기
//Tier: Bronze II
namespace Joy
{
    class Q10809
    {
        static void Main()
        {
            string word = Console.ReadLine();
            int[] pos = new int[26];

            for (int i = 0; i < pos.Length; i++)
            {
                pos[i] = -1;
            }

            for (int i = 0; i < word.Length; i++)
            {
                char current = word[i];
                int index = current - 'a';
                if (pos[index] == -1)
                {
                    pos[index] = i;
                }
            }
            foreach (var p in pos)
            {
                Console.Write($"{p} ");
            }
        }
    }
}