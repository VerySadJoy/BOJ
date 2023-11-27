//Question No: 2744
//Title: 대소문자 바꾸기
//Tier: Bronze V
namespace Joy
{
    class Q2744
    {
        static void Main()
        {
            string input = Console.ReadLine();

            string result = Swap(input);

            Console.WriteLine(result);
        }
        static string Swap(string input)
        {
            char[] chars = input.ToCharArray();

            for (int i = 0; i < chars.Length; i++)
            {
                if (char.IsLower(chars[i]))
                {
                    chars[i] = char.ToUpper(chars[i]);
                }
                else if (char.IsUpper(chars[i]))
                {
                    chars[i] = char.ToLower(chars[i]);
                }
            }

            return new string(chars);
        }
    }
}