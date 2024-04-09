//Question No: 20529
//Title: 가장 가까운 세 사람의 심리적 거리
//Tier: Silver I
using System.Text;
namespace Joy
{
    class Q20529
    {
        static void Main()
        {
            StringBuilder result = new StringBuilder();
            List<string> list = new List<string>();
            int t = int.Parse(Console.ReadLine());
            while (t-- > 0)
            {
                int n = int.Parse(Console.ReadLine());
                var inputs = Console.ReadLine().Split();
                
                if (n > 32)
                {
                    result.AppendLine("0");
                }
                else
                {
                    list.Clear();
                    for (int i = 0; i < n; i++)
                    {
                        list.Add(inputs[i]);
                    }
                    int answer = int.MaxValue;
                    for (int i = 0; i < list.Count - 2; i++)
                    {
                        for (int j = i + 1; j < list.Count - 1; j++)
                        {
                            for (int k = j + 1; k < list.Count; k++)
                            {
                                int count = 0;
                                for (int l = 0; l < 4; l++)
                                {
                                    if (list[i][l] != list[j][l]) count++;
                                    if (list[j][l] != list[k][l]) count++;
                                    if (list[k][l] != list[i][l]) count++;
                                }
                                answer = Math.Min(answer, count);
                            }
                        }
                    }
                    result.AppendLine($"{answer}");
                }
            }
            Console.Write(result);
        }
    }   
}