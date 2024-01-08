class BinaryHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public int[] getHeap() {
        return heap;
    }

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void buildHeap(int[] arr) {
        if (arr.length > capacity) {
            System.out.println("Array exceeds heap capacity");
            return;
        }
        size = arr.length;
        System.arraycopy(arr, 0, heap, 0, size);

        for (int i = (size - 1) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Inserting a new element
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full, cannot insert");
            return;
        }

        int index = size;
        heap[size++] = value;

        while (index > 0 && heap[parent(index)] < heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Deleting the maximum element
    public int deleteMax() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }

    // Finding the maximum element
    public int findMax() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        return heap[0];
    }

    // Checking if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returning the number of elements
    public int heapSize() {
        return size;
    }
}
public class A12Q1 {
    public static void printHeap(BinaryHeap binaryHeap) {
        int[] heap = binaryHeap.getHeap();
        int size = binaryHeap.heapSize();
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 12, 7, 15, 10, 3, 4, 1, 8, 20 };
        int size = arr.length;

        BinaryHeap binaryHeap = new BinaryHeap(size);
        binaryHeap.buildHeap(arr);

        System.out.println("Heap built from array: ");
        printHeap(binaryHeap);

        int maxElement = binaryHeap.deleteMax();
        System.out.println("\nMax element deleted: " + maxElement);
        System.out.println("Heap after deleting max element: ");
        printHeap(binaryHeap);


        int newElement = 25;
        binaryHeap.insert(newElement);
        System.out.println("\nHeap after inserting " + newElement + ": ");
        printHeap(binaryHeap);

        int max = binaryHeap.findMax();
        System.out.println("\nMaximum element in heap: " + max);

        boolean isEmpty = binaryHeap.isEmpty();
        System.out.println("\nIs heap empty? " + isEmpty);

        int heapSize = binaryHeap.heapSize();
        System.out.println("\nNumber of elements in heap: " + heapSize);
    }
}
