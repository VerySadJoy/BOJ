//Question No: 1918
//Title: 후위 표기식
//Tier: Gold II
class Program
{
    const int MAX_STACK_SIZE = 102;

    struct StackType
    {
        public char[] data;
        public int top;
    }

    static void InitStack(ref StackType s)
    {
        s.top = -1;
        s.data = new char[MAX_STACK_SIZE];
    }

    static bool IsEmpty(StackType s)
    {
        return (s.top == -1);
    }

    static bool IsFull(StackType s)
    {
        return (s.top == MAX_STACK_SIZE - 1);
    }

    static void Push(ref StackType s, char item)
    {
        if (IsFull(s))
        {
            Console.WriteLine("Error");
            return;
        }
        else
        {
            s.data[++s.top] = item;
        }
    }

    static char Pop(ref StackType s)
    {
        if (IsEmpty(s))
        {
            Console.WriteLine("Error");
            Environment.Exit(1);
            return '\0';
        }
        else
        {
            return s.data[s.top--];
        }
    }

    static char Peek(StackType s)
    {
        if (IsEmpty(s))
        {
            Console.WriteLine("Error");
            Environment.Exit(1);
            return '\0';
        }
        else
        {
            return s.data[s.top];
        }
    }

    static int Prec(char op)
    {
        switch (op)
        {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    static void InfixToPostfix(string exp)
    {
        int len = exp.Length;
        StackType s = new StackType();
        InitStack(ref s);

        for (int i = 0; i < len; i++)
        {
            char ch = exp[i];
            switch (ch)
            {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!IsEmpty(s) && (Prec(ch) <= Prec(Peek(s))))
                    {
                        Console.Write(Pop(ref s));
                    }
                    Push(ref s, ch);
                    break;
                case '(':
                    Push(ref s, ch);
                    break;
                case ')':
                    char topOp = Pop(ref s);
                    while (topOp != '(')
                    {
                        Console.Write(topOp);
                        topOp = Pop(ref s);
                    }
                    break;
                default:
                    Console.Write(ch);
                    break;
            }
        }

        while (!IsEmpty(s))
        {
            Console.Write(Pop(ref s));
        }
    }

    static void Main()
    {
        string exp = Console.ReadLine();
        InfixToPostfix(exp);
    }
}
