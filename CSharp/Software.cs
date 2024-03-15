using System;

public class Program
{
    public static long potentiation(long x, long y)
    {
        long[,] memo = new long[x+1, y+1];
        for(int i = 0; i <= x; i++)
        {
            for(int j = 0; j <= y; j++)
            {
                if(j == 0)
                {
                    memo[i,j] = 1;
                } else
                {
                    memo[i,j] = i * memo[i,j-1];
                }
            }
        }
        return memo[x,y];
    }

    public static void Main()
    {
        char option;
        do
        {
            long x;
            Console.Write("Type a value for X: ");
            x = Convert.ToInt64(Console.ReadLine());
            long y;
            Console.Write("Type a value for Y: ");
            y = Convert.ToInt64(Console.ReadLine());
            long test = potentiation(x, y);
            Console.Write(x + " ^ " + y + " = " + test);
            Console.Write("\nType y to return to the initial, or n to get out: ");
            option = Convert.ToChar(Console.ReadLine());
        } while(option == 'y');
    }
}
