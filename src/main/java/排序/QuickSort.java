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
        quickSort(arr,0,4);
        System.out.println(arr);
    }

    /**
     * @param arr    数组
     * @param lIndex 左下标
     * @param rIndex 右下标
     */
   static void quickSort(int[] arr, int lIndex, int rIndex) {
        if (lIndex >= rIndex) {
            return;
        }
        int nowL = lIndex, nowR = rIndex;
        int key = arr[nowL];//待比较的值
        while (nowL < nowR) {//一旦跳出循环nowL和nowR应该是相等的，内循环相等的时候就不执行了
            while (nowL < nowR && arr[nowR] > key) {//找到比arr[]lIndex大的
                nowR--;
            }

            while (nowL < nowR && arr[nowL] < key) {//找到比arr[]lIndex小的
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
        arr[lIndex] = arr[nowL];
        arr[nowL] = key;
        //递归调用左半数组
        quickSort(arr, lIndex, nowR - 1);
        //递归调用右半数组
        quickSort(arr, nowL + 1, rIndex);


    }

}
