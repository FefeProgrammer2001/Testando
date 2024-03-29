import java.util.Scanner;

public class Counting
{
    public static void countingSort(int arr[], int size)
    {
        int max = arr[0];
        for(int i = 1; i < size; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }

        int count[] = new int[max + 1];
        for(int i = 0; i <= max; ++i)
        {
            count[i] = 0;
        }
        for(int i = 0; i < size; i++)
        {
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0; i <= max; i++)
        {
            while(count[i] > 0)
            {
                arr[j++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the array size: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.print("Type the array values:\n");
        for(int j = 0; j < size; j++)
        {
            System.out.printf("Element [%d]: ", j+1);
            array[j] = scanner.nextInt();
        }
        countingSort(array, size);
        System.out.print("Sorted array: ");
        for(int i = 0; i < size; i++)
        {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}