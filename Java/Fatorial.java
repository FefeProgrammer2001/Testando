import java.util.Scanner;

public class Fatorial
{
    private static long[] memo;
    
    public static long fat(long a)
    {
        if (memo[(int) a] != 0) {
            return memo[(int) a];
        }

        if (a == 0) {
            memo[0] = 1;
            return 1;
        } else if (a == 1) {
            memo[1] = 1;
            return 1;
        } else {
            long result = a * fat(a - 1);
            memo[(int) a] = result;
            return result;
        }
    }
    
    public static void main(String[] args)
    {
        String option;
        do
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type a value for A: ");
            long a = scanner.nextLong();
            scanner.nextLine();
            memo = new long[(int)(a+1)];
            long test = fat(a);
            System.out.printf("%d! = %d", a, test);
            System.out.print("\nDo you wanna return? yes or no?: ");
            option = scanner.nextLine();
        } while(!option.equalsIgnoreCase("no"));
    }
}
