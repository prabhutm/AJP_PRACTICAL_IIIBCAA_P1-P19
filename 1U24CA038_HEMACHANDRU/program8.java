// Practical 8: Generic selection sort

public class program8 {
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 9, 1, 7};
        Float[] floatArray = {5.5f, 3.3f, 9.9f, 1.1f, 7.7f};

        System.out.println("Original Integer Array:");
        printArray(intArray);
        System.out.println("Original Float Array:");
        printArray(floatArray);

        selectionSort(intArray);
        selectionSort(floatArray);

        System.out.println("Sorted Integer Array:");
        printArray(intArray);
        System.out.println("Sorted Float Array:");
        printArray(floatArray);
    }
}
