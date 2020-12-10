package 排序;

/**
 * 插入排序
 *
 * @Author qiximiao
 * @Date 2020-12-07
 */
public class CharuSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 7, 2};
        sor(arr);
        System.out.println(arr);
    }

    static void sor(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
