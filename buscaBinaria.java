import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the values of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        System.out.print("Enter the number to be searched: ");
        int target = input.nextInt();

        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("The number was not found in the array.\n");
        } else {
            System.out.println("The number was found at position: " + result);
	    System.out.println("\n");
        }
    }

    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
