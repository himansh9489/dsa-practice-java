public class QuickSort {
    // Partition function
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choose the pivot as the lowest element
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high - 1 && arr[i] <= pivot)
                i++;
            while (j >= low + 1 && arr[j] > pivot)
                j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    // Quicksort function
    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array
            int pi = partition(arr, low, high);

            // Sort elements before and after the partition
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    // Main method to test the partition and quicksort functions
    public static void main(String[] args) {
        int[] arr = { 12, 7, 11, 5, 2, 9, 10 };
        int n = arr.length;

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        quicksort(arr, 0, n - 1);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
