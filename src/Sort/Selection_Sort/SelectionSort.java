package Sort.Selection_Sort;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        selectionSort(arr);

        System.out.println("排序后的数组:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}

