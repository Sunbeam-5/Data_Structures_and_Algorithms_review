package Sort.Quick_Sort;

public class QuickSort {
    public static void quickSort(int[] nums) {

    }
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        quickSort(arr);
        System.out.print("快速排序后的数组: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
