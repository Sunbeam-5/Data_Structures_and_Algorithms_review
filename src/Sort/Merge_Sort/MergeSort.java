package Sort.Merge_Sort;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int [] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        // 如果只有一个元素就不用继续划分了
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            // 划分
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            // 进行归并排序
            merge(arr, temp, left, mid, right);
        }
    }

    public static  void merge(int[] arr, int [] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        // 左半区第一个未排序的下标
        int l_pos = left;
        // 右半区第一个未排序的下标
        int r_pos = mid + 1;

        int pos = left;
        while (l_pos <= mid && r_pos <= right) {
            // 左半区剩余第一个元素最小
            if (temp[l_pos] < temp[r_pos]) {
                arr[pos++] = temp[l_pos++];
            } else {
                // 右半区剩余第一个元素最小
                arr[pos++] = temp[r_pos++];
            }
        }
        // 左半区剩余部分是有序的
        while (l_pos <= mid) {
            arr[pos++] = temp[l_pos++];
        }
        // 右半区剩余是有序的
        while (r_pos <= right) {
            arr[pos++] = temp[r_pos++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        System.out.print("归并排序后的数组: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
