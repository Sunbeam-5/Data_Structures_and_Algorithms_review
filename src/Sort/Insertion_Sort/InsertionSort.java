package Sort.Insertion_Sort;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j + 1]; j--) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        insertionSort(arr);

        System.out.println("排序后的数组:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
