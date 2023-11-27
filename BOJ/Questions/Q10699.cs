//Question No: 10699
//Title: 오늘 날짜
//Tier: Bronze V
namespace Joy
{
    class Q10699
    {
        static void Main()
        {
            DateTime date = DateTime.Now;
            string dateFormat = date.ToString("yyyy-MM-dd");

            Console.WriteLine(dateFormat);
        }
    }
}