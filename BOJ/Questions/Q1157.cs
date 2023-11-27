//Question No: 1157
//Title: 단어 공부
//Tier: Bronze I
namespace Joy
{
    class Q1157
    {
        static void Main()
        {
            string word = Console.ReadLine().ToUpper();

            Dictionary<char, int> letterCount = new Dictionary<char, int>();

            foreach (char letter in word)
            {
                if (char.IsLetter(letter))
                {
                    if (letterCount.ContainsKey(letter))
                    {
                        letterCount[letter]++;
                    }
                    else
                    {
                        letterCount[letter] = 1;
                    }
                }
            }

            char mostFrequent = Find(letterCount);

            Console.WriteLine(mostFrequent);
        }

        static char Find(Dictionary<char, int> letterCount)
        {
            int maxCount = letterCount.Values.Max();

            var frequent = letterCount.Where(pair => pair.Value == maxCount).Select(pair => pair.Key).ToList();

            return frequent.Count == 1 ? frequent[0] : '?';
        }
    }
}