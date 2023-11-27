//Question No: 5597
//Title: 과제 안 내신 분..?
//Tier: Bronze V
namespace Joy
{
    class Q5597
    {
        static void Main()
        {
            bool[] attendance = new bool[31];

            for (int i = 0; i < 28; i++)
            {
                int num = int.Parse(Console.ReadLine());
                attendance[num] = true;
            }
            
            for (int i = 1; i <= 30; i++)
            {
                if (!attendance[i])
                {
                    Console.WriteLine(i);
                }
            }
        }
    }
}