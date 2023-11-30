//Question No: 4949
//Title: 균형잡힌 세상
//Tier: Silver IV
using System.Text;

namespace Joy
{
    class Q4949
    {
        static void Main()
        {
            string line;
            StringBuilder result = new StringBuilder();
            while (true)
            { 
                line = Console.ReadLine();
                if (line == ".")
                {
                    break;
                }
                int count1Left = 0;
                int count1Right = 0;
                int count2Left = 0;
                int count2Right = 0;
                bool wrongOrder = false;
                List<char> charList = new List<char>();

                foreach (char c in line)
                {
                    if (c == '(')
                    {
                        count1Left++;
                        charList.Add(c);
                    }
                        
                    else if (c == ')')
                    {
                        if (count1Right == count1Left)
                        {
                            wrongOrder = true;
                        }
                        if (charList.Count > 0)
                        {
                            if (charList[charList.Count - 1] != '(')
                            {
                                wrongOrder = true;
                            }
                            else
                            {
                                charList.RemoveAt(charList.Count - 1);
                            }
                        }
                        count1Right++;
                    }
                        
                    else if (c == '[')
                    {
                        count2Left++;
                        charList.Add(c);
                    }
                        
                    else if (c == ']')
                    {
                        if (count2Right == count2Left)
                        {
                            wrongOrder = true;
                        }
                        if (charList.Count > 0)
                        {
                            if (charList[charList.Count - 1] != '[')
                            {
                                wrongOrder = true;
                            }
                            else
                            {
                                charList.RemoveAt(charList.Count - 1);
                            }
                        }
                        count2Right++;
                    }
                }
                if (count1Left == count1Right && count2Left == count2Right && !wrongOrder)
                {
                    result.Append("yes\n");
                }
                else{
                    result.Append("no\n");
                }
            }
            if (result.Length > 0)
            {
                result.Length--;
            }
            if (result.Length > 0)
            {
                Console.WriteLine(result);
            }
        }
    }
}