package 排序;

import java.util.List;

/**
 * 快速排序
 *
 * @Author qiximiao
 * @Date 2020-12-06
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 7, 2};
        int[] arr2 = {4, 1, 3, 7, 2};
        quickSort(arr, 0, arr.length - 1);
        QuickSortTest(arr2, 0, arr.length - 1);
        System.out.println("abc");
    }

    /**
     * @param arr    数组
     * @param start 左下标
     * @param end 右下标
     */
    static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int nowL = start, nowR = end;
        int key = arr[start];//待比较的值
        while (nowL < nowR) {//一旦跳出循环nowL和nowR应该是相等的，内循环相等的时候就不执行了
            while (nowL < nowR && arr[nowR] >= key) {//找到比arr[]lIndex大的
                nowR--;
            }

            while (nowL < nowR && arr[nowL] <= key) {//找到比arr[]lIndex小的
                nowL++;
            }
            if (nowL < nowR) {//只有在两边都找到了可交换的值时才会进入
                //交换
                int t;
                t = arr[nowR];
                arr[nowR] = arr[nowL];
                arr[nowL] = t;
            }
        }
        //跳出来后nowL和nowR相等，此时这个位置是什么考虑一下吧
        //要么最后一直nowR左移到结束了，左移经过的数都是比key大，左侧比基准数key大，右侧比基准数小，如果上次交换nowL在的数比key小
        //要么nowR找到了一个比基准数key小的值,最后nowL定位到这个这个值，


        //最后将基准为与i和j相等位置的数字交换
        arr[start] = arr[nowL];
        arr[nowL] = key;
        //递归调用左半数组
        quickSort(arr, start, nowR - 1);
        //递归调用右半数组
        quickSort(arr, nowR + 1, end);


    }


    public static void QuickSortTest(int arr[], int start, int end) {
        int temp, i, j, t;
        if (start > end) {
            return;
        }
        temp = arr[start];
        i = start;
        j = end;
        while (i < j) {
            //在右边寻找比基数temp小的数
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //在左边寻找比基数temp大的数
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //符合条件就交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //将基数与和i,j相遇的索引交换值
        arr[start] = arr[i];
        arr[i] = temp;
        //递归调用左边
        QuickSortTest(arr, start, j - 1);
        //递归调用右边
        QuickSortTest(arr, i + 1, end);
    }
}
