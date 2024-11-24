package DAA;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        // Record the start time
        long startTime = System.nanoTime();

        // Call the selection sort function
        selectionSort(arr);

        // Record the end time
        long endTime = System.nanoTime();

        // Calculate the total time taken
        long totalTime = endTime - startTime;

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Print start time, end time, and total time taken
        System.out.println("\nStart Time: " + startTime + " ns");
        System.out.println("End Time: " + endTime + " ns");
        System.out.println("Total Time Taken: " + totalTime + " ns");
    }
}
