//Question No: 9935
//Title: 문자열 폭발
//Tier: Gold IV
using System.Text;
namespace Joy
{
    class Q9935
    {
        static void Main()
        {
            string word = Console.ReadLine();
            string bomb = Console.ReadLine();
            StringBuilder sb = new StringBuilder();
            foreach (char c in word)
            {
                sb.Append(c);
                if (sb.Length >= bomb.Length && end(sb, bomb))
                {
                    sb.Remove(sb.Length - bomb.Length, bomb.Length);
                }
            }
            Console.WriteLine(sb.Length == 0 ? "FRULA" : sb.ToString());
        }
        private static bool end(StringBuilder sb, string bomb)
        {
            for (int i = 0; i < bomb.Length; ++i)
            {
                if (sb[sb.Length - 1 - i] != bomb[bomb.Length - 1 - i])
                    return false;
            }
            return true;
        }
    }
}
