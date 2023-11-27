//Question No: 1181
//Title: 단어 정렬
//Tier: Silver V
namespace Joy
{
    class Q1181
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            HashSet<string> words = new HashSet<string>();

            for (int i = 0; i < n; i++)
            {
                words.Add(Console.ReadLine());
            }

            List<string> sortedWords = words.OrderBy(w => w.Length).ThenBy(w => w).ToList();

            foreach (var word in sortedWords)
            {
                Console.WriteLine(word);
            }
        }
    }
}