class MaxHeapChecker {

    public boolean isMaxHeap(int arr[]) {
        int n = arr.length;

        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[i] < arr[2 * i + 1] || (2 * i + 2 < n && arr[i] < arr[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public void convertToMaxHeap(int arr[]) {
        int n = arr.length;

        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}

public class A12Q3 {
    public static void main(String args[]) {
        int arr[] = {90, 15, 10, 7, 2, 12};
        int n = arr.length;

        MaxHeapChecker checker = new MaxHeapChecker();

        if (checker.isMaxHeap(arr)) {
            System.out.println("The given array is a Max Heap.");
        } else {
            System.out.println("The given array is not a Max Heap. Converting to Max Heap...");
            checker.convertToMaxHeap(arr);
            System.out.println("Converted array to Max Heap:");

            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}
