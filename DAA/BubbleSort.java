package DAA;

//To measure the actual runtime, you could use System.nanoTime() in Java to time the bubbleSort function
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        // Measure the time complexity
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Output the time taken

        System.out.println("The start Time is :"+startTime+"Nano Seconds");
        System.out.println("the End Time is :"+endTime+"Nano Section");
        System.out.println("\nTime taken: " + (endTime - startTime) + " nanoseconds");
    }
}

